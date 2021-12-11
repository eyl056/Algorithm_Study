import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        int total = 0;
        for (int dd: d) {
            total += dd;
            if (total > budget) break;
            count += 1;
        }
        return count;
    }
}
