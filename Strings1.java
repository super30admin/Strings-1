//Time O(N) and space O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
  

        int max =0;
        int i =0;
        int j =0;
      
        while(i<=j && j<s.length()){
            Character c = s.charAt(j);
            if(map.containsKey(c)){
                int pos = map.get(c);
                if(pos>=i){ 
                    i=pos+1;
                }   
            }  
            max = Math.max(max,j-i+1);
            map.put(c,j);
            j++;
        }

        return max;
        
    }
}

// Time O(N) and space O(N)
class Solution {
    public String customSortString(String order, String s) {
        //store the string in map with count

        Map<Character,Integer> map = new HashMap<>();
        for(Character c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder st = new StringBuilder();
        for(Character c: order.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int i=0;i<count;i++){
                    st.append(c);
                    map.put(c,map.get(c)-1);
                }
                map.remove(c,0);
            }
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            Character key = entry.getKey();
            int count = entry.getValue();
            for(int i=0;i<count;i++){
                st.append(key);
            }
        }

        return st.toString();
         
    }
}
