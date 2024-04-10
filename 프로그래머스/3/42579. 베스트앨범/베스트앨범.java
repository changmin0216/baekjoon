import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!total.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
                total.put(genres[i], plays[i]);
            } else {
                music.get(genres[i]).put(i, plays[i]);
                total.put(genres[i], plays[i] + total.get(genres[i]));
            }
        }

        List<String> keySet = new ArrayList<>(total.keySet());
        Collections.sort(keySet, (s1, s2) -> total.get(s2) - (total.get(s1)));

        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys, (s1, s2) -> map.get(s2) - (map.get(s1)));

            answer.add(keys.get(0));
            if (keys.size() > 1) {
                answer.add(keys.get(1));
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}