//Time : O(n^3)   - Time Limit exceeded
//Space : O(max(s)) 

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        StringBuilder sb = null;
        int max = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            sb = new StringBuilder();
            sb.append(s.charAt(i));
            // System.out.println(sb.toString()); // Print

            for (int j = i + 1; j < s.length(); j++) {
                sb.append(s.charAt(j));
                // System.out.println(sb.toString()); // print
                HashSet<Character> set = new HashSet<>();
                for (int k = 0; k < sb.length(); k++) {
                    if (set.contains(sb.charAt(k))) {
                        set.clear();
                        set.add(sb.charAt(k));
                    } else {
                        set.add(sb.charAt(k));
                    }
                    max = Math.max(set.size(), max);
                    // System.out.println(set); //print
                }
            }
        }
        return max;
    }
}

//
// Time : O(2n)
// Space : O(26)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        int slow = 0;
        int fast = 1;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(slow));
        while (fast < s.length()) {
            if (set.contains(s.charAt(fast))) {
                while (s.charAt(slow) != s.charAt(fast)) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }

            set.add(s.charAt(fast));
            max = Math.max(max, fast - slow + 1);
            fast++;
        }

        return max;

    }
}

// Time : O(n)
// Space : O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 1;
        map.put(s.charAt(slow), 1);
        for (int i = 1; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                slow = Math.max(slow, map.get(s.charAt(i)));
                map.put(s.charAt(i), i + 1);
            } else {
                map.put(s.charAt(i), i + 1);
            }
            max = Math.max(max, i - slow + 1);
        }

        return max;

    }
}