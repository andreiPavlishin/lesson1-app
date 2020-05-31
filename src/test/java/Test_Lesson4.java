import java.util.Random;
import java.util.Scanner;
public class Test_Lesson4 {
    private static final int SIZE = 5;
    public static final int Victory_line = 4;
    public static char[][] map;
    public static final char point = '•';
    public static final char player = 'x';
    public static final char cpu1 = 'o';
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
//        Test_Lesson4 g = new Test_Lesson4();
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


//
//do {
//        System.out.println("Ваш ход, введите координаты X и Y");
//        x = sc.nextInt() - 1;
//        y = sc.nextInt() - 1;
//    } while (isCellValid(x, y));
//    map[y][x] = player;
//}
//
//    static boolean isCellValid(int x, int y) {
//        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) return true;
//        return map[y][x] != point;
//    }
//
//    boolean checkWin(char c) {
//        int countV;
//        int countH;
//        int countDiagonalA = 0;
//        int countDiagonalB = 0;
//        for (int i = 0; i <= SIZE - 1; i++) {
//            countH = 0;
//            countV = 0;
//            for (int j = 0; j <= SIZE - 1; j++) {
//                if (map[i][j] == c) {
//                    countH++;
//                    if (countH == SIZE) return true;
//                }
//
//                if (map[j][i] == c) {
//                    countV++;
//                    if (countV == SIZE) return true;
//                }
//            }
//
//            // tested diagonal A "\" check
//            if (map[i][i] == c) {
//                countDiagonalA++;
//                if (countDiagonalA == SIZE) return true;
//            } else countDiagonalA = 0;
//
//            // tested diagonal B "/" check
//            if (map[i][SIZE - 1 - i] == c) {
//                countDiagonalB++;
//                if (countDiagonalB == SIZE) return true;
//            } else countDiagonalB = 0;
//        }
//        return false;
//    }
//
//    boolean isMapFull() {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (map[i][j] == point) return false;
//            }
//        }
//        return true;
//    }
//
//    static void aiTurn() {
//        int x, y, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;
//

//
//        // 1. Ход игрока
//        for (int i = 0; i < SIZE; i++) {
//            countH = 0;
//            countHNull = 0;
//            countV = 0;
//            countVNull = 0;
//            //good vertical move
//            if (map[0][i] == Test_Lesson4.cpu1) countV++;
//            else if (map[0][i] == point) countVNull++;
//            if ((countV == SIZE - 1) && (countVNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[k][i] == point) {
//                        map[k][i] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            //good Horizontal move
//            if (map[i][0] == Test_Lesson4.cpu1) countH++;
//            else if (map[i][0] == point) countHNull++;
//            if ((countH == SIZE - 1) && (countHNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[i][k] == point) {
//                        map[i][k] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            //good vertical move
//            if (map[1][i] == Test_Lesson4.cpu1) countV++;
//            else if (map[1][i] == point) countVNull++;
//            if ((countV == SIZE - 1) && (countVNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[k][i] == point) {
//                        map[k][i] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            //good Horizontal move
//            if (map[i][1] == Test_Lesson4.cpu1) countH++;
//            else if (map[i][1] == point) countHNull++;
//            if ((countH == SIZE - 1) && (countHNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[i][k] == point) {
//                        map[i][k] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            //good vertical move
//            if (map[2][i] == Test_Lesson4.cpu1) countV++;
//            else if (map[2][i] == point) countVNull++;
//            if ((countV == SIZE - 1) && (countVNull == 1)) {
//
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[k][i] == point) {
//                        map[k][i] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            //good Horizontal move
//            if (map[i][2] == Test_Lesson4.cpu1) countH++;
//            else if (map[i][2] == point) countHNull++;
//            if ((countH == SIZE - 1) && (countHNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[i][k] == point) {
//                        map[i][k] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            //good vertical move
//            if (map[3][i] == Test_Lesson4.cpu1) countV++;
//            else if (map[3][i] == point) countVNull++;
//            if ((countV == SIZE - 1) && (countVNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[k][i] == point) {
//                        map[k][i] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            //good Horizontal move
//            if (map[i][3] == Test_Lesson4.cpu1) countH++;
//            else if (map[i][3] == point) countHNull++;
//            if ((countH == SIZE - 1) && (countHNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[i][k] == point) {
//                        map[i][k] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            //good vertical move
//            if (map[4][i] == Test_Lesson4.cpu1) countV++;
//            else if (map[4][i] == point) countVNull++;
//            if ((countV == SIZE - 1) && (countVNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[k][i] == point) {
//                        map[k][i] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            //good Horizontal move
//            if (map[i][4] == Test_Lesson4.cpu1) countH++;
//            else if (map[i][4] == point) countHNull++;
//            if ((countH == SIZE - 1) && (countHNull == 1)) {
//                for (int k = 0; k < SIZE; k++) {
//                    if (map[i][k] == point) {
//                        map[i][k] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            // good diagonal A "\" move
//            if (map[i][i] == Test_Lesson4.cpu1) countDiagonalA++;
//            else if (map[i][i] == point) countDANull++;
//            if ((countDiagonalA == SIZE - 1) && (countDANull == 1)) {
//                for (int j = 0; j < SIZE; j++) {
//                    if (map[j][j] == point) {
//                        map[j][j] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//
//            // good diagonal B "/" move
//            if (map[i][SIZE - 1 - i] == Test_Lesson4.cpu1) countDiagonalB++;
//            else if (map[i][SIZE - 1 - i] == point) countDBNull++;
//            if ((countDiagonalB == SIZE - 1) && (countDBNull == 1)) {
//                for (int j = 0; j < SIZE; j++) {
//                    if (map[j][SIZE - 1 - j] == point) {
//                        map[j][SIZE - 1 - j] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//        }
//
//        countHNull = 0;
//        countV = 0;
//        countDiagonalA = 0;
//        countDiagonalB = 0;
//        countDANull = 0;
//        countDBNull = 0;
//
//        for (int i = 0; i < SIZE; i++) {
//            countH = 0;
//            countHNull = 0;
//            countV = 0;
//            countVNull = 0;
//            for (int j = 0; j < SIZE; j++) {
//                if (map[j][i] == player) countV++;
//                else if (map[j][i] == point) countVNull++;
//                if ((countV == SIZE - 1) && (countVNull == 1)) {
//                    for (int k = 0; k < SIZE; k++) {
//                        if (map[k][i] == point) {
//                            map[k][i] = Test_Lesson4.cpu1;
//                            return;
//                        }
//                    }
//                }
//                if (map[i][j] == player) countH++;
//                else if (map[i][j] == point) {
//                    countHNull++;
//                }
//                if ((countH == SIZE - 1) && (countHNull == 1)) {
//                    for (int k = 0; k < SIZE; k++) {
//                        if (map[i][k] == point) {
//                            map[i][k] = Test_Lesson4.cpu1;
//                            return;
//                        }
//                    }
//                }
//
//            }
//
//            // good diagonal A "\" move
//            if (map[i][i] == player) {
//                int i1 = countDiagonalA++;
//            } else if (map[i][i] == point) countDANull++;
//            if ((countDiagonalA == SIZE - 1) && (countDANull == 1)) {
//                for (int j = 0; j < SIZE; j++) {
//                    if (map[j][j] == point) {
//                        map[j][j] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//            if (map[i][SIZE - 1 - i] == player) countDiagonalB++;
//            else if (map[i][SIZE - 1 - i] == point) countDBNull++;
//            if ((countDiagonalB == SIZE - 1) && (countDBNull == 1)) {
//                for (int j = 0; j < SIZE; j++) {
//                    if (map[j][SIZE - 1 - j] == point) {
//                        map[j][SIZE - 1 - j] = Test_Lesson4.cpu1;
//                        return;
//                    }
//                }
//            }
//        }
//
//
//        // 4. Taking diagonal points of map
//        if (map[0][0] == point) {
//            map[0][0] = Test_Lesson4.cpu1;
//            return;
//        }
//        if (map[0][map.length - 1] == point) {
//            map[0][map.length - 1] = Test_Lesson4.cpu1;
//            return;
//        }
//        if (map[map.length - 1][0] == point) {
//            map[map.length - 1][0] = Test_Lesson4.cpu1;
//            return;
//        }
//        if (map[map.length - 1][map.length - 1] == point) {
//            map[map.length - 1][map.length - 1] = Test_Lesson4.cpu1;
//            return;
//        }
//
//        do {
//            x = random.nextInt(SIZE);
//            y = random.nextInt(SIZE);
//        } while (isCellValid(x, y));
//        map[y][x] = Test_Lesson4.cpu1;
//    }
//
//
