package odyssee_des.saveurs.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import odyssee_des.saveurs.model.sql.Stock;
import odyssee_des.saveurs.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
    private final StockService service;
    public StockController(StockService service) { this.service = service; }

    @GetMapping("/getAll")
    public ResponseEntity<List<Stock>> getAllStocks() { return ResponseEntity.ok(service.getAllStocks()); }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Stock stock = service.getStockById(id);
        if (stock != null) {
            return ResponseEntity.ok(stock);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Stock> createStock(@RequestBody Stock s) {
        return ResponseEntity.status(201).body(service.addStock(s));
    }

    @PutMapping("/update")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock s) {
        return ResponseEntity.ok(service.updateStock(s));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        service.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}