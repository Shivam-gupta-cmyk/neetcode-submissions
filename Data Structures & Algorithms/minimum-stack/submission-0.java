class MinStack {
    Stack<Integer> st ;
        Stack<Integer> min;

        public MinStack() {
            st = new Stack<>();
            min = new Stack<>();
        }

        public void push(int val) {
            if(!st.isEmpty()){
                if(min.peek()<val){
                   min.push(min.peek());
                   st.push(val);
                   return;
                }
            }
            st.push(val);
            min.push(val);
            
        }

        public void pop() {
            if(!st.isEmpty()){
                st.pop();
                min.pop();
            }
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return min.peek();
        }
}
