package repo;

import model.CoinTransfer;
import model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CoinTransferRepository extends CrudRepository<CoinTransfer, Long> {
    public List<CoinTransfer> findAllByFromId(Long from_id);
    public List<CoinTransfer> findAllByFrom(User from);
    public List<CoinTransfer> findAllByReceiverId(Long receiver_id);
    public List<CoinTransfer> findAllByReceiver(User receiver);
}
