package com.example.HospitalConSpring;

import com.example.HospitalConSpring.entity.Doctores;
import com.example.HospitalConSpring.repository.DoctoresRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HospitalConSpringApplication {

	public static void main(String[] args) {

		ApplicationContext contex = SpringApplication.run(HospitalConSpringApplication.class, args);
		DoctoresRepository repository = contex.getBean(DoctoresRepository.class);


	//	Doctores doctores = new Doctores(null, "sebastian", "rios", "43690410", "pediatras", "sebarios@gmail.com", "1211120022", 457457);
	//	Doctores doctores1 = new Doctores(null, "esteban", "feldick", "43690410", "nutricion", "estebanrios@gmail.com" ,"14528755", 457812);

	//	System.out.println("numero de libros en la base de datos " + repository.findAll().size());
	//	repository.save(doctores);
	//	repository.save(doctores1);
	//	System.out.println("numero de libros en la base de datos " + repository.findAll().size());

	}
}



