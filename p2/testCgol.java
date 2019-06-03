public class testCgol{
    public static void main(String[] args){
        cgol theWorld = new cgol(6, 9);
        theWorld.colonize(2, 2);
        theWorld.colonize(2, 6);
        theWorld.colonize(4, 2);
        theWorld.colonize(3, 7);
        theWorld.colonize(4, 7);
        theWorld.colonize(5, 7);
        theWorld.colonize(5, 6);
        theWorld.colonize(5, 5);
        theWorld.colonize(5, 4);
        theWorld.colonize(5, 3);
        theWorld.printWorld();
        System.out.println();
        int time = Integer.parseInt(args[0]);
        for(int i=0; i<time; i++){
            theWorld.nextGen();
            //theWorld.printWorld();
            //System.out.println();
        }
        theWorld.printWorld();
    }
}