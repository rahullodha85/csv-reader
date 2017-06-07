import java.io.*;
import java.util.Hashtable;

public class test {
    public static void main(String[] args) throws IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String s=args[0];
        int[][] grid = new int[9][9];
        String[] temp = {""};
        temp = s.split(",");
        Hashtable<Integer,Integer> rowValid = new Hashtable<>();
//        while ((s = in.readLine()) != null) {
//            System.out.println(s);
//            temp = s.split(",");
//            System.out.print("hello");
//        }
        int row = 0;
        int col = 0;
        for(int i = 0; i<temp.length; i++){
            if(col != 0 && col % 9 == 0) {
                row++;
                col = 0;
            }
            grid[row][col] = Integer.parseInt(temp[i]);
            col++;
        }
        System.out.print(isValid(grid));
    }

    public static boolean isValid(int[][] grid){
        int sum = 0;
        for(int row = 0; row<9; row++){
            sum =0;
            for(int col = 0; col<9;col++){
                sum = sum + grid[row][col];
            }
            if(sum != 45){
                return false;
            }
        }
        for(int col = 0; col<9; col++){
            sum = 0;
            for(int row = 0; row<9; row++){
                sum = sum + grid[row][col];
            }
            if(sum != 45){
                return false;
            }
        }

        for(int block = 0; block < 9; block++){
            sum = 0;
            for(int row = block/3*3; row < block/3* 3 + 3; row++){
                for (int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
                    sum = sum + grid[row][col];
                }
            }
            if(sum !=45)
                return false;
        }
        return true;
    }
}
