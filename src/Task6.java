import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Task6 {
    public static void main(String[] args) {

        System.out.println("task 1");
        System.out.println(bell(1));
        System.out.println(bell(2));
        System.out.println(bell(3));
        System.out.println(bell(4));
        System.out.println(bell(5));
        System.out.println();

        System.out.println("task 2");
        System.out.println(translateWord("flag"));
        System.out.println(translateWord("Apple"));
        System.out.println(translateWord("button"));
        System.out.println(translateSentence("I like to eat honey waffles."));
        System.out.println(translateSentence("Does Peter think, that it is going to rain today?"));
        System.out.println();

        System.out.println("task 3");
        System.out.println(validColor("rgb(0,0,0)"));
        System.out.println(validColor("rgb(0,,0)"));
        System.out.println(validColor("rgb(255,256,255)"));
        System.out.println(validColor("rgba(0,0,0,0.123456789)"));
        System.out.println();

        System.out.println("task 4");
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2"));
        System.out.println(stripUrlParams("https://edabit.com?a=1&b=2&a=2", new String[]{"b"}));
        System.out.println(stripUrlParams("https://edabit.com", new String[]{"b"}));
        System.out.println();

        System.out.println("task 5");
        System.out.println(getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(getHashTags("Why You Will Probably Pay More for Your Christmas Tree This Year"));
        System.out.println(getHashTags("Hey Parents, Surprise, Fruit Juice Is Not Fruit"));
        System.out.println();

        System.out.println("task 6");
        System.out.println(ulam(4));
        System.out.println(ulam(9));
        System.out.println(ulam(206));
        System.out.println();

        System.out.println("task 7");
        System.out.println(longestNonrepeatingSubstring("abcabcbb"));
        System.out.println(longestNonrepeatingSubstring("aaaaaa"));
        System.out.println(longestNonrepeatingSubstring("abcde"));
        System.out.println(longestNonrepeatingSubstring("abcda"));

        System.out.println("task 8");
        System.out.println(convertToRoman(2));
        System.out.println(convertToRoman(12));
        System.out.println(convertToRoman(16));

        System.out.println("task 9");
        System.out.println(formula("6 * 4 = 24"));
        System.out.println(formula("18 / 17 = 2"));
        System.out.println(formula("16 * 10 = 160 = 14 + 120"));

        System.out.println("task 10");
        System.out.println(palindromeDescendant(11211230));
        System.out.println(palindromeDescendant(13001120));
        System.out.println(palindromeDescendant(23336014));
        System.out.println(palindromeDescendant(11));
    }

    private static boolean existA(String a, String[] massive) {
        for (String s : massive) {
            if (a.equals(s)) {
                return true;
            }
        }
        return false;
    }

//1. Число Белла - это количество способов, которыми массив из n элементов может
//    быть разбит на непустые подмножества. Создайте функцию, которая принимает
//    число n и возвращает соответствующее число Белла.

//    треугольник Пирса.
//    Начнем с единицы. Помещаем ее в верхнюю строку. (x0,1=1)
//    Каждая новая строка должна начинаться с крайнего правого элемента прошлой строки. (xi,1← xi−1,i)
//    Заполняем строчку i по формуле (xi,j←xi,j−1+xi−1,j−1) , начиная с j=2, пока j⩽i+1.
//    Крайнее левое число данной строки является числом Белла для этой строки. (Bi←xi,1)

    public static int bell(int n) {
        int[][] bell = new int[n + 1][n + 1]; //двухмерный массив
        bell[0][0] = 1;//начальное значение
        for (int i = 1; i <= n; i++) {
            bell[i][0] = bell[i - 1][i - 1]; // добавление числа в массив
            for (int j = 1; j <= i; j++) {
                bell[i][j] = bell[i - 1][j - 1] + bell[i][j - 1];
            }
        }
        return bell[n][0];
    }

    //2 Кабанья латынь
//    В «поросячей латыни» (свинский латинский) есть два очень простых правила:
//            – Если слово начинается с согласного, переместите первую букву (буквы) слова до
//    гласного до конца слова и добавьте «ay» в конец.
//    – Если слово начинается с гласной, добавьте "yay" в конце слова.
    public static String translateWord(String word) {
        StringBuilder stringBuilder = new StringBuilder(word);
        if (String.valueOf(stringBuilder.charAt(0)).toLowerCase().matches("[aeiou]")) {
            stringBuilder.append("y"); // проверяем на наличие гласной
        }
        while (!String.valueOf(stringBuilder.charAt(0)).toLowerCase().matches("[aeiou]")) { // ищем следующую гласную
            stringBuilder.append(Character.toLowerCase(stringBuilder.charAt(0))).deleteCharAt(0); // переносим первый символ в конец
            if (Character.isUpperCase(word.charAt(0))) {
                stringBuilder.setCharAt(0, Character.toUpperCase(stringBuilder.charAt(0)));
            }
        }
        stringBuilder.append("ay");
        return stringBuilder.toString(); // выводим строку
    }

    public static String translateSentence(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : text.split(" ")) {
            if (word.substring(word.length() - 1).matches("[ ,.!?]")) // проверяем вхождение знаков
            {
                stringBuilder.append(translateWord(word.substring(0, word.length() - 1))).
                        append(word.substring(word.length() - 1)).append(" "); // обновляем каждое слово прошлым методом
            } else {
                stringBuilder.append(translateWord(word)).append(" "); // обновляем слово
            }
        }
        return stringBuilder.toString(); // выводим строку
    }

    //    3. Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых
//    значений допустимым или нет. Создайте функцию, которая принимает строку
//            (например, " rgb(0, 0, 0)") и возвращает true, если ее формат правильный, в
//    противном случае возвращает false.
    public static boolean validColor(String s) {
        Integer r = null;
        Integer g = null;
        Integer b = null;
        Double a = null;
        // регулярка, которая принимает целочисленные числа и дроби
        Pattern pattern = Pattern.compile("\\d+\\.?\\d*");
        Matcher matcher = pattern.matcher(s);
        // по порядку находим значения r,g,b,a в строке
        while (matcher.find()) {
            try {
                if (r == null) {
                    r = parseInt(matcher.group());
                } else if (g == null) {
                    g = parseInt(matcher.group());
                } else if (b == null) {
                    b = parseInt(matcher.group());
                } else if (a == null) {
                    a = Double.parseDouble(matcher.group());
                }
            } catch (Exception e) {
                return false;
            }
        }
        // проверяем, что все значения соответствуют формату
        if (r == null || r > 255 || r < 0) {
            return false;
        }
        if (g == null || g > 255 || g < 0) {
            return false;
        }
        if (b == null || b > 255 || b < 0) {
            return false;
        }
        if (s.contains("rgba")) {
            return a != null && a <= 1 && a >= 0;
        } else return a == null && s.contains("rgb");
    }

    //    4. Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся
//    параметры запроса и параметры, указанные во втором аргументе (который будет
//необязательным массивом).
//stripUrlParams("https://edabit.com?a=1&b=2&a=2") ➞
//            "https://edabit.com?a=2&b=2"
//    stripUrlParams("https://edabit.com?a=1&b=2&a=2", ["b"]) ➞
//            "https://edabit.com?a=2"
//    stripUrlParams("https://edabit.com", ["b"]) ➞ "https://edabit.com"
    public static String stripUrlParams(String http) {
        if (http.indexOf('?') == -1) {
            return http;
        }
        String[] pars = http.split("[&,?=]");
        HashMap<String, String> uniq = new HashMap<>();
        for (int i = 1; i < pars.length; i += 2) {
            uniq.put(pars[i], pars[i + 1]);
        }
        return pars[0] + '?' + (uniq.toString().replaceAll(", ", "&").replaceAll("[{}]", ""));
    }

    public static String stripUrlParams(String http, String[] expt) {
        if (http.indexOf('?') == -1)
            return http;
        String[] pars = http.split("[&,?=]");
        HashMap<String, String> uniq = new HashMap<>();
        for (int i = 1; i < pars.length; i += 2)
            if (!existA(pars[i], expt))
                uniq.put(pars[i], pars[i + 1]);
        return pars[0] + '?' + (uniq.toString().replaceAll(", ", "&").replaceAll("[{}]", ""));
    }

    //    5. Напишите функцию, которая извлекает три самых длинных слова из заголовка
//    газеты и преобразует их в хэштеги. Если несколько слов одинаковой длины,
//    найдите слово, которое встречается первым.
    public static String getHashTags(String sentence) {
        if (sentence.equals("")) {
            return "Empty input";
        }
        String[] wordSet = sentence.split("\\W");
        Arrays.sort(wordSet, (String o1, String o2) -> Integer.compare(o2.length(), o1.length()));
        List<String> result = new ArrayList<>(3);
        result.add("#" + wordSet[0].toLowerCase());
        for (int i = 1; i < 3; i++) {
            result.add("#" + wordSet[i].toLowerCase());
        }
        return result.toString();
    }


    //6 Улам
//    Создайте функцию, которая принимает число n и возвращает n-е число в
//    последовательности Улама.
    public static int ulam(int number) {
        ArrayList<Integer> arrayList = new ArrayList<>(); // задаём список
        // начальные значения
        arrayList.add(1);
        arrayList.add(2);
        // loop цикл для создания последовательности
        for (int i = 3; arrayList.size() < number; i++) {
            int count = 0;
            for (int m = 0; m < arrayList.size() - 1; m++) {
                for (int s = m + 1; s < arrayList.size(); s++) {
                    if (arrayList.get(m) + arrayList.get(s) == i) {
                        count++;
                    }
                }
                if (count > 1) {
                    break;
                }
            }
            if (count == 1) {
                arrayList.add(i);
            }
        }
        return arrayList.get(number - 1);
    }

    //    Напишите функцию, которая возвращает самую длинную неповторяющуюся
//    подстроку для строкового ввода.
    public static String longestNonrepeatingSubstring(String word) {
        StringBuilder firstW = new StringBuilder();
        String lastW = "";
        for (int i = 0; i < word.length(); i++) {
            if (!firstW.toString().contains(String.valueOf(word.charAt(i)))) {
                firstW.append(word.charAt(i));
                if (firstW.length() > lastW.length()) {
                    lastW = firstW.toString();
                }
            } else {
                word = word.substring(1); // убирает символ с первой позиции
                firstW = new StringBuilder();
                i = -1;
            }
        }
        return lastW;
    }

    public static String convertToRoman(int number) {

        // пытаемся вычесть из number числа из Roum начиная с самых больших.
        // Если вычесть удалось, значит можно добавить соответствующую последовательность

        Roum[] roums = Roum.values();
        StringBuilder builder = new StringBuilder();
        for (Roum roum : roums) {
            if (number - roum.arab >= 0) {
                builder.append(roum.name());
                number -= roum.arab;
            }
        }
        return builder.toString();
    }

    public enum Roum {
        MMM(3000),
        MM(2000),
        M(1000),
        CM(900),
        DCCC(800),
        DCC(700),
        DC(600),
        D(500),
        CD(400),
        CCC(300),
        CC(200),
        C(100),
        XC(90),
        LXXX(80),
        LXX(70),
        LX(60),
        L(50),
        XL(40),
        XXX(30),
        XX(20),
        X(10),
        IX(9),
        VIII(8),
        VII(7),
        VI(6),
        V(5),
        IV(4),
        III(3),
        II(2),
        I(1);

        final int arab;

        Roum(int arab) {
            this.arab = arab;
        }
    }

    public static boolean formula(String formula) {
        formula += " = " + formula;
        String[] arr = formula.split(" ");
        int n = 0, res = 0, i = 0;
        while (i < 7) {
            if (arr[i + 1].equals("+")) {
                res = parseInt(arr[i]) + parseInt(arr[i + 2]);
            } else if (arr[i + 1].equals("-")) {
                res = parseInt(arr[i]) - parseInt(arr[i + 2]);
            } else if (arr[i + 1].equals("*")) {
                res = parseInt(arr[i]) * parseInt(arr[i + 2]);
            } else if (arr[i + 1].equals("/") & !arr[i + 2].equals("0")) {
                res = parseInt(arr[i]) / parseInt(arr[i + 2]);
            }
            n = res;
            i += 6;
        }
        return parseInt(arr[4]) == n & parseInt(arr[4]) == res;
    }

    //    10. Число может не быть палиндромом, но его потомком может быть. Прямой потомок
//    числа создается путем суммирования каждой пары соседних цифр, чтобы создать
//    цифры следующего числа.
//            Например, 123312 – это не палиндром, а его следующий потомок 363, где: 3 = 1 + 2; 6 = 3
//            + 3; 3 = 1 + 2.
//    Создайте функцию, которая возвращает значение true, если само число является
//    палиндромом или любой из его потомков вплоть до 2 цифр (однозначное число -
//            тривиально палиндром).
    public static boolean palindromeDescendant(int number) {
        if (number < 10) {
            return true;
        }

        while (number > 10) {
            // проверяем является ли текущая строка палиндромом
            String numberStr = "" + number;
            String reversedStr = new StringBuilder(numberStr).reverse().toString();
            if (numberStr.equals(reversedStr)) {
                return true;
            }
            // если это не палиндром, и число нечетное, то потомков создать нельзя
            if (numberStr.length() % 2 != 0) {
                return false;
            }
            // создаем потомка
            StringBuilder newStrBuilder = new StringBuilder();
            for (int i = 0; i <= numberStr.length() - 2; i += 2) {
                newStrBuilder.append(Integer.parseInt(numberStr.substring(i, i + 1)) + Integer.parseInt(numberStr.substring(i + 1, i + 2)));
            }
            number = Integer.parseInt(newStrBuilder.toString());
        }
        return false;
    }
}