package repo;

import model.Certificate;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface CertificateRepository extends CrudRepository<Certificate, Long> {
}
