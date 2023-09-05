package springbootintro.testBeans;

public class Dog implements Animal {

    public Dog() {
        makeSound();
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
