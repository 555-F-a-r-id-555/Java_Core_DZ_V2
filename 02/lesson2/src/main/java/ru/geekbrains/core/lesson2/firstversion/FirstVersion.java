package ru.geekbrains.core.lesson2.firstversion;

import java.util.Random;
import java.util.Scanner;

public class FirstVersion {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;

    public static void main(String[] args) {

        // System.out.println("Введите уровень сложности: \n"+
        // "1) simple - 1\n" +
        // "2) basic - 2 \n" +
        // "3) imortal - 3\n");
        // Scanner inputScanner = new Scanner(System.in);
        // int input = inputScanner.nextInt();
        // System.out.println("input = " + input );

        while (true) {
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if (checkState(DOT_HUMAN, "Вы победили!"))
                    break;
                aiTurn();
                printField();
                if (checkState(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да): ");
            if (!scanner.next().equalsIgnoreCase("Y"))
                break;
        }

    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;
        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Печать текущего состояния игрового поля
     */
    static void printField() {
        System.out.print("+");
        for (int x = 0; x < fieldSizeY; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("-");

        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }

        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Ход игрока (человека)
     */
    static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y\n(от 1 до 3) через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * Проверка, является ли ячейка игрового поля пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    static void aiTurn() {
        int x;
        int y;

        for (int n = 0; n < 3; n++) { // число 3 - взял произвольно
            // Проверка победы AI на следующем ходу
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    if (isCellEmpty(i, j)) {
                        field[i][j] = DOT_AI;
                        if (checkWinForAi(DOT_AI, n)) {
                            field[i][j] = DOT_AI; // Если AI победит, делаем ход
                            return;
                        }
                        field[i][j] = DOT_EMPTY;
                    }
                }
            }

            // Блокирование победы игрока на следующем ходу
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    if (isCellEmpty(i, j)) {
                        field[i][j] = DOT_HUMAN;
                        if (checkWinForAi(DOT_HUMAN, n)) {
                            field[i][j] = DOT_AI; // Если игрок победит, блокируем его ход
                            return;
                        }
                        field[i][j] = DOT_EMPTY;
                    }
                }
            }

        }

        // Если нет выигрышного или блокирующего хода, делаем случайный ход
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;

    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {

            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y))
                    return false;
            }
        }
        return true;
    }

    /**
     * TODO: Переработать в рамках домашней работы
     * Метод проверки победы
     *
     * @param dot фишка игрока
     * @return
     */
    static boolean checkWin(char dot) {
        // Проверка победы по горизонталям
        // if (field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return
        // true;
        // if (field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return
        // true;
        // if (field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return
        // true;

        // Проверка победы по горизонталям
        // for (int y = 0; y < fieldSizeY; y++) {
        // int count = 0;
        // for (int x = 0; x < fieldSizeX; x++) {
        // if (field[x][y] == dot) {
        // count++;
        // if (count == 3)
        // return true;
        // } else {
        // count = 0;
        // }
        // }
        // }

        // Проверка победы по вертикалям
        // if (field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return
        // true;
        // if (field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return
        // true;
        // if (field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return
        // true;

        // Проверка победы по вертикалям
        // for (int x = 0; x < fieldSizeX; x++) {
        // int count = 0;
        // for (int y = 0; y < fieldSizeY; y++) {
        // if (field[x][y] == dot) {
        // count++;
        // if (count == 3)
        // return true;
        // } else {
        // count = 0;
        // }
        // }
        // }

        // Проверка победы по диагоналям
        // if (field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return
        // true;
        // if (field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return
        // true;

        // Проверка победы по диагоналям
        // int count = 0;
        // for (int i = 0; i < fieldSizeX; i++) {
        // if (field[i][i] == dot) {
        // count++;
        // if (count == 3)
        // return true;
        // } else {
        // count = 0;
        // }
        // }

        // count = 0;
        // for (int i = 0; i < fieldSizeX; i++) {
        // if (field[i][fieldSizeX - 1 - i] == dot) {
        // count++;
        // if (count == 3)
        // return true;
        // } else {
        // count = 0;
        // }
        // }

        // Квадратное поле
        if (fieldSizeX == fieldSizeY) {

            // +\|-1|-2|-3|-4|-5|
            // 1-|11|12|13|14|15|
            // 2-|21|22|23|23|24|
            // 3-|31|32|33|34|35|
            // 4-|41|42|43|44|45|
            // 5-|51|52|53|54|55|
            // ------------------

            // Проверка победы по горизонталям и вертикалям
            for (int i = 0; i < fieldSizeX; i++) {
                int countX = 0;
                int countY = 0;
                for (int j = 0; j < fieldSizeY; j++) {
                    if (field[i][j] == dot)
                        countX++;
                    if (field[j][i] == dot)
                        countY++;
                    if (countX == fieldSizeY || countY == fieldSizeX)
                        return true;
                }
            }

            // Проверка победы по диагоналям
            int countMainDiagonal = 0;
            int countAntiDiagonal = 0;
            for (int i = 0; i < fieldSizeX; i++) {
                if (field[i][i] == dot)
                    countMainDiagonal++;
                if (field[i][fieldSizeX - 1 - i] == dot)
                    countAntiDiagonal++;
                if (countMainDiagonal == fieldSizeX || countAntiDiagonal == fieldSizeX)
                    return true;
            }
        } else {

            // Прямоугольное поле
            // +\|-1|-2|-3|
            // 1-|11|12|13| d1 -11-22-33
            // 2-|21|22|23| d1 -21-32-43
            // 3-|31|32|33| d1 -31-42-53
            // 4-|41|42|43| d2 -31-22-13
            // 5-|51|52|53| d2 -41-32-23
            // ------------ d2 -51-42-33

            // +\|-1|-2|-3|-4|-5| d1 -11-22-33
            // 1-|11|12|13|14|15| d1 -12-23-34
            // 2-|21|22|23|23|24| d1 -13-23-35
            // 3-|31|32|33|34|35| d2 -31-22-13
            // ------------------ d2 -32-23-14
            // ------------------ d2 -33-23-15

            // Проверка победы по горизонталям и вертикалям
            for (int i = 0; i < fieldSizeX; i++) {
                int countX = 0;
                for (int j = 0; j < fieldSizeY; j++) {
                    if (field[i][j] == dot)
                        countX++;
                    if (countX == fieldSizeY)
                        return true;
                }
            }

            for (int j = 0; j < fieldSizeY; j++) {
                int countY = 0;
                for (int i = 0; i < fieldSizeX; i++) {
                    if (field[i][j] == dot)
                        countY++;
                    if (countY == fieldSizeX)
                        return true;
                }
            }

            // Проверка победы по горизонталям и вертикалям - не работает ошибка
            // for (int i = 0; i < fieldSizeX; i++) {
            // int countX = 0;
            // int countY = 0;
            // for (int j = 0; j < fieldSizeY; j++) {
            // if (field[i][j] == dot)
            // countX++;
            // if (field[j][i] == dot)
            // countY++;
            // }
            // if (countX == fieldSizeY || countY == fieldSizeX)
            // return true;
            // }

            int win_count = Math.min(fieldSizeX, fieldSizeY); // Определяем количество элементов на диагонали

            // for (int i = 0; i < fieldSizeX; i++) {
            // for (int j = 0; j < fieldSizeY; j++) {
            // int countMainDiagonal = 0;
            // // Проверяем главную диагональ
            // for (int k = 0; k < win_count; k++) {
            // if (i + k < fieldSizeX && j + k < fieldSizeY) { // Проверяем границы массива
            // if (field[i + k][j + k] == dot) {
            // countMainDiagonal++;
            // if (countMainDiagonal == win_count) {
            // return true;
            // }
            // }
            // } else {
            // break;
            // }
            // }
            // }
            // }

            // for (int i = 0; i < fieldSizeX; i++) {
            // for (int j = fieldSizeY - 1; j >= 0; j--) { // Начинаем с последнего столбца
            // int countAntiDiagonal = 0;
            // // Проверяем побочную диагональ
            // for (int k = 0; k < win_count; k++) {
            // if (i + k < fieldSizeX && j - k >= 0) { // Проверяем границы массива
            // if (field[i + k][j - k] == dot) {
            // countAntiDiagonal++;
            // if (countAntiDiagonal == win_count) {
            // return true;
            // }
            // }
            // } else {
            // break;
            // }
            // }
            // }

            // }

            // Проверяем главную диагональ
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    int countMainDiagonal = 0;
                    int countAntiDiagonal = 0;
                    // Проверяем главную диагональ
                    for (int k = 0; k < win_count; k++) {
                        // Проверка главной диагонали
                        if (i + k < fieldSizeX && j + k < fieldSizeY && field[i + k][j + k] == dot) {
                            countMainDiagonal++;
                            if (countMainDiagonal == win_count) {
                                return true;
                            }
                        }
                        // Проверка побочной диагонали
                        if (j - k >= 0 && i + k < fieldSizeX && field[i + k][j - k] == dot) {
                            countAntiDiagonal++;
                            if (countAntiDiagonal == win_count) {
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    // static boolean checkWinForAi(char dot, int stepsAhead) {

    // // Квадратное поле
    // if (fieldSizeX == fieldSizeY) {

    // // +\|-1|-2|-3|-4|-5|
    // // 1-|11|12|13|14|15|
    // // 2-|21|22|23|23|24|
    // // 3-|31|32|33|34|35|
    // // 4-|41|42|43|44|45|
    // // 5-|51|52|53|54|55|
    // // ------------------

    // // Проверка победы по горизонталям и вертикалям
    // for (int i = 0; i < fieldSizeX; i++) {
    // int countX = 0;
    // int countY = 0;
    // for (int j = 0; j < fieldSizeY; j++) {
    // if (field[i][j] == dot)
    // countX++;
    // if (field[j][i] == dot)
    // countY++;
    // if (countX == fieldSizeY - stepsAhead || countY == fieldSizeX - stepsAhead)
    // return true;
    // }
    // }

    // // Проверка победы по диагоналям
    // int countMainDiagonal = 0;
    // int countAntiDiagonal = 0;
    // for (int i = 0; i < fieldSizeX; i++) {
    // if (field[i][i] == dot)
    // countMainDiagonal++;
    // if (field[i][fieldSizeX - 1 - i] == dot)
    // countAntiDiagonal++;
    // if (countMainDiagonal == fieldSizeX - stepsAhead || countAntiDiagonal ==
    // fieldSizeX - stepsAhead)
    // return true;
    // }
    // } else {

    // // Прямоугольное поле
    // // +\|-1|-2|-3|
    // // 1-|11|12|13| d1 -11-22-33
    // // 2-|21|22|23| d1 -21-32-43
    // // 3-|31|32|33| d1 -31-42-53
    // // 4-|41|42|43| d2 -31-22-13
    // // 5-|51|52|53| d2 -41-32-23
    // // ------------ d2 -51-42-33

    // // +\|-1|-2|-3|-4|-5| d1 -11-22-33
    // // 1-|11|12|13|14|15| d1 -12-23-34
    // // 2-|21|22|23|23|24| d1 -13-23-35
    // // 3-|31|32|33|34|35| d2 -31-22-13
    // // ------------------ d2 -32-23-14
    // // ------------------ d2 -33-23-15

    // // Проверка победы по горизонталям и вертикалям
    // for (int i = 0; i < fieldSizeX; i++) {
    // int countX = 0;
    // for (int j = 0; j < fieldSizeY; j++) {
    // if (field[i][j] == dot)
    // countX++;
    // if (countX == fieldSizeY - stepsAhead)
    // return true;
    // }
    // }

    // for (int j = 0; j < fieldSizeY; j++) {
    // int countY = 0;
    // for (int i = 0; i < fieldSizeX; i++) {
    // if (field[i][j] == dot)
    // countY++;
    // if (countY == fieldSizeX - stepsAhead)
    // return true;
    // }
    // }

    // int win_count = Math.min(fieldSizeX, fieldSizeY); // Определяем количество

    // // Проверяем главную диагональ
    // for (int i = 0; i < fieldSizeX; i++) {
    // for (int j = 0; j < fieldSizeY; j++) {
    // int countMainDiagonal = 0;
    // int countAntiDiagonal = 0;
    //
    // for (int k = 0; k < win_count; k++) {
    // // Проверка главной диагонали
    // if (i + k < fieldSizeX && j + k < fieldSizeY && field[i + k][j + k] == dot) {
    // countMainDiagonal++;
    // if (countMainDiagonal == win_count - stepsAhead) {
    // return true;
    // }
    // }
    // // Проверка побочной диагонали
    // if (j - k >= 0 && i + k < fieldSizeX && field[i + k][j - k] == dot) {
    // countAntiDiagonal++;
    // if (countAntiDiagonal == win_count - stepsAhead) {
    // return true;
    // }
    // }
    // }
    // }
    // }
    // }

    // return false;
    // }

    static boolean checkWinForAi(char dot, int stepsAhead) {
        if (fieldSizeX == fieldSizeY) {
            // Квадратное поле
            // Проверка победы по горизонталям и вертикалям
            for (int i = 0; i < fieldSizeX; i++) {
                int countX = 0;
                int countY = 0;
                for (int j = 0; j < fieldSizeY; j++) {
                    if (field[i][j] == dot)
                        countX++;
                    if (field[j][i] == dot)
                        countY++;
                    if (countX == fieldSizeY - stepsAhead || countY == fieldSizeX - stepsAhead)
                        return true;
                }
            }

            // Проверка победы по диагоналям
            int countMainDiagonal = 0;
            int countAntiDiagonal = 0;
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    countMainDiagonal = 0;
                    countAntiDiagonal = 0;
                    for (int k = 0; k < fieldSizeX; k++) {
                        if (i + k < fieldSizeX && j + k < fieldSizeY && field[i + k][j + k] == dot) {
                            countMainDiagonal++;
                            if (countMainDiagonal == fieldSizeX - stepsAhead) {
                                return true;
                            }
                        }
                        if (j - k >= 0 && i + k < fieldSizeX && field[i + k][j - k] == dot) {
                            countAntiDiagonal++;
                            if (countAntiDiagonal == fieldSizeX - stepsAhead) {
                                return true;
                            }
                        }
                    }
                }
            }
        } else {
            // Прямоугольное поле
            // Проверка победы по горизонталям и вертикалям
            for (int i = 0; i < fieldSizeX; i++) {
                int countX = 0;
                for (int j = 0; j < fieldSizeY; j++) {
                    if (field[i][j] == dot)
                        countX++;
                    if (countX == fieldSizeY - stepsAhead)
                        return true;
                }
            }

            for (int j = 0; j < fieldSizeY; j++) {
                int countY = 0;
                for (int i = 0; i < fieldSizeX; i++) {
                    if (field[i][j] == dot)
                        countY++;
                    if (countY == fieldSizeX - stepsAhead)
                        return true;
                }
            }

            int win_count = Math.min(fieldSizeX, fieldSizeY); // Определяем количество элементов


            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    int countMainDiagonal = 0;
                    int countAntiDiagonal = 0;
                    // Проверяем главную диагональ
                    for (int k = 0; k < win_count; k++) {
                        // Проверка главной диагонали
                        if (i + k < fieldSizeX && j + k < fieldSizeY && field[i + k][j + k] == dot) {
                            countMainDiagonal++;
                        }
                        // Проверка побочной диагонали
                        if (j - k >= 0 && i + k < fieldSizeX && field[i + k][j - k] == dot) {
                            countAntiDiagonal++;
                        }
                    }
                    if (countMainDiagonal == win_count - stepsAhead || countAntiDiagonal == win_count - stepsAhead) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    static boolean checkWinV2(char dot, int win) {
        for (int x = 0; x < fieldSizeX; x++) {

            for (int y = 0; y < fieldSizeY; y++) {
                // if (check1 == true || check2())
            }
        }
        return false;
    }

    static boolean check1(int x, int y, char dot, int win) {
        return false;
    }

    static boolean check2(int x, int y, char dot, int win) {
        return false;
    }

    static boolean check3(int x, int y, char dot, int win) {
        return false;
    }

    static boolean check4(int x, int y, char dot, int win) {
        return false;
    }

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return
     */
    static boolean checkState(char dot, String s) {
        if (checkWin(dot)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

}

