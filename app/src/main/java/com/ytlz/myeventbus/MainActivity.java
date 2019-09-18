package com.ytlz.myeventbus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.ytlz.myeventbus.common.EventBusConstants;
import com.ytlz.myeventbus.evbusObject.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.meta.SubscriberInfo;
import org.greenrobot.eventbus.meta.SubscriberInfoIndex;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView textSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //startService(new Intent(this, MyService.class));
        textSend = findViewById(R.id.textSend);
        textSend.setOnClickListener(v -> {
            //startActivity(new Intent(MainActivity.this, ReceiverActivity.class));
            EventBus.getDefault().post(MessageEvent.ceratMesEvent("我是Mainactivity返回的消息"));
            finish();
        });
    }

//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = false, priority = 0)
//    public void text_send(MessageEvent event) {
//        try {
//            if (event == null) {
//                Log.d(TAG, "defaultMessageText: ------event:null");
//                return;
//            }
//            JSONObject jsonObject = new JSONObject(event.getMessage());
//            Log.d(TAG, "defaultMessageText: -------event:" + event.getMessage() + "\n" + "name:" + jsonObject.optString("name"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Log.d(TAG, "defaultMessageText: -------event:" + event.getMessage());
//
//        }
//    }


//    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 0)
//    public void defaultMessageText(MessageEvent event) {
//        try {
//            if (event == null) {
//                Log.d(TAG, "defaultMessageText: ------event:null");
//                return;
//            }
//            JSONObject jsonObject = new JSONObject(event.getMessage());
//            Log.d(TAG, "defaultMessageText: -------event:" + event + "\n" + "name:" + jsonObject.optString("name"));
//        } catch (JSONException e) {
//            e.printStackTrace();
//            Log.d(TAG, "defaultMessageText: -------event:" + event.getMessage());
//        }
//    }


    @Override
    protected void onStart() {
        super.onStart();
//        if (!EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().register(this);
//        }
    }

    @Override
    protected void onStop() {
        super.onStop();
//        if (EventBus.getDefault().isRegistered(this)) {
//            EventBus.getDefault().unregister(this);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();


    }
}
