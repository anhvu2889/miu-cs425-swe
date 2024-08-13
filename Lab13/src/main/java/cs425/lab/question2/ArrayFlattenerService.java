package cs425.lab.question2;

import java.util.Arrays;

public class ArrayFlattenerService {

    public int[] flattenArray(int[][] arr) {
        if (arr == null) {
            return new int[0];
        }
        return Arrays.stream(arr).flatMapToInt(Arrays::stream).toArray();
    }

}
