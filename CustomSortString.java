// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//TC: O(S.length + T.length)
//SC: O(T.length)
class Solution {
    public String customSortString(String S, String T) {
     StringBuilder sb = new StringBuilder();
     HashMap<Character, Integer> hashmap = new HashMap<>();
        for(char ch: T.toCharArray())
            hashmap.put(ch, hashmap.getOrDefault(ch,0)+1);
        
        for(char ch = S.toCharArray()){
            if(hashmap.containsKey(ch)){
                int count = hashmap.get(ch);
                while(count != 0){
                    sb.append(ch);
                    count--;}
                hashmap.remove(ch);
            }
        }
        for (Character ch: hashmap.keySet()){
            int count = hashmap.get(ch);
            while(count != 0){
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }
}