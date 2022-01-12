package com.middleware.encrypt.strategy.impl;

import com.middleware.encrypt.encrypt.EncryptEncodeDecodeService;
import com.middleware.encrypt.enums.DataType;
import com.middleware.encrypt.strategy.IEncryptResultFieldStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MobileEncryptStrategy implements IEncryptResultFieldStrategy {
    @Autowired
    private EncryptEncodeDecodeService encryptEncodeDecodeService;
    @Override
    public String encrypt(String source) {
        return encryptEncodeDecodeService.getEncodeValue(source, DataType.MOBILE, null);
    }


}
