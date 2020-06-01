package lesson5;

public class MainClass5 {
    public static void main(String[] args) {
        Human[] human = new Human[5];
        human[0] = new Human("Иванов Иван Иваныч", "Систамный аналитик", "Ivan@bk.ru", "7(495)333-00-75", 90000, 50);
        human[1] = new Human("Хотабыч", "Сторож", "}{otabih@mail.ru", "112", 50000, 40);
        human[2] = new Human("Сидоров Пётр Иванович", "Менеджер", "Petr_Fest@bk.ru", "7(495)777-77-77", 35000, 41);
        human[3] = new Human("Козлов Сергей Григорьевич", "Сражёр", "Kozlov@bk.ru", "7(495)123-00-75", 250000, 22);
        human[4] = new Human("Ким Илья Анатольевич", "Бренд менеждер", "Kim@bk.ru", "7(495)333-00-75", 110000, 40);

//        int i = 0;
//        for (Human c : human) {
//            if (c.getAge() > 40) {
//                i++;
//                c.info();
//            }
//        }

        for (Human c : human) {
            if (c.getAge() > 0x28){
                c.info();
            }
        }
    }
}