class Problem791 {
//TC: O(n + m)
//SC: O(1)
    public String customSortString(String order, String s) {
        HashMap<Character,Integer> sFreqMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            sFreqMap.put(c,sFreqMap.getOrDefault(c,0)+1);
        }
        StringBuilder result=new StringBuilder();
        for(int i=0;i<order.length();i++){
            char c=order.charAt(i);
            if(sFreqMap.containsKey(c)){
                int count=sFreqMap.get(c);
                for(int j=0;j<count;j++){
                    result.append(c);
                }
            }
            sFreqMap.remove(c);
        }
        for(Character c:sFreqMap.keySet()){
            int count=sFreqMap.get(c);
            for(int j=0;j<count;j++){
                result.append(c);
            }
        }
        return result.toString();
    }
}
