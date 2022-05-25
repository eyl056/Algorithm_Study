import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<String> rReport = new ArrayList<>();
        
        int[] answer = new int[id_list.length];
        
        // <신고 당한 유저, 신고한 유저 집합>
        HashMap<String, HashSet<String>> reportTo = new HashMap<>();
        HashMap<String, Integer> id = new HashMap<>();
        
        for (int i = 0; i < id_list.length; i++) {
            reportTo.put(id_list[i], new HashSet<>());
            id.put(id_list[i], i);
        }
        
        for (String tmp : report) {
            String[] str = tmp.split(" ");
            reportTo.get(str[1]).add(str[0]);
        }
        
        for (int i = 0; i < id_list.length; i++) {
            HashSet<String> from = reportTo.get(id_list[i]);
            if (from.size() >= k) {
                for (String name : from) {
                    answer[id.get(name)]++;
                }
            }
        }
        
        return answer;
    }
}
