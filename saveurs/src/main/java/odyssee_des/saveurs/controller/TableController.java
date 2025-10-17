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

import odyssee_des.saveurs.model.sql.Tables;
import odyssee_des.saveurs.service.TableService;

@RestController
@RequestMapping("/tables")
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/getAll")
    public List<Tables> getAllTables() {
        return tableService.getAllTables();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tables> getTableById(@PathVariable Long id) {
        Tables table = tableService.getTableById(id);
        if (table != null) {
            return ResponseEntity.ok(table);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/addTable")
    public Tables createTable(@RequestBody Tables table) {
        return tableService.addTable(table);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Tables> updateTable(@PathVariable Long id, @RequestBody Tables table) {
        table.setId(id);
        Tables updatedTable = tableService.updateTable(table);
        if (updatedTable != null) {
            return ResponseEntity.ok(updatedTable);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTable(@PathVariable Long id) {
        tableService.deleteTable(id);
        return ResponseEntity.noContent().build();
    }
}
