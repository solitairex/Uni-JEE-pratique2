package ma.ens.hopitalpratique2.service;

import ma.ens.hopitalpratique2.entities.Consultation;
import ma.ens.hopitalpratique2.entities.Medecin;
import ma.ens.hopitalpratique2.entities.Patient;
import ma.ens.hopitalpratique2.entities.RendezVous;

public interface IHospitalService {
     Patient savePatient(Patient patient);
     Medecin saveMedecin(Medecin medecin);
     RendezVous saveRDV(RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);

}
