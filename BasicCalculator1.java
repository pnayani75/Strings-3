class BasicCalculator1 {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int calc = 0;
        int curr = 0;
        char last = '+';
        for(int i=0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = 10*curr + c-'0';
            }
            if(c=='+' || c=='-'|| (i==s.length()-1 && s.charAt(i) != ')')){
                if(last=='+'){
                    st.push(curr);
                } else if(last=='-'){
                    st.push(-curr);
                } else {
                    st.push(curr);
                }
                curr = 0;
                last = c;
            }
            if(c=='('){
                if(last == '+'){
                    st.push(1);
                } else {
                    st.push(-1);
                }
                st.push(Integer.MAX_VALUE);
                curr = 0;
                last = '+';
            }
            if(c==')'){
                int intResult = 0;
                if(last == '+'){
                    st.push(curr);
                } else if(last == '-'){
                    st.push(-curr);
                }
                while(st.peek() != Integer.MAX_VALUE){
                    intResult += st.pop();
                }
                st.pop();
                st.push(st.pop()*intResult);
                curr = 0;
                last = '+';
            }
        }
        while(!st.isEmpty()){
            calc = calc + st.pop();
        }
        return calc;
    }
}
