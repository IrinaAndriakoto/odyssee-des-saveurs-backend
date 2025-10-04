package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.Stock;
import java.util.List;
import java.util.Optional;

public interface StockService {
    List<Stock> getAll();
    Optional<Stock> getById(Long id);
    Stock create(Stock s);
    Stock update(Long id, Stock s);
    void delete(Long id);
}