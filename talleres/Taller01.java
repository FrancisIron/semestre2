/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller01;

import java.util.*;

/**
 *
 * @author Diego
 */
public class Taller01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int VOTOS[][] = new int[27][6];
        VOTOS = rellenar(VOTOS);
        menu(VOTOS);
    }
//No conseguí validar el máximo de 2500 votantes por local
    public static void menu(int VOTOS[][]) {
        int confirm = 0;
        while (confirm == 0) {
            int selec = 0;
            System.out.println("Ingrese un número para seleccionar: \n"
                    + "1. Mostrar Matriz\n"
                    + "2. Mostrar Votos por local\n"
                    + "3. Calcular Cantidad de votos por candidato\n"
                    + "4. Calcular Votos por candidato real\n"
                    + "5. Calcular Candidato Ganador\n"
                    + "6. Salir");
            while (selec != 1 && selec != 2 && selec != 3 && selec != 4 && selec != 5 && selec != 6) {
                selec = leerint();
            }
            if (selec == 1) {
                mostrar(VOTOS);
            } else {
                if (selec == 2) {
                    int local = 0;
                    System.out.println("Ingrese numero del local:");
                    while (local <= 0 || local > VOTOS.length) {
                        local = leerint();
                    }
                    
                    System.out.println(votoslocal(VOTOS, local)+"\n");
                } else {
                    if (selec == 3) {
                        System.out.println("Ingrese candidato deseado");
                        int cand = 0;
                        while (cand <= 0 || cand > (VOTOS[0].length) - 2) {
                            cand = leerint();
                        }
                        System.out.println(votoscandidato(VOTOS, cand)+"\n");
                    } else 
                    if(selec==4){}else
                    
                    {
                        if (selec == 6) {
                            confirm = 1;
                        }
                    }
                }
            }
        }
    }
    
    public static int real(int m[][]){
    int sum=0;
    for(int i=0;i<m[0].length;i++){
    votoscandidato(m,i);
    }
    return sum;
    }

    public static int votoscandidato(int m[][], int cand) {
        System.out.println("Votos del candidato " + cand);
        int sum = 0;
        for (int i = 0; i < m[0].length; i++) {
            sum += m[i][(cand - 1)];
        }
        System.out.println(sum + "\n");
        return sum;
    }

    public static int votoslocal(int m[][], int loc) {
        System.out.println("Votos del local " + loc + ":");
        int sum = 0;
        for (int i = 0; i < m[0].length; i++) {
            sum += m[(loc - 1)][i];
        }
        System.out.println(sum + "\n");
        return sum;
    }

    public static int leerint() {
        int n = 0, confirm = 0;
        while (confirm == 0) {
            try {
                Scanner num = new Scanner(System.in);
                n = num.nextInt();
                confirm = 1;
            } catch (java.util.InputMismatchException ex) {
                System.out.println("Error");
            }
        }
        return n;
    }

    public static int[][] rellenar(int m[][]) {
        Random r = new Random();
        int filas = m.length, columnas = m[0].length;
        for (int i = 0; i < filas; i++) {
            int sum = 0;
            for (int j = 0; j < columnas; j++) {
                int n, confirm = 0;
                while (confirm == 0) {
                    m[i][j] = r.nextInt(2500) + 1;
                    sum += m[i][j];
                    if (sum > 2500) {
                        confirm = 1;
                    }
                }
            }
        }
        return m;
    }

    public static void mostrar(int m[][]) {
        System.out.print("Local\tCandidato 1\tCandidato 2\tCandidato 3\tCandidato 4\tNulos\t\tBlancos\n");
        for (int i = 0; i < m.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("");
    }
}
