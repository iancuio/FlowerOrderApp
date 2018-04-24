package com.iancuio.flowerorder.ui.splashScreen;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.iancuio.flowerorder.R;
import com.iancuio.flowerorder.data.local.realm.RealmImpl;
import com.iancuio.flowerorder.data.remote.retrofit.OnRetrofitFinish;
import com.iancuio.flowerorder.data.remote.retrofit.RetrofitImpl;
import com.iancuio.flowerorder.ui.CoreActivity;
import com.iancuio.flowerorder.ui.orders.Order;
import com.iancuio.flowerorder.utils.activity.BaseActivity;
import com.iancuio.flowerorder.utils.network.NetworkUtils;

import java.util.List;

import butterknife.ButterKnife;
import io.realm.Realm;
import retrofit2.Response;

public class SplashScreenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
    }

    @Override
    public void preparePostViewData() {
        if (NetworkUtils.isNetworkAvailable(SplashScreenActivity.this)) {
            RetrofitImpl.getOrders(SplashScreenActivity.this, R.string.something_went_wrong_new_orders, getClass().getSimpleName(), "getOrders", new OnRetrofitFinish() {
                @Override
                public void onRetrofitFinishExecuteSuccess(Response response) {
                    final List<Order> newOrderList = (List<Order>) response.body();

                    RealmImpl.saveOrderList(realm, newOrderList, new Realm.Transaction.OnSuccess() {
                        @Override
                        public void onSuccess() {
                            finishAndContinue();
                        }
                    }, null);
                }

                @Override
                public void onRetrofitFinishExecuteFail() {
                    finishAndContinue();
                }
            });
        } else {
            Snackbar snackbar = Snackbar.make(getWindow().getDecorView(), R.string.no_internet, Snackbar.LENGTH_SHORT);

            snackbar.addCallback(new Snackbar.Callback() {
                @Override
                public void onDismissed(Snackbar transientBottomBar, int event) {
                    super.onDismissed(transientBottomBar, event);

                    finishAndContinue();
                }
            });

            snackbar.show();
        }
    }

    private void finishAndContinue() {
        startActivity(new Intent(SplashScreenActivity.this, CoreActivity.class));
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
