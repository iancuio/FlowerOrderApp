package com.iancuio.flowerorder.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.iancuio.flowerorder.R;
import com.iancuio.flowerorder.ui.orders.OrderListFragment;
import com.iancuio.flowerorder.utils.activity.BaseActivity;
import com.iancuio.flowerorder.utils.fragment.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoreActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_core);
        ButterKnife.bind(this);
    }

    @Override
    public void preparePostViewData() {
        FragmentUtils.replaceFragment(new OrderListFragment(), R.id.fragmentContainer_coreActivity_frameLayout, this);
    }
}
