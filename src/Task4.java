import java.util.ArrayList;
import java.util.Spliterator;

public class Task4 {

    public static void main(String[] args) {


//        System.out.println(split("((()))").toString());
//        System.out.println(split("((()))(())()()(()())").toString());
//        System.out.println(split("((())())(()(()()))").toString());
        //    split("()()()") ➞ ["()", "()", "()"]
//    split("((()))") ➞ ["((()))"]
//    split("((()))(())()()(()())") ➞ ["((()))", "(())", "()", "()",
//            "(()())"]
//    split("((())())(()(()()))") ➞ ["((())())", "(()(()()))"]

//        test 3
//        System.out.println(toCamelCase("hello_edabit"));
//        System.out.println(toCamelCase("is_modal_open"));
//        System.out.println(toSnakeCase("helloEdabit"));
//        System.out.println(toSnakeCase("toSnakeCase"));


//        test 4
//        System.out.println(overTime(9, 17, 30, 1.5F));
//        System.out.println(overTime(16, 18, 30, 1.8F));
//        System.out.println(overTime(13.25F, 15, 30, 1.5F));
//        System.out.println(overTime(18, 20, 30, 2));


//        test 5
//        System.out.println(BMI("205 pounds", "73 inches"));
//        System.out.println(BMI("55 kilos", "1.65 meters"));
//        System.out.println(BMI("154 pounds", "2 meters"));


//        test 6
//        System.out.println(bugger(39));
//        System.out.println(bugger(999));
//        System.out.println(bugger(4));


//        test 7
        System.out.println(toStarShorthand("abbvvccc"));
        System.out.println(toStarShorthand("77777geff"));
        System.out.println(toStarShorthand("abc"));
        System.out.println(toStarShorthand(""));
        System.out.println(toStarShorthand("sadsaabbcc"));




    }

//    lst = input().split()
//    n, k = map(int, lst.pop(0).split(','))
//    i = 0
//    s = ''
//    spaces = 0
//    while i<n:
//      while i<n and len(s)+len(lst[i])-spaces <= k:
//          s += lst[i] + ' '
//          spaces += 1
//          i += 1
//      s.rstrip()
//      print(s)
//      s = ''
//      spaces = 0

    public static void letterEditor(int n, int k, String line) {
        String[] arrayWords = line.split(" ");
        String prevEl = arrayWords[0];
        for (int i = 1; i < n; i++) {

            while (prevEl.length() + arrayWords[i].length() <= k) {

            }


        }
    }

//    Напишите функцию, которая группирует строку в кластер скобок. Каждый кластер
//    должен быть сбалансирован.
//            Пример:
//    split("()()()") ➞ ["()", "()", "()"]
//    split("((()))") ➞ ["((()))"]
//    split("((()))(())()()(()())") ➞ ["((()))", "(())", "()", "()",
//            "(()())"]
//    split("((())())(()(()()))") ➞ ["((())())", "(()(()()))"]

    public static String[] split(String line) {
        return line.split(" ");
    }


    //    3. Создайте две функции toCamelCase () и toSnakeCase (), каждая из которых берет
//    одну строку и преобразует ее либо в camelCase, либо в snake_case.
    public static String toCamelCase(String line) {
        String[] concatLine = line.split("_");
        StringBuilder finaLine = new StringBuilder(concatLine[0]);

        for (int i = 1; i < concatLine.length; i++) {
            String currentWord = concatLine[i].toLowerCase();

            StringBuilder addWord = new StringBuilder();
            addWord.append(currentWord.substring(0, 1).toUpperCase());
            addWord.append(currentWord.substring(1));

            finaLine.append(addWord);
        }
        return String.valueOf(finaLine);
    }


    public static String toSnakeCase(String line) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < line.length(); i++) {

            char ch = line.charAt(i);

            if (Character.isUpperCase(ch)) {
                result.append('_');
                result.append(Character.toLowerCase(ch));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }


//    4. Напишите функцию, которая вычисляет сверхурочную работу и оплату, связанную
//    с сверхурочной работой.
//    Работа с 9 до 5: обычные часы работы
//    После 5 вечера это сверхурочная работа
//    Ваша функция получает массив с 4 значениями:
//            – Начало рабочего дня, в десятичном формате, (24-часовая дневная нотация)
//            – Конец рабочего дня. (Тот же формат)
//            – Почасовая ставка
//– Множитель сверхурочных работ
//    Ваша функция должна возвращать:
//    $ + заработанные в тот день (округлены до ближайшей сотой)

    public static String overTime(float... massive) {
        float startDay = massive[0];
        float endDay = massive[1];
        float hourlyRate = massive[2];
        float overtimeCoefficient = massive[3];
        float salary = 0;
        StringBuilder finalLine = new StringBuilder();

        if (startDay - (int) startDay != 0) {
            salary += ((int) startDay - startDay) * hourlyRate;
//            startDay++;
        }

        for (float i = startDay; i < endDay; i++) {
            if (i >= 17) {
                salary += hourlyRate * overtimeCoefficient;
            } else {
                salary += hourlyRate;
            }
        }
        String finalResult = String.format("%.2f", salary);
        finalLine.append("$").append(finalResult);
        return finalLine.toString();
    }


    //    Индекс массы тела (ИМТ) определяется путем измерения вашего веса в
//    килограммах и деления на квадрат вашего роста в метрах. Категории ИМТ таковы:
//    Недостаточный вес: <18,5
//    Нормальный вес: 18.5-24.9
//    Избыточный вес: 25 и более
//    Создайте функцию, которая будет принимать вес и рост (в килограммах, фунтах,
//                                                          метрах или дюймах) и возвращать ИМТ и связанную с ним категорию. Округлите
//    ИМТ до ближайшей десятой.
    public static String BMI(String weight, String height) {
        String[] weightArray = weight.split(" ");
        String[] heightArray = height.split(" ");
        float weightNumber;
        float heightNumber;
        float BMI;
        if (weightArray[1].equals("pounds")) {
            weightNumber = Float.parseFloat(weightArray[0]) * 0.453592F;
        } else {
            weightNumber = Float.parseFloat(weightArray[0]);
        }

        if (heightArray[1].equals("inches")) {
            heightNumber = Float.parseFloat(heightArray[0]) * 0.0254F;
        } else {
            heightNumber = Float.parseFloat(heightArray[0]);
        }

        BMI = weightNumber / (heightNumber * heightNumber);
        String BMIString = String.format("%.1f", BMI);


        if (BMI < 18.5) {
            return BMIString + " Underweight";
        } else if (BMI >= 18.5 && BMI < 25) {
            return BMIString + " Normal weight";
        }
        return BMIString + " Overweight";
    }


//    6. Создайте функцию, которая принимает число и возвращает его мультипликативное
//    постоянство, которое представляет собой количество раз, которое вы должны
//    умножать цифры в num, пока не достигнете одной цифры.
//    Пример:
//    bugger(39) ➞ 3
//    // Because 3 * 9 = 27, 2 * 7 = 14, 1 * 4 = 4 and 4 has only one digit.
//    bugger(999) ➞ 4
//// Because 9 * 9 * 9 = 729, 7 * 2 * 9 = 126, 1 * 2 * 6 = 12, and
//            finally 1 * 2 = 2.
//    bugger(4) ➞ 0
//// Because 4 is already a one-digit number.

    public static int bugger(int number) {
        int newNumber = number;
        int count = 0;
        while (newNumber > 9) {

            int tempNumber = 1;
            while (newNumber > 0) {
                tempNumber *= newNumber % 10;
                newNumber /= 10;
            }
            newNumber = tempNumber;
            count++;
        }
        return count;
    }


//    Напишите функцию, которая преобразует строку в звездную стенографию. Если
//    символ повторяется n раз, преобразуйте его в символ*n.
//            Пример:
//    toStarShorthand("abbccc") ➞ "ab*2c*3"
//    toStarShorthand("77777geff") ➞ "7*5gef*2"
//    toStarShorthand("abc") ➞ "abc"
//    toStarShorthand("") ➞ ""

    public static String toStarShorthand(String line) {
        if (line.isEmpty()) {
            return "";
        }
        String changeLine = line;
        char prevEl = line.charAt(0);
        boolean flag = false;
        int count = 1;
        char var = prevEl;
        for (int i = 0; i < line.length() - 1; i++) {
            if (line.charAt(i) == line.charAt(i + 1)) {
                count++;
                var = line.charAt(i);
//            проверка, ибо заходило когда не надо
            } else if (count >= 2) {
                flag = true;
            }
            // проверка когда сходятся последние символы
            if (i == line.length() - 2 && count >= 2) {
                flag = true;
            }
            if (count >= 2 && flag) {
                String forRepeat = String.valueOf(var);
                String someCharacters = forRepeat.repeat(count);
                String magicLine = forRepeat + "*" + count;
                changeLine = changeLine.replaceFirst(someCharacters, magicLine);
                count = 1;
                flag = false;
            }
        }
        return changeLine;

    }

}
