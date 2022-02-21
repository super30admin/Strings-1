# Strings-1

## Problem1

Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
//T.C O(m+n) where m and n is order and s length
//S.C o(1) since 26 characters will be saved in Hashmap

class Solution {
public String customSortString(String order, String s) {
if(s == null || s.length() == 0) return "";
HashMap<Character,Integer> map = new HashMap<>();
for (int i = 0; i < s.length(); i++)
{
char c = s.charAt(i);
map.put(c,map.getOrDefault(c,0)+1);
}
StringBuilder sb = new StringBuilder();
for(int i = 0; i < order.length(); i++)
{
char c=order.charAt(i);
if(map.containsKey(c))
{
int times=map.get(c);
for(int j=0; j<times; j++)
{
sb.append(c);
}

        }

        map.remove(c);
    }

        for(Character c : map.keySet())
        {
            int times=map.get(c);
            for(int j=0; j<times; j++)
            {
               sb.append(c);
            }
        }

        return sb.toString();
    }

}

## Problem2

Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

T.C O(N)
S.C O(1)

class Solution {
public int lengthOfLongestSubstring(String s) {

        if(s.length() == 0 || s==null) return 0;

        int slow = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                slow=Math.max(slow,map.get(c));
            }

            map.put(c,i+1);
            max=Math.max(max,i-slow+1);
        }
      return max;
    }

}
