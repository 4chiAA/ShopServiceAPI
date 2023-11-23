package bootcamp.neuefische.shopserviceapi;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shop;

    @GetMapping("/product")
    public List<Product> findAllProducts(){
        return shop.findAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable String id){
        return shop.findProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name){
        return shop.findProductByName(name);
    }

    @PostMapping("/product")
    public List<Product> addProduct(@RequestBody List<Product> product){
        return shop.addProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void removeProduct(@PathVariable String id){
        shop.removeProduct(id);
    }

    @GetMapping("/order")
    public List<Order> findAllOrders(){
        return shop.findAllOrders();
    }

    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable String id){
        return shop.findOrderById(id);
    }

    @GetMapping("/order/{status}")
    public List<Order> findOrderByStatus(@PathVariable OrderStatus status){
        return shop.findOrdersByStatus(status);
    }

    @PostMapping("/order")
    public Order addOrder(@RequestBody List<String> productIds){
        return shop.addOrder(productIds);
    }

    @DeleteMapping("/order/{id}")
    public void removeOrder(@PathVariable String id){
        shop.removeOrder(id);
    }
}
