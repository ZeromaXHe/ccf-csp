//100分
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int count = 0;
		while(n>=30) {
			if(n>=50) {
				n-=50;
				count+=7;
			}
			else {
				n-=30;
				count+=4;
			}
		}
		count+=n/10;
		System.out.println(count);
		scanner.close();
	}
}