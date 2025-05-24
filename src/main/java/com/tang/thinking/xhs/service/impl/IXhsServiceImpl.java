package com.tang.thinking.xhs.service.impl;

import com.tang.thinking.xhs.service.XhsService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class IXhsServiceImpl implements XhsService {

    @Override
    public String getSign(Map<String, Object> params) {
        /**
         * 調用python代碼獲取最終值
         */

        return "Python執行結果";
    }
}
