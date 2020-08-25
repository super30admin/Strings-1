//time complexity: O(n)
//space complexity: O(n) in case there are no duplicates
//approach: end pointer moves along the string. 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> set = new HashSet<>();
        int start = 0;
        int end= start; 
        int max = 0;
        int f=0;
        int l = 0;
        while(end<s.length())
        {
            if(!set.contains(s.charAt(end))) //if set doesnt contain a character, add that character to the set, calculate the max, increment end pointer
                //if we cal max in else clause, 0 will be returned in case there are no duplicates in the string
            {
                set.add(s.charAt(end++));
                if(set.size()>max) //we are doing this to be able to print the longest substring
                {
                    f = start;
                    l = end-1;
                }
                max=Math.max(max,set.size());
            }
            else 
            {   
                set.remove(s.charAt(start++));
            }
        }
        System.out.println(s.substring(f,l+1));
        return max;
        
    }
}