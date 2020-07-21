// Time Complexity : O(m+n).  m is the length of the first string. n is the length of the second string.
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public String customSortString(String S, String T) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> frequencyMap = new HashMap();
        
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            frequencyMap.put(ch,frequencyMap.getOrDefault(ch,0)+1);
        }
        
        //iterating through S string and appending map chars to string builder
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(frequencyMap.containsKey(ch)){
                
                int frequency = frequencyMap.get(ch);
                
                while(frequency>0){
                    sb.append(ch);
                    frequency--;
                }
                frequencyMap.remove(ch);
            }
        }
        
        //iterating through remaining hashmap
        for(Map.Entry<Character,Integer> map:frequencyMap.entrySet()){
            
            int frequency = map.getValue();
            char ch = map.getKey();
                while(frequency>0){
                    sb.append(ch);
                    frequency--;
                }
            
            
        }
        
        return sb.toString();
    }
}
