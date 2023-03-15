
// map
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;
        for(int fast=0;fast<s.length();fast++){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, fast-slow+1);
            map.put(c, fast+1);
        }
        return max;
    }
}

// TC - O(n)
// SC - O(1)

// set
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        int slow = 0;
        int fast = 1;
        int max = 0;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(slow));
        while(fast<s.length()){
            char c = s.charAt(fast);
            if(set.contains(c)){
                while(s.charAt(slow)!=c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            max = Math.max(max,fast-slow+1);
            set.add(s.charAt(fast));
            fast++;
        }
        return max;
    }
}

// TC - O(n)
// SC - O(1)