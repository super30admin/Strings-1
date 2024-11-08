//form all the substrings check for repeatition it will be nested iteration-to optimize nested iteraion-
//binary, 2 pointer, hashhing, slidong window



//slidong window tc- O(2n) scO(1)
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet<>();

//        int max = 0;
//        int slow = 0;
//        for(int i = 0; i < s.length(); i++){
//         char c = s.charAt(i);
//         if(set.contains(c)){
//             //escape all char till we reach c(that is repeating)
//             while(s.charAt(slow) != c){
//                 set.remove(s.charAt(slow));
//                 slow++;
//             }
//             slow++;
//         }
//         set.add(c);
//         max = Math.max(max, i-slow+1);
//        }
//        return max;
//     }
// }


//tc- O(n) sc-O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
       HashMap<Character, Integer> map = new HashMap<>();

       int max = 0;
       int slow = 0;
       for(int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
        if(map.containsKey(c)){
            //escape all char till we reach c(that is repeating)
           slow = Math.max(slow, map.get(c) + 1);
        }
        map.put(c, i);
        max = Math.max(max, i-slow+1);
       }
       return max;
    }
}