package ru.geekbrains.core.lesson2;

import java.util.Random;
import java.util.Scanner;

public class ProgramV2 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    // private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';
    private static final char DOT_EMPTY = '*';
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static char[][] field;

    public static void main(String[] args) {
        try (Scanner inputScanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Введите уровень сложности: \n" +
                        "1) Ai off - 1\n" +
                        "2) Ai random - 2 \n" +
                        "3) Ai immortal - 3\n");

                if (inputScanner.hasNextInt()) {
                    int versionAi = inputScanner.nextInt();
                    initialize();
                    printField();
                    while (true) {
                        humanTurn();
                        printField();
                        if (checkState(DOT_HUMAN, "Вы победили!"))
                            break;
                        aiTurn(versionAi);
                        printField();
                        if (checkState(DOT_AI, "Победил компьютер!"))
                            break;
                    }
                    System.out.println("Желаете сыграть еще раз? (Y - да): ");
                    if (!inputScanner.hasNext() || !inputScanner.next().equalsIgnoreCase("Y"))
                        break;
                } else {
                    System.out.println("Пожалуйста, введите число.");
                    inputScanner.next(); // Пропускаем некорректный ввод
                }
            }
        }
    }

    /**
     * Инициализация объектов игры
     */
    static void initialize() {
        fieldSizeX = 10;
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
        //        Черный: \u001B[30m
        //        Красный: \u001B[31m
        //        Зеленый: \u001B[32m
        //        Желтый: \u001B[33m
        //        Синий: \u001B[34m
        //        Пурпурный: \u001B[35m
        //        Голубой: \u001B[36m
        //        Белый: \u001B[37m
        // ANSI escape коды для цветов
        String resetColor = "\u001B[0m";  // Сброс цвета

        System.out.print("\u001B[36m+"); // Голубой цвет для верхней линии
        for (int x = 0; x < fieldSizeY; x++) {
            System.out.print("-" + (x + 1));
        }
        System.out.println("-" + resetColor); // Сброс цвета после линии

        // Вывод элементов поля с номерами строк в зеленом цвете
        for (int x = 0; x < fieldSizeX; x++) {
            System.out.print("\u001B[32m" + (x + 1) + "|"); // Зеленый цвет для номеров строк
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }
            System.out.println();
        }


        for (int x = 0; x < fieldSizeX * 2 + 2; x++) {
            System.out.print("-"); // Зеленый цвет нижней горизонтальной линии
        }
        System.out.println(resetColor); // Сброс цвета после линии
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
     * @param x i
     * @param y j
     * @return field == DOT_EMPTY
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка валидности координат хода
     *
     * @param x i
     * @param y j
     * @return true or false валидация координат поля
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    static void aiTurn(int versionAi) {
        int x;
        int y;

        switch (versionAi) {
            case 1:
                break;

            case 2:
                do {
                    x = random.nextInt(fieldSizeX);
                    y = random.nextInt(fieldSizeY);
                } while (!isCellEmpty(x, y));
                field[x][y] = DOT_AI;
                break;
            default:
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

                break;
        }

    }

    /**
     * Проверка на ничью
     *
     * @return false or true
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
     * @return false or true
     */

    static boolean checkWinForAi(char dot, int stepsAhead) {
        if (fieldSizeX == fieldSizeY) {
            // Квадратное поле
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

            int win_count = Math.min(fieldSizeX, fieldSizeY); // Определяем количество элементов на главной диагонали

            // Проверяем главную диагональ
            for (int i = 0; i < fieldSizeX; i++) {
                for (int j = 0; j < fieldSizeY; j++) {
                    int countMainDiagonal = 0;
                    int countAntiDiagonal = 0;
                    // Проверяем главную диагональ, начиная с текущего элемента
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

    /**
     * Проверка состояния игры
     *
     * @param dot фишка игрока
     * @param s   победный слоган
     * @return проверка выиграш или ничья - вкл 3 вариант Ai
     */
    static boolean checkState(char dot, String s) {
        if (checkWinForAi(dot, 0)) {
            System.out.println(s);
            return true;
        } else if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

}
