package cs425.lab.question2;

import cs425.lab.question1.ArrayFlattener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

public class ArrayReversorTC1Test {

    @Test
    public void should_returnReversedArray_when_reverseArray() throws Exception {
        // given
        int [][] input = {{1, 3}, {0}, {4, 5, 9}};

        ArrayFlattenerService mockArrayFlattenerService = Mockito.mock(ArrayFlattenerService.class);
        PowerMockito.whenNew(ArrayFlattenerService.class).withNoArguments().thenReturn(mockArrayFlattenerService);

        Mockito.when(mockArrayFlattenerService.flattenArray(input)).thenReturn(new int[]{1,3,0,4, 5, 9});

        // when
        int [] result = ArrayReversor.reverseArray(input);

        // then
        Assertions.assertEquals(6, result.length);
        Assertions.assertArrayEquals(new int[]{9, 5, 4, 0, 3, 1}, result);
    }
}
