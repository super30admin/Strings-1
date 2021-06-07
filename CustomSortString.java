//Time: O(m+n) where m = length of string order and n= length of string str
//space: O(n)
//Did it run successfully in leetcode: yes
class CustomSortString {
    public String customSortString(String order, String str) {
        //map to store count of characters in str variable
        HashMap<Character, Integer> map = new HashMap<>();
        //storing the count of all charcters in input variable str
        for(int i=0; i<str.length(); i++){
            //get current character
            Character c = str.charAt(i);
            //if curr character not present in map
            if(!map.containsKey(c)){
                //add to map and initialize its value as 1
                map.put(c,1);
            }
            else{//if current character already present, increement its value
                map.put(c, map.get(c)+1);
            }

        }

        //StringBuilder to store result
        StringBuilder res = new StringBuilder();
        //looping through the order
        for(int i=0; i<order.length(); i++){
            Character c = order.charAt(i);
            //if current character exists in map
            if(map.containsKey(c)){
                int count = map.get(c);
                //add all the occurence of currenent character in str variable to result
                while(count>0){
                    res.append(c);
                    count--;
                }
                //remove current character from map
                map.remove(c);
            }
        }
        //loop through remaining characters that are not present in order
        for(Character key: map.keySet()){
            //get current character
            int count = map.get(key);
            //add all occurence of current character to result
            while(count>0){
                res.append(key);
                count--;
            }
        }

        return res.toString();

    }
}