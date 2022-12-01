class Solution {
    public int lengthOfLongestSubstring(String s) {
Set<Character> set = new HashSet ();
int start=0, end=0;
int maxLen = 0;
while(end < s.length()) {
    char ch = s.charAt(end);
if(set.contains(ch)) {
set.remove(s.charAt(start));
++start;
} else {
set.add(ch);
maxLen = Math.max(maxLen, end-start+1);
++end;
}
}
return maxLen;
    }
}
//tc=O(s)
//sc=O(s)
