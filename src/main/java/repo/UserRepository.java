package repo;

import model.User;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public User getUserByNickNameAndAndPassword(String nickName, String password);
    public boolean existsByNickName(String nickName);
}
