package ma.ens.hopitalpratique2.service;

import jakarta.transaction.Transactional;
import ma.ens.hopitalpratique2.entities.Consultation;
import ma.ens.hopitalpratique2.entities.Medecin;
import ma.ens.hopitalpratique2.entities.Patient;
import ma.ens.hopitalpratique2.entities.RendezVous;
import ma.ens.hopitalpratique2.repository.ConsultationRepository;
import ma.ens.hopitalpratique2.repository.MedecinRepository;
import ma.ens.hopitalpratique2.repository.PatientRepository;
import ma.ens.hopitalpratique2.repository.RendezVousRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service@Transactional

public class IHospitalServiceImpl implements IHospitalService{

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }


}
