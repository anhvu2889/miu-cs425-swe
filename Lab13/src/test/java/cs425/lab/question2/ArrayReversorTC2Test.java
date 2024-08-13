package cs425.lab.question2;

import cs425.lab.question1.ArrayFlattener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;

public class ArrayReversorTC2Test {

    @Test
    public void should_returnEmptyArray_when_reverseArray() throws Exception {
        // given
        int [][] input = null;

        ArrayFlattenerService mockArrayFlattenerService = Mockito.mock(ArrayFlattenerService.class);
        PowerMockito.whenNew(ArrayFlattenerService.class).withNoArguments().thenReturn(mockArrayFlattenerService);

        Mockito.when(mockArrayFlattenerService.flattenArray(input)).thenReturn(new int[]{});

        // when
        int [] result = ArrayReversor.reverseArray(input);

        // then
        Assertions.assertEquals(0, result.length);
        Assertions.assertArrayEquals(new int[]{}, result);
    }
}
