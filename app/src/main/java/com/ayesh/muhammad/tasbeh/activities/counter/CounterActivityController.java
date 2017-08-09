package com.ayesh.muhammad.tasbeh.activities.counter;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.model.Counter;

/**
 * Created by muhammad on 29/07/17.
 */
class CounterActivityController {
    private AppCompatActivity mainActivity;
    private CounterActivityView activityView;
    private Counter counter;
    private TextView counterText;

    public CounterActivityController(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.activityView = new CounterActivityView(mainActivity);
        this.counter = new Counter();
    }


    public void invoke() {
        setActivityClickListener();
        setResetButtonClickListener();
    }


    private void setActivityClickListener() {
        activityView.setActivityClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activityOnClickModel();
            }
        });
    }

    private void activityOnClickModel() {
        counterText = (TextView) mainActivity.findViewById(R.id.counter);
        counter.setCounter(counter.getCounter() + 1);
        counterText.setText(counter.getCounter() + "");
    }


    private void setResetButtonClickListener() {
        activityView.setResetButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetButtonModel();
            }
        });
    }

    private void resetButtonModel() {
        counter.setCounter(0);
        counterText.setText("0");
    }
}
