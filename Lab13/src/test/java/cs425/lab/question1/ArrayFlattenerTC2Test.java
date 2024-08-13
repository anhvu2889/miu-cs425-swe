package cs425.lab.question1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayFlattenerTC2Test {

    @Test
    public void should_returnEmptyArray_when_flattenArray() {
        // given
        int [][] input = null;

        // when
        int [] result = ArrayFlattener.flattenArray(input);

        // then
        Assertions.assertEquals(0, result.length);
        Assertions.assertArrayEquals(new int[]{}, result);
    }
}
