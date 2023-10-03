package TopKElements;

import java.util.PriorityQueue;

// Reorganize String
public class Problem_01 {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(int i = 0; i < 26; i++){
            if(count[i] > 0){
                pq.add(new int[]{
                    i + 'a', count[i]
                });
            }
        }
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            char fir = (char) first[0];
            int freqCount = first[1];
            if(res.length() == 0 || fir != res.charAt(res.length()-1)){
                res.append(fir);
                freqCount--;
                if(freqCount > 0){
                    pq.add(new int[]{first[0],freqCount});
                }
            }
            else{
                if(pq.isEmpty())
                    return "";
                int[] second = pq.poll();
                char sec = (char) second[0];
                int secFreqCount = second[1];
                res.append(sec);
                secFreqCount--;
                if(secFreqCount > 0){
                    pq.add(new int[]{second[0],secFreqCount});
                }
                pq.add(new int[]{first[0],first[1]});
            }

        }
        return res.toString();
        
    }
}
