//Timecomplexity:- O(n+m)
//Spacecomplexity:-O(n);
//Did it run on leetcode:- yes.
//What problems did you face?:- got wrong answers initially.
//Your code with explanation:- initially in string s storing in hashmap with their frequencies and traversing in main string
// if that key is found how many frequencies are there thatmuch characters are built as output string, and remaing based on counts added last.



class Solution {
    public String customSortString(String order, String s) {
        StringBuilder output= new StringBuilder();
        HashMap<Character,Integer> cache=new HashMap<>();
        for(int i=0;i<s.length();i++){
            cache.put(s.charAt(i),cache.getOrDefault(s.charAt(i),0)+1);
        }
        for(int j=0;j<order.length();j++){
            if(cache.containsKey(order.charAt(j))){
                int count=cache.get(order.charAt(j));
                while(count!=0){
                    output.append(order.charAt(j));
                    count=count-1;
                }
                cache.remove(order.charAt(j));
            }
        }
        for(Map.Entry<Character,Integer> en:cache.entrySet()){
            char ch=en.getKey();
            int count=cache.get(ch);
            while(count!=0){
                output.append(ch);
                count--;
            }
        }
        
        
     return output.toString();   
}
}