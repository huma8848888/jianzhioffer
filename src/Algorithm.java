import java.util.Stack;

public class Algorithm {

    static Stack<Integer> numStack = new Stack<>();
    static Stack<Integer> minStack = new Stack<>();
    static int min;
    static boolean isStarted = false;

    public static void main(String[] args) {
        pushNum(3);
        pushNum(4);
        pushNum(2);
        pushNum(1);
        popNum();
        popNum();
        System.out.printf(getMinNum() + "");
    }


    private static int getMinNum() {
        if (minStack.isEmpty()) {
            return -1;
        } else {
            return minStack.pop();
        }
    }

    private static void pushNum(int num) {
        if (!isStarted) {
            min = num;
            isStarted = true;
        }
        if (num < min) {
            min = num;
        }
        numStack.push(num);
        minStack.push(min);
    }

    private static int popNum() {
        minStack.pop();
        return numStack.pop();
    }


}
