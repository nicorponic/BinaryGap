/*
A binary gap within a positive integer N is any maximal sequence of consecutive 
zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap 
of length 2. The number 529 has binary representation 1000010001 and contains 
two binary gaps: one of length 4 and one of length 3. The number 20 has binary 
representation 10100 and contains one binary gap of length 1. The number 15 has 
binary representation 1111 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }
that, given a positive integer N, returns the length of its longest binary gap. 
The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary 
representation 10000010001 and so its longest binary gap is of length 5.

Assume that:

N is an integer within the range [1..2,147,483,647].
Complexity:

expected worst-case time complexity is O(log(N));
expected worst-case space complexity is O(1).
Copyright 2009–2016 by Codility Limited. 
All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
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
            // a division of a number by two, shifts the binary number to the right
            N = (N / 2);
        }
        return maxLength;
    }
}
