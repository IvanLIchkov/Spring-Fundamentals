package springbootintro.testBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {

    @Bean(value = "dog") //Когато зададем Value при инициализиране в
    public Animal createDog(){
        return new Dog();
    }


    @Bean(value = "cat")
    public Animal createCat(){
        return new Cat();
    }
}
