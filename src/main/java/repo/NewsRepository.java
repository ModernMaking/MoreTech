package repo;

import model.News;
import org.springframework.data.repository.CrudRepository;

public interface NewsRepository extends CrudRepository<News,Long> {
}
