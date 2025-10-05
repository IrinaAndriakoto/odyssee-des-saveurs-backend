package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Personnel;
import odyssee_des.saveurs.repository.PersonnelRepository;

@Service
public class PersonnelService {
    private final PersonnelRepository pr;

    @Autowired
    public PersonnelService(PersonnelRepository p) {
        this.pr = p;
    }

    public List<Personnel> getAllPersonnels(){
        return pr.findAll();
    }
    public Personnel getPersonnelById(Long id){
        return pr.findById(id).orElse(null);
    }
    public Personnel addPersonnel(Personnel pp){
        return pr.save(pp);
    }
    public Personnel updatePersonnel(Personnel pp) {
        if(pp.getId() != 0 && pr.existsById(pp.getId())) {
            return pr.save(pp);
        } else {
            throw new EntityNotFoundException("Personnel non existant.");
        }
    }
    public void deletePersonnel(Long id) {
        pr.deleteById(id);
    }
}
