package com.iancuio.flowerorder.ui.orders;


import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.iancuio.flowerorder.R;
import com.iancuio.flowerorder.data.local.realm.RealmImpl;
import com.iancuio.flowerorder.data.local.realm.TransactionBody;
import com.iancuio.flowerorder.data.remote.retrofit.OnRetrofitFinish;
import com.iancuio.flowerorder.data.remote.retrofit.RetrofitImpl;
import com.iancuio.flowerorder.ui.orders.viewOrder.ViewOrderFragment;
import com.iancuio.flowerorder.utils.Constants;
import com.iancuio.flowerorder.utils.fragment.BaseFragment;
import com.iancuio.flowerorder.utils.fragment.FragmentUtils;
import com.iancuio.flowerorder.utils.network.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import butterknife.OnItemClick;
import io.realm.Realm;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderListFragment extends BaseFragment {

    @BindView(R.id.filter_orderList_ediText)
    EditText filterEditText;
    @BindView(R.id.clearFilter_orderList_imageView)
    ImageView clearFilterImageView;
    @BindView(R.id.filterNew_orderList_checkBox)
    AppCompatCheckBox filterNewCheckBox;
    @BindView(R.id.swipeRefresh_orderList_swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshOrders;
    @BindView(R.id.orderList_orderList_listView)
    ListView orderListView;
    @BindView(R.id.emptyListProgress_orderList_progressBar)
    ProgressBar emptyListProgressBar;
    @BindView(R.id.emptyListText_orderList_textView)
    TextView emptyListTextView;

    private List<Order> orderList = new ArrayList<>();
    private List<Order> orderListFiltered = new ArrayList<>();

    AsyncTask filterOrderAsyncTask;

    private OrderListAdapter orderListAdapter;

    boolean filterNew = false;

    public OrderListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_order_list, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void preparePostViewData() {
        filterNew = filterNewCheckBox.isChecked();

        getOrders(filterNew);

        filterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filterOrders();
            }
        });
    }

    @OnItemClick(R.id.orderList_orderList_listView)
    public void onOrderListViewItemClick(long orderId) {
        Bundle bundle = new Bundle();
        bundle.putLong(Constants.ORDER_ID, orderId);

        FragmentUtils.addFragmentWithBackstack(new ViewOrderFragment(), R.id.fragmentContainer_coreActivity_frameLayout,
                (AppCompatActivity) (context), bundle,
                R.anim.slide_in_from_bottom, R.anim.slide_out_to_top, R.anim.slide_in_from_top, R.anim.slide_out_to_bottom);
    }

    @OnCheckedChanged(R.id.filterNew_orderList_checkBox)
    public void onFilterNewClick(boolean isChecked) {
        filterNew = isChecked;

        getOrders(filterNew);
    }

    @OnClick(R.id.clearFilter_orderList_imageView)
    public void onClearFilterClick() {
        filterEditText.getText().clear();
    }

    @Override
    public void onDestroy() {
        RealmImpl.modifyRealmObject(realm, new TransactionBody() {
            @Override
            public void execute() {
                for (Order order : orderList) {
                    order.setNotNew(true);
                }
            }
        });

        super.onDestroy();
    }

    @SuppressLint("StaticFieldLeak")
    private void getOrders(final boolean filterNew) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                clearLists();
                orderList = RealmImpl.getOrderList(realm, filterNew);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                orderListAdapter = new OrderListAdapter(context, orderListFiltered);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);

                orderListFiltered.addAll(orderList);

                orderListView.setAdapter(orderListAdapter);

                emptyListProgressBar.setVisibility(View.GONE);
                orderListView.setEmptyView(emptyListTextView);

                swipeRefreshOrders.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if (NetworkUtils.isNetworkAvailable(context)) {
                            RetrofitImpl.getOrders(context, R.string.something_went_wrong_new_orders, getClass().getSimpleName(), "getOrders", new OnRetrofitFinish() {
                                @Override
                                public void onRetrofitFinishExecuteSuccess(Response response) {
                                    final List<Order> newOrderList = (List<Order>) response.body();

                                    if (newOrderList.size() == 0) {
                                        Snackbar.make(getView().getRootView(), R.string.no_new_orders, Snackbar.LENGTH_SHORT).show();
                                        return;
                                    }

                                    RealmImpl.saveOrderList(realm, newOrderList, new Realm.Transaction.OnSuccess() {
                                        @Override
                                        public void onSuccess() {
                                            getOrders(filterNew);

                                            swipeRefreshOrders.setRefreshing(false);
                                        }
                                    }, null);
                                }

                                @Override
                                public void onRetrofitFinishExecuteFail() {

                                }
                            });
                        } else {
                            Snackbar.make(getView().getRootView(), R.string.no_internet, Snackbar.LENGTH_SHORT).show();
                            swipeRefreshOrders.setRefreshing(false);
                        }
                    }
                });
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    @SuppressLint("StaticFieldLeak")
    private void filterOrders() {
        if (filterOrderAsyncTask != null
                && (filterOrderAsyncTask.getStatus() == AsyncTask.Status.PENDING || filterOrderAsyncTask.getStatus() == AsyncTask.Status.RUNNING)) {
            filterOrderAsyncTask.cancel(true);
        }

        final String searchText = filterEditText.getText().toString();

        filterOrderAsyncTask = new AsyncTask<Void, Void, List<Long>>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();

                if (!swipeRefreshOrders.isRefreshing()) {
                    swipeRefreshOrders.setRefreshing(true);
                }
            }

            @Override
            protected List<Long> doInBackground(Void... voids) {
                clearLists();

                if (!searchText.equals("")) {
                    Realm bgRealm = Realm.getDefaultInstance();

                    List<Order> orderListToFilterFrom = RealmImpl.getOrderList(bgRealm, filterNew);
                    List<Long> orderIdList = new ArrayList<>();

                    for (Order order : orderListToFilterFrom) {
                        String filterField = order.getId() + " " + order.getDeliverTo();

                        if (filterField.toLowerCase().contains(searchText.toLowerCase())) {
                            orderIdList.add(bgRealm.copyFromRealm(order).getId());
                        }
                    }

                    bgRealm.close();

                    return orderIdList;
                }

                return null;
            }

            @Override
            protected void onPostExecute(List<Long> orderIdList) {
                super.onPostExecute(orderIdList);

                if (orderIdList != null) {
                    orderListFiltered.addAll(RealmImpl.getOrderByIdList(realm, orderIdList));
                } else {
                    orderListFiltered.addAll(orderList);
                }

                orderListAdapter.notifyDataSetChanged();

                swipeRefreshOrders.setRefreshing(false);
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void clearLists() {
        orderListFiltered.clear();
    }
}
