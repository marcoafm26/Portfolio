/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monk;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class MonkZada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Long> list = new LinkedList();
        Scanner ler = new Scanner(System.in);
        long n = ler.nextLong();       
        for (int i = 0; i < n; i++) {
            list.add(ler.nextLong());
        }

        long peso, base = 100000, inte = 1,aux;
       while(true){
            peso = 0;
            for (int i = 0; i < list.size();i++) {
                aux = list.get(i);
                peso += Math.abs(base % aux / inte);
            }
            if (peso > 0) {
                System.out.println(imprimir(ordenar(inte, list, base, n)));
            }
            else
               break;
            base = base * 100000;
            inte = inte * 100000;

        }         
    }

    public static List<Long> ordenar(long inte,List<Long> list, long base, long n) {       
        LinkedList<Long>[] listAux = new LinkedList[30];
        for (int i = 0; i < 30; i++) {
            listAux[i] = new LinkedList();
        }
        int peso, mod = 10;
        LinkedList<Long> auxList;
        for (int t = 0; t < 10; t++) {

            for (Long aux : list) {
                peso = (int) ((aux % base / inte));                 
                int m = ((int) (peso % mod / (mod/ 10))) + 10;
               listAux[m].add(aux);
            }
            if (!list.isEmpty())
            list.clear();

            for (int p =0; p < listAux.length ; p++) {
                auxList = listAux[p];
                while (!auxList.isEmpty()) {
                    list.add(auxList.pop());
                }
            }
            mod = mod *10;
        }
        return list;

    }

    public static String imprimir(List<Long> list) {
        StringBuilder sb = new StringBuilder();
        int m = list.size() - 1;
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if(i != list.size() -1 )
                sb.append(" ");
        }
        return sb.toString();
    }
}
