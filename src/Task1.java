public class Task1 {

    public static void main(String[] args) {

//        System.out.println(remainder(1, 3)); // 1
//        System.out.println(remainder(3, 4)); // 3
//        System.out.println(remainder(-9, 45)); // -9
//        System.out.println(remainder(5, 5)); // 0


//      test 2
//        System.out.println(triArea(3, 2)); // 4
//        System.out.println(triArea(7, 4)); // 14
//        System.out.println(triArea(7, 5)); // 17.5


//       test3
//        System.out.println(animals(2, 3, 5)); // 36
//        System.out.println(animals(1, 2, 3)); // 22
//        System.out.println(animals(5, 2, 8)); // 50


//        test4
//        System.out.println(profitableGamble(0.2, 50, 9)); // true
//        System.out.println(profitableGamble(0.9, 1, 2)); // false
//        System.out.println(profitableGamble(0.9, 3, 2)); // true


//        test 5
//        System.out.println(operation(24, 15, 9)); // added
//        System.out.println(operation(24, 26, 2)); // subtracted
//        System.out.println(operation(24.0, 12, 2)); // multiply
//        System.out.println(operation(6, 12.0, 2)); // divide
//        System.out.println(operation(15, 11, 11)); // none


//        test 6
//        System.out.println(ctoa('A')); // 65
//        System.out.println(ctoa('m')); // 109
//        System.out.println(ctoa('[')); // 91


//        test 7
//        System.out.println(addUpTo(3)); // 6
//        System.out.println(addUpTo(10)); // 55
//        System.out.println(addUpTo(7)); // 28


//        test 8
//        System.out.println(nextEdge(8, 10)); // 17
//        System.out.println(nextEdge(5, 7));  // 11
//        System.out.println(nextEdge(9, 2));  // 10


//        test 9
//        System.out.println(sumOfCubes(new int[] {1,5,9})); // 855
//        System.out.println(sumOfCubes(new int[] {3,4,5})); // 216
//        System.out.println(sumOfCubes(new int[] {2})); // 8
//        System.out.println(sumOfCubes(new int[] {})); // 0


//        test 10
//        System.out.println(abcmath(42, 5, 10)); // false
//        System.out.println(abcmath(5, 2, 1)); // true
//        System.out.println(abcmath(1, 2, 3)); // false
//        System.out.println(abcmath(5, 5, 10)); // true


    }

    //  task1
//    В Java есть единственный оператор, способный обеспечить остаток от операции
//    деления. Два числа передаются в качестве параметров. Первый параметр,
//    разделенный на второй параметр, будет иметь остаток, возможно, ноль. Верните
//    это значение.
    public static int remainder(int firstNumber, int secondNumber) {
        if (secondNumber == 0) {
            return (int) Double.POSITIVE_INFINITY;
        } else {

            return firstNumber % secondNumber;
        }
    }

    //    task 2
//    Напишите функцию, которая принимает основание и высоту треугольника и
//    возвращает его площадь
    public static double triArea(int a, int h) {
        return (double) a * h / 2;
    }

    //  task 3
//    В этой задаче фермер просит вас сказать ему, сколько ног можно сосчитать среди
//    всех его животных. Фермер разводит три вида:
//    chickens = 2 legs
//            cows = 4 legs
//            pigs = 4 legs
//    Фермер подсчитал своих животных, и он дает вам промежуточный итог для каждого вида.
//    Вы должны реализовать функцию, которая возвращает общее количество ног всех
//    животных.
    public static int animals(int chickenLegs, int cowsLegs, int pigsLegs) {
        return chickenLegs * 2 + cowsLegs * 4 + pigsLegs * 4;
    }

    //   task4
//    Создайте функцию, которая принимает три аргумента (prob, prize, pay) и
//    возвращает true, если prob * prize > pay; в противном случае возвращает false.
//    Чтобы проиллюстрировать это: profitableGamble (0,2, 50, 9) должен выдать значение true,
//    поскольку 1 (0,2 * 50 - 9), а 1> 0.
    public static boolean profitableGamble(double prob, int prize, double pay) {
        return prob * prize > pay;
    }

//    task5
//Напишите функцию, которая принимает 3 числа и возвращает, что нужно сделать с
//    a и b: они должны быть сложены, вычитаны, умножены или разделены, чтобы
//    получить N. Если ни одна из операций не может дать N, верните "none".
//            3 числа – это N, a и b.

    public static String operation(double N, double a, double b) {
        if (a + b == N) {
            return "added";
        } else if (a - b == N) {
            return "subtracted";
        } else if (a * b == N) {
            return "multiply";
        } else if (a / b == N) {
            return "divide";
        } else {
            return "none";
        }
    }

    //  task 6
//  Создайте функцию, которая возвращает значение ASCII переданного символа.
    public static int ctoa(char symbol) {
        return symbol;
    }

    //    task 7
//    Напишите функцию, которая берет последнее число из последовательного списка
//    чисел и возвращает сумму всех чисел до него и включая его
    public static int addUpTo(int number) {
        int sums = 0;
        for (int i = 1; i <= number; i++) {
            sums += i;
        }
        return sums;
    }

    //    task 8
//    Создайте функцию, которая находит максимальное значение третьего ребра
//    треугольника, где длины сторон являются целыми числами.
    public static int nextEdge(int a, int b) {
        return a + b - 1;
    }


    //    task 9
//      Создайте функцию, которая принимает массив чисел и возвращает сумму его
//      кубов.
    public static int sumOfCubes(int[] array) {
        int sums = 0;
        for (double v : array) {
            sums += v * v * v;
        }
        return sums;
    }


//    task 10

    //    Создайте функцию, которая будет для данного a, b, c выполнять следующие
//    действия:
//            – Добавьте A к себе B раз.
//            – Проверьте, делится ли результат на C
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i < b; i++) {
            a += a;
        }
        return a % c == 0;
    }
}
