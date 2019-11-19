import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "classic"};
        int[] plays = {400, 600, 150, 2500, 500, 500};
        System.out.println(Arrays.toString(sc.solution(genres, plays)));
    }

    private static class Solution {

        public Solution() {

        }

        public int[] solution(String[] genres, int[] plays) {
            Map<String, Integer> genreMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            }

            LinkedHashMap<String, Integer> sortedMap = sortHashMapByValues((HashMap<String, Integer>) genreMap);

//            sortedMap.keySet().stream().forEach(System.out::println);
//            sortedMap.values().stream().forEach(System.out::println);

            List<Integer> result = new ArrayList<>();
            Map<Integer, Integer> songMap = null;
            for (String genre : sortedMap.keySet()) {
                songMap = new HashMap<>();
                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(genre)) {
                        songMap.put(i, plays[i]);
                    }
                }

                LinkedHashMap<Integer, Integer> resultMap = sortHashMapByIntegerValues((HashMap<Integer, Integer>) songMap);

                int count = 0;
                for(int i : resultMap.keySet()){
                    if(count > 1) break;
                    if(count == 0) {
                        result.add(i);
                    }
                    if(count == 1) {
                        result.add(i);
                    }
                    count++;
                }

                //specific.stream().(p -> result.add(songMap.get(p)));
            }

            int[] answer = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i).intValue();
            }
            //result.stream().mapToInt(p->p);

            return answer;
        }

        public LinkedHashMap<String, Integer> sortHashMapByValues(
                HashMap<String, Integer> passedMap) {
            List<String> mapKeys = new ArrayList<>(passedMap.keySet());
            List<Integer> mapValues = new ArrayList<>(passedMap.values());
            Collections.sort(mapValues, Collections.reverseOrder());
            Collections.sort(mapKeys);

            LinkedHashMap<String, Integer> sortedMap =
                    new LinkedHashMap<>();

            Iterator<Integer> valueIt = mapValues.iterator();
            while (valueIt.hasNext()) {
                Integer val = valueIt.next();
                Iterator<String> keyIt = mapKeys.iterator();

                while (keyIt.hasNext()) {
                    String key = keyIt.next();
                    Integer comp1 = passedMap.get(key);
                    Integer comp2 = val;

                    if (comp1.equals(comp2)) {
                        keyIt.remove();
                        sortedMap.put(key, val);
                        break;
                    }
                }
            }
            return sortedMap;
        }

        public LinkedHashMap<Integer, Integer> sortHashMapByIntegerValues(
                HashMap<Integer, Integer> passedMap) {
            List<Integer> mapKeys = new ArrayList<>(passedMap.keySet());
            List<Integer> mapValues = new ArrayList<>(passedMap.values());
            Collections.sort(mapValues, Collections.reverseOrder());
            Collections.sort(mapKeys);

            LinkedHashMap<Integer, Integer> sortedMap =
                    new LinkedHashMap<>();

            Iterator<Integer> valueIt = mapValues.iterator();
            while (valueIt.hasNext()) {
                Integer val = valueIt.next();
                Iterator<Integer> keyIt = mapKeys.iterator();

                while (keyIt.hasNext()) {
                    Integer key = keyIt.next();
                    Integer comp1 = passedMap.get(key);
                    Integer comp2 = val;

                    if (comp1.equals(comp2)) {
                        keyIt.remove();
                        sortedMap.put(key, val);
                        break;
                    }
                }
            }
            return sortedMap;
        }

    }

}
