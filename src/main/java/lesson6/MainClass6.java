package lesson6;

import lesson6.Animal.Cat;
import lesson6.Animal.Dog;

public class MainClass6 {
    public static void main(String[] args) {

            Cat cat = new Cat( );
            cat.run(201);
            cat.swim(1);
            cat.jump(1.9);

            Dog dog = new Dog();
            dog.run(500);
            dog.swim(10);
            dog.jump(0.4);

    }
}
