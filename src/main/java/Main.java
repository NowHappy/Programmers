import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] testCase = new String[] {"123", "122345", "111111"};
        System.out.println(solution(testCase));
    }

    public static boolean solution(String[] phone_book) {
        Map<String, Integer> phoneBook = new HashMap<>();
        int minimuxLength = 20;
        //가능한 조합을 모두 저장한다 단, 자기 자신은 저장하지 않는다. 진부분 집합만 저장
        for (String num : phone_book) {
            if (num.length() < minimuxLength) {
                minimuxLength = num.length();
            }
            for (int i = num.length() - 1; i >= minimuxLength; i--) {
                phoneBook.put(num.substring(0, i), 1);
            }
        }

        // "전체 번호로"  검색해서 존재하면 false 아니면 true
        for (String num : phone_book) {
            if (phoneBook.getOrDefault(num, 0) == 1) {
                return false;
            }
        }

        System.out.println(phoneBook);

        return true;
    }

}
