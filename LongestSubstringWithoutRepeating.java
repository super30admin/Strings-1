// USING : SLIDING WINDOW
// TC : O(2n)
// SC : O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i =0 ; i<s.length(); i++){
            char in = s.charAt(i);
            if(set.contains(in)){
                while(s.charAt(slow) != in){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }else{
                set.add(in);
            }
            max = Math.max(max, set.size());
        }
        return max;
        
    }
}


// USING : HASHMAP
// TC : O(n)
// SC : O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashMap<Character, Integer > map = new HashMap<>();
        for(int i =0 ; i<s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(map.get(ch)+1, slow);
            }
            map.put(ch, i);
            max = Math.max(max, i-slow+1);      
        }
        return max;   
    }
}