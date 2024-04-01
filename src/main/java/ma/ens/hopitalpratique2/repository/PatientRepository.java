package ma.ens.hopitalpratique2.repository;

import ma.ens.hopitalpratique2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);

}
