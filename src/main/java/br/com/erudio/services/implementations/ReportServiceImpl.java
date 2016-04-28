package br.com.erudio.services.implementations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.erudio.models.fakedata.DataBean;
import br.com.erudio.models.fakedata.DataBeanMaker;
import br.com.erudio.services.ReportService;
import br.com.erudio.utils.FileUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ReportServiceImpl implements ReportService {
	
	private Logger logger = Logger.getLogger(ReportServiceImpl.class);

	@Override
	public byte[] makeReport() throws Exception {

    	FileUtils fileUtils = new FileUtils();
	
    	DataBeanMaker dataBeanMaker = new DataBeanMaker();
		InputStream inputStream = getClass().getResourceAsStream("template/test_jasper.jrxml");
        
        ArrayList<DataBean> dataBeanList = dataBeanMaker.getDataBeanList();
        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);
		@SuppressWarnings("rawtypes")
		Map parameters = new HashMap();
		File pdf = File.createTempFile("output.", ".pdf");
        try {
			JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters, beanColDataSource);
			JasperExportManager.exportReportToPdfStream(jasperPrint, new FileOutputStream(pdf));
		} catch (Exception e) {
			logger.error(e);
		}
        return fileUtils.getBytesFromFile(pdf);
	}
}
