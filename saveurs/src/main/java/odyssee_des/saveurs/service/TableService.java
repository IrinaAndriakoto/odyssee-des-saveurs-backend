package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import odyssee_des.saveurs.model.sql.Table;
import odyssee_des.saveurs.repository.TableRepository;

@Service
public class TableService {
    private final TableRepository tr;

    @Autowired
    public TableService(TableRepository t){
        this.tr = t;
    }

    public List<Table> getAllTables(){
        return tr.findAll();
    }
    public Table getTableById(Long id){
        return tr.findById(id).orElse(null);
    }
    public Table addTable(Table t){
        return tr.save(t);
    }
    public Table updateTable(Table t){
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
