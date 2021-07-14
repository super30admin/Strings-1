class customSortString{
    public String customSortString(String order, String str) {
        StringBuilder result = new StringBuilder();
        if(str == null ) return result.toString();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c)+1);
        }

        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                for(int j=0; j<count;j++){
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            Character key = item.getKey();
            Integer value = item.getValue();
            for(int j=0; j<value;j++){
                result.append(key);
            }
        }

        return result.toString();
    }
}