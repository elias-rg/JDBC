package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.firs.jdbc.T_ficha;
import com.firs.jdbc.T_persona;

import interfaces.DAOPersona;

public class DAOPersonaImpl extends Conexion implements DAOPersona {

	@Override
	public void registrar(T_persona persona) throws Exception {
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO public.t_persona(\r\n"
					+ "	a_id_persona, a_nombre_persona, a_telefono)\r\n"
					+ "	VALUES (?, ?, ?);"); 
			st.setString(1,UUID.randomUUID().toString()); // Système D
			st.setString(2, persona.getA_nombre_persona());
			st.setString(3, persona.getA_telefono() );
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void modificar(T_persona persona) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("UPDATE t_persona set a_nombre_persona where a_id_persona = ?");// should change where id to  a_id_ficha 
			st.setString(1, persona.getA_id_persona());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void eliminar(T_persona persona) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("DELETE FROM t_persona  where a_id_persona = ?");
			st.setString(1, persona.getA_id_persona());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public List<T_persona> lista() throws Exception {
		List<T_persona> lista = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("SELECT * FROM public.t_persona\r\n"
					+ "ORDER BY a_id_persona ASC ");
			
			 lista = new ArrayList<T_persona>();
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					T_persona persona = new T_persona();
					persona.setA_id_persona(rs.getString("a_id_persona"));
					persona.setA_nombre_persona(rs.getString("a_nombre_persona"));
					lista.add(persona);
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
	public List<T_persona> getById(String id) throws Exception {
		List<T_persona> lista = null;
		try {
			
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement ("select * from t_persona where a_id_persona = ?  ");
				lista = new ArrayList<T_persona>();
			 	T_persona persona = null;
				st.setString(1, id );
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					
					T_persona persona1 = new T_persona();
					persona1.setA_id_persona(rs.getString("a_id_persona"));
					persona1.setA_nombre_persona(rs.getString("a_nombre_persona"));
					lista.add(persona1);
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
	public List<T_persona> getByName(String name) throws Exception {
		List<T_persona> lista = null;
		try {
			
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement ("select * from t_persona where a_nombre_persona = ?  ");
				lista = new ArrayList<T_persona>();
			 	T_persona persona = null;
				st.setString(1, name );
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					
					T_persona persona1 = new T_persona();
					persona1.setA_id_persona(rs.getString("a_id_persona"));
					persona1.setA_nombre_persona(rs.getString("a_nombre_persona"));
					lista.add(persona1);
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
	public List<T_persona> getByPhone(String phone) throws Exception {
		List<T_persona> lista = null;
		try {
			
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement ("select * from t_persona where a_nombre_persona = ?  ");
				lista = new ArrayList<T_persona>();
			 	T_persona persona = null;
				st.setString(1, phone );
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					
					T_persona persona1 = new T_persona();
					persona1.setA_id_persona(rs.getString("a_id_persona"));
					persona1.setA_nombre_persona(rs.getString("a_nombre_persona"));
					lista.add(persona1);
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

}
