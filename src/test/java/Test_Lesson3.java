
import java.util.Scanner;
public class Test_Lesson3 {

        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            int a;
            int result = (int) (Math.random() * 10 + 1);

            for (int i = 0; i < 3; i++) {
                System.out.println("Угадайте число:");
                a = sc.nextInt();
                if (a == result) {
                    System.out.println("Правильно");
                    break;
                } else{
                    if(result < a){
                        System.out.println("Неправильно, число < " + a);
                    } else {
                        System.out.println("Неправильно, число > " + a);
                    }
                }
            }
            System.out.println("Ответ:" + result);
            sc.close();
        }
}
// public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int userAnsver;
//        int i = 0;
//        System.out.println("Здравстввейте, добро пожаловать в игру угадай число.\nВведие число от 0 до 9");
//        Random rand = new Random();
//        int x = rand.nextInt(9);
//        userAnsver = sc.nextLine();
//        for ( i = 0; i < 3; i++){
//            if (userAnsver = x)
//        }
//
//        System.out.println(x);
//    }