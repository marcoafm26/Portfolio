/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class IrEvir {

    static List<Integer>[] grafo;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int N = ler.nextInt();
        while (N < 2 || N > 2000) {
            N = ler.nextInt();
        }

        grafo = new LinkedList[N];
        for (int i = 0; i < grafo.length; i++) {
            grafo[i] = new LinkedList();
        }

        int M = ler.nextInt();
        while (M < 2 || M > (N * (N - 1) / 2)) {
            M = ler.nextInt();
        }
        
        // Vertices
        int V, W, P;
        for (int i = 1; i <= M; i++) {
            V = ler.nextInt();
            while (V < 1 || V > N) {
                V = ler.nextInt();
            }
            W = ler.nextInt();
            while (W < 1 || W > N) {
                W = ler.nextInt();
            }
            P = ler.nextInt();
            while (P != 1 && P != 2) {
                P = ler.nextInt();
            }
            
            grafo[V-1].add(W-1);
            if(P==2)
               grafo[W-1].add(V-1);               
        }
    }
}
