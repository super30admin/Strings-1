import java.util.HashMap;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class LongestUniqueSubstring {	
	/**Approach:Two Pointers + HashMap **/
	public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        
        HashMap<Character, Integer> map= new HashMap();
        int slow=0;
        int max=0;
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if(map.containsKey(c)){
               slow= Math.max(slow, map.get(c));
            }
            map.put(c, i+1);
            max= Math.max(max, i-slow+1);
        }
        return max;
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		LongestUniqueSubstring ob = new LongestUniqueSubstring();	
		String s="dvdf";
		
		System.out.println("Length of longest Substring is: "+ob.lengthOfLongestSubstring(s));      
	}	
}
