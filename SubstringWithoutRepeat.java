
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
public int lengthOfLongestSubstring(String s) {
    if(s == null || s.length() == 0) return 0;
    HashMap<Character,Integer> map = new HashMap<>();
    int slow=0,max=0;
    
    for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(map.containsKey(c)){
            slow = Math.max(slow,map.get(c)); // updating slow if map.get(c) is higher than right now, means repeatation
        }
        map.put(c,i+1);
        max = Math.max(i-slow+1,max);
    }
    return max;
}