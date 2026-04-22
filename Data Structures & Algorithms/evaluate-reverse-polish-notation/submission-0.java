class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for (String s : tokens) {
            if (!st.isEmpty() && st.size() > 1 && s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                String topEle = st.pop();
                Integer ans = null;
                if (s.equals("+")) {
                    ans = Integer.parseInt(st.pop()) + Integer.parseInt(topEle);
                } else if (s.equals("-")) {
                    ans = Integer.parseInt(st.pop()) - Integer.parseInt(topEle);
                } else if (s.equals("*")) {
                    ans = Integer.parseInt(st.pop()) * Integer.parseInt(topEle);
                } else {
                    if (Integer.parseInt(topEle) != 0)
                        ans = (int) Math.floor(Integer.parseInt(st.pop()) / Integer.parseInt(topEle));
                    else
                        st.pop();
                }

                st.push(ans.toString());
            } else {
                st.push(s);
            }

        }
        return st.isEmpty() ? 0 : Integer.parseInt(st.pop());

    }
}
