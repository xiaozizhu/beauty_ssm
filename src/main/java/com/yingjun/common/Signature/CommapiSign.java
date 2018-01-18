package com.yingjun.common.Signature;

import org.apache.commons.codec.digest.HmacUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;

public class CommapiSign {
    String AppSecret = "ohseb7eiJeel";
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());



    public String sign(String content) {
        try {
            LOG.info("sign的传入参数======"+content);
            byte[] bytes = HmacUtils.hmacSha256(AppSecret, content);
            bytes = Base64.getEncoder().encode(bytes);
            bytes = MessageDigest.getInstance("MD5").digest(bytes);
            StringBuilder res = new StringBuilder(new BigInteger(1, bytes).toString(16));
            for (int i = 0; i < 32 - res.length(); i++) {
                res.insert(0, "0");
            }
            return res.substring(5, 15);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(" common misc api sign error:");
//            logger.warn(" common misc api sign error:{}", ExceptionUtils.getStackTrace(e));
        }
        return null;
    }





    public String Sort (TreeMap<String, String> map) {
        String str="";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals("false")) {
                if (str.equals("")) {
                    str=str+entry.getKey()+"="+"0";

                }else {
                    str=str+"&"+entry.getKey()+"="+"0";
                }


            }else {
                if (str.equals("")) {
                    str=str+entry.getKey()+"="+entry.getValue();

                }else {
                    str=str+"&"+entry.getKey()+"="+entry.getValue();
                }

            }


        }
        if (str.equals("")) {
            str="11";
        }

        str = sign(str);


        return str;

    }




}
