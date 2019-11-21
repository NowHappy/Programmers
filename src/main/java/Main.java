import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    //Line Coding Test Problem 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputInfo = br.readLine().split(" ");
        int orderSize = Integer.valueOf(inputInfo[0]);
        int quereSize = Integer.valueOf(inputInfo[1]);
        Deque<String> deque = new LinkedBlockingDeque(quereSize);
        String[] inputString;
        for (int i = 0; i < orderSize; i++) {
            inputString = br.readLine().split(" ");
            if (inputString[0].equals("OFFER")) {
                System.out.println(deque.offer(inputString[1]));
            }
            if (inputString[0].equals("TAKE")) {
                System.out.println(deque.pop());
            }
            if (inputString[0].equals("SIZE")) {
                System.out.println(deque.size());
            }
        }
    }

}
