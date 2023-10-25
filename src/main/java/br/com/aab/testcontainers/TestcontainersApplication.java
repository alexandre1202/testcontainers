package br.com.aab.testcontainers;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class TestcontainersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestcontainersApplication.class, args);
	}


	@Bean
	ApplicationRunner jdbcRunner(PersonRepository repository) {
		return args -> {
			var person = repository.save(new Person(null, "Alexandre"));
			System.out.println("person = " + person);
		};
	}
}

record Person(@Id String id, String name){}

interface PersonRepository extends MongoRepository<Person, Long>{}