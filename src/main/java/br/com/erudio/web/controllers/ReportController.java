package br.com.erudio.web.controllers;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.erudio.services.ReportService;

@Controller
@RequestMapping("/report")
@Api(value = "/report", description = "Building a report in PDF!")
public class ReportController {

	@Autowired
	private ReportService reportService;
	
	FileUtils fileUtils = new FileUtils();

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Building a report in PDF!", notes = "Building a report in PDF!")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Houston we have a problem") })
	public @ResponseBody HttpEntity<byte[]> makeReport(HttpServletResponse response) throws Exception {
		byte[] buffer = reportService.makeReport();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("application/pdf"));
		headers.setContentDispositionFormData("Content-Disposition", "output.pdf");
	    headers.setContentLength(buffer.length);
		return new HttpEntity<byte[]>(buffer, headers);
	}
}