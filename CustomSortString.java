// TC: O(m+n)
// SC: O(m) --for StringBuilder to store intermediate result

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        StringBuilder res= new StringBuilder();

        for(char c: order.toCharArray()){

            if(map.containsKey(c)){
                for(int i=0;i<map.get(c);i++){
                    res.append(c);
                }
            }
            map.remove(c);
        }

        //append the remaining characters to the string
        for(char c: map.keySet()){

            int cnt=map.get(c);

            for(int i=0;i<cnt;i++){
                res.append(c);
            }
        }

        return res.toString();

    }
}