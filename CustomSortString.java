package com.ds.rani.string;

import java.util.HashMap;
import java.util.Map;

/**
 * S and T are strings composed of lowercase letters. In S, no letter occurs more than once.
 * <p>
 * S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.
 * <p>
 * Return any permutation of T (as a string) that satisfies this property.
 * <p>
 * Example :
 * Input:
 * S = "cba"
 * T = "abcd"
 * Output: "cbad"
 * Explanation:
 * "a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a".
 * Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
 * <p>
 * <p>
 * Note:
 * <p>
 * S has length at most 26, and no character is repeated in S.
 * T has length at most 200.
 * S and T consist of lowercase letters only.
 */

//Approach:Use hashmap.Add all the characters  of T and how many times in occured in map.
//Traverse over S and check if the curr character present in map, if it is present append it to result else move to next charcater.
// at the end append remaining characters from map to result

//Time Complexity:o(m+n) where m is length of S and n is length of t
//Space Complexity:o(1) as at max there will be 26 characters in the hashmap

public class CustomSortString {
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0 || T == null || T.length() == 0)
            return T;

        Map<Character, Integer> map = new HashMap<>();

        //put all the characters from the T to hashmap
        for (char ch : T.toCharArray()) {
            map.put( ch, map.getOrDefault( ch, 0 ) + 1 );
        }
        //Traverse over S
        StringBuilder sb = new StringBuilder();
        for (char ch : S.toCharArray()) {
            if (map.containsKey( ch )) {
                int count = map.get( ch );
                while (count > 0) {
                    sb.append( ch );
                    count--;
                }
                map.remove( ch );
            }
        }
        //append remaining characters of T
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            char ch = entry.getKey();
            while (count > 0) {
                sb.append( ch );
                count--;
            }
        }
        return sb.toString();
    }
}
