import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
//        int bridge_length = 2;
//        int weight = 10;
//        int[] truck_weights = {7,4,5,6};
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};
        System.out.println(sc.solution(bridge_length, weight, truck_weights));
    }

    private static class Solution {

        public Solution() {

        }

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Deque<Integer> waitingTrucks = new ArrayDeque<>();
            Deque<Integer> passingTrucks = new ArrayDeque<>();
            Deque<Integer> arrivedTrucks = new ArrayDeque<>();
            int truckNumber = truck_weights.length;
            List<Integer> locations = new ArrayList<>();

            for (int w : truck_weights) {
                waitingTrucks.add(w);
            }
            //waitingTrucks.forEach(w -> System.out.print(w + " "));

            int count = 1;
            passingTrucks.add(waitingTrucks.pop());
            locations.add(1);
            while (arrivedTrucks.size() < truckNumber) {
                count++;
                //passingTrucks 의 이동거리 전체 +1 씩 해줌
                for (int i = 0; i < locations.size(); i++) {
                    locations.set(i, locations.get(i) + 1);
                }
                if (locations.get(0) > bridge_length) {
                    locations.remove(0);
                    arrivedTrucks.add(passingTrucks.pop());
                }
                if (waitingTrucks.size() > 0 && getCurrentWeight(passingTrucks) + waitingTrucks.getFirst() <= weight) {
                    passingTrucks.add(waitingTrucks.pop());
                    // 거리 계산 배열에도 추가
                    locations.add(1);
                }

            }
            return count;
        }

        private int getCurrentWeight(Deque<Integer> passingTruck) {
            return passingTruck.stream().mapToInt(w -> w).sum();
        }

    }

}
