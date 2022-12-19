import java.security.MessageDigest;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {

        System.out.println("task 1");
        System.out.println(encrypt("Hello"));
        System.out.println(encrypt("Sunshine"));
        System.out.println(decrypt(72, 33, -73, 84, -12, -3, 13, -13, -68));
        System.out.println();

        System.out.println("task 2");
        System.out.println(canMove("ладья", "A8", "H8"));
        System.out.println(canMove("слон", "A7", "G1"));
        System.out.println(canMove("ферзь", "C4", "D6"));
        System.out.println();

        System.out.println("task 3");
        System.out.println(canComplete("butl", "beautifulqq"));
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
        System.out.println(numToEng(126));
        System.out.println(numToEng(909));
        System.out.println(numToRus(0));
        System.out.println(numToRus(18));
        System.out.println(numToRus(126));
        System.out.println(numToRus(909));
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


    //1  Криптография через разницу кода символов
    public static String encrypt(String line) {
        // берём первый символ и добавляем в массив, размер которого равен длине строки
        int[] crypt = new int[line.length()];
        crypt[0] = line.charAt(0);
        // добавляем разность индексов с предыдущим символом в массив
        for (int i = 1; i < line.length(); i++) {
            crypt[i] = line.charAt(i) - line.charAt(i - 1);
        }
        return Arrays.toString(crypt);
    }

    public static StringBuilder decrypt(int... crypt) {
        // создаём изменяемую строку, добавляем туда первый символ
        StringBuilder line = new StringBuilder(crypt.length);
        int sum = crypt[0];
        line.append((char) sum);
        // для того, чтобы находить последующие, суммируем значения разности индексов символов, добавляя по индексу символы в строку
        for (int i = 1; i < crypt.length; i++) {
            sum += crypt[i];
            line.append((char) sum);
        }
        return line;
    }


    //2 шахматы
    public static boolean canMove(String name, String a, String b) {
        // разбиваем вторую и третью строку на координаты
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        // описываем все возможные ходы для каждой фигуры, по правилам шахмат. Не указан цвет фигуры, так что симметрия пешки
        return switch (name) {
            case ("пешка") -> (Math.abs((int) x[0] - (int) y[0]) == 1) && (Math.abs((int) x[1] - (int) y[1]) == 1);
            case ("конь") ->
                    (Math.abs((int) x[0] - (int) y[0]) == 1) && (Math.abs((int) x[1] - (int) y[1]) == 2) || (Math.abs((int) x[0] - (int) y[0]) == 2) && (Math.abs((int) x[1] - (int) y[1]) == 1);
            case ("слон") -> (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1]));
            case ("ладья") -> (Math.abs((int) x[0] - (int) y[0]) == 0) || (Math.abs((int) x[1] - (int) y[1]) == 0);
            case ("ферзь") ->
                    (Math.abs((int) x[0] - (int) y[0]) == Math.abs((int) x[1] - (int) y[1])) || (Math.abs((int) x[0] - (int) y[0]) == 0) || (Math.abs((int) x[1] - (int) y[1]) == 0);
            case ("король") -> (Math.abs((int) x[0] - (int) y[0]) == 1) || (Math.abs((int) x[1] - (int) y[1]) == 1);
            default -> false;
        };
    }

    //3 завершённость строки
    public static boolean canComplete(String subline, String line) {
        // Идём по строке, сравнивая поочерёдно с каждм символом субстроки.
        // Если длинна субстроки равна счётку совпадений, true
        int count = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == subline.charAt(count)) {
                count++;
                if (subline.length() == count) return true;
            }
        }
        return false;
    }

    //4 сложение чисел массива, и перемножение цифр суммы, до 1 цифры
    public static int sumDigProd(int... massive) {
        // как в предыдущем таске, только прежде суммируем все эллементы массива
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

    //5 совпадение глассных
    public static List<String> sameVowelGroup(String... lines) {
        // Создаём результирующий список, массив уникальных эллементов
        List<String> result = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        // по умолчанию вводим первое слово, вносим все его гласные в set, глассные находим через регулярку
        result.add(lines[0]);
        String word1 = lines[0].replaceAll("[^aeiouy]", "");
        for (int i = 0; i < word1.length(); i++) set.add(word1.charAt(i));
        // идём по всем строка, начиная со второй, сравниваем глассные с теми, что есть в set
        for (int i = 1; i < lines.length; i++) {
            String word2 = lines[i].replaceAll("[^aeiouy]", "");
            boolean k = true;
            for (char c : word2.toCharArray())
                if (!set.contains(c)) {
                    k = false;
                    break;
                }
            if (k) result.add(lines[i]);
        }
        return result;
    }

    //6 банковские карты
    public static boolean validateCard(long number) {
        // работаем с числами, возможно быстрее, чем со строками
        if (Math.pow(10, 14) > number && Math.pow(10, 20) <= number) return false;
        // выводим контрольную цифру из числа
        int control = (int) number % 10;
        number /= 10;
        int sum = 0;
        int k;
        //идём по числу соблюдая условия.
        for (int i = 1; Math.pow(10, i) <= number; i++) {
            k = (int) (number % Math.pow(10, i) / Math.pow(10, i - 1) * (i % 2 + 1));
            sum += k % 10 + k / 10;
        }
        return 10 - sum % 10 == control;
    }

    //7 число в литерацию
    public static StringBuilder numToEng(int n) {
        StringBuilder result = new StringBuilder();
        String[] SUBTWENTY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] DECADES = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        if (n / 100 > 0) result.append(String.format("%s hundred ", SUBTWENTY[n / 100]));
        if (n % 100 >= 20) result.append(String.format("%s ", DECADES[n % 100 / 10]));
        if (n % 10 > 0 || n == 0) result.append(SUBTWENTY[n % 20]);
        return result;
    }

    public static StringBuilder numToRus(int n) {
        StringBuilder result = new StringBuilder();
        String[] SUBTWENTY = {"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять",
                "десять", "одинадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
                "семнадцать", "восемнадцать", "девятнадцать"};
        String[] DECADES = {"двадцать", "тридцать", "сорок", "пятьдесят",
                "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        String[] HUNDREDS = {"сто", "двесте", "триста", "четыреста",
                "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        if (n / 100 > 0) result.append(String.format("%s ", HUNDREDS[n / 100 - 1]));
        if (n % 100 >= 20) result.append(String.format("%s ", DECADES[n % 100 / 10 - 2]));
        if (n % 10 > 0 || n == 0) result.append(SUBTWENTY[n % 20]);
        return result;
    }

    //8 SHA-256
    public static String getSha256Hash(String Line) {
        try {
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

    //9 Титул
    public static String correctTitle(String text) {
        StringBuilder right = new StringBuilder(text.toLowerCase());
        //выставляем первый символ заглавным, если это буква
        right.setCharAt(0, Character.toUpperCase(text.charAt(0)));
        //крутимся в цикле, и меняем буквы, перед которыми пробел на заглавные + требует проверки, что слово не является служебной частью речи
        for (int i = 1; i < text.length(); i++)
            if (Character.isSpaceChar(text.charAt(i - 1)) && !right.substring(i, i + 3).matches
                    ("of |in |the|and")) right.setCharAt(i, Character.toUpperCase(text.charAt(i)));
        return right.toString();
    }

    //10 Гексогон
    public static void hexLattice(int n) {
        // вычисляем модификатор, присваиваем его n
        for (int i = 1; n >= 1; i++) {
            if (n == 1) {
                n = i;
                break;
            }
            n -= i * 6;
        }
        if (n < 0) System.out.println("Invalid");
        // проход с модификатором, как можно обойтись без space?
        // который бы контролировал отступ с динамичным n
        int space = 1 + (n - 1) * 2;
        for (int i = space; i > 0; i--) {
            System.out.println(" ".repeat(Math.abs(space + 1 - n)) + "o ".repeat(n));
            if (n <= i) n++;
            else n--;
        }
    }
}