/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs
 * more than once.
 * 
 * S was sorted in some custom order previously. We want to permute the
 * characters of T so that they match the order that S was sorted. More
 * specifically, if x occurs before y in S, then x should occur before y in the
 * returned string.
 * 
 * Return any permutation of T (as a string) that satisfies this property.
 * 
 * Idea:
 * Compute a frequency map of characters given in T, use HashMap to store it.
 * Now Iterating over characters in S, we get the desired ordering, put as many copies,
 * as its frequency into the String Builder. Once done, copy remaining letters into the builder.
 * These are the ones for whom we dont have any preference as they are missing in S.
 * Eventually, return the string contained in the StringBuilder.
 * 
 * Runtime: 2 ms, faster than 46.17% of Java online submissions for Custom Sort String.
 * Memory Usage: 35.7 MB, less than 84.85% of Java online submissions for Custom Sort String.
 */
class Solution {
    public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        // compute the frequency map
        for (Character ch : T.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // respect ordering as in S.
        for (Character ch : S.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            while (count > 0) {
                sb.append(ch);
                count--;
            }
            map.remove(ch);
        }

        // get the remaining characters, that have no specific ordering
        // without the loss of generality, they are appended at the end
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