package ma.ens.hopitalpratique2.repository;

import ma.ens.hopitalpratique2.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,String> {
}
