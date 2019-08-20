//iterate over string ,find  combinations of substrings and calculate its length and return maxlength.
//to store repeating characters first time index use hashmap and one more pointer j to find length of substring.
//keep in mind j value should always me incrementing so keep   maximum value of j between j and previous index of repeating character  to avoid 
//checking same combination again.


//tc:o(n)
//sc:o(n)
import java.util.HashMap;

public class LengthOfLongestSubstring {
	    public static int lengthOfLongestSubstring(String s) {
	        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
	        int maxLength=0, index=0;
	        for(int i=0,j=0;i<s.length();i++){
	            if(map.containsKey(s.charAt(i))){   //check element is repeating
	                index = map.get(s.charAt(i));     //fetch previous index of repeating character
	                j = Math.max(j,index+1);    //consider maximum value of j between j and previous index of repeating character 
	            }
	            map.put(s.charAt(i),i);
	            int length = i-j+1;    //calculate length of substring, add 1 because i starts from 0.
	            maxLength = Math.max(maxLength,length);     //take maximum substring length
	        }
	        return maxLength;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "pwwkew";
		int length = lengthOfLongestSubstring(s);
		System.out.println("longest substring length is="+length);

	}

}
