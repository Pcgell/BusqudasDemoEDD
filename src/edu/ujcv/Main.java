package edu.ujcv;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arregloOrdenado = new int[10000];
        Random random = new Random();

        for(int i = 0, j = 0; i < arregloOrdenado.length; i++){

            j+= Math.abs(random.nextInt())%10;
            arregloOrdenado[i] = j;
        }
        for (int i = 0; i < 10; i++) {
            int elemento = Math.abs(random.nextInt()% arregloOrdenado.length);
            long startTime = System.nanoTime();

            int result = busquedaSequencial(arregloOrdenado, elemento);

            long endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda sequencial:\n tiempo: "
                    + endTime + "\n indice: " + result);


            startTime = System.nanoTime();
            result = busquedaBinaria(arregloOrdenado, elemento);
            endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda Binaria:\n tiempo: "
                    + endTime + "\n indice: " + result);
        }

        for (int i = 0; i < 10; i++) {
            int elemento = arregloOrdenado[ Math.abs(random.nextInt())% arregloOrdenado.length];
            long startTime = System.nanoTime();

            int result = busquedaSequencial(arregloOrdenado, elemento);

            long endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda sequencial:\n tiempo: "
                    + endTime + "\n indice: " + result);


            startTime = System.nanoTime();
            result = busquedaBinaria(arregloOrdenado, elemento);
            endTime = System.nanoTime() - startTime;

            System.out.println("resultado Busqueda Binaria:\n tiempo: "
                    + endTime + "\n indice: " + result);
        }
    }

    public static int busquedaSequencial (int[] arreglo, int elemento){
        int retval = -1;
        for(int i = 0; i < arreglo.length; i++){
            if(arreglo[i]== elemento){
                return i;
            }
        }
        return retval;
    }

    public static int busquedaBinaria(int[] arreglo, int elemento){
        int retval = -1;

        int superior = arreglo.length-1;
        int inferior = 0;
        while(superior >= inferior){
            int centro = (superior + inferior)/2;
            if(elemento == arreglo[centro]){
                //buscar primera incidencia
                return centro;
            }else if(arreglo[centro] > elemento) {
                superior = centro -1;
            }else {
                inferior = centro +1;
            }
        }
        return retval;
    }
}
