package reducao;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Reducao {

    public static class Rodovia implements Comparable<Rodovia> {

        int cidadeA;
        int cidadeB;
        int distancia;

        @Override
        public int compareTo(Rodovia o) {
            return distancia - o.distancia;
        }
    }

    public static class Vertices {

        int destino = 0;
        LinkedList<Integer> list = new LinkedList();
    }

    public static int kruskall(PriorityQueue<Rodovia> fila, int vertices) {
        int vertAtuais = 0;
        int distancia = 0;
        LinkedList[] listaVert = new LinkedList[vertices + 1];

        for (int i = 0; i < listaVert.length; i++) {
            listaVert[i] = new LinkedList();
            listaVert[i].add(i);
        }
        
        int conjuntoA = 0, conjuntoB = 0;
        Rodovia rodovia;
        while (vertAtuais != vertices) {
            rodovia = fila.poll();
            conjuntoA =encontraConjunto(rodovia.cidadeA, listaVert);
            conjuntoB =encontraConjunto(rodovia.cidadeB, listaVert);
            if(conjuntoA != conjuntoB){
                listaVert[conjuntoA].addAll(listaVert[conjuntoB]);
                listaVert[conjuntoB].clear();
                distancia += rodovia.distancia;
                vertAtuais = listaVert[conjuntoA].size();
            }               
        }

        return distancia;
    }
    
    public static int encontraConjunto(int vertice,LinkedList[] listaVert){
        for (int i = 0; i < listaVert.length; i++) {
                if( listaVert[i].contains(vertice))
                return i;
        }
        return 0;
        }
    
    

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        LinkedList<Rodovia> lista = new LinkedList();

        int vertices = ler.nextInt();
        int rodovias = ler.nextInt();

        Rodovia rodovia;
        for (int i = 0; i < rodovias; i++) {
            rodovia = new Rodovia();
            rodovia.cidadeA = ler.nextInt();
            rodovia.cidadeB = ler.nextInt();
            rodovia.distancia = ler.nextInt();
            lista.add(rodovia);
        }

        PriorityQueue<Rodovia> fila = new PriorityQueue(lista);

        System.out.println(kruskall(fila, vertices));
    }

}
