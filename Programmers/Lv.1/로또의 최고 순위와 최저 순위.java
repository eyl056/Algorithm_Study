class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        for (int lotto: lottos) {
            if (lotto == 0) zero++;
            for (int win_num: win_nums) {
                if (lotto == win_num) count++;
            }
        }
        int best = count + zero;
        if (best < 2) best = 1;
        if (count < 2) count = 1;
        int []answer = {7-best, 7-count};
        return answer;
    }
}
