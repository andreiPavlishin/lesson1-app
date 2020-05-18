import java.util.Arrays;

public class Test_Lesson2 {

        public static void main(String[] args) {

            int[] arry = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.println("Первое задание: ");
            System.out.println(Arrays.toString(arry)); // Показывает арегинал
            for (int i = 0; i < arry.length; i++)
                if (arry[i] == 1) {
                    arry[i] = 0;
                } else arry[i] = 1;
            System.out.println(Arrays.toString(arry)); // Показывает ревирс

            int[] secondTask = new int[8];
            int j = 0; // Устанавливаем для точки отчета.
            System.out.println("\nВторое задание: ");
            for (int i = 0; i <secondTask.length ; ++i, j = j + 3) {//j = j + 3 Увеличивает цыкл на 3 шага
                secondTask[i] = j; // Длина масива начинветься с нуля
//                System.out.print(+secondTask[i] + ", "); // Выводит результат
            } // Необходимо писать в функции
            System.out.println(Arrays.toString(secondTask));
            // Необходио писать в не функции

            int[] thirdTask = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
            System.out.println("\nТретье задание: ");
            for (int i = 0; i < thirdTask.length; i++) { //Обезательно поставить скобки. в противнов случае переменная I выдаст ошибку
                if (thirdTask[i] < 6)
                    thirdTask[i] = thirdTask[i] * 2;
                System.out.print(+thirdTask[i] + ", ");
            }
            int[][] sqArr = new int[2][2]; // default прописанные в Java {{0, 0}, {1, 0}};
//переносим результат вывода на строку ниже от задания 3 (для читаемости результата)
            System.out.println("Task 4:");
            //для значения по индексу i, если значение равно нулю но меньше 2, сделать инкремент(т.е приращение на +1)
            for (int i = 0; i < 2; i++) {
                for (j = 0; j < 2; j++) {
/*
"проходим" по каждому значению в массиве и если заданные нами условия исполнены
то значение не меняется, если нет, то меняется на 1
  */
                    if (i < j) {
                        sqArr[i][j] = 0;
                    } else if (i > j) {
                        sqArr[i][j] = 1;
                    } else {
                        sqArr[i][j] = 1;
                    }
                    System.out.print(sqArr[i][j] + " ");
                }
                System.out.println();
            }
        }
}







