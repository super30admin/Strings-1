 // Time : O(n) =O(n+n) // by moving slow pointer to escape the duplicates and fast pointer through out the string
 // Space : O(1) // 26 characters
 // Approach : Using Sliding Window technique and HashSet
 class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       HashSet<Character> set = new HashSet<>();
       int slow = 0;
       int max = 0;

       for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(slow)!=ch){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else{
                set.add(ch);
                max = Math.max(max,i-slow+1);
            }
       }

       return max;


    }
}

 // Time : O(n) =O(n) // when i come across duplicate Move slow pointer directly to the position of duplicate
 // Space : O(1) // HashMap 26 characters
 // Approach : Using Sliding Window technique and HashSet
 class Solution {
    public int lengthOfLongestSubstring(String s) {
       int n = s.length();
       HashMap<Character,Integer> map = new HashMap<>();
       int slow = 0;
       int max = 0;

       for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                slow = Math.max(slow,map.get(ch)+1);
            }
            map.put(ch,i);
            max = Math.max(max,i-slow+1);
       }

       return max;


    }
}