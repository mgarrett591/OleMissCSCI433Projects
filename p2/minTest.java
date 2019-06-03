public class minTest{
    public static void main(String[] args){
        System.out.println(min(1,2,3));
        System.out.println(min(2,1,3));
        System.out.println(min(3,1,2));
        System.out.println(min(3,2,1));
        System.out.println(min(1,3,2));
        System.out.println(min(2,3,1));

        System.out.println(min(1,2,2));
        System.out.println(min(2,1,2));
        System.out.println(min(2,2,1));
        
        System.out.println(min(1,1,1));

        String three = "1 2 3";
        String four = "1 2 3 ";
        String Four = "1 2 3 4";
        String[] Sthree = three.split(" ");
        String[] Sfour = four.split(" ");
        String[] SFour = Four.split(" ");

        System.out.println(Sthree.length);
        System.out.println(Sfour.length);
        System.out.println(SFour.length);
    }

    public static int min(int a, int b, int c) {
        if (a > b) {
            if (b > c) {
                return c;
            }
            return b;
        } else {
            if (a > c) {
                return c;
            }
            return a;
        }
    }
}