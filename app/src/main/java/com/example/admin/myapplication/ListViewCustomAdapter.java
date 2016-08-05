package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewCustomAdapter extends BaseAdapter {

    ArrayList<Object> itemList;

    public Activity context;
    public LayoutInflater inflater;

    public ListViewCustomAdapter(Activity context,ArrayList<Object> itemList) {
        super();

        this.context = context;
        this.itemList = itemList;

        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public static class ViewHolder
    {
               TextView txtViewTitle;
        TextView txtViewDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list, null);

                        holder.txtViewTitle = (TextView) convertView.findViewById(R.id.Image_viewall);
            holder.txtViewDescription = (TextView) convertView.findViewById(R.id.Tv_viewall);

            convertView.setTag(holder);
        }
        else
            holder=(ViewHolder)convertView.getTag();

        Ran ran = (Ran) itemList.get(position);


        holder.txtViewTitle.setText(ran.getTxt());
        holder.txtViewDescription.setText(ran.getItem());

        return convertView;
    }

}