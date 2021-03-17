package com.firs.jdbc;

import com.api.api.Api;

import dao.DAOClienteImpl;
import dao.DAOFichaImpl;
import dao.DAOPersonaImpl;
import interfaces.DAOCliente;
import interfaces.DAOFicha;
import interfaces.DAOPersona;

public class Test {
	

	public static void main(String[] args) throws Exception {
		
		
		  T_ficha ficha = new T_ficha(); 
		  ficha.setA_nombre_ficha("Santiago");
		  
		  
		  try { 
			  DAOFicha dao = new DAOFichaImpl();
			  dao.registrar(ficha); 
			  } catch (Exception e) 
		  { System.out.println(e.getMessage()); 
		  }
		 

	
		/*
		 * Api test = new Api(); System.out.print(test.getDatosFicha());
		 */
		
		/*
		 * T_persona persona = new T_persona(); persona.setA_nombre_persona("ilyes");
		 * persona.setA_telefono("0556824604");
		 * 
		 * try { DAOPersona dao = new DAOPersonaImpl(); dao.registrar(persona); }catch
		 * (Exception e) { System.out.println(e.getMessage()); }
		 */
		
		/*
		 * T_cliente cliente = new T_cliente(); cliente.setA_nombre_cliente("reguieg");
		 * cliente.setA_telefono("644534881");
		 * 
		 * try { DAOCliente dao = new DAOClienteImpl(); dao.registrar(cliente);
		 * }catch(Exception e ) { System.out.println(e.getMessage()); }
		 */
	}	
}
