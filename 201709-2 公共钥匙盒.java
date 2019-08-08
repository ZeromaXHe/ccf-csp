//100分
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int w;
		int s;
		int c;
		int[] hook = new int[n];
		ArrayList<Node> al = new ArrayList<>(2*k);
		
		for(int i = 0 ; i<n;i++) {
			hook[i]=i;
		}
		for(int i=0;i<k;i++) {
			w = scanner.nextInt();
			s = scanner.nextInt();
			c = scanner.nextInt();
			Node nodeGet = new Node(s,2,w-1);
			Node nodeRtn = new Node(s+c,1,w-1);
			int getIndex = Collections.binarySearch(al, nodeGet);
			if(getIndex<0) getIndex = -(getIndex+1);
			al.add(getIndex,nodeGet);
			int rtnIndex = Collections.binarySearch(al, nodeRtn);
			if(rtnIndex<0) rtnIndex = -(rtnIndex+1);
			al.add(rtnIndex,nodeRtn);
		}
		
		scanner.close();
		
		for(int i=0;i<2*k;i++) {
			if(al.get(i).action==1) {
				for(int j=0;j<n;j++) {
					if(hook[j]==-1) {
						hook[j]=al.get(i).keynum;
						break;
					}
				}
			}
			else {
				for(int j=0;j<n;j++) {
					if(hook[j]==al.get(i).keynum) {
						hook[j]=-1;
						break;
					}
				}
			}
//			for(int j=0;j<n;j++) {
//				if(j>0) System.out.print(" ");
//				System.out.print(hook[j]+1);
//			}
//			System.out.println();
//			System.out.println("---------");
		}
		
		for(int i=0;i<n;i++) {
			if(i>0) System.out.print(" ");
			System.out.print(hook[i]+1);
		}
		
	}
}

class Node implements Comparable<Node>{
	public int time;
	public int action;//1代表还，2代表取
	public int keynum;
	
	public Node(int time, int action, int keynum) {
		this.time = time;
		this.action = action;
		this.keynum = keynum;
	}
	
	public int compareTo(Node o) {
		if(this.time!=o.time) return this.time-o.time;
		else if(this.action!=o.action) return this.action-o.action;
		else return this.keynum-o.keynum;
	};
}