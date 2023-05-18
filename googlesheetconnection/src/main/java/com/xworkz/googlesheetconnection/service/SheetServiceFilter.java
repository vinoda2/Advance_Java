package com.xworkz.googlesheetconnection.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.mortbay.log.Log;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AddFilterViewRequest;
import com.google.api.services.sheets.v4.model.BasicFilter;
import com.google.api.services.sheets.v4.model.BatchGetValuesByDataFilterRequest;
import com.google.api.services.sheets.v4.model.BatchGetValuesByDataFilterResponse;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetResponse;
import com.google.api.services.sheets.v4.model.BooleanCondition;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ConditionValue;
import com.google.api.services.sheets.v4.model.DataFilter;
import com.google.api.services.sheets.v4.model.FilterCriteria;
import com.google.api.services.sheets.v4.model.FilterView;
import com.google.api.services.sheets.v4.model.GetSpreadsheetByDataFilterRequest;
import com.google.api.services.sheets.v4.model.GridData;
import com.google.api.services.sheets.v4.model.GridRange;
import com.google.api.services.sheets.v4.model.MatchedValueRange;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.SortSpec;
import com.google.api.services.sheets.v4.model.Spreadsheet;


@Service
public class SheetServiceFilter {
	private static final String APPLICATION_NAME = "Google sheet new ";
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS);
	private static String range = "A2:E";
	private static Sheets sheet;
	GoogleCredential credential;

	// loading the connection
	public SheetServiceFilter() throws IOException, GeneralSecurityException {
		credential = GoogleCredential
				.fromStream(new FileInputStream(new ClassPathResource("credentials.json").getFile().getAbsolutePath()))
				.createScoped(SCOPES);
		sheet = new Sheets.Builder(new NetHttpTransport(), JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

	String spreadsheetId = "1WiZVpFrIsl_Wf_mpAG8LV-ObF2Gmwb8Wjw9Bev6qmY4";

	public List<Object> getData(String searchText) throws IOException {
		List<Object> list = new ArrayList<>();
		
		DataFilter dataFilter = new DataFilter().setGridRange(new GridRange().setSheetId(0).setStartRowIndex(1)
				.setEndRowIndex(100).setStartColumnIndex(0).setEndColumnIndex(4));

		GetSpreadsheetByDataFilterRequest request = new GetSpreadsheetByDataFilterRequest()
				.setDataFilters(Arrays.asList(dataFilter)).setIncludeGridData(true);

		Spreadsheet response = sheet.spreadsheets().getByDataFilter(spreadsheetId, request).execute();

		// multiple sheets
		List<Sheet> sheets = response.getSheets();
		for (Sheet sheet : sheets) {
			List<GridData> gridDataList = sheet.getData();
			for (GridData gridData : gridDataList) {
				List<RowData> rowDataList = gridData.getRowData();
				Log.info("row values :" + rowDataList.size());
				for (RowData rowData : rowDataList) {
					List<CellData> cellDataList = rowData.getValues();
					for (CellData cellData : cellDataList) {
						if (cellData.getFormattedValue().contains(searchText)) {
							list.add(cellData.getFormattedValue());

						} else {
							Log.info("Data not found");
						}
					}
				}
			}
		}
		Log.info("list of data:" + list);
		return list;
	}

	public String getDataFilter(String searchText) throws IOException {

		BooleanCondition booleanCondition = new BooleanCondition();
		booleanCondition.setFactory(JSON_FACTORY);
		FilterCriteria criteria = new FilterCriteria().setCondition(booleanCondition.setType("TEXT_CONTAINS")
				.setValues(Arrays.asList(new ConditionValue().setUserEnteredValue(searchText))));
		Log.info("setting creteria:" + criteria);

		Map<String, FilterCriteria> mapFilter = new LinkedHashMap<>();
		mapFilter.put("A", criteria);

		Log.info("setting map Filter");
		BasicFilter filter = new BasicFilter().setRange(new GridRange().setSheetId(0).setStartRowIndex(0)
				.setEndRowIndex(10).setStartColumnIndex(0).setEndColumnIndex(5)).setCriteria(mapFilter);

		List<DataFilter> fill = new ArrayList<>();

		Log.info("setting basic criteria" + filter);
		BatchGetValuesByDataFilterRequest request = new BatchGetValuesByDataFilterRequest().set(searchText, filter)
				.setDataFilters(fill).setValueRenderOption("UNFORMATTED_VALUE")
				.setDateTimeRenderOption("SERIAL_NUMBER");
		Log.info(request.toString());

		try {
			BatchGetValuesByDataFilterResponse response = sheet.spreadsheets().values()
					.batchGetByDataFilter(searchText, request).execute();
			List<MatchedValueRange> matchedRanges = response.getValueRanges();
			Log.info(matchedRanges.toString());
		} catch (GoogleJsonResponseException e) {
			if (e.getStatusCode() == 400) {
				Log.info("Invalid JSON payload received:" + e.getMessage());
			} else {
				Log.info("Google Sheets API returned an error:" + e.getMessage());
			}
		}
		return "this is new test";
	}

	public String filter(String searchText) throws IOException {

		/*
		 * BooleanCondition condition = new BooleanCondition();
		 * condition.setType("TEXT_CONTAINS"); condition.setFactory(JSON_FACTORY);
		 */
/*
		DataFilter dataFilter = new DataFilter().setGridRange(new GridRange().setSheetId(0).setStartRowIndex(1)
				.setEndRowIndex(100).setStartColumnIndex(0).setEndColumnIndex(4));
		System.out.println(dataFilter);
		
		List<DataFilter> fill = new ArrayList<>();
		fill.add(dataFilter);
		
		GetSpreadsheetByDataFilterRequest request = new GetSpreadsheetByDataFilterRequest().setDataFilters(fill);
		System.out.println(request.isEmpty());
		request.setIncludeGridData(true);
		AddFilterViewRequest addFilterViewRequest=new  AddFilterViewRequest();
		
		Map<String, String> filter=new HashMap<String, String>();
		
		filter.put("title", "Sample Filter");
		filter.put("range", "A1");
		
		Map<String, Object> filterView=new HashMap<String, Object>();
		filterView.put("addFilterView", filter);
		
		Spreadsheet responses=sheet.spreadsheets().getByDataFilter(spreadsheetId,request).execute();
		System.out.println(responses);
		
	
		GridRange myRange = new GridRange()
		            .setSheetId(0)
		            .setStartRowIndex(0)
		            .setStartColumnIndex(0)
		            .setEndRowIndex(100);
		System.out.println(myRange);
		
		BasicFilter filter = new BasicFilter()
	            .setRange(myRange)
	            .setSortSpecs(Collections.singletonList(
	                new SortSpec()
	                    .setDimensionIndex(3)
	                    .setSortOrder("DESCENDING")));
	        
		System.out.println(filter);
	    
		filter.put("title", "Sample Filter");
		filter.put("range", "A1");
		
		Map<String, Object> filterView=new HashMap<String, Object>();
		filterView.put("addFilterView", filter);
		
		AddFilterViewRequest addFilterViewRequest = new AddFilterViewRequest()
				.set("email","vinoda@gmail.com")
				.setFilter((FilterView) filterView);
	        System.out.println(addFilterViewRequest);
	        
	        
		/*
		
		        BasicFilter filter = new BasicFilter()
		            .setRange(myRange)
		            .setSortSpecs(Collections.singletonList(
		                new SortSpec()
		                    .setDimensionIndex(3)
		                    .setSortOrder("DESCENDING")));
		        
		        System.out.println(filter);
		        
		        AddFilterViewRequest addFilterViewRequest = new AddFilterViewRequest();
		        BatchUpdateSpreadsheetResponse  response= sheet.spreadsheets().batchUpdate(spreadsheetId, new BatchUpdateSpreadsheetRequest()
		            .setRequests(Collections.singletonList(
		                new Request()
		                    .setAddFilterView(addFilterViewRequest))))
		            .execute();
		        System.out.println(addFilterViewRequest);
		        System.out.println(response);
		*/
		return searchText;
	}
	
	
}
