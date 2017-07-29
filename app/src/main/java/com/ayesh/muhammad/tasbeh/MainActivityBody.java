package com.ayesh.muhammad.tasbeh;

import android.view.View;
import android.widget.TextView;

/**
 * Created by muhammad on 29/07/17.
 */
class MainActivityBody {
    private MainActivity mainActivity;
    private MainActivityView activityView;
    private CounterModel counter;
    private TextView counterText;

    public MainActivityBody(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.activityView = new MainActivityView(mainActivity);
        this.counter = new CounterModel();
    }

    public void invoke() {
        setMainActivityLogic();
        setResetButtonLogic();
    }

    private void setResetButtonLogic() {
        activityView.setResetButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter.setCounter(0);
                counterText.setText("0");
            }
        });
    }

    private void setMainActivityLogic() {
        activityView.setActivityClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //                Toast.makeText(MainActivity.this, counter++ +"", Toast.LENGTH_SHORT).show();
                counterText = (TextView) mainActivity.findViewById(R.id.counter);
                counter.setCounter(counter.getCounter() + 1);
                counterText.setText(counter.getCounter() + "");
            }
        });
    }
}
