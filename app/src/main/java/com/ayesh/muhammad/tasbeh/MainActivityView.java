package com.ayesh.muhammad.tasbeh;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by muhammad on 29/07/17.
 */

public class MainActivityView{
    private RelativeLayout layout;
    private Button reset;

    public MainActivityView(AppCompatActivity mainActivity) {
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
