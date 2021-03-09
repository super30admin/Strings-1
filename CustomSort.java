//TC: O(n)
//Space:O(n)
//We stored frequency of chars from T in hashmap and then we iterated S string and if we find the char from s is presnet in hashmap
//we just appended those number of chars to our output string
class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch:T.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch,map.get(ch)+1);
            }else{
                map.put(ch,1);
            }
        }
        
        for(char ch:S.toCharArray()){
                       
                int count = map.getOrDefault(ch,0);
                while(count!=0){
                    sb.append(ch);
                    count--;
                }
                map.remove(ch);
            
            
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            int count = entry.getValue();
            while(count!=0){
                sb.append(entry.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}
