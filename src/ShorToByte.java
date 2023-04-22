import org.junit.Assert;
import org.junit.Test;

public class ShorToByte {

    public byte[] transformaArrayParaBytes(short[] array, ShortToByteFunction function) {
        byte[] transformedArray = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = function.applyAsByte(array[i]);
        }
        return transformedArray;
    }

    @Test
    public void testTransformaArrayParaBytes() {
        short[] array = {(short) 1, (short) 2, (short) 3};
        byte[] transformedArray = transformaArrayParaBytes(array, s -> (byte) (s * 2));

        byte[] expectedArray = {(byte) 2, (byte) 4, (byte) 6};
        Assert.assertArrayEquals(expectedArray, transformedArray);

    }

}
