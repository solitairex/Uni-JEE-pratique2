package ma.ens.hopitalpratique2;

import ma.ens.hopitalpratique2.entities.*;
import ma.ens.hopitalpratique2.repository.ConsultationRepository;
import ma.ens.hopitalpratique2.repository.MedecinRepository;
import ma.ens.hopitalpratique2.repository.PatientRepository;
import ma.ens.hopitalpratique2.repository.RendezVousRepository;
import ma.ens.hopitalpratique2.service.IHospitalService;
import ma.ens.hopitalpratique2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Hopitalpratique2Application {

	@Autowired


	public static void main(String[] args) {
		SpringApplication.run(Hopitalpratique2Application.class, args);
	}

	@Bean
	CommandLineRunner start(IHospitalService hospitalService, RendezVousRepository rendezVousRepository, PatientRepository patientRepository, MedecinRepository medecinRepository,UserService userService) {

		return args -> {
			Stream.of("Mohamed", "Hassan", "Najat").forEach(name -> {
				Patient patient = new Patient();
				patient.setNom(name);
				patient.setDatenaissance(new Date());
				patient.setMalade(false);
				hospitalService.savePatient(patient);
			});

			Stream.of("Adam", "Mohamed", "Saber").forEach(name -> {
				Medecin medecin = new Medecin();
				medecin.setNom(name);
				medecin.setEmail(name + "@gmail.com");
				medecin.setSpecialite(Math.random() > 0.5 ? "Cardio" : "Dentiste");
				hospitalService.saveMedecin(medecin);
			});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient2 = patientRepository.findByNom("Mohamed");
			Medecin medecin = medecinRepository.findByNom("aya");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			rendezVousRepository.save(rendezVous);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous);
			consultation.setRapport("Rapport de consultation");
			hospitalService.saveConsultation(consultation);

			
			User u = new User();
			u.setUsername("user1");
			u.setPassword("123456");
			userService.addNewUser(u);

			User u2 = new User();
			u2.setUsername("admin");
			u2.setPassword("123456789");
			userService.addNewUser(u2);

			Stream.of("STUDENT", "USER", "ADMIN").forEach(r -> {
				Role role1 = new Role();
				role1.setRoleName(r);
				userService.addNewRole(role1);
			});

			userService.addRoleToUser("user1", "STUDENT");
			userService.addRoleToUser("user1", "USER");
			userService.addRoleToUser("admin", "ADMIN");

			try {
				User user = userService.authenticate("user1", "123456");
				System.out.println(user.getUserId());
				System.out.println(user.getUsername());
				System.out.println("Roles=>");
				user.getRoles().forEach(r -> {
					System.out.println("Roles=>" + r.toString());
				});
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		};
	}
}
