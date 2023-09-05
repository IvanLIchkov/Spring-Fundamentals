package springbootintro.testBeans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final Animal dog;
    private final Animal cat;
    private final List<Animal> animals;

//    public HomeService(@Qualifier("cat") Animal animal) { //Qualifier се използва за пoяснение на това кой от всички интерфейси е
//        this.animal = animal;                              //Ако има зададено Bean като primary bean тогава ако не е
//                                                            // зададен qualifier  по подразбиране се взима Primary
//    }
//    public HomeService( Animal dog) { //Ако във BeanConfiguration file е зададено value то тогава може да се инициализира чрез Value-name
//        this.animal = dog;
//    }
//    @Autowired
//    public HomeService(Animal dog, Animal cat, List<Animal> animals) {
//        dog.makeSound();
//        cat.makeSound();
//        animals.forEach(Animal::makeSound);
//    }



        public HomeService(Animal dog, Animal cat, List<Animal> animals) {
            this.dog = dog;
            this.cat = cat;
            this.animals = animals;
        }

        @PostConstruct
        public void postConstruct(){
            System.out.println("post construct of home");
            this.cat.makeSound();
            this.dog.makeSound();
            System.out.println(this.cat.hashCode());
            System.out.println(this.dog.hashCode());
            this.animals.forEach(Animal::makeSound);
        }

}
