package service;

import datos.PersonaDao;
import domain.Persona;
import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;

@Stateless
@WebService(endpointInterface = "service.PersonaServiceWs")
@DeclareRoles({"ROLE_ADMIN","ROLE_USER"})
@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
public class PersonServiceImpl implements PersonServiceRemote, PersonServiceLocal, PersonaServiceWs {

    
    @Inject
    private PersonaDao personaDao;

    @Resource
    private SessionContext contexto;
    
    @Override
    public List<Persona> listarPersonas() {
         return personaDao.findAllPersons();
    }

    @Override
    public Persona encontrarId(Persona persona) {
        return personaDao.findPersonByID(persona);
    }

    @Override
    public Persona encontrarEmail(Persona persona) {
        return personaDao.findPersonByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
     personaDao.insertPerson(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
            try {
            personaDao.updatePerson(persona);
        } catch (Throwable t) {
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    @RolesAllowed("ROLE_ADMIN")
    public void eliminarPersona(Persona persona) {
          personaDao.deletePerson(persona);
    }
    
    
    
}
