package com.esi.msbourse;

import com.esi.msbourse.dao.EtudiantRepository;
import com.esi.msbourse.dao.VirementRepository;
import com.esi.msbourse.entities.Etudiant;
import com.esi.msbourse.entities.Virement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.sql.Date;

@SpringBootApplication
@EnableFeignClients
public class MsBourseApplication implements CommandLineRunner {

	@Autowired
	EtudiantRepository etudiantRepository;

	@Autowired
	VirementRepository virementRepository;

	@Autowired
	RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(MsBourseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		repositoryRestConfiguration.exposeIdsFor(Virement.class);

		Etudiant e1= etudiantRepository.save(new Etudiant(1L,146L,40000F,true,null,null));
		Etudiant e2=etudiantRepository.save(new Etudiant(2L,6845L,20000F,true,null,null));
		Etudiant e3=	etudiantRepository.save(new Etudiant(3L,5456L,90000F,true,null,null));
		Etudiant e4=	etudiantRepository.save(new Etudiant(4L,4322L,60000F,true,null,null));

		virementRepository.save(new Virement(null,4000F, Date.valueOf("2019-01-01"),e1));
		virementRepository.save(new Virement(null,4000F, Date.valueOf("2019-04-01"),e1));
		virementRepository.save(new Virement(null,8000F, Date.valueOf("2019-07-01"),e1));

		virementRepository.save(new Virement(null,8000F, Date.valueOf("2019-02-01"),e2));
		virementRepository.save(new Virement(null,12000F, Date.valueOf("2019-05-01"),e2));

		virementRepository.save(new Virement(null,5000F, Date.valueOf("2020-04-01"),e3));
		virementRepository.save(new Virement(null,9000F, Date.valueOf("2020-07-01"),e3));


	}
}
