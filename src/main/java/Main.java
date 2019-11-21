import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    //Line Coding Test Problem 5

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int windowSize = Integer.valueOf(br.readLine().toString());
        Deque<Integer> deque = new LinkedBlockingDeque(windowSize);
        int num, max = 0, prev, count = 0;
        while (br.ready()) {
            num = Integer.valueOf(br.readLine().toString());
            if (deque.size() >= windowSize) {
                prev = deque.pop();
                if (prev >= max) {
                    max = deque.stream().mapToInt(n -> n)
                            .max().getAsInt();
                }
            }
            deque.add(num);
            if (num > max) {
                max = num;
            }
            count++;
            if(count >= windowSize){
                System.out.println(max);
            }
        }
    }

}
