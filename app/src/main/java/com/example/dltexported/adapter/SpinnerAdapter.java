package com.example.dltexported.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dltexported.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhoomit on 1/21/2017.
 */
public class SpinnerAdapter extends BaseAdapter {
    private Context mContext;
    private List<String> arrayList;
    private LayoutInflater layoutInflater = null;

    public SpinnerAdapter(Context mContext, List<String> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        convertView = layoutInflater.inflate(R.layout.spinner_custom_view, null);
        TextView textView = (TextView) convertView.findViewById(R.id.tv_textview);

        textView.setText(arrayList.get(position).toString());
        return convertView;
    }
}
