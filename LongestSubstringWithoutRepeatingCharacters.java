// TC: O(2n) - O(n)-  Sliding window
// SC: O(M) -> M - length of Substring Without Repeating Characters
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        while ( j < s.length())
        {
            if (set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            else
            {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }    
        }
      return ans;
    }
}



//Using HashMap
// TC : O(n) 
// SC : O(n)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int ans = 0;
//         HashMap<Character, Integer> map = new HashMap<Character, Integer>();
//         for ( int j = 0, i = 0; j < s.length(); j++)
//         {
//             if (map.containsKey(s.charAt(j)))
//             {
//                i = Math.max(map.get(s.charAt(j)), i);
//             }
//              ans = Math.max(ans, j - i + 1);
//              map.put(s.charAt(j), j+1) ;          
//         }
//       return ans;
//     }
// }


