class Solution {

    public String encode(List<String> strs) {
         StringBuilder encodedString = new StringBuilder("");
        for (String str : strs) {
            String delimiter = str.length() + "#";
            encodedString.append(delimiter);
            encodedString.append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> ls = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            StringBuilder sb = new StringBuilder(""); 
            while (str.charAt(i) != '#') {
                sb.append(str.charAt(i));
                i++;
            }
            int val = Integer.parseInt(sb.toString());
            i++;
            ls.add(str.substring(i, i + val));
            i = i + val;
        }
        return ls;
    }
}
