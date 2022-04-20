import java.util.HashMap;

//Time Complexity : O(m+n); where m and n are length of input strings
//Space Complexity : O(1)
public class CustomSortString {	
	/**Approach: Using HashMap**/
	public String customSortString(String order, String s) {
        HashMap<Character, Integer> map= new HashMap<>();
        for(char c: s.toCharArray()){            
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        //Place all matching characters in given order
        StringBuilder sb= new StringBuilder();
        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                int count= map.get(c);
                for(int i=0; i<count; i++){
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        
        //Add remaining characters
        for(char c: map.keySet()){
            int count= map.get(c);
            for(int i=0; i<count; i++){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		CustomSortString ob = new CustomSortString();	
		String s="abcd";
		String order= "cba";
		
		System.out.println("Permuted String in given order is: "+ob.customSortString(order, s));      
	}	
}
