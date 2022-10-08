package repo;

import model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    //public List<Product> findAllByproductExists(boolean exists);
}
