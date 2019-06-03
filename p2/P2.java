
// Mark Garrett
// CSCI 433
// PA1
//
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class P2{
    public static void main(String[] args) throws FileNotFoundException{
        //read file
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a file name.");
        Scanner file = new Scanner(new File(keyboard.nextLine()));
        System.out.println("Enter a k-value.");
        int k=Integer.parseInt(keyboard.nextLine());
        keyboard.close();
        ArrayList<String[]> lines = new ArrayList<String[]>();
        while (file.hasNext()) {
            lines.add(file.nextLine().split(" "));
        }
        file.close();
        int N = lines.size();
        int M = lines.get(0).length;
        int[][] distanceMatrix = new int[N][M];
        int MaxLenght = 0;
        ArrayList<Integer> IMaxCords = new ArrayList<Integer>();
        ArrayList<Integer> JMaxCords = new ArrayList<Integer>();
        for(int i=0; i<N; i++){
            String[] temp = lines.get(i);
            for(int j=0; j<M; j++){
                if(Integer.parseInt(temp[j])<=k){
                    distanceMatrix[i][j]=0;
                }
                else if(i>0&&j>0){
                    distanceMatrix[i][j]=1+min(distanceMatrix[i-1][j], distanceMatrix[i][j-1], distanceMatrix[i-1][j-1]);
                }
                else{
                    distanceMatrix[i][j]=1;
                }
                if(distanceMatrix[i][j]==MaxLenght){
                    IMaxCords.add(i+1);
                    JMaxCords.add(j+1);
                }
                if(distanceMatrix[i][j]>MaxLenght){
                    MaxLenght=distanceMatrix[i][j];
                    IMaxCords.clear();
                    JMaxCords.clear();
                    IMaxCords.add(i+1);
                    JMaxCords.add(j+1);
                }
            }
        }
        file.close();
        System.out.println(MaxLenght);
        for(int i = 0; i<IMaxCords.size(); i++){
            System.out.println(IMaxCords.get(i)+" "+JMaxCords.get(i));
        }
    }

    public static int min(int a, int b, int c){
        if(a>b){
            if(b>c){
                return c;
            }
            return b;
        }
        else{
            if(a>c){
                return c;
            }
            return a;
        }
    }
}