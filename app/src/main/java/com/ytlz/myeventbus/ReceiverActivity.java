package com.ytlz.myeventbus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.ytlz.myeventbus.evbusObject.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);
        Button sendText = findViewById(R.id.sendMes);
        sendText.setOnClickListener(v -> {
            sendText();
        });
    }


    void sendText() {
        String mesJson = "{\"name\":\"张三\",\"age\":\"24\",\"address\":{\"province\":\"江苏\",\"city\":\"苏州\",\"street\":\"元和\"}}";
        MessageEvent messageEvent = MessageEvent.ceratMesEvent(mesJson);
        EventBus.getDefault().post(messageEvent);
        finish();
    }
}
