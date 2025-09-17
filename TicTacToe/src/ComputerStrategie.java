public class ComputerStrategie {
    boolean end=false;
    int cnt=0,cntO=0,cntX=0,cntEmpty=0,pos1=0,pos2=0;
    char [][] xo;
    public ComputerStrategie(char [][]xo){
        this.xo=xo;
    }
    void Reset(){
        cnt=cntO=cntEmpty=cntX=0;
    }
    boolean BlockOrWin(char [][]xo,char x){
        Reset();
        for(int i=1;i<4;i++){
            if(xo[i][i]==x){
                cnt++;
            }
            else if(xo[i][i]=='.'){
                cntEmpty++;
                pos1=i;
                pos2=i;
            }
        }
        if(cnt==2&&cntEmpty==1){
            xo[pos1][pos2]='o';
            return true;
        }
        Reset();
        for (int i = 1; i < 4; i++) {
            Reset();
            for(int j=1;j<4;j++){
                if(xo[j][i]==x){
                    cnt++;
                }
                else if(xo[j][i]=='.'){
                    cntEmpty++;
                    pos1=j;
                    pos2=i;
                }
            }
            if(cnt==2&&cntEmpty==1){
                xo[pos1][pos2]='o';
                return true;
            }
        }
        Reset();
        for (int i = 1; i < 4; i++) {
            Reset();
            for(int j=1;j<4;j++){
                if(xo[i][j]==x){
                    cnt++;
                }
                else if(xo[i][j]=='.'){
                    cntEmpty++;
                    pos1=i;
                    pos2=j;
                }
            }
            if(cnt==2&&cntEmpty==1){
                xo[pos1][pos2]='o';
                return true;
            }
        }
        int k=3;
        Reset();
        for(int i=1;i<4;i++){
            if(xo[i][k]==x){
                cnt++;
            }
            else if(xo[i][k]=='.'){
                cntEmpty++;
                pos1=i;
                pos2=k;
            }
            k--;
        }
        if(cnt==2&&cntEmpty==1){
            xo[pos1][pos2]='o';
            return true;
        }
        return false;
    }
    boolean WhatToPlay(char [][]xo){
        Reset();
        for(int i=1;i<4;i++){
            if(xo[i][i]=='o'){
                cntO++;
            }
            else if(xo[i][i]=='x'){
                cntX++;
            }
        }
        if(cntX==2&&cntO==1&&xo[2][2]=='o'&&xo[2][3]=='.'){
            xo[2][3]='o';
            return true;
        }
        int k=3;
        Reset();
        for(int i=1;i<4;i++){
            if(xo[i][k]=='x'){
                cntX++;
            }
            else if(xo[i][k]=='o'){
                cntO++;
            }
            k--;
        }
        if(cntX==2&&cntO==1&&xo[2][3]=='.'){
            xo[2][3]='o';
            return true;
        }
        if(xo[1][1]=='.'&&xo[1][2]=='x'&&xo[2][1]=='x'){
            xo[1][1]='o';
            return true;
        }
        if(xo[2][2]=='.'){
            xo[2][2]='o';
            return true;
        }
        for(int i=1;i<4;i+=2){
            Reset();
            for(int j=1;j<4;j+=2){
                if(xo[i][j]=='.'){
                    cntEmpty++;
                    pos1=i;
                    pos2=j;
                }
            }
        }
        if(cntEmpty>=1){
            xo[pos1][pos2]='o';
            return true;
        }
        for(int i=1;i<4;i++){
            for(int j=1;j<4;j++){
                if(xo[i][j]=='.'){
                    xo[i][j]='o';
                    return true;
                }
            }
        }
        return false;
    }
    public void Play(){
        end=false;
        if(BlockOrWin(xo,'o')){
            end=true;
        }
        else if(BlockOrWin(xo,'x')){
            end=true;
        }
        if(!end){
            WhatToPlay(xo);
        }
    }
}