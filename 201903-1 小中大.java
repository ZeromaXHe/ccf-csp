//100分；如果没注意保留1位小数(四舍五入貌似没有意义），80分
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int[] arr = new int[num];
		for(int i=0;i<num;i++) {
//			int current = scanner.nextInt();
//			if(current>max) {
//				max = current;
//			}
//			if(current<min) {
//				min = current;
//			}
			arr[i]=scanner.nextInt();
		}
		Arrays.sort(arr);
		// System.out.print(arr[num-1]+" "+((num%2==0)?(arr[num/2]+arr[num/2-1])/2:arr[num/2])+" "+arr[0]);
		if(num%2==1)System.out.print(arr[num-1]+" "+arr[num/2]+" "+arr[0]);
		else if((arr[num/2]+arr[num/2-1])%2==1)System.out.printf("%d %.1f %d",arr[num-1],(arr[num/2]+arr[num/2-1])/2.0,arr[0]);
		else System.out.printf("%d %d %d",arr[num-1],(arr[num/2]+arr[num/2-1])/2,arr[0]);
	}
}