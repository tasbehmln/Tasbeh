package com.ayesh.muhammad.tasbeh;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

import com.ayesh.muhammad.tasbeh.layout.LayoutFamily;

/**
 * Created by mayesh on 8/7/17.
 */

public class ActivityView extends Activity {
    private Activity activity;
    private LayoutFamily layout;

    public ActivityView(Activity activityType, LayoutFamily layout) {
        this.activity = activityType;
        this.layout = layout;
    }


    private void setActivityClickListener(View.OnClickListener clickListener) {
        try {
            ((RelativeLayout) layout).setOnClickListener(clickListener);

        } catch (NullPointerException e) {

        }
    }


}


class RelativeLayoutException extends Exception {

}
