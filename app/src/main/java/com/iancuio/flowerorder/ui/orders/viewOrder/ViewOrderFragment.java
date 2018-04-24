package com.iancuio.flowerorder.ui.orders.viewOrder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.iancuio.flowerorder.R;
import com.iancuio.flowerorder.data.local.realm.RealmImpl;
import com.iancuio.flowerorder.data.local.realm.TransactionBody;
import com.iancuio.flowerorder.ui.orders.Order;
import com.iancuio.flowerorder.utils.Constants;
import com.iancuio.flowerorder.utils.date.DateUtils;
import com.iancuio.flowerorder.utils.fragment.BaseFragment;
import com.iancuio.flowerorder.utils.nullcheck.NullCheck;
import com.iancuio.flowerorder.utils.nullcheck.NullCheckUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewOrderFragment extends BaseFragment {

    @BindView(R.id.orderDetailsContainer_viewOrder_linearLayout)
    LinearLayout orderDetailsContainerLinearLayout;
    @BindView(R.id.number_viewOrder_textView)
    TextView numberTextView;
    @BindView(R.id.deliverTo_viewOrder_textView)
    TextView deliverToTextView;
    @BindView(R.id.price_viewOrder_textView)
    TextView priceTextView;
    @BindView(R.id.date_viewOrder_textView)
    TextView dateTextView;
    @BindView(R.id.description_viewOrder_textView)
    TextView descriptionTextView;
    @BindView(R.id.populateProgress_viewOrder_progressBar)
    ProgressBar populateProgressBar;

    private long orderId;

    private Order order;

    public ViewOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_order, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @Override
    public void preparePostViewData() {
        orderId = getArguments().getLong(Constants.ORDER_ID);

        getOrder();

        populateOrder();
    }

    private void getOrder() {
        order = RealmImpl.getOrderById(realm, orderId);

        RealmImpl.modifyRealmObject(realm, new TransactionBody() {
            @Override
            public void execute() {
                order.setNotNew(true);
            }
        });
    }

    private void populateOrder() {
        NullCheckUtils.nullCheck(order.getId(), new NullCheck() {
            @Override
            public void onNotNull() {
                numberTextView.setText(String.valueOf(order.getId()));
            }

            @Override
            public void onNull() {
                numberTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDeliverTo(), new NullCheck() {
            @Override
            public void onNotNull() {
                deliverToTextView.setText(order.getDeliverTo());
            }

            @Override
            public void onNull() {
                deliverToTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getPrice(), new NullCheck() {
            @Override
            public void onNotNull() {
                priceTextView.setText(String.valueOf(order.getPrice()));
            }

            @Override
            public void onNull() {
                priceTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDateMillis(), new NullCheck() {
            @Override
            public void onNotNull() {
                dateTextView.setText(DateUtils.getFormattedDate(order.getDateMillis(), DateUtils.FORMAT_DATE_TIME_SHORT));
            }

            @Override
            public void onNull() {
                dateTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDescription(), new NullCheck() {
            @Override
            public void onNotNull() {
                descriptionTextView.setText(order.getDescription());
            }

            @Override
            public void onNull() {
                descriptionTextView.setText("-");
            }
        });

        populateProgressBar.setVisibility(View.GONE);
        orderDetailsContainerLinearLayout.setVisibility(View.VISIBLE);
    }
}
