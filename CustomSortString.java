//idea is to use hashmap and store second string characters as key and no of occurances as value.
//then iterate over first string and check weather first string characters present in map or not if yes then reduce no of occurances and append key to result till no of occurances become 0.
//and then remove key from hashmap.
//after iterating first string, add remaining element in hashmap into result.

//tc:0(n) because we need to iterate over first string and its length is n. 
//sc: o(m) m is no of element in second string

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
	    public static String customSortString(String S, String T) {
	        HashMap<Character,Integer> map = new HashMap<>();
	        char[] charS = S.toCharArray();
	        char[] charT = T.toCharArray();
	        StringBuilder result = new  StringBuilder();
	        
	        //iterate over second string and put it in hashmap
	        for(int i=0;i<charT.length;i++){
	            if(!map.containsKey(charT[i]))  map.put(charT[i],1); //if new key
	            else {
	                map.put(charT[i], map.get(charT[i])+1);//if already contains key then increase its value(no of occurances) by 1.
	            }
	        }
	        int freq=0;
	        
	        //iterate over first string to check common elements and maintain order as per first string
	        for(int j=0;j<charS.length;j++){
	            if(map.containsKey(charS[j] )){       //if element found in map then put it in output till no of occurrence become 0
	                result.append(charS[j]);
	                freq = map.get(charS[j]);
	                freq= freq-1;
	                if(freq>0){
	                    while(freq>0){
	                     result.append(charS[j]);
	                     freq= freq-1;
	                    }
	                }
	                if(freq==0) map.remove(charS[j]); //once no of occurance =0 and put element in output remove key from map.
	            }
	            
	               
	        }
	        
	        //add remaining characters of map which are uncommon characters of second string
	      for(Map.Entry<Character,Integer> m : map.entrySet()){
	          int occurance =m.getValue();
	          if(occurance>=1){
	             while(occurance>0){
	                  result.append(m.getKey());
	                  occurance = occurance-1;
	             }
	          }
	      }
	        return result.toString();
	    }
	    
	    //using java 8
	   /* public static String customSortString(String S, String T) {
	        Map<Character, Integer> map = new HashMap<>();
	        IntStream.range(0, S.length()).forEach(i -> map.put(S.charAt(i), i));
	        return T.chars().mapToObj(i -> (char)i)
			.sorted(comparingInt(ch -> map.getOrDefault(ch, 0)))
			.map(c -> String.valueOf((char)c))
			.collect(joining());
	    }
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s= "cba";
       String t= "abcd";
       String result = customSortString(s,t);
       System.out.println("output string is="+result);
	}

}
