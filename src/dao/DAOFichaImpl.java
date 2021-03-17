package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.firs.jdbc.T_cliente;
import com.firs.jdbc.T_ficha;

import interfaces.DAOFicha;

public class DAOFichaImpl extends Conexion implements DAOFicha {

	@Override
	public void registrar(T_ficha ficha) throws Exception {
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO public.t_ficha(\r\n"
					+ "	a_id_ficha, a_nombre_ficha)\r\n" + "	VALUES (?, ?);"); 
			st.setString(2, ficha.getA_nombre_ficha());
			st.setString(1,UUID.randomUUID().toString()); // Système D
			
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void modificar(T_ficha ficha) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("UPDATE t_ficha set a_nombre_ficha where id = ?");// should change where id to  a_id_ficha 
			st.setString(1, ficha.getA_id_ficha());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}

	@Override
	public void eliminar(T_ficha ficha) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("DELETE FROM t_ficha set a_nombre_ficha where id = ?");
			st.setString(1, ficha.getA_id_ficha());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
 
	@Override
	public List<T_ficha> lista() throws Exception {
		List<T_ficha> lista = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("SELECT * FROM public.t_ficha\r\n"
					+ "ORDER BY a_id_ficha ASC ");
			
			 lista = new ArrayList<T_ficha>();
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					T_ficha ficha = new T_ficha();
					ficha.setA_id_ficha(rs.getString("a_id_ficha"));
					ficha.setA_nombre_ficha(rs.getString("a_nombre_ficha"));
					lista.add(ficha);
				}
				rs.close();
				st.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		return lista;
	}

	
	@Override
	public List<T_ficha> getByName(String nombre) throws Exception {
		
		List<T_ficha> lista = null;
		try {
			
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement ("select * from t_ficha where a_nombre_ficha = ?  ");
				lista = new ArrayList<T_ficha>();
			 	T_ficha ficha = null;
				st.setString(1, nombre);
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					
					T_ficha ficha1 = new T_ficha();
					ficha1.setA_id_ficha(rs.getString("a_id_ficha"));
					ficha1.setA_nombre_ficha(rs.getString("a_nombre_ficha"));
					lista.add(ficha1);
				}
				rs.close();
				st.close();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		return lista;
	}

	@Override
	public List<T_ficha> getByName() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	

}
