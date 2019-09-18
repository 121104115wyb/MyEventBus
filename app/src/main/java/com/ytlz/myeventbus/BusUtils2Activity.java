package com.ytlz.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.blankj.utilcode.util.BusUtils;

import static com.ytlz.myeventbus.BusUtilsActivity.TAG_INTENT_PARAM;

public class BusUtils2Activity extends AppCompatActivity {

    Button send1, send2, stickSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_utils2);
        BusUtils.register(this);
        send1 = findViewById(R.id.send1);
        send2 = findViewById(R.id.send2);
        stickSend = findViewById(R.id.stickSend);
        send1.setOnClickListener(v -> {
            BusUtils.post("TagNoParam");
            finish();
        });
        send2.setOnClickListener(v -> {
            BusUtils.post("TagOneParam", "我是带参数的");
            finish();
        });

        stickSend.setOnClickListener(v -> {
            BusUtils.postSticky("TagStickyParam", "我是粘性的");
            finish();
        });

    }


    @BusUtils.Bus(sticky = true,tag = TAG_INTENT_PARAM)
    public void intentParamFun(String param) {
        Log.d("BusUtils2Activity", "intentParamFun: -------" + param);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        BusUtils.unregister(this);
    }
}
