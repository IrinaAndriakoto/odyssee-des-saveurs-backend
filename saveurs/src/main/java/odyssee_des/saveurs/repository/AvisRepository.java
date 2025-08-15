package odyssee_des.saveurs.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import odyssee_des.saveurs.model.nosql.Avis;

public interface AvisRepository extends MongoRepository<Avis,String> {
    
}
