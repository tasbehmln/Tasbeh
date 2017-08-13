package com.ayesh.muhammad.tasbeh.activities.counter;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.ayesh.muhammad.tasbeh.R;

/**
 * Created by muhammad on 29/07/17.
 */

public class CounterActivityView {
    private RelativeLayout layout;
    private Button reset;

    public CounterActivityView(AppCompatActivity mainActivity) {
        this.layout = (RelativeLayout) mainActivity.findViewById(R.id.main_activity);
        this.reset = (Button) mainActivity.findViewById(R.id.button);
    }

    public void setActivityClickListener(View.OnClickListener clickListener) {
        layout.setOnClickListener(clickListener);
    }

    public void setResetButtonClickListener(View.OnClickListener clickListener) {
        reset.setOnClickListener(clickListener);
    }
}
