import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
        int[] heights = new int[] {3, 9, 9, 3, 5, 7, 2};
        System.out.println(Arrays.toString(sc.solution(heights)));
    }

    private static class Solution {

        public Solution() {

        }

        public int[] solution(int[] heights) {
            int[] answer = new int[heights.length];
            List<Tower> towers = new ArrayList<>();
            for (int i = 0; i < heights.length; i++) {
                Tower tower = new Tower(i + 1, heights[i]);
                towers.add(tower);
            }
            //towers.forEach(tower -> System.out.print(tower.getOrder() + " "));

            for (int i = heights.length - 1; i >= 0; i--) {
                for (int j = i - 1; j >= 0; j--) {
                    if (towers.get(j).getHeight() > towers.get(i).getHeight()) {
                        answer[i] = towers.get(j).getOrder();
                        break;
                    }
                }
            }

            return answer;
        }

        public static class Tower {
            private int order;
            private int height;

            public Tower(int order, int height) {
                this.order = order;
                this.height = height;
            }

            public int getOrder() {
                return order;
            }

            public int getHeight() {
                return height;
            }

        }

    }

}
