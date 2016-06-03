
package binarygap;


public class BinaryGap {

    
    public static void main(String[] args) {
        int N;
        N = 161;
    
        int max = 0;
        int count = -1;
        int r = 0;

        while (N > 0) {
            // get right most bit. The & bitwise operator makes r=1 if right 
            //hand bit of N is also 1, otherwise 0.
            r = N & 1;
            // shift right
            N = N >> 1;

            // the counter; when r equals 0 and the count is not on its 1st loop
            if (0 == r && count >= 0) {
                count++;
            }
            // the way to find max binary gap and set counter to zero, when r=1
            if (1 == r) {
                max = count > max ? count : max;
                count = 0;
            }
        }
        System.out.println(max);
    }

    public static long solution1(int N) {
        int maxLength = 0;
        int currentLength = 0;

        while (N > 0) {
            //  Since uneven numbers (00000001=1),
            // then if the remainder (%) of a division by 2, equals to 1. This 
            // means that the right bit is equal to 1
            if (N % 2 == 1) {
                currentLength = 0;
            } else {
                currentLength = currentLength + 1;
            }

            if (currentLength > maxLength) {
                maxLength = currentLength;
            }
            // a division of a number by two, effectively shifts the binary number to the right
            N = (N / 2);
        }
        return maxLength;
    }
}

 
