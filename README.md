## Java_Core_DZ_3
Урок 3. Классы и объекты
1. Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).
2) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
Для «повременщиков» формула для расчета такова: «среднемесячная заработная плата = 20.8 * 8 * почасовая ставка», для работников с фиксированной оплатой «среднемесячная заработная плата = фиксированная месячная оплата».
3) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.
4) ** Реализовать интерфейсы для возможности сортировки массива/коллекции (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на урове базового типа и создайте свой уникальный компаратор.
5) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer), и реализовать возможность вывода данных с использованием foreach (подсказка: вам потребуется поработать с интерфейсом Iterable).


## Java_Core_DZ_2

            // Квадратное поле

            // +\|-1|-2|-3|-4|-5|
            // 1-|11|12|13|14|15|
            // 2-|21|22|23|23|24|
            // 3-|31|32|33|34|35|
            // 4-|41|42|43|44|45|
            // 5-|51|52|53|54|55|
            // ------------------


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

1) Полностью разобраться с кодом программы разработанной на семинаре, переписать программу. Это минимальная задача для сдачи домашней работы.

Усложняем задачу:

2) ** Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3) **** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.


1)  nmake /f D:\Java_Core_DZ\Java_Core_DZ\02\lesson2\Makefile.mak build
2)  nmake /f D:\Java_Core_DZ\Java_Core_DZ\02\lesson2\Makefile.mak run
     
        docker run -i --name java-container-lesson2 java-program-lesson2
        Введите уровень сложности:
           1) Ai off - 1  
           2) Ai random - 2
           3) Ai immortal - 3`



            // Пример работы
           2024-04-22 02:16:08 Введите уровень сложности:
           2024-04-22 02:16:08 1) Ai off - 1
           2024-04-22 02:16:08 2) Ai random - 2
           2024-04-22 02:16:08 3) Ai immortal - 3
           2024-04-22 02:16:08
           2024-04-22 02:16:12 +-1-2-3-4-5-
           2024-04-22 02:16:12 1|*|*|*|*|*|
           2024-04-22 02:16:12 2|*|*|*|*|*|
           2024-04-22 02:16:12 3|*|*|*|*|*|
           2024-04-22 02:16:12 4|*|*|*|*|*|
           2024-04-22 02:16:12 5|*|*|*|*|*|
           2024-04-22 02:16:12 6|*|*|*|*|*|
           2024-04-22 02:16:12 7|*|*|*|*|*|
           2024-04-22 02:16:12 8|*|*|*|*|*|
           2024-04-22 02:16:12 9|*|*|*|*|*|
           2024-04-22 02:16:12 10|*|*|*|*|*|
           2024-04-22 02:16:12 ----------------------
           2024-04-22 02:16:12 Введите координаты хода X и Y
           2024-04-22 02:16:12 (от 1 до 3) через пробел:
           2024-04-22 02:16:15 +-1-2-3-4-5-
           2024-04-22 02:16:15 1|X|*|*|*|*|
           2024-04-22 02:16:15 2|*|*|*|*|*|
           2024-04-22 02:16:15 3|*|*|*|*|*|
           2024-04-22 02:16:15 4|*|*|*|*|*|
           2024-04-22 02:16:15 5|*|*|*|*|*|
           2024-04-22 02:16:15 6|*|*|*|*|*|
           2024-04-22 02:16:15 7|*|*|*|*|*|
           2024-04-22 02:16:15 8|*|*|*|*|*|
           2024-04-22 02:16:15 9|*|*|*|*|*|
           2024-04-22 02:16:15 10|*|*|*|*|*|
           2024-04-22 02:16:15 ----------------------
           2024-04-22 02:16:15 +-1-2-3-4-5-
           2024-04-22 02:16:15 1|X|*|*|*|*|
           2024-04-22 02:16:15 2|*|*|*|*|*|
           2024-04-22 02:16:15 3|*|*|*|*|*|
           2024-04-22 02:16:15 4|*|*|*|*|*|
           2024-04-22 02:16:15 5|*|*|*|*|*|
           2024-04-22 02:16:15 6|*|*|*|*|*|
           2024-04-22 02:16:15 7|*|*|*|*|*|
           2024-04-22 02:16:15 8|*|*|*|*|*|
           2024-04-22 02:16:15 9|*|*|*|*|*|
           2024-04-22 02:16:15 10|*|*|*|*|*|
           2024-04-22 02:16:15 ----------------------
           2024-04-22 02:16:15 Введите координаты хода X и Y
           2024-04-22 02:16:15 (от 1 до 3) через пробел:
           2024-04-22 02:16:21 +-1-2-3-4-5-
           2024-04-22 02:16:21 1|X|*|*|*|*|
           2024-04-22 02:16:21 2|*|X|*|*|*|
           2024-04-22 02:16:21 3|*|*|*|*|*|
           2024-04-22 02:16:21 4|*|*|*|*|*|
           2024-04-22 02:16:21 5|*|*|*|*|*|
           2024-04-22 02:16:21 6|*|*|*|*|*|
           2024-04-22 02:16:21 7|*|*|*|*|*|
           2024-04-22 02:16:21 8|*|*|*|*|*|
           2024-04-22 02:16:21 9|*|*|*|*|*|
           2024-04-22 02:16:21 10|*|*|*|*|*|
           2024-04-22 02:16:21 ----------------------
           2024-04-22 02:16:21 +-1-2-3-4-5-
           2024-04-22 02:16:21 1|X|*|*|*|*|
           2024-04-22 02:16:21 2|*|X|*|*|*|
           2024-04-22 02:16:21 3|*|*|*|*|*|
           2024-04-22 02:16:21 4|*|*|*|*|*|
           2024-04-22 02:16:21 5|*|*|*|*|*|
           2024-04-22 02:16:21 6|*|*|*|*|*|
           2024-04-22 02:16:21 7|*|*|*|*|*|
           2024-04-22 02:16:21 8|*|*|*|*|*|
           2024-04-22 02:16:21 9|*|*|*|*|*|
           2024-04-22 02:16:21 10|*|*|*|*|*|
           2024-04-22 02:16:21 ----------------------
           2024-04-22 02:16:21 Введите координаты хода X и Y
           2024-04-22 02:16:21 (от 1 до 3) через пробел:
           2024-04-22 02:16:24 +-1-2-3-4-5-
           2024-04-22 02:16:24 1|X|*|*|*|*|
           2024-04-22 02:16:24 2|*|X|*|*|*|
           2024-04-22 02:16:24 3|*|*|X|*|*|
           2024-04-22 02:16:24 4|*|*|*|*|*|
           2024-04-22 02:16:24 5|*|*|*|*|*|
           2024-04-22 02:16:24 6|*|*|*|*|*|
           2024-04-22 02:16:24 7|*|*|*|*|*|
           2024-04-22 02:16:24 8|*|*|*|*|*|
           2024-04-22 02:16:24 9|*|*|*|*|*|
           2024-04-22 02:16:24 10|*|*|*|*|*|
           2024-04-22 02:16:24 ----------------------
           2024-04-22 02:16:24 +-1-2-3-4-5-
           2024-04-22 02:16:24 1|X|*|*|*|*|
           2024-04-22 02:16:24 2|*|X|*|*|*|
           2024-04-22 02:16:24 3|*|*|X|*|*|
           2024-04-22 02:16:24 4|*|*|*|*|*|
           2024-04-22 02:16:24 5|*|*|*|*|*|
           2024-04-22 02:16:24 6|*|*|*|*|*|
           2024-04-22 02:16:24 7|*|*|*|*|*|
           2024-04-22 02:16:24 8|*|*|*|*|*|
           2024-04-22 02:16:24 9|*|*|*|*|*|
           2024-04-22 02:16:24 10|*|*|*|*|*|
           2024-04-22 02:16:24 ----------------------
           2024-04-22 02:16:24 Введите координаты хода X и Y
           2024-04-22 02:16:24 (от 1 до 3) через пробел:
           2024-04-22 02:16:28 +-1-2-3-4-5-
           2024-04-22 02:16:28 1|X|*|*|*|*|
           2024-04-22 02:16:28 2|*|X|*|*|*|
           2024-04-22 02:16:28 3|*|*|X|*|*|
           2024-04-22 02:16:28 4|*|*|*|X|*|
           2024-04-22 02:16:28 5|*|*|*|*|*|
           2024-04-22 02:16:28 6|*|*|*|*|*|
           2024-04-22 02:16:28 7|*|*|*|*|*|
           2024-04-22 02:16:28 8|*|*|*|*|*|
           2024-04-22 02:16:28 9|*|*|*|*|*|
           2024-04-22 02:16:28 10|*|*|*|*|*|
           2024-04-22 02:16:28 ----------------------
           2024-04-22 02:16:28 +-1-2-3-4-5-
           2024-04-22 02:16:28 1|X|*|*|*|*|
           2024-04-22 02:16:28 2|*|X|*|*|*|
           2024-04-22 02:16:28 3|*|*|X|*|*|
           2024-04-22 02:16:28 4|*|*|*|X|*|
           2024-04-22 02:16:28 5|*|*|*|*|*|
           2024-04-22 02:16:28 6|*|*|*|*|*|
           2024-04-22 02:16:28 7|*|*|*|*|*|
           2024-04-22 02:16:28 8|*|*|*|*|*|
           2024-04-22 02:16:28 9|*|*|*|*|*|
           2024-04-22 02:16:28 10|*|*|*|*|*|
           2024-04-22 02:16:28 ----------------------
           2024-04-22 02:16:28 Введите координаты хода X и Y
           2024-04-22 02:16:28 (от 1 до 3) через пробел:
           2024-04-22 02:16:31 +-1-2-3-4-5-
           2024-04-22 02:16:31 1|X|*|*|*|*|
           2024-04-22 02:16:31 2|*|X|*|*|*|
           2024-04-22 02:16:31 3|*|*|X|*|*|
           2024-04-22 02:16:31 4|*|*|*|X|*|
           2024-04-22 02:16:31 5|*|*|*|*|X|
           2024-04-22 02:16:31 6|*|*|*|*|*|
           2024-04-22 02:16:31 7|*|*|*|*|*|
           2024-04-22 02:16:31 8|*|*|*|*|*|
           2024-04-22 02:16:31 9|*|*|*|*|*|
           2024-04-22 02:16:31 10|*|*|*|*|*|
           2024-04-22 02:16:31 ----------------------
           2024-04-22 02:16:31 Вы победили!
           2024-04-22 02:16:31 Желаете сыграть еще раз? (Y - да):
           2024-04-22 02:16:38 Введите уровень сложности:
           2024-04-22 02:16:38 1) Ai off - 1
           2024-04-22 02:16:38 2) Ai random - 2
           2024-04-22 02:16:38 3) Ai immortal - 3
           2024-04-22 02:16:38
           2024-04-22 02:16:40 +-1-2-3-4-5-
           2024-04-22 02:16:40 1|*|*|*|*|*|
           2024-04-22 02:16:40 2|*|*|*|*|*|
           2024-04-22 02:16:40 3|*|*|*|*|*|
           2024-04-22 02:16:40 4|*|*|*|*|*|
           2024-04-22 02:16:40 5|*|*|*|*|*|
           2024-04-22 02:16:40 6|*|*|*|*|*|
           2024-04-22 02:16:40 7|*|*|*|*|*|
           2024-04-22 02:16:40 8|*|*|*|*|*|
           2024-04-22 02:16:40 9|*|*|*|*|*|
           2024-04-22 02:16:40 10|*|*|*|*|*|
           2024-04-22 02:16:40 ----------------------
           2024-04-22 02:16:40 Введите координаты хода X и Y
           2024-04-22 02:16:40 (от 1 до 3) через пробел:
           2024-04-22 02:16:42 +-1-2-3-4-5-
           2024-04-22 02:16:42 1|*|X|*|*|*|
           2024-04-22 02:16:42 2|*|*|*|*|*|
           2024-04-22 02:16:42 3|*|*|*|*|*|
           2024-04-22 02:16:42 4|*|*|*|*|*|
           2024-04-22 02:16:42 5|*|*|*|*|*|
           2024-04-22 02:16:42 6|*|*|*|*|*|
           2024-04-22 02:16:42 7|*|*|*|*|*|
           2024-04-22 02:16:42 8|*|*|*|*|*|
           2024-04-22 02:16:42 9|*|*|*|*|*|
           2024-04-22 02:16:42 10|*|*|*|*|*|
           2024-04-22 02:16:42 ----------------------
           2024-04-22 02:16:42 +-1-2-3-4-5-
           2024-04-22 02:16:42 1|*|X|*|*|*|
           2024-04-22 02:16:42 2|*|*|*|*|*|
           2024-04-22 02:16:42 3|*|*|*|*|*|
           2024-04-22 02:16:42 4|*|*|*|*|*|
           2024-04-22 02:16:42 5|*|*|*|*|*|
           2024-04-22 02:16:42 6|*|*|*|*|*|
           2024-04-22 02:16:42 7|*|*|*|*|*|
           2024-04-22 02:16:42 8|*|*|*|*|*|
           2024-04-22 02:16:42 9|*|*|*|*|*|
           2024-04-22 02:16:42 10|*|*|*|*|*|
           2024-04-22 02:16:42 ----------------------
           2024-04-22 02:16:42 Введите координаты хода X и Y
           2024-04-22 02:16:42 (от 1 до 3) через пробел:
           2024-04-22 02:16:43 +-1-2-3-4-5-
           2024-04-22 02:16:43 1|*|X|X|*|*|
           2024-04-22 02:16:43 2|*|*|*|*|*|
           2024-04-22 02:16:43 3|*|*|*|*|*|
           2024-04-22 02:16:43 4|*|*|*|*|*|
           2024-04-22 02:16:43 5|*|*|*|*|*|
           2024-04-22 02:16:43 6|*|*|*|*|*|
           2024-04-22 02:16:43 7|*|*|*|*|*|
           2024-04-22 02:16:43 8|*|*|*|*|*|
           2024-04-22 02:16:43 9|*|*|*|*|*|
           2024-04-22 02:16:43 10|*|*|*|*|*|
           2024-04-22 02:16:43 ----------------------
           2024-04-22 02:16:43 +-1-2-3-4-5-
           2024-04-22 02:16:43 1|*|X|X|*|*|
           2024-04-22 02:16:43 2|*|*|*|*|*|
           2024-04-22 02:16:43 3|*|*|*|*|*|
           2024-04-22 02:16:43 4|*|*|*|*|*|
           2024-04-22 02:16:43 5|*|*|*|*|*|
           2024-04-22 02:16:43 6|*|*|*|*|*|
           2024-04-22 02:16:43 7|*|*|*|*|*|
           2024-04-22 02:16:43 8|*|*|*|*|*|
           2024-04-22 02:16:43 9|*|*|*|*|*|
           2024-04-22 02:16:43 10|*|*|*|*|*|
           2024-04-22 02:16:43 ----------------------
           2024-04-22 02:16:43 Введите координаты хода X и Y
           2024-04-22 02:16:43 (от 1 до 3) через пробел:
           2024-04-22 02:16:45 +-1-2-3-4-5-
           2024-04-22 02:16:45 1|*|X|X|X|*|
           2024-04-22 02:16:45 2|*|*|*|*|*|
           2024-04-22 02:16:45 3|*|*|*|*|*|
           2024-04-22 02:16:45 4|*|*|*|*|*|
           2024-04-22 02:16:45 5|*|*|*|*|*|
           2024-04-22 02:16:45 6|*|*|*|*|*|
           2024-04-22 02:16:45 7|*|*|*|*|*|
           2024-04-22 02:16:45 8|*|*|*|*|*|
           2024-04-22 02:16:45 9|*|*|*|*|*|
           2024-04-22 02:16:45 10|*|*|*|*|*|
           2024-04-22 02:16:45 ----------------------
           2024-04-22 02:16:45 +-1-2-3-4-5-
           2024-04-22 02:16:45 1|*|X|X|X|*|
           2024-04-22 02:16:45 2|*|*|*|*|*|
           2024-04-22 02:16:45 3|*|*|*|*|*|
           2024-04-22 02:16:45 4|*|*|*|*|*|
           2024-04-22 02:16:45 5|*|*|*|*|*|
           2024-04-22 02:16:45 6|*|*|*|*|*|
           2024-04-22 02:16:45 7|*|*|*|*|*|
           2024-04-22 02:16:45 8|*|*|*|*|*|
           2024-04-22 02:16:45 9|*|*|*|*|*|
           2024-04-22 02:16:45 10|*|*|*|*|*|
           2024-04-22 02:16:45 ----------------------
           2024-04-22 02:16:45 Введите координаты хода X и Y
           2024-04-22 02:16:45 (от 1 до 3) через пробел:
           2024-04-22 02:16:47 +-1-2-3-4-5-
           2024-04-22 02:16:47 1|*|X|X|X|X|
           2024-04-22 02:16:47 2|*|*|*|*|*|
           2024-04-22 02:16:47 3|*|*|*|*|*|
           2024-04-22 02:16:47 4|*|*|*|*|*|
           2024-04-22 02:16:47 5|*|*|*|*|*|
           2024-04-22 02:16:47 6|*|*|*|*|*|
           2024-04-22 02:16:47 7|*|*|*|*|*|
           2024-04-22 02:16:47 8|*|*|*|*|*|
           2024-04-22 02:16:47 9|*|*|*|*|*|
           2024-04-22 02:16:47 10|*|*|*|*|*|
           2024-04-22 02:16:47 ----------------------
           2024-04-22 02:16:47 +-1-2-3-4-5-
           2024-04-22 02:16:47 1|*|X|X|X|X|
           2024-04-22 02:16:47 2|*|*|*|*|*|
           2024-04-22 02:16:47 3|*|*|*|*|*|
           2024-04-22 02:16:47 4|*|*|*|*|*|
           2024-04-22 02:16:47 5|*|*|*|*|*|
           2024-04-22 02:16:47 6|*|*|*|*|*|
           2024-04-22 02:16:47 7|*|*|*|*|*|
           2024-04-22 02:16:47 8|*|*|*|*|*|
           2024-04-22 02:16:47 9|*|*|*|*|*|
           2024-04-22 02:16:47 10|*|*|*|*|*|
           2024-04-22 02:16:47 ----------------------
           2024-04-22 02:16:47 Введите координаты хода X и Y
           2024-04-22 02:16:47 (от 1 до 3) через пробел:
           2024-04-22 02:16:53 +-1-2-3-4-5-
           2024-04-22 02:16:53 1|X|X|X|X|X|
           2024-04-22 02:16:53 2|*|*|*|*|*|
           2024-04-22 02:16:53 3|*|*|*|*|*|
           2024-04-22 02:16:53 4|*|*|*|*|*|
           2024-04-22 02:16:53 5|*|*|*|*|*|
           2024-04-22 02:16:53 6|*|*|*|*|*|
           2024-04-22 02:16:53 7|*|*|*|*|*|
           2024-04-22 02:16:53 8|*|*|*|*|*|
           2024-04-22 02:16:53 9|*|*|*|*|*|
           2024-04-22 02:16:53 10|*|*|*|*|*|
           2024-04-22 02:16:53 ----------------------
           2024-04-22 02:16:53 Вы победили!
           2024-04-22 02:16:53 Желаете сыграть еще раз? (Y - да): 
