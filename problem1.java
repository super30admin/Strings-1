   /**
    Time Complexity = O(N + M)
    Explanation:
    N = length of string s → used to build frequency map
    M = length of order string → used to arrange characters
    Each character is processed a limited number of times.

    Space Complexity = O(1)
    Explanation:
    HashMap stores at most 26 lowercase letters, so constant space.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially used String concatenation inside loops which caused
    unnecessary overhead. Later corrected it using StringBuilder.
    Also needed to remove already processed characters from the
    HashMap to avoid duplicates in the final result.
    */

    class Solution {

        public String customSortString(String order, String s) {
    
            HashMap<Character, Integer> fmap = new HashMap<>();
    
            // Build frequency map
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
    
                if (fmap.containsKey(c)) {
                    Integer count = fmap.get(c);
                    fmap.put(c, count + 1);
                } else {
                    fmap.put(c, 1);
                }
            }
    
            StringBuilder r = new StringBuilder();
    
            // Arrange characters according to order
            for (int i = 0; i < order.length(); i++) {
                char c = order.charAt(i);
    
                if (fmap.containsKey(c)) {
                    Integer ct = fmap.get(c);
    
                    while (ct != 0) {
                        r.append(c);
                        ct--;
                    }
                }
                fmap.remove(c);
            }
    
            // Add remaining characters
            for (Character c : fmap.keySet()) {
                Integer ct = fmap.get(c);
    
                while (ct != 0) {
                    r.append(c);
                    ct--;
                }
            }
    
            return r.toString();
        }
    }
    