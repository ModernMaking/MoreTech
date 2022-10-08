package repo;

import model.TextVR;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TextVRRepository extends CrudRepository<TextVR, Long> {
    public List<TextVR> findAllByPalaceId(Long palaceId);
}
