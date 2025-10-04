package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.User;
import odyssee_des.saveurs.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository ur;

    @Autowired
    public UserService(UserRepository ur){
        this.ur = ur;
    }

    public List<User> getAllUsers(){
        return ur.findAll();
    }

    public User getUserById(Long id){
        return ur.findById(id).orElse(null);
    }

    public User addUser(User u){
        return ur.save(u);
    }

    public User udpateUser(User u){
        if(u.getId() != 0 && ur.existsById(u.getId())){
            return ur.save(u);
        } else {
            throw new EntityNotFoundException("L'utilisateur n'existe pas.");
        }
    }

    public void deleteUser(Long id){
        ur.deleteById(id);
    }
}
