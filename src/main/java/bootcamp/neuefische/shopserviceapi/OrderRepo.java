package bootcamp.neuefische.shopserviceapi;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends MongoRepository<Order, String> {
    public Optional<Order> findByStatus(OrderStatus status);
}
