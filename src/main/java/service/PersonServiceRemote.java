package service;

import domain.Persona;
import java.util.List;
import javax.ejb.Remote;
    

@Remote
public interface PersonServiceRemote {
    

    public List<Persona> listarPersonas ();

    public Persona encontrarId (Persona persona);

    public Persona encontrarEmail (Persona persona);

    public void registrarPersona(Persona persona);

    public void modificarPersona (Persona persona);

    public void eliminarPersona (Persona persona);
    
}