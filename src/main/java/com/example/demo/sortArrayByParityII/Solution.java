package com.example.demo.sortArrayByParityII;


import lombok.extern.slf4j.Slf4j;


@Slf4j
public class Solution {

    public static void main(String[] args) {

        log.info("{}", new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7}));
    }


    public int[] sortArrayByParityII(int[] A) {

        int m = 0;
        int n = 0;
        int t;
        while (true) {
            for (int i = m; i < A.length; i++) {
                if (i % 2 == 0 && A[i] % 2 == 1) {
                    m = i;
                    for (int j = n; j < A.length; j++) {
                        if (j % 2 == 1 && A[j] % 2 == 0) {
                            n = j;
                            t = A[i];
                            A[i] = A[j];
                            A[j] = t;
                            break;
                        }
                    }
                    break;
                } else {
                    if (i == A.length -1) {
                        return A;
                    }
                }
            }
        }
    }

}
