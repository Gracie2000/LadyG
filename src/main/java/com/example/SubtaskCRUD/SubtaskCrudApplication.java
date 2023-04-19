package com.example.SubtaskCRUD;

import com.example.SubtaskCRUD.entity.SubtaskEntity;
import com.example.SubtaskCRUD.repository.SubtaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubtaskCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SubtaskCrudApplication.class, args);
	}

	@Autowired
	private SubtaskRepository subtaskRepository;
	@Override
	public void run(String... args) throws Exception {
		SubtaskEntity subtaskEntity = new SubtaskEntity();
		subtaskEntity.setName("Grace");
		subtaskEntity.setTitle("Unknown");
		subtaskEntity.setJob("Cyber Security");
		subtaskEntity.setSalary("$" + 500.0);
		subtaskEntity.setHireDate("20/03/2023");
		subtaskRepository.save(subtaskEntity);
	}
}
