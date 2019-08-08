//60分，运行超时
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int n = scanner.nextInt();
		scanner.nextLine();

		ArrayList<LinkedList<String>> list = new ArrayList<>(n);

		for (int i = 0; i < n; i++) {
			list.add(new LinkedList<String>());
		}

		for (int i = 0; i < T; i++) {
			for (int j = 0; j < n; j++) {
				list.get(j).clear();
				String[] strs = scanner.nextLine().trim().split("\\s+");
				for (String s : strs) {
					//System.out.println(s);
					list.get(j).add(s);
				}
			}
			//System.out.println(list);
			
			boolean flag = false;
			while (!isSubListEmpty(list)) {
				flag=false;
				for(int j=0;j<list.size();j++) {
					LinkedList<String> ll=list.get(j);
					if(ll.isEmpty()||ll.peekFirst().charAt(0)=='R') continue;
					else {
						int sendTo = Integer.parseInt(ll.peekFirst().substring(1));
//						System.out.println("判断："+("R"+sendTo)+"是否等于"+list.get(sendTo).peekFirst()
//								+"  "+("R"+sendTo).equals(list.get(sendTo).peekFirst()));
						if(("R"+j).equals(list.get(sendTo).peekFirst())){
							list.get(sendTo).pollFirst();
							ll.pollFirst();
							flag = true;
							break;
						}
						else {
							continue;
						}
					}
				}
				if(!flag) {
					break;
				}
				//System.out.println(list);
			}
			if(flag) {
				System.out.println("0");
			}
			else {
				System.out.println("1");
			}

		}
		scanner.close();
	}

	private static <T> boolean isSubListEmpty(ArrayList<LinkedList<T>> list) {
		for (int i = 0; i < list.size(); i++) {
			if (!list.get(i).isEmpty())
				return false;
		}
		return true;
	}
}
//样例1：
//3 2
//R1 S1
//S0 R0
//R1 S1
//R0 S0
//R1 R1 R1 R1 S1 S1 S1 S1
//S0 S0 S0 S0 R0 R0 R0 R0
//样例2：
//2 3
//R1 S1
//R2 S0 R0 S2
//S1 R1
//R1
//R2 S0 R0
//S1 R1