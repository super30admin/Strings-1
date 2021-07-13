class Solution {
    public String customSortString(String order, String str) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer>  resultMap = new HashMap<>();
      if (str ==  null ){
          return result.toString();
      }
        for(int i = 0; i<str.length();i++){
            char c = str.charAt(i);
           resultMap.put(c,resultMap.getOrDefault(c,0)+1);

        }

        for(int i = 0; i<order.length();i++){
            char c = order.charAt(i);
            if(resultMap.containsKey(c)){
                int cnt = resultMap.get(c);
                while(cnt > 0){
                result.append(c);
                cnt--;
                }
                resultMap.remove(c);
            }
        }
        for(char c: resultMap.keySet()){
            int cnt = resultMap.get(c);
            while(cnt > 0){
                result.append(c);
                cnt--;
            }
        }
        return result.toString();
    }

}