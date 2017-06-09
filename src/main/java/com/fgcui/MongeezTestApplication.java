package com.fgcui;

import com.mongodb.Mongo;
import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class MongeezTestApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MongeezTestApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		
		userRepository.save(new User("1", "zhangsan", "12"));
		userRepository.save(new User("2", "zhangsan", "12"));
		userRepository.save(new User("lisi", "12"));
		
		Mongeez mongeez = new Mongeez();
		mongeez.setFile(new ClassPathResource("mongeez.xml"));
		mongeez.setDbName("test");
		mongeez.setMongo(new Mongo("127.0.0.1", 27017));
		mongeez.process();
		
		
		for(User user: userRepository.findAll()) {
			System.out.println(user);
		}
	}
}
