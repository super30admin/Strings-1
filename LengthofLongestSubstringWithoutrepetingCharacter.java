//Time Complexity :O(N).
//Space Complexity :O(N).
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :Nope


//Your code here along with comments explaining your approach
class LengthofLongestSubstringWithoutrepetingCharacter{
	
	public int lengthOfLongestSubstring(String s) {
       HashSet<Character> window = new HashSet<>();
        int i = 0, j = 0, result = 0, n = s.length();
        while(i < n && j < n){
            if(window.contains(s.charAt(j))){
                window.remove(s.charAt(i));
                i++;
            }else{
                window.add(s.charAt(j));
                j++;
                result = Math.max(result,window.size());
            }
        }
    return result;
    }
	
}