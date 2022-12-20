package com.decagon.decablogjavabe;

import com.decagon.decablogjavabe.infrastructure.persistence.repository.CategoryRepository;
import com.decagon.decablogjavabe.usercase.services.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@Slf4j
public class DecaBlogJavaBeApplication implements CommandLineRunner {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(DecaBlogJavaBeApplication.class, args);
	}

	@Override
	public void run(String... args) {
		if (categoryRepository.count() == 8){
			return;
		}
		log.info("executing: command line runner");
		categoryService.saveToCategoryDatabase();
		log.info("executed: command line runner");
	}


}
