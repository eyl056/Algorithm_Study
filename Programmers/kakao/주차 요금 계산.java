import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        // <차 번호, 총 가격>
        TreeMap<String, Integer> time = new TreeMap<>();
        // <차 번호, <입출차 기록 리스트>>
        HashMap<String, ArrayList<Integer>> reco = new HashMap<>();
        // 차 번호
        List<String> car = new ArrayList<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] str = records[i].split(" ");
            String t = str[0];
            String number = str[1];
            String inout = str[2];
            if (!car.contains(number)) car.add(number);
            if (!reco.containsKey(number)) {
                reco.put(number, new ArrayList());
            } 
            reco.get(number).add(convertTime(t));
        }
        
        // 차량 번호가 작은 자동차부터
        Collections.sort(car);
        // 전체 시간(가격) 계산
        for (int i = 0; i < car.size(); i++) {
            ArrayList<Integer> time_record = reco.get(car.get(i));

            // 마지막에 출차 기록이 없을 때 23:59로 가정
            if (time_record.size() % 2 != 0) time_record.add(1439);

            int total = 0;
            for (int j = 0; j < time_record.size(); j+=2) {
                total += (time_record.get(j + 1) - time_record.get(j));
            }

            int totalPrice = 0;
            if (total <= fees[0]) totalPrice = fees[1];
            else totalPrice = fees[1] + (int)Math.ceil((double)(total - fees[0]) / fees[2]) * fees[3];
            time.put(car.get(i), totalPrice);
        }
        
        int[] answer = new int[time.size()];
        int idx = 0;
        Iterator<String> keys = time.keySet().iterator();
        while(keys.hasNext()) {
            String key = keys.next();
            answer[idx++] = time.get(key);
        }
        
        return answer;
        
    }
    
    // 전체 분으로 환산
    public int convertTime(String time) {
        String[] str = time.split(":");
        int totalTime = 60 * Integer.parseInt(str[0]) + Integer.parseInt(str[1]);
        return totalTime;
    }
}
