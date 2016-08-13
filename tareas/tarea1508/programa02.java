/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareametodos2;

import java.util.*;

/**
 *
 * @author Diego
 */
public class Tareametodos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int m[][] = new int[3][3], confirm = 0;
        while (confirm == 0) {
            m = rellenar(m);
            if (suma(m) == 8) {
                confirm = 1;
            } else {
                confirm = 0;
            }
            for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rellenar(int m[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int confirm = 0;
                while (confirm == 0) {
                    Random r = new Random();
                    m[i][j] = r.nextInt(9) + 1;
                    if (comparar(m, m[i][j]) == 1) {
                        confirm = 1;
                    }
                }
            }
        }
        return m;
    }

    public static int suma(int m[][]) {
        //comprobar que las sumas dan 15
        int n = 0, sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += m[i][j];
            }
            if (sum == 15) {
                n++;
            }
            sum = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += m[j][i];
            }
            if (sum == 15) {
                n++;
            }
            sum = 0;
        }
        if (m[0][0] + m[1][1] + m[2][2] == 15) {
            n++;
        }
        if (m[0][2] + m[1][1] + m[2][0] == 15) {
            n++;
        }
        return n;
    }

    public static int comparar(int m[][], int n) {
        //comprobar que no se repitan los números del 1 al 9
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (n == m[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
