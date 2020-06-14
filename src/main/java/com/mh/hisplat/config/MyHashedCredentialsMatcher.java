package com.mh.hisplat.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

/**
 * 在密码比较时添加日志查看信息，便于学习。
 */
@Slf4j
public class MyHashedCredentialsMatcher extends HashedCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        Object tokenHashedCredentials = this.hashProvidedCredentials(token, info);
        Object accountCredentials = this.getCredentials(info);
//        log.warn("tokenHashedCredentials:"+tokenHashedCredentials);
//        log.warn("accountCredentials:"+accountCredentials);
//        log.warn("HashAlgorithmName:"+this.getHashAlgorithmName());
//        log.warn("HashIterations:"+this.getHashIterations());
        return this.equals(tokenHashedCredentials, accountCredentials);
    }
}
