import java.util.*;

class MinStack {

    Stack<Long> st;
    long mini;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {

        long value = val;

        if (st.isEmpty()) {
            st.push(value);
            mini = value;
        }

        else if (value >= mini) {
            st.push(value);
        }

        else {
            st.push(2 * value - mini);
            mini = value;
        }
    }
    
    public void pop() {

        if (st.isEmpty()) {
            return;
        }

        long top = st.pop();

        if (top < mini) {
            mini = 2 * mini - top;
        }
    }
    
    public int top() {

        long top = st.peek();

        if (top >= mini) {
            return (int) top;
        }

        return (int) mini;
    }
    
    public int getMin() {
        return (int) mini;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */