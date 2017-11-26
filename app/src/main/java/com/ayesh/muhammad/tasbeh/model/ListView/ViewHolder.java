package com.ayesh.muhammad.tasbeh.model.ListView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayesh.muhammad.tasbeh.R;

import java.util.ArrayList;
import java.util.List;

public class ViewHolder {
    private int position;
    private View row;
    private TextView textView;
    private ImageView icon;
    private ArrayList<Object> data;


    public ViewHolder(int position, View view, ArrayList<Object> data) {
        this.position = position;
        this.row = view;
        this.data = data;
    }

    public void setData(int position) {
        textView = row.findViewById(R.id.title_row);
        textView.setText(((Category) data.get(position)).getRowTitle());
        icon = row.findViewById(R.id.icon_row);
        icon.setImageResource(((Category) data.get(position)).getIcon());
    }


}
