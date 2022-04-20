/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilhas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class PilhaDinamicaMain{

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PilhaDinamica<String> pd = new PilhaDinamica();
        int i =0;
        System.out.println("------- Editor de Texto -------\n");
        while (i == 0 ){
         System.out.println("Insira o nome(sem o txt) de um arquivo que esteja na raiz do seu projeto.\n");
                try{
                sb.delete(0, sb.length());    
                String file = leitura.next(); // Leitura do nome do arquivo
                System.out.println();
                file = sb.append(file).append(".txt").toString();
                pd.readFile(file);
                i = 1;
                }catch(FileNotFoundException e){
                    System.out.println("Arquivo não encontrado");                   
                }catch(IOException e){
                    System.out.println("Arquivo não encontrado");
                }
    }
    }
    
}
