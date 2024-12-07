// TC : O(n2)
// SC : O(1)
class LengthofLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < n; i++) {
            set.clear();
            for(int j = i; j < n; j++) {
                if(set.contains(s.charAt(j))) break;
                else {
                    set.add(s.charAt(j));
                }
            }
            max = Math.max(set.size(),max);
        }
        return max;
    }
}

// TC: O(2n)
// SC : O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(set.contains(s.charAt(i))) {
                while(s.charAt(left) != s.charAt(i)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(i));
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}


// TC : O(n)
// SC : O(1)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),i);
            } else {
                left = Math.max(left , map.get(s.charAt(i)) + 1);
                map.put(s.charAt(i),i);
            }
            max = Math.max(max, map.get(s.charAt(i)) - left + 1);
        }
        return max;
    }
}