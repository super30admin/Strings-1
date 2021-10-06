class Solution {
    public int lengthOfLongestSubstring(String s) {
        int slow = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<s.length();i++)
        {   char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow = Math.max(slow,map.get(c));
            }
         max = Math.max(max, i-slow+1);
         map.put(c,i+1);
         System.out.println(map.get(c));
        }
        
        return max;
        
    }
}

//TC:O(n);
//SC:O(1);