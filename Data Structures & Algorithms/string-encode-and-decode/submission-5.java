class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {

            int i = 0;

            while (i < str.length()) {

                int count = 1;

                while (i + 1 < str.length() &&
                        str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }

                sb.append(count)
                  .append("#")
                  .append(str.charAt(i))
                  .append("|");

                i++;
            }

            sb.append("@");
        }

        return sb.toString();
    }
        public List<String> decode(String str) {

        List<String> ans = new ArrayList<>();

        int i = 0;

        while (i < str.length()) {

            StringBuilder curr = new StringBuilder();

            while (i < str.length() && str.charAt(i) != '@') {

                StringBuilder num = new StringBuilder();

                while (str.charAt(i) != '#') {
                    num.append(str.charAt(i));
                    i++;
                }

                int count = Integer.parseInt(num.toString());

                i++;                // skip '#'

                char ch = str.charAt(i++);

                i++;                // skip '|'

                curr.append(String.valueOf(ch).repeat(count));
            }

            ans.add(curr.toString());

            i++;                    // skip '@'
        }

        return ans;
    }

    
}