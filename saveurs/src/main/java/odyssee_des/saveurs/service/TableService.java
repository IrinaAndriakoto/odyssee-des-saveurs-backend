package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Tables;
import odyssee_des.saveurs.repository.TableRepository;

@Service
public class TableService {
    private final TableRepository tr;

    @Autowired
    public TableService(TableRepository t){
        this.tr = t;
    }

    public List<Tables> getAllTables(){
        return tr.findAll();
    }
    public Tables getTableById(Long id){
        return tr.findById(id).orElse(null);
    }
    public Tables addTable(Tables t){
        return tr.save(t);
    }
    public Tables updateTable(Tables t){
        if(t.getId() != 0 && tr.existsById(t.getId())) {
            return tr.save(t);
        }
        else {
            throw new EntityNotFoundException("La table n'existe pas");
        }
    }
    public void deleteTable(Long id) {
        tr.deleteById(id);
    }
}
