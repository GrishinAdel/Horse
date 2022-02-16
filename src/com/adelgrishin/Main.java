package com.adelgrishin;

import java.util.Scanner;

public class Main {

    static int x_change[] = new int[] {1,2,2,1,-1,-2,-2,-1};
    static int y_change[] = new int[] {2,1,-1,-2,-2,-1,1,2};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 8;
        int matrix [][] = new int[n][n];
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                matrix[i][j] = 0;
            }
        }
        int x1 = in.nextInt();
        int y1 = in.nextInt();
        motion(matrix,1, x1--, y1--, n);
    }

    static void motion(int matrix[][], int num, int x1, int y1, int n) {
        matrix[x1][y1] = num++;
        for (int i = 0; i < 8; i++ ) {
            int x_new = x1 + x_change[i];
            int y_new = y1 + y_change[i];

            if (num > n*n) {
                print(matrix, n);
                System.exit(0);
            }
            if (x_new < 0 || x_new > n-1 || y_new < 0 || y_new > n -1 || matrix[x_new][y_new] != 0) {
                continue;
            }
            motion(matrix, num, x_new, y_new, n);
            matrix[x_new][y_new] = 0;
        }


    }

    static void print(int matrix[][], int n) {
        for (int i = 0; i<n; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}

