// Time complexity - 0(m+n) S and T lengths
// space complexity - 0(n)
// code successfully executed on leetcode

class Solution {
    public String customSortString(String S, String T) {
        
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map =  new HashMap<>();
        for(Character c: T.toCharArray()){
                map.put(c,map.getOrDefault(c,0)+1);
                }
         for(Character c: S.toCharArray()){
             if(map.containsKey(c)){
                 int count = map.get(c);
                 while(count > 0){
                     sb.append(c);
                     count--;
                 }
                 map.remove(c);
             }
         }
        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int count = entry.getValue();
            Character c = entry.getKey();
            while(count>0){
                sb.append(c);
                count--;
            }
        }
        return sb.toString();
        
    }
}