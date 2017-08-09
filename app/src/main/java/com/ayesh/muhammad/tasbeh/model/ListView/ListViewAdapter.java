package com.ayesh.muhammad.tasbeh.model.ListView;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.ayesh.muhammad.tasbeh.MainActivity;

/**
 * Created by muhammad on 03/08/17.
 */

public class ListViewAdapter extends ArrayAdapter{
    private int resource;
    private ViewHolder holder;
    private Context context;

    public ListViewAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource, DataHolder.getData());
        this.resource = resource;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        try {
            swapTheDataOfTheView(position, convertView);
        } catch (NullPointerException e) {
            convertView = createView(position, parent);
        }
        return convertView;
    }

    private void swapTheDataOfTheView(int position, @Nullable View convertView) throws NullPointerException {
        ViewHolder holder = (ViewHolder) convertView.getTag();
        holder.setData(position);
    }


    private View createView(int position, @NonNull ViewGroup parent) {
        View convertView;
        convertView = inflate(parent);
        createViewHolder(position, convertView);
        return convertView;
    }

    private void createViewHolder(int position, View convertView) {
        holder = new ViewHolder(position, convertView);
        holder.setData(position);
        convertView.setTag(holder);
    }


    private View inflate(@NonNull ViewGroup parent) {
        return LayoutInflater.from(getContext()).inflate(resource, parent, false);
    }








}
