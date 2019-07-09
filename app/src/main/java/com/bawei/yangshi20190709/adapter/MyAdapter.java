package com.bawei.yangshi20190709.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yangshi20190709.R;
import com.bawei.yangshi20190709.bean.Bean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Android Studio.
 * User: 杨石
 * Date: 2019/7/9
 * Time: 09:38
 */
public class MyAdapter extends BaseAdapter {
    private List<Bean.ResultBean> list;
    private Context context;

    public MyAdapter(List<Bean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView=View.inflate(context, R.layout.item,null);
            viewHolder.iv=convertView.findViewById(R.id.iv);
            viewHolder.tv=convertView.findViewById(R.id.tv);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        viewHolder.tv.setText(list.get(position).getCommodityName());
        Glide.with(context).load(list.get(position).getMasterPic()).into(viewHolder.iv);
        return convertView;
    }
    class ViewHolder{
        ImageView iv;
        TextView tv;
    }
}
