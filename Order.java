// Time Complexity :O(n) where n is elngth of s string
// Space Complexity :constant
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

//we'll make a hashmap of count and char in string s,and a hashset too  then we'll start our pointer
//from order string. we'll check if char in order string exists in hashmap, if yes will append in 
//stringBuilder number of occurence in s string. after completing order string, if there are more lements
//left, will check if hashset is not empty, will add all the occurences checking from hashmap
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> smap = new HashMap<>();
        HashSet<Character> sSet = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
            sSet.add(c);
        }
        for (int i = 0; i < order.length(); i++) {
            char o = order.charAt(i);
            if (smap.containsKey(o)) {
                int count = smap.get(o);
                while (count != 0) {
                    sb.append(o);
                    count--;
                }
                sSet.remove(o);
            }
        }
        if (!sSet.isEmpty()) {
            for (char c : sSet) {
                int count = smap.get(c);
                while (count != 0) {
                    sb.append(c);
                    count--;
                }
            }
        }
        return sb.toString();
    }
}
// -----------------OPRIMIZED SOLUTION-------------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

// we'll be doing same as previous except we are not making hashmap here,
// becausewe can iterate through
// hashMap for remanining characters

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> smap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char o = order.charAt(i);
            if (smap.containsKey(o)) {
                int count = smap.get(o);
                while (count != 0) {
                    sb.append(o);
                    count--;
                }
                smap.remove(o);
            }
        }
        for (char m : smap.keySet()) {

            int count = smap.get(m);
            while (count != 0) {
                sb.append(m);
                count--;
            }

        }
        return sb.toString();
    }
}