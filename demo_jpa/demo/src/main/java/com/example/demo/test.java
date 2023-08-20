package com.example.demo;

public class test {
    public static void main(String[] args) {
        public static int solve(int[][] arr, int m, int n) {
            int cuts = 0;

            for (int col = 0; col < n; col++) {
                int consecutiveHoles = 0;

                for (int row = 1; row <= m; row++) {
                    if (arr[row][col] == 0) {
                        consecutiveHoles++;
                    } else {
                        if (consecutiveHoles > 0) {
                            cuts++;
                            consecutiveHoles = 0;
                        }
                    }
                }
            }

            return cuts;
        }
    }
}
