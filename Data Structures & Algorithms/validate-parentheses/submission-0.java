class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> hmap = new HashMap<>();
        hmap.put(')', '(');
        hmap.put('}', '{');
        hmap.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.isEmpty() || hmap.get(s.charAt(i)) != st.peek())
                    return false;
                else
                    st.pop();

            } else {
                st.push(s.charAt(i));
            }
        }
        return st.isEmpty();

    }
}
