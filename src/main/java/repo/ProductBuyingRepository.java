package repo;

import model.ProductByuing;
import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductBuyingRepository extends CrudRepository<ProductByuing, Long> {
    public List<ProductByuing> findAllByBuyer(User buyer);
    public List<ProductByuing> findAllByBuyerId(Long buyer_id);
}
