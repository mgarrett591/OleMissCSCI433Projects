//Mark Garrett
//CSCI 433
//PA1
//
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;



public class dfs{ 
    
    static int vertexCount;
    static int count;
    static int numberOfIslands;
    static int adjMatrix[][];
    static int treeEdges[][];
    static int backEdges[][];
    static int visitedList[];
    static int deadCount;
    static int deadEndList[];

    public static void main(String[] args)throws FileNotFoundException {
        //read file
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a file name.");
        Scanner file = new Scanner(new File(keyboard.nextLine()));
        keyboard.close();
        ArrayList<String> lines = new ArrayList<String>();
        while(file.hasNext()){
            lines.add(file.nextLine());
        }

        //setup
        int vertexCount = lines.size();
        adjMatrix = new int[vertexCount][vertexCount];
        treeEdges = new int[vertexCount][vertexCount];
        backEdges = new int[vertexCount][vertexCount];
        count = 0;
        visitedList = new int[vertexCount];
        deadEndList = new int[vertexCount];
        deadCount = 1;

        for(int i = 0; i < vertexCount; i++){
            String line=lines.get(i);
            for(int j = 0; j < vertexCount; j++){
                adjMatrix[i][j] = Character.getNumericValue(line.charAt(j*2));
                treeEdges[i][j] = 0;
                backEdges[i][j] = 0;
            }
        }
        
        for(int i = 0; i < vertexCount; i++){
            visitedList[i]=0;
            deadEndList[i]=0;
        }
        
        //main for loop
        numberOfIslands=0;
        for(int i=0; i < vertexCount; i++){
            if(visitedList[i]==0){
                numberOfIslands++;
                dfs(i, vertexCount);
            }
        }

        // fillter out false back edges
        backEdges = adjMatrix.clone();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if (treeEdges[i][j] == 1 || treeEdges[j][i] == 1 || visitedList[i] < visitedList[j]) {
                    backEdges[i][j] = 0;
                }
            }
        }
        
        //output
        System.out.println("First encountered :");

        for (int i = 0; i < vertexCount; i++) {
            System.out.print(visitedList[i] + " ");
        }
        System.out.print("\n");

        System.out.println("First dead:");
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(deadEndList[i] + " ");
        }
        System.out.print("\n");

        System.out.println("Number of connected componets: "+numberOfIslands);

        System.out.println("tree edges:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(treeEdges[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("back edges:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(backEdges[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    //dfs method
    public static void dfs(int vertex, int n){
        count++;
        visitedList[vertex] = count;
        for (int i = 0; i < n; i++) {
            if ((adjMatrix[vertex][i] == 1) && (visitedList[i] == 0)) {
                treeEdges[vertex][i]=1;
                dfs(i, n);
            }
            else if ((adjMatrix[vertex][i] == 1)){
                backEdges[vertex][i] = 1;
            }
        }
        deadEndList[vertex]=deadCount;
        deadCount++;
    }

}