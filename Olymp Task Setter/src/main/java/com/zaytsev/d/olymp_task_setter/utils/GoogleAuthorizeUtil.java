package com.zaytsev.d.olymp_task_setter.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import com.zaytsev.d.olymp_task_setter.models.GoogleSheetInfo;
import com.zaytsev.d.olymp_task_setter.models.GoogleSheetResponse;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.*;

@Component
public class GoogleAuthorizeUtil {
    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens/path";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Arrays.asList(SheetsScopes.SPREADSHEETS, SheetsScopes.DRIVE);
    private static final String CREDENTIALS_FILE_PATH = "/google-sheets-client-secret.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws Exception {
        // Load client secrets.
        InputStream in = GoogleAuthorizeUtil.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(System.getProperty("user.home"), TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8850).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    public Map<Object, Object> getDataFromSheet() throws Exception {
        final String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        final String range = "Class Data!A2:E";
        Sheets service = getSheetService();
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        List<List<Object>> values = response.getValues();
        Map<Object, Object> storeDataFromGoogleSheet = new HashMap<>();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                storeDataFromGoogleSheet.put(row.get(0), row.get(4));
                //System.out.printf("%s, %s\n", row.get(0), row.get(4));
            }
            return storeDataFromGoogleSheet;
        }
        return storeDataFromGoogleSheet;
    }

    private Sheets getSheetService() throws Exception {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public GoogleSheetResponse createSheet(GoogleSheetInfo request) throws Exception {
        Sheets service = getSheetService();
        SpreadsheetProperties spreadsheetProperties = new SpreadsheetProperties();
        spreadsheetProperties.setTitle(request.getSheetName());
        SheetProperties sheetProperties = new SheetProperties();
        sheetProperties.setTitle(request.getSheetName());

        Sheet sheet = new Sheet().setProperties(sheetProperties);
        Spreadsheet spreadsheet = new Spreadsheet()
                .setProperties(spreadsheetProperties)
                .setSheets(Collections.singletonList(sheet));
        GoogleSheetResponse googleSheetResponse = new GoogleSheetResponse();
        ValueRange valueRange = new ValueRange().setValues(request.getDataToUpdated());
        Spreadsheet createdResponse = service.spreadsheets().create(spreadsheet).execute();
        service.spreadsheets().values().update(createdResponse.getSpreadsheetId(), "A1", valueRange).setValueInputOption("RAW").execute();
        googleSheetResponse.setSpreadSheetId(createdResponse.getSpreadsheetId());
        googleSheetResponse.setSpreadSheetURL(createdResponse.getSpreadsheetUrl());
        return googleSheetResponse;
        //return service.spreadsheets().create(spreadsheet).execute().getSpreadsheetUrl();
    }
    /**
     * Prints the names and majors of students in a sample spreadsheet:
     * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
     * https://docs.google.com/spreadsheets/d/1PPhylBUKuRrsmVcYF0-YsrV7-uYeWu1JLvoZHTHSIIc/edit?usp=sharing
     */
    /*public static void main(String... args) throws Exception {
        // Build a new authorized API client service.

    }*/
}