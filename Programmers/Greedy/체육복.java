import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int lostCount = lost.length;
    
        // 배열 정렬해주는 이유
        // lost: [4, 2] reserve: [3, 5]
        // 3->2에게, 5->4에게 빌려주면 되는데 정렬을 하지 않으면 3->4부터 빌려주게 됨
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        // 도난 당한 학생이 여벌의 체육복을 가져온 경우에 자기밖에 입을 수 없고 자기 자신은 입을 수 있음
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    lostCount -=1;
                }
            }
        }
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                // 앞 or 뒷 번호 학생이 여벌의 체육복이 있는 경우, lost 빌려줌
                if ((lost[i] + 1) == reserve[j] || (lost[i] - 1) == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    lostCount -= 1;
                    break;
                }
            }
        }
        
        return n - lostCount;
    }
}
