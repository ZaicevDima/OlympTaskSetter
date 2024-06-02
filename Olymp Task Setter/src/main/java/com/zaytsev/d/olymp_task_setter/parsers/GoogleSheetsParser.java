package com.zaytsev.d.olymp_task_setter.parsers;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
//import com.google.auth.http.HttpCredentialsAdapter;
//import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class GoogleSheetsParser extends Parser {
    GoogleSheetsParser(String token, String URL) {
        super(token, URL);//https://docs.google.com/spreadsheets/d/1PPhylBUKuRrsmVcYF0-YsrV7-uYeWu1JLvoZHTHSIIc/edit?usp=sharing
    }

    @Override
    List<String> getUserNames() {
        return null;
    }

    @Override
    List<String> getActivityName() {
        return null;
    }

    @Override
    List<String> getAmountTask(String lesson) {
        return null;
    }

    @Override
    List<String> addUserNames() {
        return null;
    }

    @Override
    List<String> setActivityName() {
        return null;
    }

    @Override
    List<String> setAmountTask(String lesson) {
        return null;
    }
}
