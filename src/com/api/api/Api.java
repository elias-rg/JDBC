package com.api.api;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.firs.jdbc.T_cliente;
import com.firs.jdbc.T_ficha;

import dao.DAOFichaImpl;
import interfaces.DAOFicha;

public class Api implements Serializable {
	
	public List<T_ficha> getDatosFicha() throws Exception {

		DAOFicha ficha = new DAOFichaImpl();

		return ficha.lista();
	}
	

	
	
}
