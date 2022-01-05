package sol;
import java.util.*;
public class SubstringWithoutRepeating {
	 public int lengthOfLongestSubstring(String s) {
	        Queue<Character> q= new LinkedList<>(); 
	        // queue to have a sliding window
	        
	        HashSet<Character>hs= new HashSet<>();  
	        // hashset to store the char already in the queue at a time
	        
	        
	        int size=0; //variable which stores the max size of the queue 
	        
	        for( int i=0;i<s.length();i++){
	          //iterate over each element in the string
	            
	            if(hs.contains(s.charAt(i))){
	            // read this comment after the next comment
	                
	            // if the hashmap already contains this character that means the duplicate value exists
	            // somewhere in my queue so start poping the queue till we remove that duplicate
	            // after duplicate is removed add the new occurance of the removed value again    
	                
	               while(!q.isEmpty()&&q.peek()!=s.charAt(i)){
	                        
	                        hs.remove(q.poll());
	                                 
	               }hs.remove(q.poll());
	                    hs.add(s.charAt(i));
	                    q.add(s.charAt(i));
	                    
	                }
	                
	            else{
	                
	                // if hashset does not have the value that means the current character is 
	                // a newly introduced one so store in hashmap and addin the queue
	                 hs.add(s.charAt(i));
	                q.add(s.charAt(i));
	                
	            }
	               
	        
	                if(q.size()>size){size=q.size();}
	              
	        }
	                     return size; 
	    }
	             
	               
	               
}
