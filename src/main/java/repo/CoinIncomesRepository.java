package repo;

import model.CoinIncome;
import model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinIncomesRepository extends CrudRepository<CoinIncome, Long> {
    public List<CoinIncome> findAllByUserId(Long user_id);
    public List<CoinIncome> findAllByUser(User user);
}
