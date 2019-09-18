package com.ytlz.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

import com.ytlz.myeventbus.evbusObject.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class FragmentTestActivity extends AppCompatActivity {
    private static final String TAG = "FragmentTestActivity";
    TextView receiveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EventBus.getDefault().register(this);
        setContentView(R.layout.activity_fragment_test);
        receiveText = findViewById(R.id.receiveText);
    }


//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void activityMesReceiver(MessageEvent event) {
//        if (receiveText == null) {
//            Log.d(TAG, "activityMesReceiver: receiveText can not be null");
//            return;
//        }
//        if (event==null || TextUtils.isEmpty(event.getMessage())){
//            Log.d(TAG, "activityMesReceiver: event is null");
//            return;
//        }
//        receiveText.setText(event.getMessage());
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }
}
