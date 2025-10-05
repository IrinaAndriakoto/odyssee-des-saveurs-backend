package odyssee_des.saveurs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

import odyssee_des.saveurs.model.sql.Stock;
import odyssee_des.saveurs.repository.StockRepository;

@Service
public class StockService {
    private final StockRepository sr;

    @Autowired
    public StockService(StockRepository s) {
        this.sr = s;
    }

    public List<Stock> getAllStocks() {
        return sr.findAll();
    }

    public Stock getStockById(Long id) {
        return sr.findById(id).orElse(null);
    }
    public Stock addStock(Stock s) {
        return sr.save(s);
    }
    public Stock updateStock(Stock s) {
        if (s.getId() != 0 && sr.existsById(s.getId())) {
            return sr.save(s);
        } else {
            throw new EntityNotFoundException("Le stock n'existe pas");
        }
    }
    public void deleteStock(Long id) {
        sr.deleteById(id);
    }
}