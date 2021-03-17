package interfaces;

import java.util.List;

import com.firs.jdbc.T_ficha;

public interface DAOFicha {
	
	public void registrar(T_ficha ficha) throws Exception;  
	public void modificar(T_ficha ficha) throws Exception;  
	public void eliminar(T_ficha ficha) throws Exception;
	public List<T_ficha> lista() throws Exception;  
	public List<T_ficha> getByName() throws Exception;
	List<T_ficha> getByName(String nombre) throws Exception;
	
}
