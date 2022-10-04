class Problem2 {
    public String customSortString(String order, String s) {

        StringBuffer result = new StringBuffer();
        Map<Character, StringBuffer> characterStore = new HashMap<>();
        // Iterate through the string and add every character to a Map at specified location.
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(order.contains(""+c)){
                if(!characterStore.containsKey(c)){
                    characterStore.putIfAbsent(c, new StringBuffer());
                }
                StringBuffer current = characterStore.get(c);
                current.append(c);
                characterStore.replace(c, current);
            }
            else{
                result.append(c);
            }
        }
        for(int i=0; i<order.length(); i++){
            char c = order.charAt(i);
            StringBuffer current=characterStore.get(c);
            if(current!=null){
                result.append(current);
                characterStore.remove(c);
            }

        }
        return result.toString();
    }
}