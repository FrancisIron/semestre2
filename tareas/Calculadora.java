/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author Diego
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int confirm = 0;
        while (confirm == 0) {
            try {
                System.out.println("Ingrese operación: (ej: 1+1)");
                String cal = leerString();
                String[] parts = separar(cal);
                if (parts[0] == null || parts[1] == null || parts[2] == null) {
                    System.out.println("Ingrese los números sin espacio entre el operador");
                } else {
                    int num1 = Integer.parseInt(parts[0]);
                    int num2 = Integer.parseInt(parts[1]);
                    calcular(num1, num2, parts[2]);
                    confirm = 1;
                }
            } catch (java.lang.NumberFormatException | java.lang.ArrayIndexOutOfBoundsException | java.lang.NullPointerException ex) {
                System.out.println("Error, vuelva a intentarlo");
            }
        }
    }

    public static void calcular(int n1, int n2, String op) {
        if (op == "/") {
            System.out.println(n1 + " / " + n2 + " = " + (n1 / n2));
        }
        if (op == "*") {
            System.out.println(n1 + " * " + n2 + " = " + (n1 * n2));
        }
        if (op == "+") {
            System.out.println(n1 + " + " + n2 + " = " + (n1 + n2));
        }
        if (op == "-") {
            System.out.println(n1 + " - " + n2 + " = " + (n1 - n2));
        }
        if (op == "^") {
            System.out.println(n1 + " ^ " + n2 + " = " + ((int) pow(n1, n2)));
        }
    }

    public static String[] separar(String str) {
        String[] parts = new String[3];
        if (str.contains("/") || str.contains(" / ")) {
            String[] part = str.split("/");
            parts[0] = part[0];
            parts[1] = part[1];
            parts[2] = "/";
            if (part.length > 2) {
                parts = null;
            }
        } else if (str.contains("+")) {
            String[] part = str.split("\\+");
            parts[0] = part[0];
            parts[1] = part[1];
            parts[2] = "+";
            if (part.length > 2) {
                parts = null;
            }
        } else if (str.contains("-")) {
            String[] part = str.split("\\-");
            if (part.length == 3) {
                parts[0] = "-" + part[1];
                parts[1] = part[2];
            } else {
                parts[0] = part[0];
                parts[1] = part[1];
            }
            parts[2] = "-";
        } else if (str.contains("*")) {
            String[] part = str.split("\\*");
            parts[0] = part[0];
            parts[1] = part[1];
            parts[2] = "*";
            if (part.length > 2) {
                parts = null;
            }
        } else if (str.contains("^")) {
            String[] part = str.split("\\^");
            parts[0] = part[0];
            parts[1] = part[1];
            parts[2] = "^";
            if (part.length > 2) {
                parts = null;
            }
        }
        return parts;
    }

    public static String leerString() {
        Scanner n = new Scanner(System.in);
        String str = n.next();
        return str;
    }

}
