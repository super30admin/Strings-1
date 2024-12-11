import java.util.*;
class Problem1 {
    public String customSortString(String order, String s) {
        return solByHashMap(order,s);

    }
    //TC :O(M+N)
    //SC :O(N) - for the stringbuilder . Hashmap would be O(1)
    public String solByHashMap(String order,String s){
        HashMap<Character,Integer> frequency = new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
            char letter = s.charAt(i);
            frequency.put(letter, frequency.getOrDefault(letter, 0) + 1);

        }



        StringBuilder resultBuilder = new StringBuilder();
        for(char alp : order.toCharArray()){
            if(frequency.containsKey(alp)){
                Integer freq = frequency.get(alp);
                for(int i=0;i<freq;i++){
                    resultBuilder.append(alp);
                }
                frequency.remove(alp);

            }


        }

        for (char letter : frequency.keySet()) {
            int count = frequency.get(letter);
            while (count > 0) {
                resultBuilder.append(letter);
                count--;
            }
        }

        return resultBuilder.toString();
    }

}