package interfaces;

import java.util.List;

import com.firs.jdbc.T_persona;



public interface DAOPersona {
	public void registrar(T_persona persona) throws Exception;  
	public void modificar(T_persona persona) throws Exception;  
	public void eliminar(T_persona persona) throws Exception;
	public List<T_persona> lista() throws Exception;  
	public List<T_persona> getByName(String name) throws Exception;
	public List<T_persona> getById(String id) throws Exception;
	public List<T_persona> getByPhone(String phone) throws Exception;
	
	
	
}
