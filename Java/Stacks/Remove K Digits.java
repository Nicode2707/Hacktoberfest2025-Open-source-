class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            while (!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }
        
        // If still k > 0, remove from end
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }
        
        // Build the result
        StringBuilder res = new StringBuilder();
        while (!st.isEmpty()) {
            res.append(st.pop());
        }
        
        res.reverse();
        
        // Remove leading zeros
        while (res.length() > 1 && res.charAt(0) == '0') {
            res.deleteCharAt(0);
        }
        
        return res.length() == 0 ? "0" : res.toString();
    }
}
