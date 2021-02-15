class Solution {
    public String customSortString(String S, String T) {

        //edge case
        if(S.length() == 0 || T.length() == 0){
            return "";
        }

        HashMap<Character, Integer> hmap = new HashMap<>();
        //store characters in string T and its count in hashmap
        for(int i = 0; i < T.length(); i++){
            char ch = T.charAt(i);
            hmap.put(ch,hmap.getOrDefault(ch,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(hmap.containsKey(ch)){
                int count = hmap.get(ch);

                while(count > 0){
                    sb.append(ch);
                    count--;
                }
                hmap.remove(ch);
            }
        }

        for(Map.Entry<Character, Integer> map : hmap.entrySet()){
            int count = map.getValue();

            while(count>0){
                sb.append(map.getKey());
                count--;
            }
        }
        return sb.toString();
    }
}