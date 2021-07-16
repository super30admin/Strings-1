package strings1;

//TC : o(m+n)/o(1), m and n are length of given strings
// SC : o(1)
public class customSortString {
	    public String customSortString(String order, String str) {
	        StringBuilder result = new StringBuilder();
	        if(str == null) return result.toString();
	        HashMap<Character, Integer> map = new HashMap<>();
	        for(int i=0; i<str.length(); i++){
	            char c = str.charAt(i);
	            map.put(c, map.getOrDefault(c,0)+1);
	        }
	        for(int i=0; i<order.length(); i++){ // chars which are in order string
	            char c = order.charAt(i);
	            if(map.containsKey(c)){
	                int count = map.get(c);
	                while(count > 0){
	                    result.append(c);
	                    count--;
	                }
	                map.remove(c);
	            }
	        }
	        
	        for(char key : map.keySet()){ // for remaining chars which are not in order string
	            int count = map.get(key);
	            while(count > 0){
	                result.append(key);
	                count--;
	            }
	        }
	        return result.toString();
	    }
}
