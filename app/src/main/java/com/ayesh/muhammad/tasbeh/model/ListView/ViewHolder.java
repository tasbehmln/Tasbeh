package com.ayesh.muhammad.tasbeh.model.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayesh.muhammad.tasbeh.R;

import java.util.List;

public class ViewHolder {
    private int position;
    private View row;
    private TextView textView;
    private ImageView icon;


    public ViewHolder(int position, View view) {
        this.position = position;
        this.row = view;
    }

    public void setData(int position) {
        textView = row.findViewById(R.id.title_row);
        textView.setText(((Category)getData().get(position)).getText());
        icon = row.findViewById(R.id.icon_row);
        icon.setImageResource(((Category)getData().get(position)).getIcon());
    }


    private List<Object> getData() {
        return DataHolder.getData();
    }
}
