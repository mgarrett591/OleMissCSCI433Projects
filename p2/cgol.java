public class cgol{
    int grid[][];
    int I;
    int J;
    
    public cgol(int i, int j){
        grid = new int[i][j];
        I=i;
        J=j;
        clear();
    }

    public cgol(int gameBoard[][]){
        grid = gameBoard;
        I = gameBoard.length;
        J = gameBoard[0].length;
    }

    public int[][] getGen(){
        return grid;
    }

    public void setCell(int value, int i, int j){
        grid[i][j]=value%2;
    }

    public void exterminate(int i, int j){
        grid[i][j]=0;
    }

    public void clear() {
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                grid[i][j] = 0;
            }
        }
    }

    public void printWorld(){
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.print("\n");
        }
    }

    public void colonize(int i, int j){
        grid[i][j]=1;
    }

    public void nextGen(){
        int temp[][]=new int[I][J];
        for (int i = 0; i < I; i++) {
            for (int j = 0; j < J; j++) {
                int adj=0;
                adj+=grid[(i+1)%I][j];
                adj+=grid[(I+i-1)%I][j];
                adj+=grid[i][(j+1)%J];
                adj+=grid[i][(J+j-1)%J];

                adj+=grid[(i+1)%I][(j+1)%J];
                adj+=grid[(i+1)%I][(J+j-1)%J];
                adj+=grid[(I+i-1)%I][(j+1)%J];
                adj+=grid[(I+i-1)%I][(J+j-1)%J];
                if(adj==3||(grid[i][j]==1&&adj==2)){
                    temp[i][j]=1;
                }
                else{
                    temp[i][j]=0;
                }
            }
        }
        grid = temp;
    }
}