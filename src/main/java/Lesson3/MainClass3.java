package Lesson3;
import java.util.Scanner;
public class MainClass3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int userAnsver;
        do{
            int result = (int) (Math.random() * 10 - 1);
            System.out.println("Добро пожаловать в игру угадай число.");
            for (int i = 0; i < 3; i++) {
                System.out.println("Введите число от 0 до 9");
                a = sc.nextInt();
                if (a == result) {
                    System.out.println("Ответ верный, поздравляем");
                    break;
                } else {
                    if (result < a) {
                        System.out.println("Неправильно, загаданное число меньше ");
                    } else {
                        System.out.println("Неправильно, загаданное число больше ");
                    }
                }
            }
            System.out.println("Ответ:" + result);
            System.out.println();
            System.out.println("Хотите повторить, нажмите 1");
            userAnsver = sc.nextInt();
        } while (userAnsver == 1);
            System.out.println("До скорых встреч");
    }
}

