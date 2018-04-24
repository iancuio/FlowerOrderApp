package com.iancuio.starterapp.utils.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.iancuio.starterapp.utils.ScreenUtils;

import io.realm.Realm;

public abstract class BaseActivity extends AppCompatActivity implements ActivityOperations {

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        openRealm();
        preparePreViewData();
        preparePostViewData();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        boolean handleReturn = super.dispatchTouchEvent(ev);

        View view = getCurrentFocus();

        int x = (int) ev.getX();
        int y = (int) ev.getY();

        if(view instanceof EditText){
            View innerView = getCurrentFocus();

            if (ev.getAction() == MotionEvent.ACTION_UP &&
                    !ScreenUtils.getLocationOnScreen(innerView).contains(x, y)) {

                InputMethodManager input = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                input.hideSoftInputFromWindow(getWindow().getCurrentFocus()
                        .getWindowToken(), 0);
            }
        }

        return handleReturn;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeRealm();
        unregisterReceivers();
        cleanProgressDialogs();
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
