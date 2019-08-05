import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] s = scanner.nextLine().toCharArray();
        int sum = 0;
        int count = 1;
        for(int i=0;i<11;i++){
            if(i==1||i==5) continue;
            sum+=(s[i]-'0')*count;
            count++;
        }
        char end = 'F';
        //System.out.println("sum:"+sum+" sum%11:"+sum%11);
        if(sum%11==10) end = 'X';
        else end = (char)('0'+sum%11);
        if(end == s[12]) System.out.print("Right");
        else {
            for(int i=0;i<12;i++){
                System.out.print(s[i]);
            }
            System.out.print(end);
        }

    }
}