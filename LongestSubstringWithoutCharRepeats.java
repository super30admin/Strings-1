class Solution {
    // TC = O(n) solution using 2 pointers
    // SC = O(1) -- as Hashmap can max have 26 characters
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int start = 0; int end = 0;
        int max = 0;
        for(int i=0;i<s.length();i++){
            end = i;
            char c = s.charAt(i);
            if(map.containsKey(c) && start<=map.get(c)){
                start = map.get(c) + 1;
            }
            map.put(c,i);
            max = Math.max(max,end - start + 1);
        }
        return max;
    }
}


// Brute Force Solution -- 
// TC = O(n^2)
// SC = O(1) -- as hashset can have max 26 characters
// class Solution {
//     public int lengthOfLongestSubstring(String s) {
//         int max = 0;
//         for(int i=0;i<s.length();i++){
//             int count = 0;
//             HashSet<Character> set = new HashSet<>();
//             set.add(s.charAt(i));
//             count++;
//             for(int j=i+1;j<s.length();j++){
//                 if(set.contains(s.charAt(j))) break;
//                 set.add(s.charAt(j));
//                 count++;
//             }
//             max = Math.max(max,count);
//         }
//         return max;
//     }
// }