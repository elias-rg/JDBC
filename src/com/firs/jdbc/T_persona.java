package com.firs.jdbc;

public class T_persona {
	private String a_id_persona ; 
	private String a_nombre_persona ;
	private String a_telefono ;
	public String getA_id_persona() {
		return a_id_persona;
	}
	public void setA_id_persona(String a_id_persona) {
		this.a_id_persona = a_id_persona;
	}
	public String getA_nombre_persona() {
		return a_nombre_persona;
	}
	public void setA_nombre_persona(String a_nombre_persona) {
		this.a_nombre_persona = a_nombre_persona;
	}
	public String getA_telefono() {
		return a_telefono;
	}
	public void setA_telefono(String a_telefono) {
		this.a_telefono = a_telefono;
	}
	@Override
	public String toString() {
		return "T_persona [a_id_persona=" + a_id_persona + ", a_nombre_persona=" + a_nombre_persona + ", a_telefono="
				+ a_telefono + "]";
	}
	
}
