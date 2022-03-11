package com.WalletManagement.WalletApi.service;

import com.WalletManagement.WalletApi.utils.exceptions.NotFoundException;
import org.apache.tomcat.jni.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements userDetailService{

    @Override
    public userDetails loadUserByUsername(String userName) throws NotFoundException{
        return new Use;
    }
}
