package br.com.erudio.services.implementations;

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
//        byte[] array = fileUtils.getBytesFromFile(pdf);
		return null;
	}
    
}
