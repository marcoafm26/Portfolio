/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package navalhabatal;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class NavalhaBatalMain {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int size, cellsNumber;
        
        do {
            size = ler.nextInt();
            cellsNumber = ler.nextInt();
            ler.nextLine();
        } while (size < 1 || size > 1000000 || cellsNumber < 0 || cellsNumber > 100000);
        
        long firstTime = System.nanoTime();
        NavalhaBatal nb = new NavalhaBatal();
        nb.inicializarMatriz(size, size);
        
        int linha, coluna;
        for (int i = 0; i < cellsNumber; i++) {
            do{
            linha = ler.nextInt();
            coluna = ler.nextInt();
            }while ( linha > size || linha < 1 ||coluna > size ||coluna < 1);
            nb.addMatriz(coluna, linha, 1);
            ler.nextLine();
        }
        long finalTime = System.nanoTime();
        System.out.print(nb.possibilities());
       // System.out.println("Tempo de execucao para matriz de tamanho " + size +": " + (finalTime - firstTime) + " ns");
    }

}
