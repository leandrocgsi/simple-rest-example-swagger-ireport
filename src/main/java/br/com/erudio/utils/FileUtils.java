package br.com.erudio.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class FileUtils {
	
	private Logger logger = Logger.getLogger(FileUtils.class);
	
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