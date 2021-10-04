// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// set the hashmap to get the index of the present element and get the count of the list from the difference of start and end
// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap <Character,Integer> hm = new HashMap<>();
        int start = 0;
        int max = 0;
        for( int i = 0; i < start; i++){
            char c = s.charAt(i);
            if(hm.contiansKey(c)){
                start = Math.max(start, hm.get(c));
            }
            max = Math.max(max, i-start+1);
            hm.put(c,i+1);
        }
        return max;
    }
}

// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if( s == "" || s.length() == 0) return 0;
//         HashSet<Character> hs = new HashSet<>();
//         int start = 0;
//         int end = 0;
//         int count = 0;
//         for(int i = 0; i<s.length(); i++){
//             if(hs.contains(s.charAt(i))){
//                 count = Math.max(count, end - start);
//                 start = end;
//                 end++;
//             }else{
//                 hs.add(s.charAt(i));
//                 end++;
//             }
//         }
//         return Math.max(count, end - start);
//     }
// }