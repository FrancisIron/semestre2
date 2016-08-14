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
        int confirm = 0, M[][] = new int[3][3], n = 0;
        System.out.println("Calculando cuadrado mágico...");
        while (confirm == 0) {
            int m[][] = new int[3][3];
            m = rellenar(m);
            if (suma(m) == 8) {
                confirm = 1;
                M = m;
                System.out.println("Intento N°: " + n);
            } else {
                System.out.println("Intento N°: " + n + " fallido!");
                confirm = 0;
            }
            n++;
        }
        System.out.println("Se consiguió un cuadrado mágico en el intento N° " + n);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] rellenar(int m[][]) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int confirm = 0;
                while (confirm == 0) {
                    m[i][j] = random();
                    if (comparar(m, m[i][j]) == 1) {
                        confirm = 1;
                    }
                }
            }
        }
        return m;
    }

    public static int random() {
        int n;
        Random r = new Random();
        n = r.nextInt(9) + 1;
        return n;
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
