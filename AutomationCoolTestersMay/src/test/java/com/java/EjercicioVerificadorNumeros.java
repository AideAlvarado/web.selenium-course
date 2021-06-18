package com.java;

public class EjercicioVerificadorNumeros {
    public static void main(String[] args) {
        imprimirVerificadorNumeros(1, 1, 1);
        imprimirVerificadorNumeros(1, 1, 2);
        imprimirVerificadorNumeros(-1, -1, -1);
        imprimirVerificadorNumeros(1, 2, 3);
    }

    public static void imprimirVerificadorNumeros(int x, int y, int z) {
        String resultado = "";
        if (x < 0 || y < 0 || z < 0) {
            resultado = " Valor no válido";
        } else if (x == y && y == z) {
            resultado = " Todos los numeros son iguales";
        } else if (x != y && y != z && x != z) {
            resultado = " Todos los numeros son diferentes";
        } else if (x == y && y != z) {
            resultado = " Ni todos los numeros son iguales ni diferentes";
        }
        System.out.println("" + x + "," + y + "," + z + resultado);
    }
}
