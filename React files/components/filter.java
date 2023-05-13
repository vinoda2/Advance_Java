import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class SheetFilterExample {

    private static final String APPLICATION_NAME = "Google Sheets API Java Example";

    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

    public static void main(String[] args) throws GeneralSecurityException, IOException {
        // Build the credential object for authentication
        GoogleCredential credential = GoogleCredential.fromStream(getCredentialStream())
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS_READONLY));

        // Build the Sheets API client
        Sheets sheetsService = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
                .setApplicationName(APPLICATION_NAME)
                .build();

        // TODO: Replace with your spreadsheet ID
        String spreadsheetId = "your_spreadsheet_id";

        // Define the filter criteria
        FilterCriteria filterCriteria = new FilterCriteria()
                .setCondition(new TextCondition()
                        .setType("TEXT_CONTAINS")
                        .setValues(Collections.singletonList(new ConditionValue()
                                .setUserEnteredValue("Apple"))));

        // Define the range to apply the filter to
        GridRange range = new GridRange()
                .setSheetId(0)
                .setStartRowIndex(0)
                .setEndRowIndex(100)
                .setStartColumnIndex(0)
                .setEndColumnIndex(3);

        // Create the filter view and set the filter criteria and range
        FilterView filterView = new FilterView()
                .setFilterCriteria(filterCriteria)
                .setRange(range);

        // Create the request to set the filter view
        SetBasicFilterRequest request = new SetBasicFilterRequest()
                .setFilter(filterView);

        // Create the batch update request and add the filter request to it
        BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
                .setRequests(Collections.singletonList(new Request()
                        .setSetBasicFilter(request)));

        // Send the batch update request to apply the filter to the sheet
        sheetsService.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest).execute();

        // Define the range to retrieve the filtered data from
        String rangeName = "Sheet1!A1:C";
        String query = "select * where A contains 'Apple'";

        // Create the request to get the filtered data
        ValueRange response = sheetsService.spreadsheets().values()
                .get(spreadsheetId, rangeName)
                .setMajorDimension("ROWS")
                .setValueRenderOption("FORMATTED_VALUE")
                .setDateTimeRenderOption("FORMATTED_STRING")
                .setDataFilters(Collections.singletonList(new DataFilter()
                        .setGridRange(range)
                        .setFilterCriteria(filterCriteria)))
                .execute();

        // Process the filtered data
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            for (List<Object> row : values) {
                System.out.printf("%
