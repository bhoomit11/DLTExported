package com.example.dltexported.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dltexported.R;

import java.util.List;

/**
 * Created by bhumit on 9/2/17.
 */
public class SubcategoryAdapter extends BaseAdapter {
    private Context mContext;
    List<String> subCategoryList;
    private LayoutInflater layoutInflater = null;

    public SubcategoryAdapter(Context mContext, List<String> subCategoryList) {
        this.mContext = mContext;
        this.subCategoryList = subCategoryList;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return subCategoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return subCategoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.subcategory_list, null);
        TextView tv_subcategory = (TextView) convertView.findViewById(R.id.tv_subcategory);
        TextView tv_subcategory_name = (TextView) convertView.findViewById(R.id.tv_subcategory_name);
        final RelativeLayout rl_subcategory_row = (RelativeLayout) convertView.findViewById(R.id.rl_subcategory_row);
        final LinearLayout ll_subcategory_detail = (LinearLayout) convertView.findViewById(R.id.ll_subcategory_detail);
        final ImageView iv_hide_details = (ImageView) convertView.findViewById(R.id.iv_hide_details);

        tv_subcategory.setText(subCategoryList.get(position));
        tv_subcategory_name.setText(subCategoryList.get(position));

        rl_subcategory_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll_subcategory_detail.getVisibility() == View.GONE) {
                    ll_subcategory_detail.setVisibility(View.VISIBLE);
                    rl_subcategory_row.setVisibility(View.GONE);
//                    notifyDataSetChanged();
                }
            }
        });

        iv_hide_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rl_subcategory_row.getVisibility() == View.GONE) {
                    ll_subcategory_detail.setVisibility(View.GONE);
                    rl_subcategory_row.setVisibility(View.VISIBLE);
//                    notifyDataSetChanged();
                }
            }
        });
        return convertView;
    }
}
