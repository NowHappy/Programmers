import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
        int[] priorities = new int[] {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(sc.solution(priorities, location));
    }

    private static class Solution {

        public Solution() {

        }

        public int solution(int[] priorities, int location) {
            int answer = 0;
            List<Document> docs = new ArrayList<>();
            Deque<Document> documentDeque = new ArrayDeque<>();

            for (int i = 0; i < priorities.length; i++) {
                Document doc = new Document(priorities[i], i);
                docs.add(doc);
                documentDeque.addLast(doc);
            }

            int count = 1;
            while (!documentDeque.isEmpty()) {
                Document doc = documentDeque.pop();
                boolean isBiggerExist = false;
                for (Document document : docs) {
                    if (doc.getPriority() < document.getPriority()) {
                        isBiggerExist = true;
                        break;
                    }
                }
                if (!isBiggerExist) {
                    docs.remove(doc);
                    if (doc.getLocation() == location) {
                        answer = count;
                    }
                    count++;
                } else {
                    documentDeque.addLast(doc);
                }
            }
            return answer;
        }

    }

    static class Document {
        private int priority;
        private int location;

        public Document(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }
    }

}
