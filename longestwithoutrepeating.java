/*
Time Complexity: O(m*n)
Space omplexity: O(n)
*/
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
               if(s.length()==1){
            return 1;
        }
        HashMap<Character,Integer> a=new HashMap<Character,Integer>();
        int i=0, j=0;
        int max=0;
        char[] x=s.toCharArray();
        while(j<x.length) {
        	char present=s.charAt(j);
        	if(a.containsKey(present)) {
                i=Math.max(a.get(s.charAt(j)), i);
            }
        		a.put(present,j+1);
            max=Math.max(max,j-i+1);
            j++;
        	}
    return max;
    }
    }