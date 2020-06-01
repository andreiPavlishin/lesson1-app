public class test {
    public static void main(String[] args) {
        secondTask();
        System.out.println("a * (b + (c / d)) = "  +  thirdTask(1, 2, 3, 4));
        System.out.println(fourTask(5, 8));
        fifthTask(5);
        System.out.println(sixthTask(- 1));
        seventhTask("Андрей");
        eighthTask(2020);
    }

    static void secondTask() {
        System.out.println("Задание 2.");

        System.out.println("Значение для типа byte\nОписание: 8-битное знаковое целое число");
        System.out.println("Возможные значения: от -128 до 127\n");

        System.out.println("Значение для типа short\nОписание: 16-битное знаковое целое число");
        System.out.println("Возможные значения: от -32768 до 32767\n");

        System.out.println("Значение для типа int\nОписание: 32-битное знаковое целое число");
        System.out.println("Возможные значения: от -2147483648 до 2147483647\n");

        System.out.println("Значение для типа long\nОписание: 64-битное знаковое целое число");
        System.out.println("Возможные значения: от -9223372036854775808 до 9223372036854775807\n");

        System.out.println("Значение для типа float: 32-битное знаковое число с плавающей запятой одинарной точности\n");

        System.out.println("Значение для типа double: 64-битное знаковое число с плавающей запятой двойной точности\n");

        System.out.println("Значение для типа char: 16-битный тип данных, предназначенный для хранения символов в кодировке Unicode\n");

        System.out.println("Значение для типа boolean: логический тип данных. Пример false, true " );

    }

    static double thirdTask(double a, double b, double c, double d) {
        System.out.println("\nЗадание 3.");
        return a * (b + (c / d));
    }

    static boolean fourTask(int a, int b) {
        System.out.println("\nЗадание 4.");
        int sum = a + b;
        if (sum > 10 && sum <= 20) return true;
        else return false;
    }

    static void fifthTask(int a) {
        System.out.println("\nЗадание 5.");
        if (a >= 0) System.out.println("Число " + a + " положительное");
        else System.out.println("Число " + a + " отрицательное");
    }

    static boolean sixthTask(int a) {
        System.out.println("\nЗадание 6.");
        if (a < 0) return true;
        return false;
    }

    static void seventhTask(String name) {
        System.out.println("\nЗадание 7.");
        System.out.println("Привет, " + name + "!");
    }
// По чесному подглядывал. Но во всём разобрался. (Не списал, а подглядел, это важно :)
    static void eighthTask(int year) {
        System.out.println("\nЗадание 8.");
        if (!(year % 4 == 0) || ((year % 100 == 0) && !(year % 400 == 0))) System.out.println(year + " г. не високосный");
        else System.out.println(year + " г. высокосный");
    }
}

