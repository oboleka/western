package obolochkova.repository;

import obolochkova.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    void deleteByEmail(String email);

    User findByEmail(String email);
}
