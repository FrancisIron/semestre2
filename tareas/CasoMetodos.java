/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casometodos;

import java.util.*;

/**
 *
 * @author Diego
 */
public class CasoMetodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int fil = 0, col = 0, confirm = 0;
        System.out.println("Ingrese datos de la matriz:");
        while (confirm == 0) {
            System.out.println("Filas");
            fil = leerOpcion();
            System.out.println("Columnas");
            col = leerOpcion();
            if (validarDimensiones(fil, col) == true) {
                confirm = 1;
            }
        }
        int m[][] = crearMatriz(fil, col);
        m = llenarMatriz(m);
        confirm = 0;
        while (confirm == 0) {
            System.out.println("Ingrese un número para seleccionar: ");
            System.out.println("1.Mostar fila\n2.Mostrar columna\n3.Verificar matriz tipo Cero\n4.Salir ");
            int opc = 0;
            while (opc != 1 && opc != 2 && opc != 3 && opc != 4) {
                opc = leerOpcion();
                if (opc != 1 && opc != 2 && opc != 3 && opc != 4) {
                    System.out.println("Ingrese 1, 2, 3 o 4!");
                }
            }
            switchCase(opc, m);
            if (opc == 4) {
                confirm = 1;
            }
        }
    }

    public static void switchCase(int op, int M[][]) {
        switch (op) {
            case 1:
                int n = 0;
                while (n <= 0 || n > M.length) {
                    System.out.println("Ingrese Fila para mostrar:");
                    n = leerOpcion();
                }
                mostrarFila(M, n);
                break;
            case 2:
                int n2 = 0;
                while (n2 <= 0 || n2 > M[0].length) {
                    System.out.println("Ingrese Columna para mostrar:");
                    n2 = leerOpcion();
                }
                mostrarColumna(M, n2);
                break;
            case 3:
                if (matrizCero(M) == true) {
                    System.out.println("La matriz es de tipo Cero\n");
                } else {
                    System.out.println("La matriz no es de tipo Cero\n");
                }
                break;
            case 4:
                break;
        }
    }

    public static boolean matrizCero(int mat[][]) {
        int mitad = (mat.length * mat[0].length) / 2, sum = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                    sum++;
                }
            }
        }
        return sum > mitad;
    }

    public static void mostrarColumna(int mat[][], int col) {
        System.out.println("Imprimiendo columna " + col);
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i][col - 1] + "\n");
        }
    }

    public static void mostrarFila(int mat[][], int fila) {
        System.out.println("Imprimiendo fila " + fila + "\n");
        for (int i = 0; i < mat[fila - 1].length; i++) {
            System.out.print(mat[fila - 1][i] + " ");
        }
        System.out.println();
    }

    public static int[][] llenarMatriz(int Matriz[][]) {
        for (int i = 0; i < Matriz.length; i++) {
            for (int j = 0; j < Matriz[i].length; j++) {
                Random rand = new Random();
                Matriz[i][j] = rand.nextInt(9);
            }
            if (validarFila100(Matriz[i]) == true) {
                i--;
            }
        }
        return Matriz;
    }

    public static boolean validarFila100(int fila[]) {
        int sum = 0;
        for (int i = 0; i < fila.length; i++) {
            sum += fila[i];
        }
        if (sum > 100) {
            return true;
        } else {
            System.out.println("Fila generada exitosamente!");
            return false;
        }
    }

    public static int[][] crearMatriz(int fil, int col) {
        int Matriz[][] = new int[fil][col];
        return Matriz;
    }

    public static int leerOpcion() {
        int confirm = 0, n = 0;
        while (confirm == 0) {
            try {
                Scanner num = new Scanner(System.in);
                n = num.nextInt();
                if (n <= 0) {
                    System.out.println("Ingrese un número mayor a 0");
                } else {
                    confirm = 1;
                }
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Ingrese un número");
            }
        }
        return n;
    }

    public static boolean validarDimensiones(int filas, int cols) {
        boolean respuesta = true;
        if (filas <= 0 || cols <= 0) {
            respuesta = false;
        }
        return respuesta;
    }

}
