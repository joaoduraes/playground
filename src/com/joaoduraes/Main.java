package com.joaoduraes;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {


        /*int[][] arr = new int[3][3];
         *//*11 2 4
        4 5 6
        10 8 -12*//*

        arr[0][0] = 11;
        arr[0][1] = 2;
        arr[0][2] = 4;

        arr[1][0] = 4;
        arr[1][1] = 5;
        arr[1][2] = 6;

        arr[2][0] = 100;
        arr[2][1] = 8;
        arr[2][2] = -12;

        System.out.println(diagonalDifference(arr));*/

        /*int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 0;
        arr[3] = -1;
        arr[4] = -1;
        plusMinus(arr);*/

        //staircase(101);

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        miniMaxSum(arr);
    }

    /*
     * Complete the simpleArraySum function below.
     */
    static int simpleArraySum(int[] ar) {
        int sum = 0;
        for (int i : ar) {
            sum += i;
        }
        return sum;
    }

    // Complete the compareTriplets function below.

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        if ((a.size() != b.size())
                || (a.stream().anyMatch(i -> i < 1 || i > 100))
                || ((b.stream().anyMatch(i -> i < 1 || i > 100)))) {
            throw new IllegalArgumentException();
        }


        int scoreA = 0;
        int scoreB = 0;

        for (int i = 0; i < a.size(); i++) {
            int compare = a.get(i).compareTo(b.get(i));

            if (compare < 0) {
                scoreB++;
            } else if (compare > 0) {
                scoreA++;
            }
        }

        return Arrays.asList(scoreA, scoreB);
    }

    // Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
        long sum = 0;
        for (long l : ar) {
            sum += l;
        }

        return sum;
    }

    // Complete the diagonalDifference function below.
    static int diagonalDifference(int[][] arr) {

        int sumLeftToRight = 0;
        int sumRightToLeft = 0;

        //testing constraint
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < -100 || arr[i][j] > 100) {
                    throw new IllegalArgumentException();
                }
            }
        }


        //testing if it's a square matrix
        //also making first sum
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != n) {
                throw new IllegalArgumentException();
            }

            sumLeftToRight += arr[i][i];
        }

        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sumRightToLeft += arr[i][j];
            j++;
        }

        return Math.abs(sumLeftToRight - sumRightToLeft);
    }

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        long n = arr.length;

        long negatives = 0;
        long positives = 0;
        long zeros = 0;

        for (int i : arr) {
            if (i < -100 || i > 100) {
                throw new IllegalArgumentException();
            }

            if (i == 0) {
                zeros++;
            } else if (i < 0) {
                negatives++;
            } else {
                positives++;
            }
        }

        BigDecimal posFraction = BigDecimal.valueOf(positives).setScale(6, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(n), RoundingMode.HALF_EVEN).setScale(6, RoundingMode.HALF_EVEN);
        BigDecimal negFraction = BigDecimal.valueOf(negatives).setScale(6, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(n), RoundingMode.HALF_EVEN).setScale(6, RoundingMode.HALF_EVEN);
        BigDecimal zeroFraction = BigDecimal.valueOf(zeros).setScale(6, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(n), RoundingMode.HALF_EVEN).setScale(6, RoundingMode.HALF_EVEN);

        System.out.println(posFraction.toString());
        System.out.println(negFraction.toString());
        System.out.println(zeroFraction.toString());


    }

    // Complete the staircase function below.
    static void staircase(int n) {
        if (n <= 0 || n > 100) {
            throw new IllegalArgumentException();
        }

        for (int i = n; i > 0; i--) {
            int numOfHashes = n - i + 1;
            int numOfSpaces = n - numOfHashes;

            StringBuilder stringBuilder = new StringBuilder();

            for (int j = 0; j < numOfSpaces; j++) {
                stringBuilder.append(" ");
            }

            for (int j = 0; j < numOfHashes; j++) {
                stringBuilder.append("#");
            }
            System.out.println(stringBuilder.toString());
        }


    }

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        if (arr.length != 5) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = new ArrayList<>();

        for (int i : arr) {
            numbers.add(i);
        }

        numbers.sort(Integer::compareTo);

        Long mini = 0L;
        Long max = 0L;

        for (int i = 0; i < 4; i++) {
            mini += numbers.get(i);
        }

        for (int i = 1; i < 5; i++) {
            max += numbers.get(i);
        }

        System.out.println(mini + " " + max);
    }


}