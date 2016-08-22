/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usostring;

import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;
import java.util.*;

/**
 *
 * @author Diego
 */
public class UsoString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char confirm = ' ';
        while (confirm != 'S') {
            System.out.println("Ingrese su Cadena:");
            String cadena = leerString();
            Scanner enter = new Scanner(System.in);
            System.out.println("Presione enter para imprimir resultados...");
            enter.nextLine();
            imprimirResultados(cadena);
            System.out.println("Escriba S para cerrar el programa o Escriba cualquier otra letra para continuar...");
            confirm = leerString().charAt(0);
            if (confirm == 's') {
                confirm = toUpperCase(confirm);
            }
        }
    }

    public static void imprimirResultados(String str) {
        System.out.println("Su cadena es: " + str);
        System.out.println("Largo de la cadena: " + largoCadena(str));
        System.out.println("Vocales en su cadena: " + contarVocales(str));
        System.out.println("Consonantes en su cadena: " + contarConsonantes(str));
        System.out.println("Cadena invertida: " + invertirString(str));
        System.out.println("Ingrese un carácter para buscar: ");
        String leer = "";
        while (leer.length() != 1) {
            leer = leerString();
            if (leer.length() != 1) {
                System.out.println("Ingrese sólo un carácter");
            }
        }
        char busq = toLowerCase(leer.charAt(0));
        if (existeChar(str, busq)) {
            System.out.println("El carácter '" + busq + "' si está en la cadena");
        } else {
            System.out.println("El carácter '" + busq + "' no está en la cadena");
        }
        System.out.println("Ingrese Sub cadena para buscar: ");
        String sub = leerString();
        if (existeSubString(str, sub)) {
            System.out.println("La subcadena '" + sub + "' si existe en la cadena");
        } else {
            System.out.println("La subcadena '" + sub + "' no existe en la cadena");
        }
        char array[] = crearArrayChar(str);
        System.out.println("La cadena en arreglo de Char: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static char[] crearArrayChar(String str) {
        char arreglo[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arreglo[i] = str.charAt(i);
        }
        return arreglo;
    }

    public static boolean existeSubString(String str, String substr) {
        if (str.toLowerCase().contains(substr.toLowerCase())) {
            return true;
        }
        return false;
    }

    public static boolean existeChar(String str, char ch) {
        for (int i = 0; i < str.length(); i++) {
            if (toLowerCase(str.charAt(i)) == ch) {
                return true;
            }
        }
        return false;
    }

    public static String invertirString(String str) {
        String string = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            string = string + str.charAt(i);
        }
        return string;
    }

    public static int contarConsonantes(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (toLowerCase(str.charAt(i)) != 'a' && toLowerCase(str.charAt(i)) != 'e' && toLowerCase(str.charAt(i)) != 'i' && toLowerCase(str.charAt(i)) != 'o' && toLowerCase(str.charAt(i)) != 'u') {
                n++;
            }
        }
        return n;
    }

    public static int contarVocales(String str) {
        int n = 0;
        for (int i = 0; i < str.length(); i++) {
            if (toLowerCase(str.charAt(i)) == 'a' || toLowerCase(str.charAt(i)) == 'e' || toLowerCase(str.charAt(i)) == 'i' || toLowerCase(str.charAt(i)) == 'o' || toLowerCase(str.charAt(i)) == 'u') {
                n++;
            }
        }
        return n;
    }

    public static int largoCadena(String str) {
        int n = 0;
        n = str.length();
        return n;
    }

    public static String leerString() {
        String cadena = null;
        int confirm = 0;
        while (confirm == 0) {
            Scanner leer = new Scanner(System.in);
            cadena = leer.next();
            confirm = 1;
        }
        return cadena;
    }
}
