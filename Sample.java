//Time Complexity:O(n)
//Space Complexity:O(min(m,n))
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
-------------------------------------------------------------------------------------
class Solution {

   public String customSortString(String S, String T) {

       StringBuilder sb = new StringBuilder();

       Map<Character, Integer> map = new HashMap<>();


       for (Character ch : T.toCharArray()) {

           map.put(ch, map.getOrDefault(ch, 0) + 1);

       }

       
       for (Character ch : S.toCharArray()) {

           int count = map.getOrDefault(ch, 0);

           while (count > 0) {

               sb.append(ch);

               count--;

           }

           map.remove(ch);

       }

       for (Map.Entry<Character, Integer> entry : map.entrySet()) {

           Character ch = entry.getKey();

           int count = entry.getValue();

           while (count > 0) {

               sb.append(ch);

               count--;

           }

       }

       return sb.toString();

   }

}

------------------------------------------------------------------------