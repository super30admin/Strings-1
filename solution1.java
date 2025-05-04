//custom sort
//Time complexity is o(m+n)
//space complecity is o(1)
class Solution1 {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map=new HashMap<>();
       
       for(char c:s.toCharArray()){
        map.put(c,map.getOrDefault(c,0)+1);
        }
        StringBuilder sb=new StringBuilder();

        for(char c :order.toCharArray())
        {
            while(map.getOrDefault(c,0)> 0){
                sb.append(c);
                map.put(c,map.get(c)-1);
            }
        }
        for(char c:map.keySet()){
              int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }



        return sb.toString();
        
    }
}
//Longest substring without repeation
//Time Complexity:o(2n)
//space complexity o(1)
//using slinding window approch
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int max=0;
        int slow=0;
        HashSet<Character> st=new HashSet<>();
        for(int i=0;i<n;i++){
            char c =s.charAt(i);
            if(st.contains(c)){

                while(s.charAt(slow)!=c){
                st.remove(s.charAt(slow));
                slow++;
                }
                slow++;


            }
            st.add(c);
            max= Math.max(max,i-slow+1);
        }
        return max;
    }
}
       



