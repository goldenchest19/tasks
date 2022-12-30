import java.security.MessageDigest;
import java.sql.SQLOutput;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        System.out.println("task 1");
        System.out.println(Arrays.toString(encrypt("Hello")));
        System.out.println(Arrays.toString(encrypt("Sunshine")));
        System.out.println(decrypt(72, 33, -73, 84, -12, -3, 13, -13, -68));
        System.out.println(decrypt(encrypt("Hello")));
        System.out.println();

        System.out.println("task 2");
        System.out.println("Rook");
        System.out.println(canMove("Rook", "A8", "H8")); // true
        System.out.println(canMove("Rook", "A8", "A1")); // true
        System.out.println(canMove("Rook", "A1", "A8")); // true
        System.out.println(canMove("Rook", "B3", "H3")); // true
        System.out.println(canMove("Rook", "A1", "H8")); // false
        System.out.println("Bishop");
        System.out.println(canMove("Bishop", "A7", "G1")); // true
        System.out.println(canMove("Bishop", "B1", "H7")); // true
        System.out.println(canMove("Bishop", "H7", "B1")); // true
        System.out.println(canMove("Bishop", "A8", "H1")); // true
        System.out.println(canMove("Bishop", "F1", "B5")); // true
        System.out.println();
        System.out.println(canMove("Queen", "C4", "D6")); // false
        System.out.println(canMove("Queen", "C4", "D5")); // true
        System.out.println(canMove("Horse", "E4", "D6")); // true
        System.out.println(canMove("Pawn", "A4", "A5")); // true
        System.out.println();
        System.out.println("king");
        System.out.println(canMove("King", "E4", "D4")); // true
        System.out.println(canMove("King", "E4", "D5")); // true
        System.out.println(canMove("King", "E4", "D3")); // true
        System.out.println(canMove("King", "E4", "E5")); // true
        System.out.println(canMove("King", "E4", "E3")); // true
        System.out.println(canMove("King", "E4", "F5")); // true
        System.out.println(canMove("King", "E4", "F4")); // true
        System.out.println(canMove("King", "E4", "F3")); // true

        System.out.println();

        // пешка - на один ход вперед
        // слон - диагонально
        // ладья - Ладья умеет ходить по любым прямым линиям — вертикалям и горизонталям, н
        // а любое количество клеток, пока перед ней не возникнет препятствие.
        // ферзь - прямо и по диагонали
        // король - на одну клетку в любом направление

//        "Horse"; // конь
//        "Bishop"; // слон
//        "Queen"; // ферзь
//        "Rook"; // ладья
//        "Pawn"; // пешка
//        "King";

        System.out.println("task 3");
        System.out.println(canComplete("butl", "beautiful"));
        System.out.println(canComplete("butlz", "beautiful"));
        System.out.println(canComplete("tulb", "beautiful"));
        System.out.println(canComplete("bbutl", "beautiful"));
        System.out.println();

        System.out.println("task 4");
        System.out.println(sumDigProd(16, 28));
        System.out.println(sumDigProd(0));
        System.out.println(sumDigProd(1, 2, 3, 4, 5, 6));
        System.out.println();

        System.out.println("task 5");
        System.out.println(sameVowelGroup("toe", "ocelot", "maniac"));
        System.out.println(sameVowelGroup("many", "carriage", "emit", "apricot", "animal"));
        System.out.println(sameVowelGroup("hoops", "chuff", "bot", "bottom"));
        System.out.println();

        System.out.println("task 6");
        System.out.println(validateCard(1234567890123456L));
        System.out.println(validateCard(1234567890123452L));
        System.out.println();

        System.out.println("task 7");
        System.out.println(numToEng(0));
        System.out.println(numToEng(18));
        System.out.println(numToEng(134));
        System.out.println(numToEng(167));
        System.out.println(numToEng(895));
        System.out.println(numToRus(0));
        System.out.println(numToRus(18));
        System.out.println(numToRus(134));
        System.out.println(numToRus(807));
        System.out.println();

        System.out.println("task 8");
        System.out.println(getSha256Hash("password123"));
        System.out.println(getSha256Hash("Fluffy@home"));
        System.out.println(getSha256Hash("Hey dude!"));
        System.out.println();

        System.out.println("task 9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        System.out.println(correctTitle("sansa stark, lady of winterfell."));
        System.out.println(correctTitle("TYRION LANNISTER, HAND OF THE QUEEN."));
        System.out.println();

        System.out.println("task 10");
        hexLattice(1);
        System.out.println();
        hexLattice(7);
        System.out.println();
        hexLattice(19);
        System.out.println();
        hexLattice(21);
        System.out.println();
    }

    //    1. Пришло время отправлять и получать секретные сообщения.
//    Создайте две функции, которые принимают строку и массив и возвращают
//    закодированное или декодированное сообщение.
//    Первая буква строки или первый элемент массива представляет собой символьный код
//    этой буквы. Следующие элементы-это различия между символами: например, A +3 --> C
//    или z -1 --> y.
    public static int[] encrypt(String line) {
        int[] crypt = new int[line.length()];
        crypt[0] = line.charAt(0);
        // добавляем разность индексов с предыдущим символом в массив
        for (int i = 1; i < line.length(); i++) {
            crypt[i] = line.charAt(i) - line.charAt(i - 1);
        }
        return crypt;
    }

    public static String decrypt(int... crypt) {
        StringBuilder line = new StringBuilder(crypt.length);
        int sum = crypt[0];
        line.append((char) sum);
        // суммируем значения разности индексов символов, добавляя по индексу символы в строку
        for (int i = 1; i < crypt.length; i++) {
            sum += crypt[i];
            line.append((char) sum);
        }
        return line.toString();
    }

    //    2. Создайте функцию, которая принимает имя шахматной фигуры, ее положение и
//    целевую позицию. Функция должна возвращать true, если фигура может двигаться
//    к цели, и false, если она не может этого сделать.
//    Возможные входные данные - "пешка", "конь", "слон", "Ладья", "Ферзь"и " король"
    // пешка - на один ход вперед
    // слон - диагонально
    // ладья - Ладья умеет ходить по любым прямым линиям — вертикалям и горизонталям, н
    // а любое количество клеток, пока перед ней не возникнет препятствие.
    // ферзь - прямо и по диагонали
    // король - на одну клетку в любом направление
    //        "Horse"; // конь
//        "Bishop"; // слон
//        "Queen"; // ферзь
//        "Rook"; // ладья
//        "Pawn"; // пешка
//        "King";
    public static boolean canMove(String figure, String from, String to) {
        boolean flag = false;
        int x0 = from.charAt(0);
        int x1 = to.charAt(0);
        int y0 = from.charAt(1);
        int y1 = to.charAt(1);

        if (figure.equals("Pawn")) {
            if ((x0 == x1) && (y1 - y0 == 1)) {
                flag = true;
            }
        } else if (figure.equals("Horse")) {
           if (((Math.abs(x0 - x1) == 2) && (Math.abs(y0 - y1) == 1)) ||
                    ((Math.abs(x0 - x1) == 1) && (Math.abs(y0 - y1) == 2))) {
               flag = true;
           }
        } else if (figure.equals("Bishop")) {
            //слон находится по диагонали от исходной клетки -> модули разности координат ==
            if (Math.abs(x0 - x1) == Math.abs(y0 - y1)) {
                flag = true;
            }
        } else if (figure.equals("Rook")) {
            // ладья
            if ((x0 == x1) || (y0 == y1)) {
                flag = true;
            }
        } else if (figure.equals("Queen")) {
            // ферзь
            if ((Math.abs(x0 - x1) == Math.abs(y0 - y1))
                    || ((x0 == x1) || (y0 == y1))) {
                flag = true;
            }
        } else if (figure.equals("King")) {
            if ((Math.abs(x0 - x1) == 1)
                    || (Math.abs(y0 - y1) == 1)) {
                flag = true;
            }
        }
        return flag;
    }

    //    3. Входная строка может быть завершена, если можно добавить дополнительные
//    буквы, и никакие буквы не должны быть удалены, чтобы соответствовать слову.
//    Кроме того, порядок букв во входной строке должен быть таким же, как и порядок
//    букв в последнем слове.
//    Создайте функцию, которая, учитывая входную строку, определяет, может ли слово быть
//    завершено.
    public static boolean canComplete(String subline, String line) {
        // Идём по строке, сравнивая поочерёдно с каждым символом субстроки.
        // Если длина субстроки равна количеству совпадений - true
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == subline.charAt(count)) {
                count++;
                if (subline.length() == count) return true;
            }
        }
        return false;
    }

    //    4. Создайте функцию, которая принимает числа в качестве аргументов, складывает их
//    вместе и возвращает произведение цифр до тех пор, пока ответ не станет длиной
//    всего в 1 цифру.
    public static int sumDigProd(int... massive) {
        int number = 0;
        for (int i : massive) {
            number += i;
        }
        while (number > 9) {
            int tempNumber = 1;
            while (number > 0) {
                tempNumber *= number % 10;
                number /= 10;
            }
            number = tempNumber;
        }
        return number;
    }


    //    5. Напишите функцию, которая выбирает все слова, имеющие все те же гласные
//    (в любом порядке и / или количестве), что и первое слово, включая первое слово.
    public static List<String> sameVowelGroup(String... lines) {
        List<String> result = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        // по умолчанию вводим первое слово, вносим все его гласные в set
        result.add(lines[0]);
        String vowelLettersFirstWord = lines[0].replaceAll("[^aeiouy]", "");
        for (int i = 0; i < vowelLettersFirstWord.length(); i++) {
            set.add(vowelLettersFirstWord.charAt(i));
        }
        // идём по всем строкам, начиная со второй, сравниваем гласные с теми, что есть в set
        for (int i = 1; i < lines.length; i++) {
            String vowelLetters = lines[i].replaceAll("[^aeiouy]", "");
            boolean flag = true;
            for (char c : vowelLetters.toCharArray()) {
                if (!set.contains(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(lines[i]);
            }
        }
        return result;
    }

//    6. Создайте функцию, которая принимает число в качестве аргумента и возвращает
//      true, если это число является действительным номером кредитной карты, а в
//    противном случае-false.
//    Номера кредитных карт должны быть длиной от 14 до 19 цифр и проходить тест Луна,
//    описанный ниже:
//            – Удалите последнюю цифру (это"контрольная цифра").
//            – Переверните число.
//            – Удвойте значение каждой цифры в нечетных позициях. Если удвоенное значение имеет
//    более 1 цифры, сложите цифры вместе (например, 8 x 2 = 16 ➞ 1 + 6 = 7).
//            – Добавьте все цифры.
//– Вычтите последнюю цифру суммы (из шага 4) из 10. Результат должен быть равен
//    контрольной цифре из Шага 1.
// Step 1: check digit = 6, num = 123456789012345
// Step 2: num reversed = 543210987654321
// Step 3: digit array after selective doubling: [1, 4, 6, 2, 2, 0, 9,
//8, 5, 6, 1, 4, 6, 2, 2]
// Step 4: sum = 58
// Step 5: 10 - 8 = 2 (not equal to 6) ➞ false
//    validateCard(1234567890123452) ➞ true
    // Same as above, but check digit checks out.
    public static boolean validateCard(Long number) {
        if (number < Math.pow(10, 14) || number >= Math.pow(10, 20)) {
            return false;
        }
        // шаг 1 - находим контрольную сумму
        int checkSum = (int) (number % 10);
        String num = number.toString();
        num = num.substring(0, num.length() - 1);
        // шаг 2-3-4, идем по числу в обратном порядке, и сразу же складываем найденные цифры
        int sum = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            int doubleInt = Integer.parseInt(num.substring(i, i + 1));
            if ((num.length() - i) % 2 == 1) {
                doubleInt *= 2;
                if (doubleInt > 9) {
                    doubleInt = doubleInt % 10 + (doubleInt / 10) % 10;
                }
            }
            sum += doubleInt;
        }
        // шаг 5 - сравниваем число с контрольной цифрой
        return (10 - (sum % 10)) == checkSum;
    }

    //    7. Напишите функцию, которая принимает положительное целое число от 0 до 999
//    включительно и возвращает строковое представление этого целого числа,
//    написанное на английском, руссском языке.
    public static String numToEng(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) {
            return result.append("zero").toString();
        }
        String[] SUBTWENTY = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] DECADES = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n / 100 != 0) {
            result.append(String.format("%s hundred ", SUBTWENTY[n / 100]));
        }
        if (n % 100 >= 20) {
            result.append(String.format("%s %s ", DECADES[(n % 100 / 10) - 2], SUBTWENTY[n % 10]));
        } else {
            result.append(SUBTWENTY[n % 100]);
        }
        return result.toString();
    }

    public static String numToRus(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) {
            return result.append("ноль").toString();
        }
        String[] SUBTWENTY = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать"};
        String[] DECADES = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] HUNDREDS = {"", "сто ", "двести ", "триста ", "четыреста ",
                "пятьсот ", "шестьсот ", "семьсот ", "восемьсот ", "девятьсот "};
        result.append(HUNDREDS[n / 100]);
        if (n % 100 >= 20) {
            result.append(String.format("%s %s ", DECADES[n % 100 / 10 - 2], SUBTWENTY[n % 10]));
        } else {
            result.append(SUBTWENTY[n % 100]);
        }
        return result.toString();
    }

    //8 SHA-256
    public static String getSha256Hash(String Line) {
        try {
//            MessageDigest представляет криптографическую хеш-функцию,
//            которая может вычислять дайджест сообщения из двоичных данных.
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(Line.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (int i : hash) {
                String hex = Integer.toHexString(0xff & i);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    //    9. Напишите функцию, которая принимает строку и возвращает строку с правильным
//    регистром для заголовков символов в серии "Игра престолов".
//    Слова and, the, of и in должны быть строчными. Все остальные слова должны иметь
//    первый символ в верхнем регистре, а остальные-в Нижнем.
    public static String correctTitle(String s) {
        String[] words = s.toLowerCase().split(" ");
        StringJoiner joiner = new StringJoiner(" ");
        for (String word : words) {
            if (!word.equals("of") && !word.equals("in") && !word.equals("and") && !word.equals("the")) {
                word = word.substring(0, 1).toUpperCase() + word.substring(1);
            }
            joiner.add(word);
        }
        return joiner.toString();
    }

    //    10. Как указано в онлайн-энциклопедии целочисленных последовательностей:
//    Гексагональная решетка - это привычная двумерная решетка, в которой каждая точка
//    имеет 6 соседей.Центрированное шестиугольное число - это центрированное фигурное число,
//    представляющее шестиугольник с точкой в центре и всеми другими точками,
//    окружающими центральную точку в шестиугольной решетке.
//    Напишите функцию, которая принимает целое число n и возвращает "недопустимое", если
//    n не является центрированным шестиугольным числом или его иллюстрацией в виде
//    многострочной прямоугольной строки в противном случае.
    public static void hexLattice(int n) {
        // вычисляем модификатор, присваиваем его n
        for (int i = 1; n >= 1; i++) {
            if (n == 1) {
                n = i;
                break;
            }
            n -= i * 6;
        }
        if (n < 0) {
            System.out.println("Invalid");
        }

        int space = 1 + (n - 1) * 2;
        for (int i = space; i > 0; i--) {
            System.out.println(" ".repeat(Math.abs(space + 1 - n)) + "o ".repeat(n));
            if (n <= i) n++;
            else n--;
        }
    }
}