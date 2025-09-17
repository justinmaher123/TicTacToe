import java.io.*;
import java.util.*;

public class TicTacToe {
    final static PrintWriter pw = new PrintWriter(System.out);
    final static Scanner sc = new Scanner(System.in);
    static char [][] xo=new char[4][4];
    static int cnt=0;
    public void increaseCnt(){
        cnt++;
    }
    void shape(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i==0&&j==0){
                    xo[i][j]=' ';
                }
                else{
                    if(i==0){
                        char temp =(char) ((j)+'0');
                        xo[i][j]=temp;
                    }
                    else if(j==0){
                        char temp =(char) ((i)+'0');
                        xo[i][j]=temp;
                    }
                    else{
                        xo[i][j]='.';
                    }
                }
            }
        }
    }
    void show(){
        for(int i = 0;i<4;i++){
            for(int j=0;j<4;j++){
                pw.print(xo[i][j]+" ");
            }
            pw.println();
        }
    }
    void needRow(String s){
        pw.println(s+"'s turn");
        pw.flush();
        pw.println("Choose 2 numbers for position");
        pw.flush();
        pw.print("Row: ");
        pw.flush();
    }
    void needColumn(){
        pw.print("Column: ");
        pw.flush();
    }
    void applyX(int pos1,int pos2){
        xo[pos1][pos2]='x';
        cnt++;
    }
    void applyO(int pos1,int pos2){
        xo[pos1][pos2]='o';
        cnt++;
    }
    void won(String s){
        pw.println(s+" won");
        pw.flush();
    }
    void draw(){
        pw.println("it is a draw");
        pw.flush();
    }
    public static void main(String[] args) throws IOException {
        // start your code here
        TicTacToe project = new TicTacToe();
        ComputerStrategie computer=new ComputerStrategie(xo);
        Check check=new Check(xo);
        int num_of_players;
        int pos1;
        int pos2;
        project.shape();
        do{
            pw.println("for 1 player enter 1 ,for 2 players enter 2: ");
            pw.flush();
            num_of_players=sc.nextInt();
        } while(!check.ValidNum(num_of_players));
        if(num_of_players==1){
            while(!check.Winner('o')){
                do{
                    project.show();
                    pw.println("Choose 2 numbers for position");
                    pw.flush();
                    pw.println("Row:");
                    pw.flush();
                    pos1= sc.nextInt();
                    pw.println("Column:");
                    pw.flush();
                    pos2= sc.nextInt();
                }while(!check.ValidPos(pos1,pos2));
                project.applyX(pos1,pos2);
                if(check.Winner('x')){
                    project.won("you");
                    project.show();
                    break;
                }
                if(check.Draw(cnt)){
                    project.draw();
                    project.show();
                    break;
                }
                computer.Play();
                project.increaseCnt();
                if(check.Winner('o')){
                    project.won("computer");
                    project.show();
                    break;
                }
            }
        }
        else{
            pw.println("Player 1 name: ");
            pw.flush();
            String player1= sc.nextLine();
            pw.println("Player 2 name: ");
            pw.flush();
            String player2= sc.nextLine();
            while(!check.Winner('o')){
                do{
                    project.show();
                    project.needRow(player1);
                    pos1= sc.nextInt();
                    project.needColumn();
                    pos2= sc.nextInt();
                }while(!check.ValidPos(pos1,pos2));
                project.applyX(pos1,pos2);
                if(check.Winner('x')){
                    project.won(player1);
                    project.show();
                    break;
                }
                if(check.Draw(cnt)){
                    project.draw();
                    project.show();
                    break;
                }
                do{
                    project.show();
                    project.needRow(player2);
                    pos1= sc.nextInt();
                    project.needColumn();
                    pos2= sc.nextInt();
                }while(!check.ValidPos(pos1,pos2));
                project.applyO(pos1,pos2);
                if(check.Winner('o')){
                    project.won(player2);
                    project.show();
                    break;
                }
            }
        }
        pw.close();
    }

    static class Scanner {

        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
        public Scanner(String file) throws IOException {
            br = new BufferedReader(new FileReader(file));
        }
        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        public String readAllLines(BufferedReader reader) throws IOException {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }
            return content.toString();
        }
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public String nextLine() throws IOException {
            return br.readLine();
        }
        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
        public long[] nextlongArray(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        public Long[] nextLongArray(int n) throws IOException {
            Long[] a = new Long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        public int[] nextIntArray(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public Integer[] nextIntegerArray(int n) throws IOException {
            Integer[] a = new Integer[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }
        public boolean ready() throws IOException {
            return br.ready();
        }

    }
}
