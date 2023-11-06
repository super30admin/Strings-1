class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int MaxCount = Integer.MIN_VALUE;
        int left =0;

        for(int right =0; right<s.length(); right++){
            char schar = s.charAt(right);
            while(set.contains(schar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(schar);
            MaxCount = Math.max(MaxCount, right - left + 1);
        }

        

        return MaxCount;
    }
}


/**
 * In Bruteforce, we can do with nested iterations, TC : O(n^3)
 *
Sliding Window → Always the TC will be O(n) which is better than O(n^2).

Maintaining left and right pointers and increasing right. If char exists inside the set then remove characters using left, till this existing character goes out. 
TC : O(2n) → Where 2 is constant.

Optimization of this is using HashMap, then O(2n) will become exactly O(n) and Space Complexity is O(1). Bcz constant number of letters. 
This HashMap will remove extra iterations between repeated letters. 

 * 
 */