package ma.ens.hopitalpratique2.repository;
import ma.ens.hopitalpratique2.entities.Medecin;

import ma.ens.hopitalpratique2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
