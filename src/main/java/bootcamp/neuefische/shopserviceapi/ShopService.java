package bootcamp.neuefische.shopserviceapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public void removeProduct(String id){
        productRepo.deleteById(id);
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product findProductById(String id){
        return productRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found!"));
    }

    public Product findProductByName(String name){
        return productRepo.findByName(name)
                .orElseThrow(() -> new NoSuchElementException("Product not found!"));
    }

    public Order addOrder(List<String> productIds){
        List<Product> products = productRepo.findAllById(productIds);
            if(products.isEmpty()) {
                throw new NoSuchElementException("No Product was found!");
            }
        Order newOrder = new Order(UUID.randomUUID().toString(), products, OrderStatus.PROCESSING, ZonedDateTime.now());
        return orderRepo.save(newOrder);
    }

    public void removeOrder(String id){
        orderRepo.deleteById(id);
    }

    public List<Order> findAllOrders(){
        return orderRepo.findAll();
    }

    public Order findOrderById(String id){
        return orderRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found!"));
    }

    public List<Order> findOrdersByStatus(OrderStatus status) {
        return orderRepo.findByStatus(status)
                .stream().collect(Collectors.toList());
    }

}
