# Strings-1

## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

Explain approach in 3 lines: In this solution first we will count the frequency of each character in string s and store it in hashmap. Then we will construct the result string by appending characters in the order which has been specified by order string and then followed by appending any other characters which were not in the order string. This ensures that the characters in s are rearranged according to the custom order defined by string order.

Time Complexity: O(m + n + k) where m is length of string s and n is length of string order and k will be the remaining characters in the hashmap which don't match with string order.

Space Complexity: O(m) where m is length of string s as we are storing all the characters in the hashmap. As there are just 26 characters we can say the space complexity could be considered as O(1).

Approached Code:

class Solution {
    public String customSortString(String order, String s) {
        
        StringBuilder result = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        int n = order.length();
        int m = s.length();

        for(int i = 0; i < m; i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            char c = order.charAt(i);

            if(map.containsKey(c)) {
                int count = map.get(c);

                for(int j = 0; j < count; j++) {
                    result.append(c);
                }

                map.remove(c);
            }
        }

        for(char c: map.keySet()) {
            int count = map.get(c);

            for(int j = 0; j < count; j++) {
                result.append(c);
            }
        }

        return result.toString();

    }
}



## Problem2 

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Explain approach in 3 lines: In this solution we will use sliding window technique with HashMap to keep track of the last index of each character encountered. As we will iterate through a string it adjusts the start of the winrow whenever there is a repeating character found which will ensure that substring between start and i is always unique. Then length of the longest unique substring will be updated during each iteration and will return it at the end.

Time Complexity: O(n) where n is the length of the string s as each character will be processed at most twice.

Space Complexity: O(min(m, n)) where m is 26 and n is unique characters in string. As there are just 26 characters we can say the space complexity could be considered as O(1).

Approached Code:

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // List<String> possibleSubstrings = new ArrayList<>();
        // int n = s.length();
        // int max = 0;

        // for(int i = 0; i < n; i++) {
        //     for(int j = i+1; j <= n; j++) {
        //         String temp = s.substring(i, j);
        //         possibleSubstrings.add(temp);
        //     }
        // }

        // for(String eachString: possibleSubstrings) {
        //     HashSet<Character> set = new HashSet<>();
        //     int count = 0;
        //     for(int i = 0; i < eachString.length(); i++) {
        //         char c = eachString.charAt(i);
        //         if(!set.contains(c)) {
        //             set.add(c);
        //             count ++;
        //         } else {
        //             break;
        //         }
        //     }
        //     max = Math.max(max, count);
        // }

        // return max;

        int n = s.length();
        int max = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;
        int i = 0;

        while(i < n) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(i - start + 1, max);
            i++;
        }

        return max;

    }
}


