class Solution {
    
//     Time Complexity: O(n), n is the length of the given string
// Space Complexity: O(n), n is the size of the HashSet
    public int lengthOfLongestSubstring(String s) {
        
     Set <Character> set = new HashSet<>();
        int maxLen =0;
        int start = 0 , end = 0;
        while(end < s.length())
        {
            char ch = s.charAt(end);
            if (set.contains(ch))
            {
                set.remove(s.charAt(start));
                ++start;
                
            }
            else{
                set.add(ch);
                ++end;
                maxLen = Math.max(maxLen , end-start);
            }
        }
        return maxLen;
    }
    
    
// public int lengthOfLongestSubstring(String s) {
     
//         Map <Character, Integer> map = new HashMap<>();
//         int maxLen =0;
//         int start = 0 , end = 0;
//         while(end < s.length())
//         {
//             char ch = s.charAt(end);
//             if (map.containsKey(ch))
//             {
//                 int chIndex = map.get(ch);
//                 if(chIndex < start)
//                 {
//                     //invalid elements should be in map
//                     map.remove(ch);
                    
//                 }
//                 else
//                 {
//                     start = chIndex +1;
//                     map.remove(ch);
                
//                 }
//                 map.remove(ch);
//             }
//             else{
//                 map.put(ch, end);
//                 ++end;
//                 maxLen = Math.max(maxLen , end-start);
//             }
//         }
//         return maxLen;
//     }
}
