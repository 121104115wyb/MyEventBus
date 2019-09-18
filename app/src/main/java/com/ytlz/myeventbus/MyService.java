package com.ytlz.myeventbus;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.ytlz.myeventbus.evbusObject.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyService extends Service {

    ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

    public MyService() {

    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Date date = new Date();
            EventBus.getDefault().post(new MessageEvent("我是Service发来的消息：时间是"+date.getHours()+"h"+date.getMinutes()+"m"+date.getSeconds()+"s"));
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        sendMesTiming();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    void sendMesTiming(){
        service.scheduleWithFixedDelay(runnable, 200, 3000, TimeUnit.MILLISECONDS);
    }




}
