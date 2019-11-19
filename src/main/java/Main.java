import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution sc = new Solution();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
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
            List<Song> songs = null;
            for (String genre : sortedMap.keySet()) {
                songs = new ArrayList<>();
                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(genre)) {
                        songs.add(new Song(i, plays[i]));
                    }
                }

                songs.sort(new Comparator<Song>() {
                    @Override
                    public int compare(Song arg0, Song arg1) {
                        int age0 = arg0.getPlays();
                        int age1 = arg1.getPlays();

                        // 앞에 있는게 클때 양수 -> 오름차순
                        // 앞에 있는게 클때 음수 -> 내림차순
                        if (age0 == age1) return 0;
                        else if (age0 > age1) return -1;
                        else return 1;
                    }
                });

                if(songs.size() < 2) {
                    if(songs.get(0).getPlays() == songs.get(1).getPlays()){
                        if(songs.get(0).getNumber() > songs.get(1).getNumber()){
                            result.add(songs.get(1).getNumber());
                        } else {
                            result.add(songs.get(0).getNumber());
                        }
                    } else {
                        result.add(songs.get(0).getNumber());
                    }
                } else {
                    if(songs.get(0).getPlays() == songs.get(1).getPlays()){
                        if(songs.get(0).getNumber() > songs.get(1).getNumber()){
                            result.add(songs.get(1).getNumber());
                            result.add(songs.get(0).getNumber());
                        } else {
                            result.add(songs.get(0).getNumber());
                            result.add(songs.get(1).getNumber());
                        }
                    } else {
                        result.add(songs.get(0).getNumber());
                        result.add(songs.get(1).getNumber());
                    }
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

        public static class Song {
            private int number;
            private int plays;

            public Song(int number, int plays) {
                this.number = number;
                this.plays = plays;
            }

            public int getNumber() {
                return number;
            }

            public int getPlays() {
                return plays;
            }
        }

    }

}
