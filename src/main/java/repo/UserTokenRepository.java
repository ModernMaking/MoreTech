package repo;

import model.User;
import model.UserToken;
import org.springframework.data.repository.CrudRepository;

public interface UserTokenRepository extends CrudRepository<UserToken, Long> {
    public boolean existsByUserIdAndToken(Long id, String token);
    public User getByIdAndToken(Long id, String token);
}
