package com.xworkz.googlesheetconnection.controller;

import java.io.IOException;
import java.util.List;

import org.mortbay.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.api.services.sheets.v4.model.DataFilter;
import com.google.api.services.sheets.v4.model.GridRange;
import com.xworkz.googlesheetconnection.dto.TraineeDTO;
import com.xworkz.googlesheetconnection.service.SheetService;
import com.xworkz.googlesheetconnection.service.SheetServiceFilter;

@RestController
@RequestMapping("/trainees")
@CrossOrigin(origins = "http://localhost:3000")
public class AutoSuggestionController {
	
	@Autowired
	SheetService sheetService;
	@Autowired
	SheetServiceFilter sheetServiceFilter;
	/*
	@GetMapping("/search/{searchText}")
	public List<TraineeDTO> findByMobile(@RequestHeader String sheetId, @PathVariable String searchText)
			throws IOException {
		return this.sheetService.findByMobile(sheetId, searchText);
	}
	*/
	@GetMapping("/search/{searchText}")
	public List<Object> getFilter(@PathVariable String searchText) throws IOException {
		return this.sheetServiceFilter.getData(searchText);
	}
	@GetMapping("/getdata/{searchText}")
	public String getData(@PathVariable String searchText) throws IOException {	
		return this.sheetServiceFilter.getDataFilter(searchText);
	}
	
	@GetMapping("/filter/{searchText}")
	public String filter(@PathVariable String searchText) throws IOException {
		return this.sheetServiceFilter.filter(searchText);
	}
	
	@GetMapping("/email/{email}")
	public String checkEmail(@RequestHeader String sheetId,@PathVariable String email) throws IOException{
		return this.sheetService.findEmail(sheetId, email);
	}
	
	@GetMapping("/number/{contactNumber}")
	public String checkNumber(@RequestHeader String sheetId,@PathVariable String contactNumber) throws IOException {
		return this.sheetService.findNumber(sheetId, contactNumber);
	}
	
	@GetMapping("/page")
	public List<TraineeDTO> pagination(@RequestHeader String sheetId,@RequestParam int startIndex,@RequestParam  int endIndex) {
		return this.sheetService.dataPagination(sheetId, startIndex, endIndex);
	}
}