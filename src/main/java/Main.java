import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        //#####, # # #, ### #, #  ##, #####
        System.out.println(Arrays.toString(sc.solution(n, arr1, arr2)));
    }

    private static class Solution {

        public Solution() {

        }

        public String[] solution(int n, int[] arr1, int[] arr2) {
            int targetBit = 1;
            String[] answer = new String[n];
            String resultString = null;
            for (int i = 0; i < n; i++) {
                resultString = "";
                targetBit = 1;
                int arr = arr1[i] | arr2[i];
                for (int j = 0; j < n; j++) {
                    resultString = ((arr & targetBit) > 0 ? "#" : " ") + resultString;
                    targetBit = targetBit << 1;
                }
                answer[i] = resultString;
            }

            return answer;
        }

    }

}
