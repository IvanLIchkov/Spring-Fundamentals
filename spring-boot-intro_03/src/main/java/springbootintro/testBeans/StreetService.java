package springbootintro.testBeans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class StreetService {

    private final Animal cat;
    private final Animal dog;


    public StreetService(Animal cat, Animal dog) {
        this.cat = cat;
        this.dog = dog;
    }
    @PostConstruct
    public void postConstruct(){
        System.out.println("On the street baby");
        this.cat.makeSound();
        this.dog.makeSound();
        System.out.println(this.cat.hashCode());
        System.out.println(this.dog.hashCode());
    }

}
