package strings1;

//TC : o(n)
//SC : o(n)

// Approach : Using sliding window technique put all chars in a map and repeatedly check the length of string formed. 
public class LongestStringWithoutRepeatingChars {
	    public int lengthOfLongestSubstring(String s) {
	        //null check
	        if(s == null || s.length() == 0) return 0;
	        HashMap<Character, Integer> map = new HashMap<>();
	        int max = 0;
	        int slow = 0;
	        String res = "";
	        for(int i=0; i<s.length(); i++){
	            char c = s.charAt(i);
	            if(map.containsKey(c)){
	                slow = Math.max(slow, map.get(c));
	            }
	            max = Math.max(max, i-slow+1);
	            res = s.substring(slow, i); 
	            map.put(c, i+1);
	        }
	        return max;
	    }
	}
