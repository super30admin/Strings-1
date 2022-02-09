
//Time complexity : O(m+n) where m is length of order and n is length of s
class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> hm=new HashMap<>();
        StringBuilder result=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        // System.out.println(hm);
        for(int i=0;i<order.length();i++){
            char c =order.charAt(i);
            if(hm.containsKey(c)){
                int cnt=hm.get(c);
                for(int k=0;k<cnt;k++){
                    result.append(c);
                }
            }
            hm.remove(c);
        }
        for(char c : hm.keySet()){
            int cnt = hm.get(c);
            for(int k=0;k<cnt;k++){
                result.append(c);
            }
        }
        return result.toString();

    }
}