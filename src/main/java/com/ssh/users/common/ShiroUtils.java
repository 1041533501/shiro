package com.ssh.users.common;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.util.UUID;

public class ShiroUtils {

    public static String createSalt(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String salt(Object password,String saltValue){
        return new SimpleHash("MD5",password,saltValue,1024).toString();
    }

}
