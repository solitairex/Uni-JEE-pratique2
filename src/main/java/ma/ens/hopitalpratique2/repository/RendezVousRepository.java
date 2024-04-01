package ma.ens.hopitalpratique2.repository;

import ma.ens.hopitalpratique2.entities.Patient;
import ma.ens.hopitalpratique2.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous,String> {

}
