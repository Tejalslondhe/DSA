import java.util.Stack;
public class InfixToPostfix {

	    public static boolean isOperand(char ch) {
	        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9');
	    }

	    public static int precedence(char ch) {
	        switch (ch) {
	            case '+':
	            case '-':
	                return 1;
	            case '*':
	            case '/':
	                return 2;
	            case '^':
	                return 3;
	        }
	        return -1;
	    }

	    public static String infixToPostfix(String exp) {
	        StringBuilder postfix = new StringBuilder();
	        Stack<Character> s = new Stack<>();

	        for (int i = 0; i < exp.length(); ++i) {
	            
	        	char ch = exp.charAt(i);

	            if (isOperand(ch)) {
	                postfix.append(ch);
	            } else if (ch == '(') {
	                s.push(ch);
	            } else if (ch == ')') {
	                while (!s.isEmpty() && s.peek() != '(') {
	                    postfix.append(s.pop());
	                }
	                s.pop(); // pop the '('
	            } else {
	                while (!s.isEmpty() && precedence(ch) <= precedence(s.peek())) {
	                    postfix.append(s.pop());
	                }
	                s.push(ch);
	            }
	        }

	        while (!s.isEmpty()) {
	            postfix.append(s.pop());
	        }

	        return postfix.toString();
	    }

	    public static void main(String[] args) {
	        String exp = "a+b*c-d";
	        System.out.println("Infix expression: " + exp);
	        System.out.println("Postfix expression: " + infixToPostfix(exp));
	    }
	

}
