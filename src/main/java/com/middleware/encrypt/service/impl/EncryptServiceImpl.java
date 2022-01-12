package com.middleware.encrypt.service.impl;

import com.middleware.encrypt.entity.EncryptParameter;
import com.middleware.encrypt.entity.QueryRequest;
import com.middleware.encrypt.util.EncryptUtil;
import com.middleware.encrypt.entity.EncryptDataResponse;
import com.middleware.encrypt.entity.WrapperRequest;
import com.middleware.encrypt.service.EncryptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author user
 * @Date 2021/10/12 14:34
 */
@Slf4j
@Service
public class EncryptServiceImpl implements EncryptService {

    @Override
    public Map<String, EncryptDataResponse> storageData(WrapperRequest wrapperRequest) {
        List<EncryptParameter> encryptParameters = wrapperRequest.getEncryptParameters();
        if (CollectionUtils.isEmpty(encryptParameters)) {
            return null;
        }
        Map<String, EncryptDataResponse> responseMap = new HashMap<>();
        encryptParameters.forEach(encryptParameter -> {
            responseMap.put(encryptParameter.getValue(), encryptParam(encryptParameter.getValue(), encryptParameter.getCode()));
        });
        return responseMap;
    }

    @Override
    public Map<String, EncryptDataResponse> queryData(QueryRequest queryRequest) {
        List<String> encryptIds = queryRequest.getEncryptIds();
        if (CollectionUtils.isEmpty(encryptIds)) {
            return null;
        }
        Map<String, EncryptDataResponse> responseMap = new HashMap<>();
        encryptIds.forEach(encryptId -> {
            responseMap.put(encryptId, decryptParam(encryptId, queryRequest.getUid()));
        });
        return responseMap;
    }

    private EncryptDataResponse decryptParam(String source, String key) {
        EncryptDataResponse encryptDataResponse = new EncryptDataResponse();
        encryptDataResponse.setEncryptId(source);
        encryptDataResponse.setContent(source);
        encryptDataResponse.setMask(decrypt(source, key));

        return encryptDataResponse;
    }

    private String decrypt(String source, String key) {
        return EncryptUtil.DESdecode(source, key);
    }

    private EncryptDataResponse encryptParam(String source, String key) {
        EncryptDataResponse encryptDataResponse = new EncryptDataResponse();
        encryptDataResponse.setEncryptId(source);
        encryptDataResponse.setContent(source);
        encryptDataResponse.setMask(encrypt(source, key));

        return encryptDataResponse;
    }

    private String encrypt(String source, String key) {
        return EncryptUtil.DESencode(source, key);
    }
}
