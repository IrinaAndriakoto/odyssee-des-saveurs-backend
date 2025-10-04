package odyssee_des.saveurs.service;

import odyssee_des.saveurs.model.sql.Stock;
import odyssee_des.saveurs.repository.StockRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {
    private final StockRepository repo;
    public StockServiceImpl(StockRepository repo) { this.repo = repo; }

    @Override public List<Stock> getAll() { return repo.findAll(); }
    @Override public Optional<Stock> getById(Long id) { return repo.findById(id); }
    @Override public Stock create(Stock s) { return repo.save(s); }
    @Override public Stock update(Long id, Stock s) { s.id = id; return repo.save(s); }
    @Override public void delete(Long id) { repo.deleteById(id); }
}