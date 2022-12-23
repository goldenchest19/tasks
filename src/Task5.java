import java.security.MessageDigest;
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
        System.out.println(canMove("ладья", "A8", "H8"));
        System.out.println(canMove("слон", "A7", "G1"));
        System.out.println(canMove("ферзь", "C4", "D6"));
        System.out.println();

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
//    Возможные входные данные - "пешка", "конь", "слон", "Ладья", "Ферзь"и " король".
    public static boolean canMove(String name, String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        int x0 = x[0];
        int y0 = y[0];
        int x1 = x[1];
        int y1 = y[1];

        return switch (name) {
            case ("пешка") -> (Math.abs(x0 - y0) == 1) && (Math.abs(x1 - y1) == 1);

            case ("конь") -> (Math.abs(x0 - y0) == 1) && (Math.abs(x1 - y1) == 2) ||
                    (Math.abs(x0 - y0) == 2) && (Math.abs(x1 - y1) == 1);

            case ("слон") -> (Math.abs(x0 - y0) == Math.abs(x1 - y1));

            case ("ладья") -> (Math.abs(x0 - y0) == 0) || (Math.abs(x1 - y1) == 0);

            case ("ферзь") -> (Math.abs(x0 - y0) == Math.abs(x1 - y1)) ||
                    (Math.abs(x0 - y0) == 0) || (Math.abs(x1 - y1) == 0);

            case ("король") -> (Math.abs(x0 - y0) == 1) || (Math.abs(x1 - y1) == 1);
            default -> false;
        };
    }

    //    3. Входная строка может быть завершена, если можно добавить дополнительные
//    буквы, и никакие буквы не должны быть удалены, чтобы соответствовать слову.
//    Кроме того, порядок букв во входной строке должен быть таким же, как и порядок
//    букв в последнем слове.
//    Создайте функцию, которая, учитывая входную строку, определяет, может ли слово быть
//    завершено.
    public static boolean canComplete(String subline, String line) {
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
        int number = 1;
        for (int i : massive) {
            number *= i;
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
        // по умолчанию вводим первое слово, вносим все его гласные в set, глассные находим через регулярку
        result.add(lines[0]);
        String vowelLettersFirstWord = lines[0].replaceAll("[^aeiouy]", "");
        for (int i = 0; i < vowelLettersFirstWord.length(); i++) {
            set.add(vowelLettersFirstWord.charAt(i));
        }
        // идём по всем строка, начиная со второй, сравниваем гласные с теми, что есть в set
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
        if (n == 0) return result.append("zero").toString();
        String[] SUBTWENTY = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] DECADES = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n / 100 != 0) {
            result.append(String.format("%s hundred ", SUBTWENTY[n / 100]));
        }
        if (n % 100 >= 20) {
            result.append(String.format("%s %s ", DECADES[n % 100 / 10 - 2], SUBTWENTY[n % 10]));
        } else {
            result.append(SUBTWENTY[n % 100]);
        }
        return result.toString();
    }

    public static String numToRus(int n) {
        StringBuilder result = new StringBuilder();
        if (n == 0) return result.append("ноль").toString();
        String[] SUBTWENTY = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать"};
        String[] DECADES = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] HUNDREDS = {"", "сто ", "двесте ", "триста ", "четыреста ",
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
                if (hex.length() == 1) hexString.append('0');
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
    public static String correctTitle(String text) {
        StringBuilder finalString = new StringBuilder(
                text.toLowerCase());
        //делаем первый символ прописным
        finalString.setCharAt(0, Character.
                toUpperCase(
                        text.charAt(0)));
        //крутимся в цикле, и меняем буквы, перед которыми пробел на заглавные + требует проверки, что слово не является служебной частью речи
        // в цикле меняем первую букву на заглавную в соответствие с требованиями
        for (int i = 1; i < text.length(); i++) {
            if (Character.isSpaceChar(text.charAt(i - 1)) && !finalString.substring(i, i + 3).matches("of |in |the|and")) {
                finalString.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
        return finalString.toString();
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