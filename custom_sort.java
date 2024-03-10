//TimeComplexity: O(n)
//SpaceComplexity: O(n)

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0; i<s.length();i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),1);
            } else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<order.length();i++) {
            if(map.containsKey(order.charAt(i))) {
            int len = map.get(order.charAt(i));
            
            for(int j =0; j<len;j++) {
                sb.append(order.charAt(i));
            }
            map.remove(order.charAt(i));

            }
        }
            for(char c : map.keySet()) {
                int count = map.get(c);
                for(int i=0; i<count;i++) {
                sb.append(c);
                }
            }

            return  sb.toString();
    }
}