/*
time complexity: O(m+n)
space complexity:O(1) + O(m) ,(hm & stringbuilder)

*/
class Solution {
    public String customSortString(String s, String t) {
        
        //add all characters of T to hashmap
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        //add all character of "T" string in hashmap
        for(int i= 0; i < t.length();i++){
            char ch = t.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch,1);
            }else{
                map.put(ch, map.get(ch)+1);
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        //iterate the pattern string and add the char if present in map
        for(int i = 0; i < s.length();i++){
            char currCh = s.charAt(i);
            if(map.containsKey(currCh)){
                int count = map.get(currCh);
                while(count > 0){
                    sb.append(currCh);
                    count--;
                }
                map.put(currCh,count);
            }
            map.remove(currCh,0);
        }
        
        for(Character ch : map.keySet()){
            int count = map.get(ch);
                while(count > 0){
                    sb.append(ch);count--;
                }
        }
        return sb.toString();
    }
}