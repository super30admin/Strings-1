// Time Complexity : O(O*L) + O(L), O = order length, L  = string length
// Space Complexity : O(1), ignored the output string builder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
public class CustomSortString {
    class Solution {
        public String customSortString(String order, String s) {
            //corner cases

            //main logic
            StringBuilder sb = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for(int i = 0; i< order.length(); i++) {
                for(int j = 0; j< s.length(); j++) {
                    if(order.charAt(i) == s.charAt(j)) {
                        sb.append(s.charAt(j));
                        set.add(s.charAt(j));
                    }
                }
            }

            for(int j = 0; j< s.length(); j++){
                if(!set.contains(s.charAt(j)))
                    sb.append(s.charAt(j));
            }
            return sb.toString();
        }
    }
}
