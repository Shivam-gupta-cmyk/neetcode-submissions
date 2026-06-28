class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String str:strs){
            sb.append(str.length()).append("#").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            StringBuilder sb = new StringBuilder("");
            while(i<str.length() && str.charAt(i)!='#'){
                sb.append(str.charAt(i)+"");
                i++;
            }
            int strIndexSalt = Integer.parseInt(sb.toString());
            res.add(str.substring(i+1,i+1+strIndexSalt));
            i+=strIndexSalt+1;
        }
        return res;
    }
}
