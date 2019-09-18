package com.ytlz.myeventbus.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ytlz.myeventbus.BusUtilsActivity;
import com.ytlz.myeventbus.MainActivity;
import com.ytlz.myeventbus.R;
import com.ytlz.myeventbus.evbusObject.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by wyb on 2019-09-17.
 */

public class SendMesFragment extends Fragment {
    private static final String TAG = "SendMesFragment";
    Button button;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

        Log.d(TAG, "onCreate: ");
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.d(TAG, "onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Log.d(TAG, "onAttach: ");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.d(TAG, "onPause: ");
    }
    

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = (View) inflater.inflate(R.layout.fragment_sendmes, container, false);
        initViews(view);

        Log.d(TAG, "onCreateView: ");
        return view;
    }


    void initViews(View view) {
        button = view.findViewById(R.id.fSend1);
        button.setOnClickListener(v -> {
//            EventBus.getDefault().postSticky(MessageEvent.ceratMesEvent("我是fragment"));
//            startActivity(new Intent(getActivity(), MainActivity.class));


            startActivity(new Intent(getActivity(), BusUtilsActivity.class));
        });
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true, priority = 0)
    public void defaultMessageText(MessageEvent event) {
        Log.d(TAG, "defaultMessageText: -------event:" + event.getMessage());
//        EventBus.getDefault().cancelEventDelivery(event);
        button.setText(event.getMessage());
    }

    @Override
    public void onStop() {
        super.onStop();
//        EventBus.getDefault().unregister(this);

        Log.d(TAG, "onStop: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(TAG, "onDestroyView: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach: ");
    }
}
