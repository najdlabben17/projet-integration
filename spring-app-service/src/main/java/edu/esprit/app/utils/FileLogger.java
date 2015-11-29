package edu.esprit.app.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements CustomLogger {

	private String loggingClassName;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");

	public FileLogger(String name) {

		this.loggingClassName = name;
	}

	public String getLoggingClassName() {
		return loggingClassName;
	}

	public void setLoggingClassName(String loggingClassName) {
		this.loggingClassName = loggingClassName;
	}

	@Override
	public void log(String message) {

		File file = new File("/users/wael.aniba/appLog.txt");
		try(FileWriter fw = new FileWriter(file, true);) {
			
			file.createNewFile();
			fw.append("\n[" + loggingClassName + "] : " + sdf.format(new Date()) + " : " + message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
