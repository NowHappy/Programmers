import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //Line Coding Test Problem 3

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int target = Integer.valueOf(br.readLine().toString());
        List<Integer> numbers = Arrays.stream(input).map(num -> Integer.valueOf(num)).collect(Collectors.toList());

        numbers.sort(Integer::compareTo);

        List<Integer> compares = new ArrayList<>(numbers);

        for (int num : numbers) {
            compares.remove(compares.indexOf(num));
            int rest = target - num;
            if (compares.contains(rest) && num != rest) {
                System.out.println(num + " " + rest);
                return;
            }
        }

    }

}
