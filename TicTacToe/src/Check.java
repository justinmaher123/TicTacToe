public class Check {
    char[][]xo;
    public Check(char[][]xo){
        this.xo=xo;
    }
    boolean Winner(char turn){
        for (int j = 1; j < 4; j++) {
            if(xo[1][j]==turn&&xo[2][j]==turn&&xo[3][j]==turn){
                return true;
            }
            if(xo[j][1]==turn&&xo[j][2]==turn&&xo[j][3]==turn){
                return true;
            }
        }
        if(xo[1][1]==turn&&xo[2][2]==turn&&xo[3][3]==turn||xo[1][3]==turn&&xo[2][2]==turn&&xo[3][1]==turn){
            return true;
        }
        return false;
    }
    boolean Draw(int cnt){
        if(cnt==9){
            return true;
        }
        return false;
    }
    boolean ValidNum(int num_of_players){
        if(num_of_players==1) return true;
        else if(num_of_players==2) return true;
        return false;
    }
    boolean ValidPos(int pos1, int pos2){
        if(pos1>3||pos2>3||pos1<1||pos2<1||xo[pos1][pos2]!='.'){
            return false;
        }
        return true;
    }
}
