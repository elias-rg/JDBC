package com.almacen.JavaJdbc.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class Configuration implements Constants {
private static final long serialVersionUID = 1L;
	
	Properties config= new Properties();
	
	static Configuration instance;
	
	Logger logger = LoggerFactory.getLogger(Configuration.class);
	
	

	public Configuration() {
		// TODO Auto-generated constructor stub
	}

	
	public static Configuration getInstance (String ruta ) {
		if (instance == null ) {
			instance = new Configuration();
			
			instance.loadProperties(ruta);
		}
		return instance;
		
	
	}



	protected void loadProperties(String ruta) {		
			
		InputStream in=null;
		
		try {
			//in = new FileInputStream(ruta);
			
			File jarPath=new File(Configuration.class.getProtectionDomain().getCodeSource().getLocation().getPath());
	        String jarDirectory=jarPath.getParent();
	        logger.info(" propertiesPath- jarDirectory"+jarDirectory);
	        in= new FileInputStream(jarPath+"/"+ruta);
			config.load(in);
			
			
		} catch (Exception e) {
			logger.error("Error leyendo ficero propiedades <"+ruta+">", e);
			

		}
		finally{
			if(in!=null){
				try{
					in.close();
				}
				catch(IOException e){
					logger.error("Error cerrando fichero propiedades <"+ruta+">", e);
				}
			}
		}
	}
	
	
	public String getProperty (String key) {		
		return this.config.getProperty(key);
	}
	
	public String getProperty (String key, String defaultValue) {		
		return this.config.getProperty(key,defaultValue);
	}
	
}
