import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<String> rReport = new ArrayList<>();
        
        // 여러번 신고하는 중복 제거
        for (String reportTo : report) {
            if(!rReport.contains(reportTo))
                rReport.add(reportTo);
        }
        report = new String[rReport.size()];
        int size = 0;
        for (String temp : rReport) {
            report[size++] = temp;
        }
        
        // 신고된 횟수 취합하기
        int[] count = new int[id_list.length];
        
        for (int i = 0; i < report.length; i++) {
            String[] reportTo = report[i].split(" ");
            
            for (int j = 0; j < id_list.length; j++) {
                if (id_list[j].equals(reportTo[1])) count[j]++;
            }
        }
        
        // 정지된 유저: ban
        ArrayList<String> ban = new ArrayList<>();
        
        for (int i = 0; i < id_list.length; i++) {
            if (count[i] >= k) ban.add(id_list[i]);
        }
        System.out.print("신고된 유저: ");
        System.out.println(ban);
        
        // 다시 report 돌면서 확인
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < report.length; i++) {
            String[] reportTo = report[i].split(" ");
            
            if (ban.contains(reportTo[1])) {
                for (int j = 0; j < id_list.length; j++) {
                    if (id_list[j].equals(reportTo[0])) answer[j]++;
                }
            }
        }
        
        return answer;
    }
}
