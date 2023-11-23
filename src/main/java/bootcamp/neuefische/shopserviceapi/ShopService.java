package bootcamp.neuefische.shopserviceapi;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ShopService {
    private final ProductRepo productRepo;

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public void removeProduct(Product product){
        productRepo.delete(product);
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
}
