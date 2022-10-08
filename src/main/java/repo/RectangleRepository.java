package repo;

import model.Rectangle;
import org.springframework.data.repository.CrudRepository;

public interface RectangleRepository extends CrudRepository<Rectangle,Long> {
}
