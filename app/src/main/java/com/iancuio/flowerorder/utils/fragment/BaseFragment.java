package com.iancuio.flowerorder.utils.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import io.realm.Realm;

/**
 * Created by vlad.iancu on 11.01.2018.
 */

public abstract class BaseFragment extends Fragment implements FragmentOperation {

    public Realm realm;
    public Context context;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openRealm();
        preparePreViewData();
    }

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        if (enter) {
            if (nextAnim != 0x0) {
                getView().setLayerType(View.LAYER_TYPE_HARDWARE, null);
                Animation animation = AnimationUtils.loadAnimation(context, nextAnim);

                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        new CountDownTimer(5, 5) {
                            @Override
                            public void onTick(long millisUntilFinished) {

                            }

                            @Override
                            public void onFinish() {
                                getView().setLayerType(View.LAYER_TYPE_NONE, null);

                                preparePostViewData();
                                registerReceivers();
                            }
                        }.start();

                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                return animation;
            } else {
                preparePostViewData();
                registerReceivers();
            }
        }

        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        closeRealm();
        unregisterReceivers();
        cleanProgressDialogs();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.context = context;
    }

    public void preparePreViewData() {

    }

    public void openRealm() {
        realm = Realm.getDefaultInstance();
    }

    public void closeRealm() {
        if (!realm.isClosed()) {
            realm.close();
        }
    }

    public void registerReceivers() {

    }

    public void unregisterReceivers() {

    }

    public void cleanProgressDialogs() {

    }
}
