package lesson6.Animal;

import lesson6.Animal.Animal;

public class Dog extends Animal {
    public double jump;
    public int sweem;



    public Dog(String name, int run, int sweem, double jump ) {
        this.name = name;
        this.run = run;
        this.sweem = sweem;
        this.jump = jump;
    }
    //выводим информацию в консоль
    public void dogInfo() {
        System.out.println("DogName: " + name  + " RunLimit: " + run+ " meters/" + " Sweem:" + sweem + " Jump: " +jump+ " meters/");
    }
}

