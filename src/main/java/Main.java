import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution ex = new Solution();
        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        System.out.print(Arrays.toString(ex.solution(progresses, speeds)));
    }

    static class Solution {
        public Solution() {

        }

        public int[] solution(int[] progresses, int[] speeds) {
            boolean canDeploy = false;
            int curPoint = 0;
            int[] neededDays = new int[progresses.length];
            for (int progress : progresses) {
                while (progress < 100) {
                    progress += speeds[curPoint];
                    neededDays[curPoint]++;
                }
                curPoint++;
            }

            curPoint = 0;
            int deployDate = neededDays[curPoint];
            Map<Integer, Integer> num = new HashMap<>();
            int days = 0;
            for(int i = 0; i < progresses.length; i++){
                if(neededDays[i] > deployDate){
                    days++;
                    deployDate = neededDays[i];
                }
                num.put(days, num.getOrDefault(days,0) + 1);
            }

            List<Integer> answer = new ArrayList<>();
            for (int n : num.values()) {
                if (n != 0) {
                    answer.add(n);
                }
            }

            int[] result = new int[answer.size()];
            for (int i = 0; i < answer.size(); i++) {
                result[i] = answer.get(i);
            }

            return result;
        }
    }


}
