import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class Task3 {
    public static void main(String[] args) {

//        test1
//        System.out.println(solutions(1, 0, -1)); // -> 2
//        System.out.println(solutions(1, 0, 0));  // -> 1
//        System.out.println(solutions(1, 0, 1));  // -> 0


//        test2
//        System.out.println(findZip("all zip files are zipped")); // -> 18
//        System.out.println(findZip("all zip files are zipped and again zipped")); // -> 18
//        System.out.println(findZip("all zip files are bum")); // -> -1


//        test3
//        System.out.println(checkPerfect(6)); // -> true
//        System.out.println(checkPerfect(28)); // -> true
//        System.out.println(checkPerfect(496)); // -> true
//        System.out.println(checkPerfect(12)); // -> false
//        System.out.println(checkPerfect(97)); // -> false
//        System.out.println(checkPerfect(8128)); // -> true


//        test4
//        System.out.println(flipEndChars("Cat, dog, and mouse.")); // ->  .at, dog, and mouseC
//        System.out.println(flipEndChars("ada")); // -> Two's a pair.
//        System.out.println(flipEndChars("Ada")); // -> adA
//        System.out.println(flipEndChars("z")); // -> Incompatible.


//        test5
//        System.out.println(isValidHexCode("#CD5C5C")); // -> true
//        System.out.println(isValidHexCode("#EAECEE")); // -> true
//        System.out.println(isValidHexCode("#eaecee")); // -> true
//        System.out.println(isValidHexCode("#CD5C58C")); // -> false
//        System.out.println(isValidHexCode("#CD5C5Z")); // -> false
//        System.out.println(isValidHexCode("#CD5C&C")); // -> false
//        System.out.println(isValidHexCode("CD5C5C")); // -> false


//        test6
//        System.out.println(same(new int[]{1, 2, 3, 2, 4, 6, 4}, new int[]{1, 2, 3, 90, 20})); // -> true
//        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7})); // -> true
//        System.out.println(same(new int[]{1, 3, 4, 4, 4}, new int[]{2, 5, 7})); // -> true
//        System.out.println(same(new int[]{9, 8, 7, 6}, new int[]{4, 4, 3, 1})); // -> false
//        System.out.println(same(new int[]{2}, new int[]{3, 3, 3, 3, 3})); // -> true


//        test 7
//        System.out.println(isKaprekar(3)); // ->  false
//        System.out.println(isKaprekar(5)); // ->  false
//        System.out.println(isKaprekar(297)); // ->  true
//        System.out.println(isKaprekar(100)); // ->  false
//        System.out.println(isKaprekar(77778)); // ->  true
//        System.out.println(isKaprekar(77779)); // ->  false
//        System.out.println(isKaprekar(45)); // ->  true


//        test 8
//        System.out.println(longestZero("01100001011000")); // -> 0000
//        System.out.println(longestZero("100100100")); // -> 00
//        System.out.println(longestZero("11111")); // -> ""


//        test 9
//        System.out.println(nextPrime(12)); // -> 13
//        System.out.println(nextPrime(24)); // -> 29
//        System.out.println(nextPrime(11)); // -> 11


//        test 10
//        System.out.println(rightTriangle(3, 4, 5)); // ??? true
//        System.out.println(rightTriangle(145, 105, 100)); // ??? true
//        System.out.println(rightTriangle(70, 130, 110)); // ??? false
//        System.out.println(rightTriangle(1, 1, 100)); // ??? false
    }

    //    1. ???????????????????? ?????????????????? ax2 + bx + c = 0 ?????????? ???????? 0, ???????? 1, ???????? 2 ??????????????????
//    ?????????????? ?????? ???????????????????????????? ???????????????? x. ???????????????? a, b ?? c, ???? ???????????? ??????????????
//    ?????????? ?????????????? ?? ??????????????????.
    public static int solutions(double a, double b, double c) {

        double D = (b * b) - (4 * a * c);
        if (D > 0) {
            return 2;
        } else if (D == 0) {
            return 1;
        }
        return 0;
    }


    //            2. ???????????????? ??????????????, ?????????????? ???????????????????? ?????????????? ?????????????? ?????????????????? " zip " ??
//    ????????????, ?????? -1, ???????? ?????? ???? ???????????????????? ???? ?????????????? ???????? ????????????. ?????? ?????? ????????????
//    ???????? ???????????????????? ??????????, ?????????? ???????????????? ?????? ?????????????????? ????????????, ?????????? "zip" ??????????
//    ?????????????????? ?? ????????????.
//            ????????????:
//    findZip("all zip files are zipped") ??? 18
//    findZip("all zip files are compressed") ??? -1
//    ????????????????????:
//    ?????????????? ?????????????? " Zip "- ?????? ???? ???? ???? ??????????, ?????? ???????????? ?????????????? "zip".
    public static int findZip(String line) {
        String newLine = line.replaceFirst("zip", "***");
//        System.out.println(newLine);
        return newLine.indexOf("zip");
    }


    //            3. ???????????????? ??????????????, ?????????????? ??????????????????, ???????????????? ???? ?????????? ?????????? ??????????????????????
//    ???????????? ?????? ??????. ?????????????????????? ?????????? - ?????? ??????????, ?????????????? ?????????? ???????????????? ??????
//    ?????????? ?????? ????????????????????, ???????????????? ???????? ??????????.
//            ????????????????, 6-?????? ?????????????????? ??????????, ?????? ?????? 1 + 2 + 3 = 6, ?????? 1, 2 ?? 3-?????? ???????????????????????? 6.
//    ?????????? ?????? ???? 28-?????? ?????????????????????? ??????????, ?????? ?????? 1 + 2 + 4 + 7 + 14 = 28.
    public static boolean checkPerfect(int number) {
        int sum = 0;
        for (int i = 1; i <= number/2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }


//            4. ???????????????? ??????????????, ?????????????? ?????????????????? ???????????? ?? ???????????????????? ?????????? ???????????? ??
//    ?????????????? ???? ?????????????? ?? ???????????????????? ????????????????, ???? ?????????????????????? ???????? ??????????????:
//            ??? ???????? ?????????? ???????????? ???????????? ????????, ?????????????? "????????????????????????".".
//            ??? ???????? ???????????? ?? ?????????????????? ?????????????? ??????????????????, ?????????????? "??????-?????? ????????.".
//    ????????????:
//    flipEndChars("Cat, dog, and mouse.") ??? ".at, dog, and mouseC"
//    flipEndChars("ada") ??? "Two's a pair."
//    flipEndChars("Ada") ??? "adA"
//    flipEndChars("z") ??? "Incompatible."

    public static String flipEndChars(String line) {
        String newLine = line;
        if (newLine.length() < 2) {
            return "Incompatible.";
        }
        if (newLine.charAt(0) == newLine.charAt(newLine.length() - 1)) {
            return "Two's a pair.";
        }
        char firstSymbol = newLine.charAt(0);

        StringBuilder stringBuilder = new StringBuilder(newLine);

        stringBuilder.setCharAt(0, stringBuilder.charAt(stringBuilder.length() - 1));
        stringBuilder.setCharAt(stringBuilder.length() - 1, firstSymbol);


        return stringBuilder.toString();
    }


    //            5. ???????????????? ??????????????, ?????????????? ????????????????????, ???????????????? ???? ???????????? ????????????????????
//    ?????????????????????????????????? ??????????.
//    ?????????????????????????????????? ?????? ???????????? ???????????????????? ?? ?????????????????? ?????????? # ?? ?????????? ?????????? ?????????? 6
//    ????????????????. ???????????? ???????????? ???????????? ???????? ???????????? ???? 0-9 ?????? ?????????????????? ???????????????? ???? A-F.
//    ?????? ?????????????????? ?????????????? ?????????? ???????? ???????????????????? ?????? ??????????????????.
    public static boolean isValidHexCode(String code) {
        if (!code.startsWith("#")) {
            return false;
        }
        if (!(code.length() == 7)) {
            return false;
        }
        String line = code.substring(1);
        // uses regular expressions
        return line.matches("^[0-9a-fA-F]+$");
    }


    //            6. ???????????????? ??????????????, ?????????????? ???????????????????? true, ???????? ?????? ?????????????? ?????????? ????????????????????
//    ???????????????????? ???????????????????? ??????????????????, ?? false ?? ?????????????????? ????????????.
    public static boolean same(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(firstArray.length);
        for (int j : firstArray) {
            arrayList1.add(j);
        }
        Set<Integer> set1 = new LinkedHashSet<>(arrayList1);

        ArrayList<Integer> arrayList2 = new ArrayList<>(secondArray.length);
        for (int j : secondArray) {
            arrayList2.add(j);
        }
        Set<Integer> set2 = new LinkedHashSet<>(arrayList2);


        return set1.size() == set2.size();
    }


    //            7. ?????????? ??????????????????-?????? ?????????????????????????? ?????????? ??????????, ?????????????? ?????????? ???????????????????? ??
//    ?????????????? ?? ?????????????????? ???? ?????? ???????????????????????????????????? ?????????? ?????????? ?????????? ????????
//    ???????????????????? ?????????? ??????????:
//            ??? ???????? ???????????????????? ???????? ?????????????????????? ?????????? ????????????, ???? ?????????? ?? ???????????? ?????????? ?????????? ??????????
//    ???????????????????? ??????????.
//            ??? ???????? ???????????????????? ???????? ?????????????????????? ?????????? ??????????????, ???? ???????????? ?????????? ?????????? ?????????? ??????????????
//    ??????????????????, ?? ??????????-?????????? ?????????????????? ?????? ???????????? ????????, ???????? ???????????????????? ???????? ?????????? 1.???
//    ???????????????? ?????????????????????????? ?????????? ?????????? n, ???????????????????? ??????????????, ?????????????? ???????????????????? true,
//    ???????? ?????? ?????????? ??????????????????, ?? false, ???????? ?????? ???? ??????.
    public static boolean isKaprekar(long number) {
        if (number == 1 || number == 0) {
            return true;
        }
        if (number == 2 || number == 3) {
            return false;
        }
        long newNumber = number * number;
        int len = String.valueOf(newNumber).length();
        len = len % 2 == 0 ? len / 2 : (len / 2) + 1;

        StringBuilder del = new StringBuilder("1");
        for (int i = 0; i < len; i++) {
            del.append("0");
        }
        int delim = Integer.parseInt(String.valueOf(del));

        long lefPart = newNumber / delim;
        long rightPart = newNumber % delim;
        // ??.??. ???????????? ?????????? ???? ?????????????????? ????????
        if (rightPart == 0) {
            return false;
        }
        return lefPart + rightPart == number;
    }


    //8. ???????????????? ??????????????, ?????????????? ???????????????????? ?????????? ?????????????? ????????????????????????????????????d
//    ???????????????????????????????? ?????????? ?? ???????????????? ????????????.
    public static String longestZero(String number) {
        int length = 0;
        int maxLength = 0;
        char[] array = number.toCharArray();

        for (int i = 0; i < array.length; i++) {
            String current = String.valueOf(array[i]);
            if (current.equals("0")) {
                length++;
            }

            if (!current.equals("0")) {
                length = 0;
            }
            maxLength = Math.max(maxLength, length);
        }


        return "0".repeat(maxLength);
    }


    //            9. ???????? ???????????? ?????????? ??????????, ???????????????? ??????????????, ?????????????? ???????????????????? ??????????????????
//    ?????????????? ??????????. ???????? ?????????? ??????????????, ?????????????? ???????? ??????????.
    public static int nextPrime(int number) {
        if (isSimple(number)) {
            return number;
        }
        while (!isSimple(number)) {
            number++;
        }
        return number;
    }

    private static boolean isSimple(int number) {
        if (number < 2)
            return false;
        double s = Math.sqrt(number);
        for (int i = 2; i <= s; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }


    //            10. ???????????????? ?????? ??????????, x, y ?? z, ????????????????????, ???????????????? ???? ?????? ??????????????
//    ???????????????????????????? ????????????????????????.
    public static boolean rightTriangle(int x, int y, int z) {
        if (!(x + y > z) || !(x + z > y) || !(y + z > x)) {
            return false;
        }
        x *= x;
        y *= y;
        z *= z;
        return x + y == z || x + z == y || y + z == x;
    }
}
