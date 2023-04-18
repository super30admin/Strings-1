class Solution {
    // TC-O(m+n),sc-O(m)
    // find hashmap of count for s string and loop through order string, and create a new string in that order
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> hs = new HashMap<>();
        int n = order.length();
        int m= s.length();
        for(int i=0;i<m;i++){
            if(hs.containsKey(s.charAt(i))){
                int c = hs.get(s.charAt(i)) + 1;
                hs.put(s.charAt(i),c);
            }
            else{
                hs.put(s.charAt(i),1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            if(hs.containsKey(order.charAt(i))){
                for(int j = 0;j < hs.get(order.charAt(i));j++){
                    sb.append(order.charAt(i));
                }
            hs.remove(order.charAt(i));
        }
    }
    // remaining in hashmap
    for(Map.Entry<Character,Integer> hm:hs.entrySet()){
        char e = hm.getKey();
        int v = hm.getValue();
         for(int j = 0;j < v;j++){
                    sb.append(e);
                }
    }

    return sb.toString();
    }
}