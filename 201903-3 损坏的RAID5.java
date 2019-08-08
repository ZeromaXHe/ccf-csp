//30分
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();//硬盘的数目
		int s = scanner.nextInt();//阵列的条带大小
		int l = scanner.nextInt();//现存的硬盘数目
		String[] strs = new String[n];
		for(int i=0;i<l;i++) {
			strs[scanner.nextInt()]=scanner.next();
		}
		int len = 0;
		for(int i=0;i<l;i++) {
			if(strs[i]!=null) {
				len = strs[i].length();
				break;
			}
		}
		int m = scanner.nextInt();
		for(int i=0;i<m;i++) {
			int check = scanner.nextInt();
			int start = (check/((n-1)*s))*s+check%s*8;
			if((strs[check/s%n]==null&&l<n-1)||check/s*8>=len) System.out.println("-");
			else if((strs[check/s%n]!=null)){
				System.out.println(strs[check/s%n].substring(start,start+8));
			}
			else {
				String s1 = null;
				for(int j=0;j<n;j++) {
					if(strs[j]!=null) {
						s1=calcXOR(strs[j].substring(start,start+8),s1);
					}
				}
				System.out.println(s1);
			}
		}
	}
	
	private static String calcXOR(String s1,String s2) {
		if(s2==null) return s1;
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s1.length();i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			int i1 = Character.isDigit(c1)?(c1-'0'):(c1-'A'+10);
			int i2 = Character.isDigit(c2)?(c2-'0'):(c2-'A'+10);
			int res = i1^i2;
			char c = (res>=10)?(char)(res-10+'A'):(char)(res+'0');
			sb.append(c);
		}
		return sb.toString();
	}
}
// 样例1：
// 2 1 2
// 0 000102030405060710111213141516172021222324252627
// 1 000102030405060710111213141516172021222324252627
// 2
// 0
// 1

// 样例2：
// 3 2 2
// 0 000102030405060710111213141516172021222324252627
// 1 A0A1A2A3A4A5A6A7B0B1B2B3B4B5B6B7C0C1C2C3C4C5C6C7
// 2
// 2
// 5
