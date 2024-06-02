package com.zaytsev.d.olymp_task_setter.controllers;

import com.zaytsev.d.olymp_task_setter.models.GoogleSheetInfo;
import com.zaytsev.d.olymp_task_setter.models.GoogleSheetResponse;
import com.zaytsev.d.olymp_task_setter.services.GoogleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GoogleSheetsController {
    @Autowired
    private GoogleAPIService googleAPIService;

    @GetMapping("/check")
    public String check() {
        return "Checking API";
    }

    @GetMapping("/getData")
    public Map<Object, Object> readDataFromGoogleSheet() throws Exception {
        return googleAPIService.readDataFromGoogleSheet();
    }

    @PostMapping("/createSheet")
    public GoogleSheetResponse createGoogleSheet(@RequestBody GoogleSheetInfo request) throws Exception {
        return googleAPIService.createSheet(request);
    }

}
