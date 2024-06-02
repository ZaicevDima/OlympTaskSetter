package com.zaytsev.d.olymp_task_setter.services;


import com.zaytsev.d.olymp_task_setter.models.GoogleSheetInfo;
import com.zaytsev.d.olymp_task_setter.models.GoogleSheetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zaytsev.d.olymp_task_setter.utils.GoogleAuthorizeUtil;

import java.util.Map;

@Service
public class GoogleAPIService {
    @Autowired
    GoogleAuthorizeUtil googleAuthorizeUtil;
    public Map<Object, Object> readDataFromGoogleSheet() throws Exception {
        return googleAuthorizeUtil.getDataFromSheet();
    }

    public GoogleSheetResponse createSheet(GoogleSheetInfo request) throws Exception {
        return googleAuthorizeUtil.createSheet(request);
    }
}
