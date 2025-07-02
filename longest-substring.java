// //hashSet, two pointers:two pass, sliding window
// TC = O(2n)
// SC = O(1)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int l = s.length();
//         if(l<=1) return l;
//         Set<Character> set = new HashSet<>();
//         int left = 0;
//         int max=0;
//         for(int right=0;right<l;right++){
//             char curr = s.charAt(right);
//             if(set.contains(curr)){
//                 //move the left pointer to escape repeat character
//                 while(s.charAt(left)!=curr){
//                     char leftChar = s.charAt(left);
//                     set.remove(leftChar);
//                     left++;
//                 }
//                 left++;
//             } else {
//                 set.add(curr);
//             }
//             max = Math.max(max, right-left + 1);
//         }
//         return max;
//     }
// }

//hashMap, two pointers
//TC = O(n)
//SC = O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l<=1) return l;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int max=0;
        for(int right=0;right<l;right++){
            char curr = s.charAt(right);
            if(map.containsKey(curr)){
                left = Math.max(left, map.get(curr) + 1);
            }
            map.put(curr,right);
            max = Math.max(max, right-left + 1);
        }
        return max;
    }
}
