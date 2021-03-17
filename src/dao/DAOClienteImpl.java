package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.firs.jdbc.T_cliente;
import com.firs.jdbc.T_persona;

import interfaces.DAOCliente;

public class DAOClienteImpl extends Conexion implements DAOCliente {

	@Override
	public void registrar(T_cliente cliente) throws Exception {
		try {
			this.conectar();
			
			PreparedStatement st = this.conexion.prepareStatement("INSERT INTO public.t_cliente(\r\n"
					+ "	a_id_cliente, a_nombre_cliente, a_telefono)\r\n"
					+ "	VALUES (?, ?, ?);"); 
			st.setString(1,UUID.randomUUID().toString()); 
			st.setString(2, cliente.getA_nombre_cliente());
			st.setString(3, cliente.getA_telefono());
			
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void modificar(T_cliente cliente) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("UPDATE public.t_cliente\r\n"
					+ "	SET  a_nombre_cliente=?, a_telefono=?\r\n"
					+ "	WHERE a_id_cliente = ?;");
			st.setString(1, cliente.getA_nombre_cliente());
			st.setString(2, cliente.getA_telefono());
			st.setString(3, cliente.getA_id_cliente());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void eliminar(T_cliente cliente) throws Exception {
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("DELETE FROM t_ficha where a_id_cliente = ?");
			st.setString(1, cliente.getA_id_cliente());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public List<T_cliente> lista() throws Exception {
		List<T_cliente> lista = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("SELECT * from t_cliente");
			
			 lista = new ArrayList<T_cliente>();
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					T_cliente cliente = new T_cliente();
					cliente.setA_id_cliente(rs.getString("a_id_cliente"));
					cliente.setA_nombre_cliente("a_nombre_cliente");
					cliente.setA_telefono("a_telefono");
					lista.add(cliente);
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
	public List<T_cliente> getByName(String name) throws Exception {
		List<T_cliente> lista = null;
		try {
			this.conectar();
			PreparedStatement st = this.conexion.prepareStatement ("SELECT * from t_cliente where a_nombre_cliente = ?");
			st.setString(1, name);
			 lista = new ArrayList<T_cliente>();
				ResultSet rs =  st.executeQuery();
				while(rs.next()) {
					T_cliente cliente = new T_cliente();
					cliente.setA_id_cliente(rs.getString("a_id_cliente"));
					cliente.setA_nombre_cliente("a_nombre_cliente");
					cliente.setA_telefono("a_telefono");
					lista.add(cliente);
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
