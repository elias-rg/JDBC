package interfaces;

import java.util.List;

import com.firs.jdbc.T_cliente;
import com.firs.jdbc.T_persona;



public interface DAOCliente {
	public void registrar(T_cliente cliente) throws Exception;  
	public void modificar(T_cliente cliente) throws Exception;  
	public void eliminar(T_cliente cliente) throws Exception;
	public List<T_cliente> lista() throws Exception;  
	public List<T_cliente> getByName(String name) throws Exception;
}
