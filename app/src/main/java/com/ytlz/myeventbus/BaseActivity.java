package com.ytlz.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.blankj.utilcode.util.BusUtils;

public class BaseActivity extends AppCompatActivity implements IBaseActivity {
    Boolean isRegistered = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isRegistered) {
            BusUtils.unregister(this);
        }
    }


    public void registerBusUtils(Boolean isRegistered) {
        this.isRegistered = isRegistered;
        if (isRegistered) {
            BusUtils.register(this);
        }
    }

    @Override
    public Boolean isRegristedBus() {


        return false;
    }

//   abstract boolean registerBusUtils();


}
