import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] testCase = new String[] {"123", "122345", "111111"};
        System.out.println(solution(testCase));
    }

    public static boolean solution(String[] phone_book) {
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book.length; j++){
                if(i != j){
                    if(phone_book[j].startsWith(phone_book[i])){

                        return false;
                    }
                }

            }
        }

        return true;
    }

}
