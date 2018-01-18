package com.yingjun.common.HttpRequest;

import com.fasterxml.jackson.jr.ob.JSON;
import com.yingjun.common.Signature.CommapiSign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.*;
import java.util.*;
import java.net.MalformedURLException;

public class HttpUtil {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    public  String get(String baseurl, Map<String,String> map){

        String  obj = "";
        try{

            //请求commapi接口
            //请求的webservice的url
            URL url = new URL(baseurl);
            //创建http链接
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            //设置请求的方法类型
            httpURLConnection.setRequestMethod("GET");
            //设置请求的内容类型
            httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");

            //设置发送数据
            httpURLConnection.setDoOutput(true);
            //设置接受数据
            httpURLConnection.setDoInput(true);

//            //设置加密数据
//            long expiresDate = new Date().getTime() + 10*60*1000;
////            map.put("appkey","58223333");
//            map.put("appKey","58223333");
//            map.put("expires",String.valueOf(expiresDate));
//            String nonce = UUID.randomUUID().toString();
////            map.put("nonce", nonce);
//
//
//            //参数加密
//            CommapiSign commapiSign = new CommapiSign();
//            TreeMap<String,String> treeMap = new TreeMap<>(map);
//            String signature = commapiSign.Sort(treeMap);
//
//            map.put("signature",signature);
//
//            LOG.info("commapi+GET请求参数加密参数======"+signature);


            //发送数据,使用输出流
            OutputStream outputStream = httpURLConnection.getOutputStream();
            String content = "";

            Set<String> set = map.keySet();
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String key = iterator.next();
                String value  = map.get(key);
                String cc = key +"=" +value;
                content += "&"+cc;
            }

            //去除第一个&
            if (content.length()>0){
                content = content.substring(1,content.length());

            }





//            for (Map.Entry<String,String> entry : map.entrySet()) {
//                String cc = entry.getKey()+"="+entry.getValue();
//                content += cc;
//
//            }
            LOG.info("commapi+GET请求参数======"+content);


            //发送数据
            outputStream.write(content.getBytes());
            //接收数据
            InputStream inputStream = httpURLConnection.getInputStream();

            //定义字节数组
            byte[] b = new byte[1024];
            //定义一个输出流存储接收到的数据
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            //开始接收数据
            int len = 0;
            while (true) {
                len = inputStream.read(b);
                if (len == -1) {
                    //数据读完
                    break;
                }
                byteArrayOutputStream.write(b, 0, len);
            }

            //从输出流中获取读取到数据(服务端返回的)
            LOG.info("commapi+GET返回参数======"+byteArrayOutputStream);

            String response = byteArrayOutputStream.toString();

            obj = response;

        }catch (Exception e){


            e.printStackTrace();
        }


        return obj;
    }


    public String sign(Map<String,String> map){
        String sign = "";


        return sign;

    }


}
