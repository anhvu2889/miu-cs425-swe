package cs425.lab.question1;

import java.util.Arrays;

public class ArrayFlattener {
    public static void main(String[] args) {
        int[][] a_in = {{1, 3}, {0}, {4, 5, 9}};
        int[] out = flattenArray(a_in);
        System.out.println(Arrays.toString(out));

        int[][] a_in2 = null;
        int[] out2 = flattenArray(a_in2);
        System.out.println(Arrays.toString(out2));
    }

    public static int[] flattenArray(int[][] arr) {
        if (arr == null) {
            return new int[0];
        }
        return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    }
}