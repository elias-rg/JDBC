package com.firs.jdbc;

public class T_ficha {
	private String a_id_ficha ; 
	private String a_nombre_ficha ;
	/**
	 * @return the a_id_ficha
	 */
	public String getA_id_ficha() {
		return a_id_ficha;
	}
	/**
	 * @param a_id_ficha the a_id_ficha to set
	 */
	public void setA_id_ficha(String a_id_ficha) {
		this.a_id_ficha = a_id_ficha;
	}
	/**
	 * @return the a_nombre_ficha
	 */
	public String getA_nombre_ficha() {
		return a_nombre_ficha;
	}
	/**
	 * @param a_nombre_ficha the a_nombre_ficha to set
	 */
	public void setA_nombre_ficha(String a_nombre_ficha) {
		this.a_nombre_ficha = a_nombre_ficha;
	}
	@Override
	public String toString() {
		return "T_ficha [a_id_ficha=" + a_id_ficha + ", a_nombre_ficha=" + a_nombre_ficha + "]";
	}
	
	
}
