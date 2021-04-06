//TC - O(n), SC - O(n)
// LC - 3
class Solution {
    public int lengthOfLongestSubstring(String s) {
		// sanity check
        if(s == null || s.length() == 0){
            return 0;
        }
		// max value to return
        int max = 0;
		// Initializing map to store character and its index
        Map<Character, Integer> map = new HashMap<>();      
		// Two pointers start and end, we increment end each time. if map has character at end, we can move start to postion of max of start and previous charAt of end
        int start = 0;
        int end = 0;
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                start = Math.max(map.get(s.charAt(end)), start);  
            }
			// update max each time, and put character at end and end+1 as position
            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end+1);
            end++;
        }
        return max;
    }
}

// Using HashSet
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         if(s == null || s.length() == 0){
//             return 0;
//         }
//         int i = 0, j = 0;
//         Set<Character> set = new HashSet<>();
//         int max = 0;
//         while(i<s.length() && j<s.length()){
//             if(!set.contains(s.charAt(j))){
//                 set.add(s.charAt(j));
//                 max = Math.max(max, j-i+1);
//                 j++;
//             }else{
//                 set.remove(s.charAt(i));
//                 i++;
//             }
//         }
//         return max;
//     }
// }