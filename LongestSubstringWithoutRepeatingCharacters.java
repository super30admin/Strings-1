//TC: O(n), n is length of input string
//SC: O(k), k is character set 
//Solution: Using Hashset

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if(len <= 1)
            return len;
        Set<Character> set = new HashSet<>();
        int left = 0, right =0;
        int max =0;
        while(right < len){
            char curr = s.charAt(right);
            if(set.contains(curr)){
                //move the left ptr to escape repeat char
                while(s.charAt(left) != curr){
                    char leftChar = s.charAt(left);
                    set.remove(leftChar);
                    left++;
                }
                left++;
            }else{
                set.add(curr);
            }
            
            max = Math.max(max, right -left +1);
            right++;
        }
        return max;
        
    }
}

//Solution: Using HashMap
//TC: O(n)
//SC: O(k)

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int len = s.length();
        if(len <= 1)
            return len;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right =0;
        int max =0;
        while(right < len){
            char curr = s.charAt(right);
            if(map.containsKey(curr)){
                left = Math.max(left, map.get(curr) +1);
            }
            map.put(curr, right);
            max = Math.max(max, right -left +1);    
            right++;
        }
        return max;
        
    }
}



