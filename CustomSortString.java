// Time Complexity : O(m) + O(n) where m,n is the length of T,S
// Space Complexity : O(1) The max space of hashmap will be 26 characters and StringBuilder is used for the final output
// Accepted on LeetCode: Yes
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);     
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            char c = entry.getKey();
            while(count > 0){
                sb.append(c);
                count--;
            }            
        }
        return sb.toString();
    }
}