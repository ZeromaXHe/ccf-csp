//30分
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=scanner.nextInt();
		}
		for(int i=0;i<m;i++) {
			int op = scanner.nextInt();
			if(op==1) {
				int l = scanner.nextInt()-1;
				int r = scanner.nextInt()-1;
				int v = scanner.nextInt();
				for(int j=l;j<r+1;j++) {
					if(arr[j]%v==0) arr[j]/=v;
				}
			}
			else {
				int l = scanner.nextInt()-1;
				int r = scanner.nextInt()-1;
				int sum = 0;
				for(int j=l;j<r+1;j++) {
					sum+=arr[j];
				}
				System.out.println(sum);
			}
		}
		
		scanner.close();
	}
}