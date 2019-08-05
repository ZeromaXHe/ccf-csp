//100分（x错写成*就只有40分）
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		char[] chars = null;

		LinkedList<Character> opStack = new LinkedList<>();
		//LinkedList<Float> postStack = new LinkedList<>();
		LinkedList<Integer> postStack = new LinkedList<>();
		for (int i = 0; i < num; i++) {
			chars = scanner.next().trim().toCharArray();
			int p = 0;

			// 一、中缀表达式需要转换成后缀表达式，转换算法：
			// 1、遇到操作数：直接输出（添加到后缀表达式中）
			// 2、栈为空时，遇到运算符：直接入栈
			// 3、遇到左括号：将其入栈
			// 4、遇到右括号：执行出栈操作，并将出栈的元素输出，直到弹出栈的是左括号，左括号不输出。
			// 5、遇到其他运算符，加减乘除：弹出所有优先级大于或者等于该运算符的栈顶元素，然后将该运算符入栈
			// 6、最终将栈中的元素依次出栈，输出。
			// 例如：a+b*c+(d*e+f)*g ----> abc*+de*f+g*+

			for (int j = 0; j < 7; j++) {
				if (Character.isDigit(chars[j])) {
					chars[p] = chars[j];
					p++;
				} else {
					if (chars[j] == 'x' || chars[j] == '/') {
						while (!opStack.isEmpty() && (opStack.peek() == 'x' || opStack.peek() == '/')) {
							chars[p] = opStack.pop();
							p++;
						}
					} else {
						while (!opStack.isEmpty()) {
							chars[p] = opStack.pop();
							p++;
						}
					}
					opStack.push(chars[j]);
				}
			}
			while (!opStack.isEmpty()) {
				chars[p] = opStack.pop();
				p++;
			}

			// 二、后缀表达式求值：
			// 1、设置一个栈，开始时，栈为空；
			// 2、然后从左到右扫描后缀表达式，若遇操作数，则进栈；
			// 3、若遇运算符，则从栈中退出两个元素，先退出的放到运算符的右边，后退出的放到运算符左边，运算后的结果再进栈，直到后缀表达式扫描完毕；
			// 4、最后，栈中仅有一个元素，即为运算的结果。
			//
			//一开始弄错了，没注意到除法在这里就是整除的意思
			// for (int j = 0; j < 7; j++) {
			// 	if (Character.isDigit(chars[j])) {
			// 		postStack.push((float) (chars[j] - '0'));
			// 	} else {
			// 		float first = postStack.pop();
			// 		float second = postStack.pop();
					
			// 		switch (chars[j]) {
			// 		case '+':
			// 			postStack.push(second + first);
			// 			break;
			// 		case '-':
			// 			postStack.push(second - first);
			// 			break;
			// 		case '*':
			// 			postStack.push(second * first);
			// 			break;
			// 		case '/':
			// 			postStack.push(second / first);
			// 			break;
			// 		}
			// 	}
			// }
			// if(Math.abs(postStack.pop()-24)<0.001) System.out.println("Yes");
			// else System.out.println("No");
			for (int j = 0; j < 7; j++) {
				if (Character.isDigit(chars[j])) {
					postStack.push(chars[j] - '0');
				} else {
					int first = postStack.pop();
					int second = postStack.pop();
					
					switch (chars[j]) {
					case '+':
						postStack.push(second + first);
						break;
					case '-':
						postStack.push(second - first);
						break;
					case 'x':
						postStack.push(second * first);
						break;
					case '/':
						postStack.push(second / first);
						break;
					}
				}
			}
			if(postStack.pop()==24) System.out.println("Yes");
			else System.out.println("No");
		}

	}
}