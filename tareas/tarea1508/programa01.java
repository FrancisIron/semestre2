/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareametodos;

import static java.lang.Character.toUpperCase;
import java.util.*;

/**
 *
 * @author Diego
 */
public class Tareametodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n = 0, hom, muj, hombresAfavor = 0, mujeresEnContra = 0, total, totalAfavor = 0;
        System.out.println("Ingrese la cantidad de hombres");
        hom = leerInt();
        System.out.println("Ingrese la cantidad de mujeres");
        muj = leerInt();
        total = muj + hom;
        char encuest[][] = new char[2][hom + muj];
        char res;
        while (n < encuest.length) {
            while (hom > 0) {
                System.out.println("Ingrese respuesta del Hombre " + (n + 1) + "\nS si aprueba la gestión del gobierno, N si no aprueba la gestión del gobierno, X si no sabe o no responde");
                res = leerRespuesta();
                encuest[0][n] = res;
                hom--;
                n++;
                if (res == 'S') {
                    hombresAfavor++;
                    totalAfavor++;
                }
            }
            n = 0;
            while (muj > 0) {
                System.out.println("Ingrese respuesta de la Mujer " + (n + 1) + "\nS si aprueba la gestión del gobierno, N si no aprueba la gestión del gobierno, X si no sabe o no responde");
                res = leerRespuesta();
                encuest[1][n] = res;
                muj--;
                n++;
                if (res == 'N') {
                    mujeresEnContra++;
                }
                if (res == 'S') {
                    totalAfavor++;
                }
            }
        }
        System.out.print("\nHombres ");
        for (int i = 0; i < total - n; i++) {
            System.out.print(encuest[0][i] + "  ");
        }
        System.out.print("\nMujeres ");
        for (int i = 0; i < n; i++) {
            System.out.print(encuest[1][i] + "  ");
        }
        System.out.println("\nHombres a favor: " + hombresAfavor);
        System.out.println("Mujeres en contra: " + mujeresEnContra);
        System.out.println("Porcentaje de aprobación: " + ((totalAfavor * 100) / total));
        System.out.println("Total de encuestados: " + total);
    }

    public static char leerRespuesta() {
        char res = '0';
        String str;
        Scanner let = new Scanner(System.in);
        while (res != 'S' && res != 'N' && res != 'X') {
            str = let.next();
            res = str.charAt(0);
            if (res == 's' || res == 'n' || res == 'x') {
                res = toUpperCase(res);
            }
            if (res != 'S' && res != 'N' && res != 'X') {
                System.out.println("Ingrese una letra válida");
            }
        }
        return res;
    }

    public static int leerInt() {
        int n = 0, confirm = 0, aux;
        while (confirm == 0) {
            try {
                Scanner num = new Scanner(System.in);
                aux = num.nextInt();
                if (aux <= 0) {
                    System.out.println("Ingrese un número mayor a 0");
                } else {
                    n = aux;
                    confirm = 1;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Ingrese un número");
                confirm = 0;
            }
        }
        return n;
    }
}
