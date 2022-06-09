import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> resSet = new HashSet<>();
        HashSet<Integer> lostSet = new HashSet<>();
        
        for (int i : reserve) {
            resSet.add(i);
        }
        for (int i : lost) {
            // 여벌 가져왔지만 도난당했을 경우
            if (resSet.contains(i)) resSet.remove(i);
            else lostSet.add(i);
        }
        
        // 여분을 기준으로 앞뒤 확인하여 체육복 빌려주기
        for (int i : resSet) {
            if (lostSet.contains(i - 1)) lostSet.remove(i - 1);
            else if (lostSet.contains(i + 1)) lostSet.remove(i + 1);
        }
        
        // 전체 학생 수에서 lostSet 학생수(체육복 못입는 수) 빼기
        
        return n - lostSet.size();
        
    }
}
