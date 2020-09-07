import java.util.Stack;

public class StackToQueue {
    private Stack<Integer> a;
    private Stack<Integer> b;

    public StackToQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }

    public void push(int x){
        a.push(x);
    }

    public int pop(){
        if (b.isEmpty()){
            while (!a.isEmpty()){
                b.push(a.pop());
            }
        }
        return b.pop();
    }

    public int peek(){
        if (b.isEmpty()) {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
        }
        return b.peek();
    }

    public boolean empty(){
        return a.isEmpty() && b.isEmpty();
    }

    public static void main(String[] args){
        StackToQueue stacki = new StackToQueue();
        stacki.push(1);
        stacki.push(13);
        stacki.pop();
        stacki.pop();
        stacki.empty();

        stacki.push(12);
        stacki.push(3);
        stacki.push(43);
        while (!stacki.empty()) {
            System.out.println(stacki.pop());
        }
    }
}
