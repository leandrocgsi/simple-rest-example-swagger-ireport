package br.com.erudio.services.implementations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.stereotype.Service;

import br.com.erudio.services.ReportService;

@Service
public class ReportServiceImpl implements ReportService {
	
	private Logger logger = Logger.getLogger(ReportServiceImpl.class);

	@Override
	public byte[] makeReport() throws Exception {

    	FileUtils fileUtils = new FileUtils();
	
//    	DataBeanMaker dataBeanMaker = new DataBeanMaker();
//		InputStream inputStream = getClass().getResourceAsStream("template/test_jasper.jrxml");
//        
//        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
//        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
//		Map parameters = new HashMap();
//		File pdf = File.createTempFile("output.", ".pdf");
//        try {
//			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
//			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
//			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
//		} catch (Exception e) {
//			logger.error(e);
//		}
//        byte[] array = getBytesFromFile(pdf);
		return null;
	}
	
	public byte[] getBytesFromFile(File file) {
		InputStream inputStream = null;
		byte[] buffer = null;
		try {
			inputStream = new FileInputStream(file);
			buffer = new byte[inputStream.available()];
			inputStream.read(buffer);
			inputStream.close();
		} catch (FileNotFoundException e) {
			logger.error(e);
		} catch (IOException e) {
			logger.error(e);
		}
		return buffer;
	}
    
}
