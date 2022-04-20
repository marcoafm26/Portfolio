/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenado;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class Ordenado {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String ord, desor;
        int n = ler.nextInt();
        long[] vet = new long[n], orden = new long[n];

        long pares[] = new long[(n/2)];
        long impares[] = new long[(n/2)+n%2];
        for (int i = 0; i < n; i++) {
            vet[i] = ler.nextInt();
            while (vet[i] < -1000 && vet[i] > 1000) {
                vet[i] = ler.nextInt();
            }
        }
        int par = 0, impar = 0;
        for (int i = 0; i < n; i++) {
            if (((i + 1) % 2) == 0 && vet[i] != 0) {
                pares[par] = vet[i];
                par++;
            } else if(vet[i] != 0) {
                impares[impar] = vet[i];
                impar++;
            }
        }

            long aux;
            for (int j = 0; j < pares.length; j++) {
                for (int k = 0; k < pares.length - 1; k++) {
                    if (pares[k + 1] > pares[k]) {
                        aux = pares[k];
                        pares[k] = pares[k + 1];
                        pares[k + 1] = aux;
                    }
                }
            }
            for (int j = 0; j < impares.length; j++) {
                for (int k = 0; k < impares.length -1 ; k++) {
                    if (impares[k + 1] < impares[k]) {
                        aux = impares[k];
                        impares[k] = impares[k + 1];
                        impares[k + 1] = aux;
                    }
                }
            }
 
        par = 0;
        impar = 0;
        int cont = 0;
        for (int i = 0; i < vet.length; i++) {
            if (cont == 0) {
                orden[i] = impares[impar];
                impar++;
                cont = 1;
                if (impar > impares.length) {
                    while (par <= pares.length) {
                        orden[i] = pares[par];
                        i++;
                        par++;
                    }
                }
            } else {
                orden[i] = pares[par];
                par++;
                cont = 0;
                if (par > pares.length) {
                    while (impar <= impares.length) {
                        orden[i] = impares[impar];
                        impar++;
                        i++;
                    }
                }
            }

        }

        ord = "V = {";
        desor = "O = {";
        for (int i = 0; i < n; i++) {
            ord = ord + " " + vet[i];
            desor = desor + " " + orden[i];
            if (i < n - 1) {
                ord = ord + ",";
                desor = desor + ",";
            }
        }
        ord = ord + "}";
        desor = desor + "}";
     System.out.println(ord + "\n" + desor);
    }

}
