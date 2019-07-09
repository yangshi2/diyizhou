package com.bawei.yangshi20190709.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Android Studio.
 * User: 杨石
 * Date: 2019/7/9
 * Time: 09:39
 */
public abstract class BaseActivity extends AppCompatActivity {
    public abstract int initLayout();
    public abstract void initFind();
    public abstract void initData();
    public abstract void initlinear();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        initFind();
        initData();
        initlinear();
    }
}
