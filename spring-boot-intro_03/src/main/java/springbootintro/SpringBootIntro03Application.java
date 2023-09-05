package springbootintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springbootintro.testBeans.Animal;
import springbootintro.testBeans.Dog;

@SpringBootApplication
public class SpringBootIntro03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootIntro03Application.class, args);
	}
}
