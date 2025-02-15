import java.util.*;

// Approach 1: Using HashMap and two pointers
// TC: O(n)
// SC: O(1)
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int ans = 0;
        int i=0, j=0;
        while(j<n){
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                while(true){
                    char x = s.charAt(i);
                    map.remove(x);
                    i++;
                    if(ch == x) break;
                }
            }
            map.put(ch, j);
            ans = Math.max(j-i+1, ans);
            j++;
        }
        return ans;
    }
}


// Approach 2: Using HashSet and two pointers
// TC: O(n)
// SC: O(1)
class LC3_1 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int n = s.length();
        int ans = 0;
        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                set.remove(s.charAt(i++));
            } else {
                ans = Math.max(j - i + 1, ans);
                set.add(ch);
                j++;
            }
        }
        return ans;
    }
}