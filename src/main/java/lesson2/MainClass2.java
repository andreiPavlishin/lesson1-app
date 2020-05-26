package lesson2;

import java.util.Arrays;

public class MainClass2 {

    public static void main(String[] args) {

        int[] arry = new int[]{1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
            System.out.println("Первое задание: ");
            System.out.println(Arrays.toString(arry));
            for (int i = 0; i < arry.length; i++)
                if (arry[i] == 1) {
                    arry[i] = 0;
                    } else arry[i] = 1;
                System.out.println(Arrays.toString(arry));

        int[] secondTask = new int[8];
        int j = 0;
            System.out.println("\nВторое задание: ");
                for (int i = 0; i <secondTask.length ; ++i, j = j + 3) {
                    secondTask[i] = j;
                System.out.print(+secondTask[i] + " ");
                }
        System.out.println();


        int[] thirdTask = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
            System.out.println("\nТретье задание: ");
                for (int i = 0; i < thirdTask.length; i++) {
                 if (thirdTask[i] < 6)
                    thirdTask[i] = thirdTask[i] * 2;
            }
        System.out.println(Arrays.toString(thirdTask));

        int[][] fourthTask = new int[4][4];
            System.out.println("\nЧетвертое задание: ");
            for (int l = 0; l < 4; l++) {
                for (j = 0; j < 4; j++) {
                    if (l < j) {
                        fourthTask[l][j] = 0;
                    } else if (l > j) {
                        fourthTask[l][j] = 1;
                    } else {
                        fourthTask[l][j] = 1;
                    }
                    System.out.print(fourthTask[l][j] + " ");
                }
                System.out.println();
        }
    }
}






