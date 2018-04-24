package com.iancuio.flowerorder.ui.orders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iancuio.flowerorder.R;
import com.iancuio.flowerorder.utils.date.DateUtils;
import com.iancuio.flowerorder.utils.nullcheck.NullCheck;
import com.iancuio.flowerorder.utils.nullcheck.NullCheckUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderListAdapter extends BaseAdapter {

    Context context;
    List<Order> orderList;

    private LayoutInflater inflater;

    public OrderListAdapter(Context context, List<Order> orderList) {
        this.context = context;
        this.orderList = orderList;

        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orderList.size();
    }

    @Override
    public Order getItem(int position) {
        return orderList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return orderList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Order order = orderList.get(position);

        final OrderViewHolder orderViewHolder;

        if (convertView != null) {
            orderViewHolder = (OrderViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.order_list_view_item, null, false);
            orderViewHolder = new OrderViewHolder(convertView);
            convertView.setTag(orderViewHolder);
        }

        if (order.isNotNew()) {
            orderViewHolder.newTextView.setVisibility(View.GONE);
        } else {
            orderViewHolder.newTextView.setVisibility(View.VISIBLE);
        }

        NullCheckUtils.nullCheck(order.getId(), new NullCheck() {
            @Override
            public void onNotNull() {
                orderViewHolder.numberTextView.setText(String.valueOf(order.getId()));
            }

            @Override
            public void onNull() {
                orderViewHolder.numberTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDeliverTo(), new NullCheck() {
            @Override
            public void onNotNull() {
                orderViewHolder.deliverToTextView.setText(order.getDeliverTo());
            }

            @Override
            public void onNull() {
                orderViewHolder.deliverToTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getPrice(), new NullCheck() {
            @Override
            public void onNotNull() {
                orderViewHolder.priceTextView.setText(String.valueOf(order.getPrice()));
            }

            @Override
            public void onNull() {
                orderViewHolder.priceTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDateMillis(), new NullCheck() {
            @Override
            public void onNotNull() {
                orderViewHolder.dateTextView.setText(DateUtils.getFormattedDate(order.getDateMillis(), DateUtils.FORMAT_DATE_TIME_SHORT));
            }

            @Override
            public void onNull() {
                orderViewHolder.dateTextView.setText("-");
            }
        });

        NullCheckUtils.nullCheck(order.getDescription(), new NullCheck() {
            @Override
            public void onNotNull() {
                orderViewHolder.descriptionTextView.setText(order.getDescription());
            }

            @Override
            public void onNull() {
                orderViewHolder.descriptionTextView.setText("-");
            }
        });

        return convertView;
    }

    class OrderViewHolder {

        @BindView(R.id.number_orderListViewItem_textView)
        TextView numberTextView;
        @BindView(R.id.deliverTo_orderListViewItem_textView)
        TextView deliverToTextView;
        @BindView(R.id.price_orderListViewItem_textView)
        TextView priceTextView;
        @BindView(R.id.date_orderListViewItem_textView)
        TextView dateTextView;
        @BindView(R.id.description_orderListViewItem_textView)
        TextView descriptionTextView;
        @BindView(R.id.new_orderListViewItem_textView)
        TextView newTextView;

        public OrderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
