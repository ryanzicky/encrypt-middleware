package com.middleware.encrypt.service;

import com.middleware.encrypt.entity.QueryRequest;
import com.middleware.encrypt.entity.EncryptDataResponse;
import com.middleware.encrypt.entity.WrapperRequest;

import java.util.Map;

/**
 * @Author user
 * @Date 2021/10/12 14:33
 */
public interface EncryptService {

    Map<String, EncryptDataResponse> storageData(WrapperRequest wrapperRequest);

    Map<String, EncryptDataResponse> queryData(QueryRequest queryRequest);
}
