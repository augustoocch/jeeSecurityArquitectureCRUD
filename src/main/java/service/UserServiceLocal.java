package service;

import domain.Usuario;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserServiceLocal {
    
    public List<Usuario> listUsers ();
    
    public Usuario userFindId (Usuario user);
    
    public void registrarUser(Usuario user);
   
    public void modificarUser(Usuario user);
    
    public void eliminarUser(Usuario user);
    
}
