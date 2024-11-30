package problems.matrix;

public class ChristmasTree {

//          *
//         ***
//        *****
//       *******
//      *********
//     ***********
//    *************
//   ***************
//  *****************
// *******************

    public static void main(String[] args) {
        var s = new ChristmasTree();
        s.createTree(100);
    }


    public void createTree(int height) {
        int width = height * 2;
        int gap = height - 1;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j - gap >= 0 && j < width - 1 - gap) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            gap = gap - 1;
            System.out.println();
        }
    }
}
