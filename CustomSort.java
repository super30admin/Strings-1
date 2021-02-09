/*
  Time : O(M+N) | M,N are lengths of S and T. Since S is max 26 we can assume it as a constant and 
                Time complexity will be dominated by length of String T. 
  Space : O(N)  | length of String T - Hashmap | Also StringBuilder will be used to building a string of length of T.
  Leetcode : YES
*/

class CustomSort {
    public String customSortString(String S, String T) {
        
        StringBuilder sb = new StringBuilder();
        if(S == null || T == null) return sb.toString();
        HashMap<Character, Integer> freqMap = new HashMap<>();
        
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        
        for(int i = 0 ;i < S.length(); i++){
            char c = S.charAt(i);
            if(freqMap.containsKey(c)){
                int count = freqMap.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                freqMap.remove(c);
            }
            
        }
        
        for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }
}
