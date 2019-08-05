//90分
import java.util.Scanner;

public class Main {
    private static char[][] map;
    private static int[][] visit;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        map = new char[row][];
        visit = new int[row][col];
        int sX = -1;
        int sY = -1;
        int tX = -1;
        int tY = -1;
        for(int i=0;i<row;i++){
            String s = scanner.nextLine();
            //System.out.println(s);
            if("".equals(s)){
                i--;
                continue;
            }
            map[i]=s.trim().toCharArray();
            for(int j=0;j<col;j++){
                if(map[i][j]=='S') {
                    sX = i;
                    sY = j;
                }
                else if(map[i][j]=='T'){
                    tX = i;
                    tY = j;
                }
            }
        }
        dfsS(sX,sY);
        dfsT(tX,tY);
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++) {
                //System.out.print(visit[i][j]+" ");
                if(visit[i][j]==1) count++;
            }
            //System.out.println();
        }
        System.out.println(count);
    }

    private static void dfsS(int x, int y){
        if((visit[x][y]& 1)==1||map[x][y]=='#') return;
        else{
            visit[x][y]+=1;

            if(map[x][y]=='|'||map[x][y]=='.'){
                if(x+1<map.length) dfsS(x+1,y);
                if(map[x][y]=='|'){
                    if(x-1>=0) dfsS(x-1,y);
                }
            }
            else {
                if(y-1>=0) dfsS(x,y-1);
                if(y+1<map[0].length) dfsS(x,y+1);
                if(map[x][y]!='-'){
                    if(x-1>=0) dfsS(x-1,y);
                    if(x+1<map.length) dfsS(x+1,y);
                }
            }


        }
    }

    private static void dfsT(int x, int y){
        if((visit[x][y]& 2)==2||map[x][y]=='#') return;
        else {
            visit[x][y]+=2;
            if(x+1<map.length && (map[x+1][y]=='+'||map[x+1][y]=='|'||map[x+1][y]=='S')){
                dfsT(x+1,y);
            }
            if(x-1>=0 && (map[x-1][y]=='+' || map[x-1][y]=='|' || map[x-1][y]=='S' || map[x-1][y]=='.')){
                dfsT(x-1,y);
            }
            if(y-1>=0 && (map[x][y-1]=='-' || map[x][y-1]=='+' || map[x][y-1]=='S')) {
                dfsT(x,y-1);
            }
            if(y+1<map[0].length && (map[x][y+1]=='+' || map[x][y+1]=='-' || map[x][y+1]=='S')){
                dfsT(x,y+1);
            }
        }
    }
}