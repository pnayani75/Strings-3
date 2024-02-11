//TC: o(n) SC: o(1)
class BasicCalculator2 {
    public int calculate(String s) {
        s = s.trim();
        int tail = 0; int calc = 0; int curr = 0;
        char lastExp = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10 + c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastExp == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                if(lastExp == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                if(lastExp == '*'){
                    calc = calc - tail + tail*curr;
                    tail = tail*curr;
                }
                if(lastExp == '/'){
                    calc = calc - tail + tail/curr;
                    tail = tail/curr;
                }
                curr = 0;
                lastExp = c;
            }
        }
        return calc;
    }
}


//TC: o(n) SC: o(n)
class BasicCalculator2 {
    public int calculate(String s) {
        s = s.trim();
        int calc = 0; int curr = 0;
        Stack<Integer> st = new Stack<>();
        char lastExp = '+';
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr*10 + c-'0';
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastExp == '+'){
                    st.push(curr);
                }
                if(lastExp == '-'){
                    st.push(-curr);
                }
                if(lastExp == '*'){
                    st.push(st.pop()*curr);
                }
                if(lastExp == '/'){
                    st.push(st.pop()/curr);
                }
                curr = 0;
                lastExp = c;
            }
        }
        while(!st.isEmpty()){
            calc += st.pop();
        }
        return calc;
    }
}


