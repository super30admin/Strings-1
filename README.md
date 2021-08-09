# Strings-1

## Problem1

Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

//Time Complexity O(M+N)
//Space Complexity O(1)

class Solution {
public String customSortString(String order, String s) {
StringBuilder result = new StringBuilder();
StringBuilder temp = new StringBuilder();
int tempSize = 0;

        int[] freq = new int[26];

        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < order.length(); i++) {
            char current = order.charAt(i);
            while(freq[current - 'a'] != 0) {
                result.append(current);
                freq[current - 'a']--;
            }
        }

        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) {
                char current = (char) (i + 'a');
                while(freq[i] != 0) {
                    result.append(current);
                    freq[i]--;
                }
            }
        }
        return result.toString();
    }

}

## Problem2

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

//Time Complexity O(N)
//Space Complexity O(N)

class Solution {
public int lengthOfLongestSubstring(String s) {
if(s.length() == 0 || s == null) {
return 0;
}
HashMap<Character, Integer> map = new HashMap<>();
int result = 0;
int count = 0;
for(int i = 0; i < s.length(); i++) {
char current = s.charAt(i);
if(!map.containsKey(current)) {
count++;
map.put(current, i);
result = Math.max(count, result);

            } else {
                if(i - map.get(current) > count) {
                    count++;
                } else {
                    count = i - map.get(current) ;
                }
                result = Math.max(count,result);
                map.put(current, i);

            }
            //System.out.println(count);
        }
        return result;
    }

}
