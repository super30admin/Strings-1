/**  Custom Sort String - We want to permute the characters of T so that they match the order that S was sorted
* SC O(1) TC O(n+m)
*/
class Solution {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0)
            return T;
        HashMap<Character, Integer> count = new HashMap<>();
        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < T.length(); i ++) {
            char c = T.charAt(i);
            if (!count.containsKey(c))
            {
                count.put(c, 1);
            }
            else {
                int val = count.get(c);
                val++;
                count.put(c, val);
            }
        }
        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);
            if (count.containsKey(c)) {
                int val = count.get(c);
                for (int j = 0; j < val; j++) {
                    finalStr.append(c);
                }
                count.remove(c);
            }
        }
        for (char c : count.keySet()) {
            int val = count.get(c);
             for (int j = 0; j < val; j++) {
                finalStr.append(c);
            }
        }
        return finalStr.toString();
    }
}
