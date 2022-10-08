package repo;

import model.VTBFilial;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Entity;
import javax.persistence.Table;


public interface VTBFilialRepository extends CrudRepository<VTBFilial, Long> {
    public VTBFilial getById(Long id);
}
