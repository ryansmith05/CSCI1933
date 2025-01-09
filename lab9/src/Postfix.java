public class Postfix {
    public static double evaluate(String[] expression) {
        Stack<Double> stack = new Stack<Double>();
        try {
            for (String s : expression) {
                if (s.equals("+")) {
                    double first = stack.pop();
                    double second = stack.pop();
                    stack.push(first + second);
                } else if (s.equals("-")) {
                    double first = stack.pop();
                    double second = stack.pop();
                    stack.push(second - first);
                } else if (s.equals("/")) {
                    double first = stack.pop();
                    double second = stack.pop();
                    stack.push(second / first);
                } else if (s.equals("*")) {
                    double first = stack.pop();
                    double second = stack.pop();
                    stack.push(first * second);
                } else {
                    stack.push(Double.parseDouble(s));
                }
            }
            return stack.pop();
        } catch (StackException e) {
            System.out.println("Stack excpetion");
        } finally {
            System.out.println("Evaluation Complete");
        }
        return 0.0;
    }

    public static void main(String[] args){
        String[][] str = {
                {"5", "2", "+"},
                {"1", "2", "-"},
                {"4", "5", "*", "3", "+"},
                {"1", "2", "+", "3", "4", "+", "/"}
        };
        for (String[] exp : str){
            System.out.println("Answer: " + Postfix.evaluate(exp));
        }
    }
}
