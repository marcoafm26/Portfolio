/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package happy;

import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class HappyN {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int b = ler.nextInt();
        while (b < 0 && b > 100) {
            b = ler.nextInt();
        }
        ler.nextLine();
        String[] horarios = new String[b];
        for (int i = 0; i < b; i++) {
            horarios[i] = ler.nextLine();
        }
        if ( b > 1){
                    while (horarios[0].length() > 1) {
            while (horarios[0].charAt(0) != ' ') {
                char hor = horarios[0].charAt(0);
                int j = 0, cont = 0;
                for (int i = 1; i < b; i++) {
                    j=0;
                    while ( horarios[i].charAt(j) != ' ') {
                        if (horarios[0].charAt(0) == horarios[i].charAt(j)) {
                            cont++;
                            break;
                        }
                        j++;
                        if(j+1 >horarios[i].length())
                            break;
                    }
                    if (cont == (b - 1)) {
                        sb.append(horarios[0].charAt(0));
                    }
                    j = 0;
                }
                horarios[0] = horarios[0].substring(1);
                cont = 0;
                if(horarios[0].length() < 1)
                            break;
            }if(horarios[0].length() > 1){
            for (int t = 0; t < b; t++) {
                while (horarios[t].charAt(0) != ' ' && horarios[t] != null) {
                    horarios[t] = horarios[t].substring(1);
                }
                if (horarios[t].charAt(0) == ' ') {
                    horarios[t] = horarios[t].substring(1);
                }
            }
            }
            if(horarios[0].length() > 1)
            sb.append(' ');
        }
        System.out.println(sb.toString());
        }else
            System.out.println(horarios[0]);
    }

}
