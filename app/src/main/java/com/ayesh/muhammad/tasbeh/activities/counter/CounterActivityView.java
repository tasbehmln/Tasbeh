package com.ayesh.muhammad.tasbeh.activities.counter;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ayesh.muhammad.tasbeh.R;

/**
 * Created by muhammad on 29/07/17.
 */

public class CounterActivityView {
    private RelativeLayout layout;
    private Button reset;
    Button next,back;
    final TextView textView;
    final String [] athkar;
    int currentIndex=0;

    public CounterActivityView(AppCompatActivity mainActivity) {
        this.layout = (RelativeLayout) mainActivity.findViewById(R.id.main_activity);
        //this.reset = (Button) mainActivity.findViewById(R.id.button);
        textView = (TextView) mainActivity.findViewById(R.id.sobhan_allah);
        athkar=mainActivity.getResources().getStringArray(R.array.MorningAthkar);
        next=(Button)mainActivity.findViewById(R.id.button2);
        back=(Button)mainActivity.findViewById(R.id.button3);
        if(athkar.length>1){
            textView.setText(athkar[currentIndex]+" " +currentIndex);
            next.setEnabled(true);
        }
        back.setEnabled(false);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final TextView textView2 = (TextView) findViewById(R.string.sobhan_allah_swipe);
                if (currentIndex==athkar.length-1){
                    next.setEnabled(false);
                }
                else{
                    currentIndex++;
                    if (currentIndex==athkar.length-1){
                        next.setEnabled(false);
                    }
                    textView.setText(athkar[currentIndex]+" " +currentIndex);
                }

                if(currentIndex>0)
                    back.setEnabled(true);
                else
                    back.setEnabled(false);


            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //final TextView textView2 = (TextView) findViewById(R.string.sobhan_allah_swipe);
                if (currentIndex==0)
                    back.setEnabled(false);
                else{
                    currentIndex--;
                    if (currentIndex==0)
                        back.setEnabled(false);
                    textView.setText(athkar[currentIndex]+" " +currentIndex);
                }
                if(currentIndex<athkar.length)
                    next.setEnabled(true);
                else
                    next.setEnabled(false);

            }
        });
    }

    public void setActivityClickListener(View.OnClickListener clickListener) {
        layout.setOnClickListener(clickListener);
    }

    public void setResetButtonClickListener(View.OnClickListener clickListener) {
        reset.setOnClickListener(clickListener);
    }
}
