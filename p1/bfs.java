//Mark Garrett
//CSCI 433
//PA1
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class bfs {

    static int vertexCount;
    static int count;
    static int numberOfIslands;
    static int adjMatrix[][];
    static int treeEdges[][];
    static int crossEdges[][];
    static int visitedList[];
    

    public static void main(String[] args) throws FileNotFoundException {
        // read file
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a file name.");
        Scanner file = new Scanner(new File(keyboard.nextLine()));
        keyboard.close();
        ArrayList<String> lines = new ArrayList<String>();
        while (file.hasNext()) {
            lines.add(file.nextLine());
        }

        // setup
        int vertexCount = lines.size();
        adjMatrix = new int[vertexCount][vertexCount];
        treeEdges = new int[vertexCount][vertexCount];
        crossEdges = new int[vertexCount][vertexCount];
        count = 0;
        visitedList = new int[vertexCount];

        for (int i = 0; i < vertexCount; i++) {
            String line = lines.get(i);
            for (int j = 0; j < vertexCount; j++) {
                adjMatrix[i][j] = Character.getNumericValue(line.charAt(j * 2));
                treeEdges[i][j] = 0;
                crossEdges[i][j] = 0;
            }
        }

        for (int i = 0; i < vertexCount; i++) {
            visitedList[i] = 0;
        }


        // main for loop
        for(int i = 0; i < vertexCount; i++){
            if(visitedList[i]==0){
                bfs(i, vertexCount);
                numberOfIslands++;
            }
        }

        // fillter out false back edges
        crossEdges=adjMatrix.clone();
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                if(treeEdges[i][j]==1||treeEdges[j][i]==1||visitedList[i]>visitedList[j]){
                    crossEdges[i][j]=0;
                }
            }
        }

        // output
        System.out.println("First encountered :");

        for (int i = 0; i < vertexCount; i++) {
            System.out.print(visitedList[i] + " ");
        }
        System.out.print("\n");

        System.out.println("Number of connected componets: " + numberOfIslands);
        
        System.out.println("tree edges:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(treeEdges[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("cross edges:");
        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(crossEdges[i][j] + " ");
            }
            System.out.print("\n");
        }

        
    }

    public static void view(int[] a){
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.print("\n");
    }

    // bfs method
    public static void bfs(int vertex, int n){
        count++;
        visitedList[vertex]=count;
        iQueue vq = new iQueue();
        vq.add(vertex);
        while(vq.NotEmpty()){
            int front = vq.remove();
            for(int w = 0; w < n; w++){
                if(adjMatrix[front][w]==1&&visitedList[w]==0){
                    count++;
                    visitedList[w] = count;
                    treeEdges[front][w]=1;
                    vq.add(w);
                }
            }
        }
    }

}