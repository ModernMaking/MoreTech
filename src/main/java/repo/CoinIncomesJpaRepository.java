package repo;

import model.CoinIncome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CoinIncomesJpaRepository extends JpaRepository<CoinIncome, Long> {
}
