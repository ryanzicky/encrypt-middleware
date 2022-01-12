package com.middleware.encrypt.strategy.impl;

import com.middleware.encrypt.encrypt.EncryptEncodeDecodeService;
import com.middleware.encrypt.strategy.IDecryptResultFieldStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonDecodeStrategy implements IDecryptResultFieldStrategy {
    @Autowired
    private EncryptEncodeDecodeService encryptEncodeDecodeService;

    @Override
    public List<String> decode(List<String> source) {
        return encryptEncodeDecodeService.getDecodeValues(source);
    }
}
