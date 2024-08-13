package cs425.lab.question2;

import java.util.Arrays;

public class ArrayReversor {

    public static void main(String[] args) {
        int [] result =  reverseArray(new int[][]{{1, 3}, {0}, {4, 5, 9}});
        System.out.println(Arrays.toString(result));

        int [] result2 =  reverseArray(null);
        System.out.println(Arrays.toString(result2));
    }

    public static int[] reverseArray(int[][] input) {
        ArrayFlattenerService arrayFlattenerService = new ArrayFlattenerService();
        int [] flattenArray = arrayFlattenerService.flattenArray(input);

        int[] result = new int[flattenArray.length];
        int index = 0;
        for (int i = flattenArray.length - 1; i >= 0; i--) {
            result[index] = flattenArray[i];
            index++;
        }
        return result;
    }
}
