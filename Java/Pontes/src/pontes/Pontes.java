/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pontes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


/**
 *
 * @author Marco
 */
public class Pontes {

    public static boolean pontes(LinkedList[] grafo, int k) {
        
        for (int i =2 ;i < grafo.length; i++) {
            if (grafo[i].size() != k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader ler = new BufferedReader(inputStreamReader);
        String[] linha;
        while ((linha = ler.readLine().split(" ")) != null && linha.length != 0) {
            if (!linha[0].equals("")) {
                int r = Integer.parseInt(linha[0]);

                int k = Integer.parseInt(linha[1]);

                LinkedList[] pontes = new LinkedList[r];

                for (int i = 0; i < pontes.length; i++) {
                    pontes[i] = new LinkedList();
                }
                int a, b;

                for (int i = 1; i <= k; i++) {
                    linha = ler.readLine().split(" ");
                    a = Integer.parseInt(linha[0]);
                    b = Integer.parseInt(linha[1]);
                    pontes[a - 1].add(b - 1);
                    pontes[b - 1].add(a - 1);
                }
                if (pontes(pontes, k)) {
                    System.out.println("S");
                } else {
                    System.out.println("N");
                }
            } else {
                break;
            }
        }
    }

}



31 147
21 2
20 29
12 23
20 4
19 30
27 19
11 25
1 29
2 16
27 25
23 31
5 31
8 20
19 26
17 19
28 4
29 27
12 6
14 6
1 12
8 6
17 1
11 17
16 14
13 8
8 5
1 16
24 13
7 28
20 15
25 9
