//50分
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		System.out.println("a\\\\b\\\"".replaceAll("\\\\\\\"", "\\\"").replaceAll("\\\\\\\\", "\\\\"));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		scanner.nextLine();
		StringBuilder sb = new StringBuilder();
		String json = null;
		String query = null;
		for (int i = 0; i < n; i++) {
			sb.append(scanner.nextLine().trim());
		}
		json = sb.toString();
		//System.out.println(json);
		for (int i = 0; i < m; i++) {
			query = scanner.nextLine().trim().replaceAll("\\\\", "\\\\\\\\").replaceAll("\\\"", "\\\\\\\"");
			//System.out.println(query);
			String[] queryArr = query.split("\\.");
			//System.out.println(Arrays.toString(queryArr));
			int[] index = new int[queryArr.length];
			int p = 0;
			while(p<queryArr.length) {
				index[p] = json.indexOf(queryArr[p]);
				//System.out.println(index[p]);
				if(index[p]==-1
						||countBrace(json,true,false,index[p])-countBrace(json,true,true,index[p])!=p+1
						||countBrace(json,false,true,index[p])-countBrace(json,false,false,index[p])!=p+1
						||(p>0 && (index[p-1]<json.lastIndexOf('}',index[p])||index[p-1]>index[p]))) {
					System.out.println("NOTEXIST");
					break;
				}
				//System.out.println("确认存在");
				if(p==queryArr.length-1) {
					int isObj =isObject(json,index[p]+queryArr[p].length()+1); 
					if(isObj>(1<<30)) {
						System.out.println("OBJECT");
					}
					else {
						System.out.print("STRING ");
						int ptr = isObj+1;
						sb.delete(0,sb.length());
						while(ptr<json.length()&&json.charAt(ptr)!=','&&json.charAt(ptr)!='}') {
							sb.append(json.charAt(ptr));
							ptr++;
						}
						String s = sb.toString().trim();
						s = s.substring(0,s.length()-1).replaceAll("\\\\\\\"", "\\\"").replaceAll("\\\\\\\\", "\\\\");
						System.out.println(s);
					}
				}
				p++;
			}
		}

		scanner.close();
	}

	private static int countBrace(String json, boolean isAfter, boolean isLeft, int index) {
		int count = 0;
		char c = '}';
		if (isLeft)
			c = '{';
		if (isAfter) {
			while (json.indexOf(c, index+1) != -1) {
				index = json.indexOf(c, index+1);
				count++;
			}
		} else {
			while (json.lastIndexOf(c, index-1) != -1) {
				index = json.lastIndexOf(c, index-1);
				count++;
			}
		}
		return count;
	}
	
	private static int isObject(String json, int index){
		while(json.charAt(index)==' ') index++;
		if(json.charAt(index)==':') index++;
		else return -1;
		while(json.charAt(index)==' ') index++;
		if(json.charAt(index)=='{') return (1<<30)+index;
		else return index;
	}
}
