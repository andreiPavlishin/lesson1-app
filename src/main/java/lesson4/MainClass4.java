package lesson4;

import java.util.Random;
import java.util.Scanner;

public class MainClass4 {
    private static final int SIZE = 5;
    public static final int Victory_line = 4;
    public static char[][] map;
    public static final char point = '•';
    public static final char player = 'x';
    public static final char cpu1 = 'o';
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        newMap();
        printMap();

        while (true) {
            //Ход  игрока
            playerTurn();
            printMap();
            if (checkWinLines(player)) {
                System.out.println("Поздравляем, вы победили");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

            //Ход компьютера
            aiTurn();
            printMap();
            if (checkWinLines(cpu1)) {
                System.out.println("Игра окончина, победил компьютер");
                break;
            }
            if (isFull()) {
                System.out.println("Ничья");
                break;
            }

        }
    }

    public static void newMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = point;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void playerTurn() {
        int x, y;

        do {
            System.out.println("Ваш ход введите координаты X и Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(y, x));
        map[y][x] = player;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == point;
    }

    public static void aiTurn() {
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = cpu1;
                    if (checkWinLines(cpu1)) {
                        return;
                    }
                    map[i][j] = point;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = player;
                    if (checkWinLines(player)) {
                        map[i][j] = cpu1;
                        return;
                    }
                    map[i][j] = point;
                }
            }
        }

        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = cpu1;
    }

    public static boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == point) {
                    return false;
                }
            }
        }
        return true;
    }


    static boolean checkLine(int cy, int cx, int vy, int vx, char dot) {
        if (cx + vx * (Victory_line - 1) > SIZE - 1 || cy + vy * (Victory_line - 1) > SIZE - 1 ||
                cy + vy * (Victory_line - 1) < 0) {
            return false;
        }

        for (int i = 0; i < Victory_line; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWinLines(char dot) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot) || checkLine(i, j, 1, 0, dot) ||
                        checkLine(i, j, 1, 1, dot) || checkLine(i, j, -1, 1, dot)) {
                    return true;
                }
            }
        }
        return false;
    }
}
