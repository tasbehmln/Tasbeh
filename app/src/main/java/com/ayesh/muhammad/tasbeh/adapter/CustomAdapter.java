package com.ayesh.muhammad.tasbeh.adapter;

/**
 * Created by mhader on 8/10/17.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayesh.muhammad.tasbeh.R;
import com.ayesh.muhammad.tasbeh.model.ListItem;

import java.util.ArrayList;

/**
 * Created by prats on 5/28/2015.
 */
public class CustomAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<ListItem> arrayList;

    public CustomAdapter(Context context,ArrayList<ListItem> arrayList)
    {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater vi =
                    (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.custom_row, null);
        }
        final ListItem listItem = arrayList.get(position);
        if (listItem != null)
            ((TextView) convertView.findViewById(R.id.txtCountryName)).setText(listItem.getLanguageName());
        ((ImageView) convertView.findViewById(R.id.imgCountryFlag)).setImageResource(listItem.getLanguageImage());

        return convertView;
    }
}