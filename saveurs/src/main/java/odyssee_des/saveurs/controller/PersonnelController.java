package odyssee_des.saveurs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odyssee_des.saveurs.model.sql.Personnel;
import odyssee_des.saveurs.service.PersonnelService;

@RestController
@RequestMapping("/personnel")
public class PersonnelController {
    private final PersonnelService ps;

    @Autowired
    public PersonnelController(PersonnelService p){
        this.ps = p;
    }

    @GetMapping("/getAll")
    public List<Personnel> getAllPersonnels(){
        return ps.getAllPersonnels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Personnel> getPersonnelById(@PathVariable Long id){
        Personnel personnel = ps.getPersonnelById(id);
        if(personnel != null){
            return ResponseEntity.ok(personnel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addPersonnel")
    public Personnel createPersonnel(@RequestBody Personnel p){
        return ps.addPersonnel(p);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Personnel> updatePersonnel(@PathVariable Long id, @RequestBody Personnel  p){
        p.setId(id);
        Personnel updatedPersonnel = ps.updatePersonnel(p);
        if(updatedPersonnel != null){
            return ResponseEntity.ok(updatedPersonnel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }   
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonnel(@PathVariable Long id){ 
        ps.deletePersonnel(id);
        return ResponseEntity.noContent().build();
    }
}
