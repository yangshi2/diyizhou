package com.bawei.yangshi20190709;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.bawei.yangshi20190709.adapter.MyAdapter;
import com.bawei.yangshi20190709.base.BaseActivity;
import com.bawei.yangshi20190709.bean.Bean;
import com.bawei.yangshi20190709.utils.HttpUtils;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:杨石
 * 时间:20190709
 * 作用:主页面  172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=5
 */
public class MainActivity extends BaseActivity {
    private PullToRefreshScrollView pull;
    private GridView gv;
    private HttpUtils utils;
    private String str="172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=5";
    private ArrayList<Bean.ResultBean>list=new ArrayList<>();

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String string  = (String) msg.obj;
            Gson gson = new Gson();
            Bean bean = gson.fromJson(string, Bean.class);
            List<Bean.ResultBean> result = bean.getResult();
            MyAdapter myAdapter = new MyAdapter(result, MainActivity.this);
            gv.setAdapter(myAdapter);
        }
    };

    @Override
    public int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initFind() {
     pull=findViewById(R.id.pull);
     gv=findViewById(R.id.gv);
    }

    @Override
    public void initData() {
        utils = HttpUtils.getInstance();
        new Thread(){
            @Override
            public void run() {
                super.run();
                String string = utils.getString(str);
                Message message = Message.obtain();
                message.obj=string;
                handler.sendMessage(message);
            }
        }.start();
    }

    @Override
    public void initlinear() {

    }
}
