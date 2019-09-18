package com.ytlz.myeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.BusUtils;

import org.greenrobot.eventbus.EventBus;

public class BusUtilsActivity extends BaseActivity {


    public static final String TAG_NO_PARAM = "TagNoParam";
    public static final String TAG_ONE_PARAM = "TagOneParam";
    public static final String TAG_STICKY_PARAM = "TagStickyParam";

    public static final String TAG_INTENT_PARAM = "TagIntentParam";

    @BusUtils.Bus(threadMode = BusUtils.ThreadMode.SINGLE, tag = TAG_NO_PARAM)
    public void noParamFun() {
        Log.d("BusUtilsActivity", "noParamFun: -------不带参数");
    }

    @BusUtils.Bus(tag = TAG_ONE_PARAM)
    public void oneParamFun(String param) {
        Log.d("BusUtilsActivity", "oneParamFun: -------" + param);
    }

    @BusUtils.Bus(tag = TAG_STICKY_PARAM)
    public void oneStickyParam(String param) {
        Log.d("BusUtilsActivity", "oneStickyParam: -------" + param);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_utils);

        Button jumpBtn = findViewById(R.id.jumpBtn);
        jumpBtn.setOnClickListener(v -> {
            BusUtils.postSticky(TAG_INTENT_PARAM,"我是BusUtilsActivity");
            ActivityUtils.startActivity(new Intent(this, BusUtils2Activity.class));
        });

        registerBusUtils(true);
    }



    //    @Override
//    public void setTitle(int titleId) {
//        super.setTitle(titleId);
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }

    @Override
    boolean registerBusUtils() {
        return false;
    }
}
