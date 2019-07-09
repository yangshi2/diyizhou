package com.bawei.yangshi20190709.utils;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Android Studio.
 * User: 杨石
 * Date: 2019/7/9
 * Time: 08:58
 * 作用:工具类
 */
public class HttpUtils {
    //单例模式
    private static HttpUtils utils=new HttpUtils();
    private HttpUtils(){};
    public static HttpUtils getInstance(){
     return utils;
    }
    public String getString(String strUrl){
        HttpURLConnection connection=null;
        try {
            URL url = new URL(strUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int code = connection.getResponseCode();
            if(code==200){
                InputStream stream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String str="";
                while((str=reader.readLine())!=null){
                    buffer.append(str);
                }
                stream.close();
                connection.disconnect();
                return buffer.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
