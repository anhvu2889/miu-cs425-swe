package cs425.lab.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerTC1Test {

    @Test
    public void should_returnSingleArray_when_flattenArray() {
        // given
        int [][] input = {{1, 3}, {0}, {4, 5, 9}};

        // when
        int [] result = ArrayFlattener.flattenArray(input);

        // then
        Assertions.assertEquals(6, result.length);
        Assertions.assertArrayEquals(new int[]{1,3,0,4, 5, 9}, result);
    }
}
