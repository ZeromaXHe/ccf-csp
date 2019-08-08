//60分
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		boolean[][] knowNext = new boolean[n][n];
		boolean[][] knowPre = new boolean[n][n];

		for (int i = 0; i < m; i++) {
			int from = scanner.nextInt() - 1;
			int to = scanner.nextInt() - 1;
			knowNext[from][to] = knowPre[to][from] = true;
			for (int j = 0; j < n; j++) {
				if (knowNext[to][j])
					knowPre[j][from] = knowNext[from][j] = true;
				if (knowNext[j][from])
					knowPre[to][j] = knowNext[j][to] = true;
			}
			for (int j = 0; j < n; j++) {//这个循环以内的东西不加的话只有50分
				if (knowNext[to][j]) {
					for (int k = 0; k < n; k++) {
						if (knowNext[k][from])
							knowPre[j][k] = knowNext[k][j] = true;
					}
				}
			}
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (!knowNext[i][j] && !knowPre[i][j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				count++;
		}
		System.out.println(count);
		scanner.close();
	}
}