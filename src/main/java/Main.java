import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] testCase = new String[] {"123", "122345", "111111"};
        System.out.println(solution(testCase));
    }

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> phoneBook = new HashMap<>();

        for (String num : phone_book) {
            phoneBook.put(num, 1);
        }

        Arrays.sort(phone_book, Comparator.comparingInt(String::length).reversed());

        for (String num : phone_book) {
            for (int i = num.length() - 1; i > 0; i--) {
                if (phoneBook.getOrDefault(num.substring(0, i), 0) == 1) {
                    return false;
                }
            }
        }

        return true;
    }

}
