import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        String[][] clothes = new String[][] {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> clotheMap = new HashMap<>();

        for (String[] clothe : clothes) {
            clotheMap.put(clothe[1], clotheMap.getOrDefault(clothe[1], 0) + 1);
        }

        for (int num : clotheMap.values()) {
            answer *= (num+1);
        }

        return answer-1;

    }



}
