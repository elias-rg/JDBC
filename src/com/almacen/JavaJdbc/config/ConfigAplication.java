package com.almacen.JavaJdbc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class ConfigAplication extends Configuration {
private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(ConfigAplication.class);
	
	static ConfigAplication instance;

	/**
	 * 
	 */
	public ConfigAplication() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static final ConfigAplication getInstance () {
		
		logger.debug("Inicio");
		
		if (instance == null ) {
				instance = new ConfigAplication();	
				instance.loadProperties(PATH_CONFIGURATION);
		
		}
		
		logger.debug("Final");
		
		return instance;		
	} 
	
	

	public String getDataBaseUserPwd(){
		
		return getProperty(DB_USER_PWD);
	}
	
	
	public String getDataBaseUser(){
		
		return getProperty(DB_USER);
	}
	
	
	public String getDataBaseConnectionURI(){
		
		return getProperty(DB_CONNECTION_URI);
	}
}
