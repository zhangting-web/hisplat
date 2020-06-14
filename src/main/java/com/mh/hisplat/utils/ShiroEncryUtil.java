package com.mh.hisplat.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShiroEncryUtil {
    @Value("${spring.redis.hashAlgorithmName}")
    private String hashAlgorithmName;
    @Value("${spring.redis.hashIterations}")
    private int hashIterations;
    public String encryPwd(String pwd){
        Object obj = new SimpleHash(hashAlgorithmName, pwd,"", hashIterations);
        return obj.toString();
    }
}
