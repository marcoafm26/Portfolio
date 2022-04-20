/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tabhase;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class TabHase {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int testes = ler.nextInt();

        for (int i = 0; i < testes; i++) {
            int tamanho = ler.nextInt();

            while (tamanho < 1 || tamanho > 100) {
                tamanho = ler.nextInt();
            }
            int entradas = ler.nextInt();

            while (entradas < 1 || entradas > 200) {
                entradas = ler.nextInt();
            }

            int[][] table = new int[tamanho][entradas];
            int aux = 0;
            for (int j = 0; j < entradas; j++) {
                int valores = ler.nextInt();
                while (valores < 1 || valores > 200) {
                    valores = ler.nextInt();
                }
                int add = dispTable(valores,tamanho);

                for (int k = 0; k < entradas; k++) {

                    if (table[add][k] == 0) {
                        table[add][k] = valores;
                        break;
                    }
//                    } else if (table[add][k] > valores) {
//                        int m = k;
//                        while (table[add][m] != 0) {
//                        aux = table[add][m];                     
//                        table[add][m] = valores;
//                        valores = aux;
//                        m++;
//                        }
//                        break;
//                    }

                }
            }
            StringBuilder sb = new StringBuilder();
            for (int m = 0; m < tamanho; m++) {
                sb.append(m).append(" -> ");
                for (int j = 0; j < entradas; j++) {
                 if (table[m][j] != 0 )
                 sb.append(table[m][j]).append(" -> ");
                 else
                     break;
                                  
                }
                sb.append("\\").append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public static int dispTable(int chave,int tamanho) {
        int pos = chave % tamanho;
        return pos;
    }

}
