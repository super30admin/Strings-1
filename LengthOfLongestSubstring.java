package week7.day6;

import java.util.HashMap;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//TC - O(n)
//SC - O(1)
class Solution11 {
  public int lengthOfLongestSubstring(String s) {
      int left =0;
      int right = 0;
      int longestSubstring =0;
      HashMap<Character, Integer> map= new HashMap<>();
      while(right!=s.length()){
          char ch = s.charAt(right);
              if(!map.containsKey(ch))
                  map.put(ch,right);
              else{
                  int old_idx = map.get(ch);
                  longestSubstring = Math.max(longestSubstring, right-left);
                  //left == map idx
                  if(old_idx == left){
                      left++;
                      map.put(ch,right);
                  }
                  //left< map idx
                  else if(left<old_idx){
                      left = old_idx+1;
                      map.put(ch,right);
                  } 
                  //left>map idx
                  else
                      map.put(ch,right);
              }
              right++;
      }
      longestSubstring = Math.max(longestSubstring, right-left); //once right reaches out of bound, calculate the sub string length
      return longestSubstring;
  }
}
public class LengthOfLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
