package lesson7;

public class MainClass7 {
    public static
    void main(String[] args) {
        Cat[] cats = {new Cat("Vasilij", 50), new Cat("Bombilo", 50), new Cat("Snezhok", 25), new Cat("Kuzma", 5), new Cat("Kote", 1)};
// здесь вводим наполнение миски и программа автоматический определит какой из котов сможет наесться а какой нет.
        Plate plate = new Plate( 80);

        for (Cat cat : cats) {
            cat.eat(plate);
            cat.info();
        }
    }
}
