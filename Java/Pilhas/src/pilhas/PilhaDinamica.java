package pilhas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PilhaDinamica<T> {

    private Celula topo;

    public PilhaDinamica() { // Contrutor responsavel por inicializar a pilha
        topo = new Celula();
    }

    private class Celula { // Classe privada que define os atributos de uma celula

        Celula prox;
        char caracter;
    }

    public void readFile(String arquivo) throws FileNotFoundException { // Metodo responsavel por fazer a leitura do arquivo txt e aplicar as regras do trabalho     
        File file = new File(arquivo);
        StringBuilder texto = new StringBuilder();
        Scanner leitura = new Scanner(file);  
            while ( leitura.hasNextLine()){
                 texto.append(leitura.nextLine()+" ");
            }   
            char caracter;
            int j =0,i=0;
            while ((caracter =texto.charAt(j)) != '~') {
                //System.out.println(caracter);
                if (caracter == '#') {
                    pop();
                    i--;
                } else if (caracter == '*') {
                    System.out.println(toString());
                    topo = null;
                    i = 0;
                } else if (caracter == '\\') {
                    topo = null;
                    i= 0;
                } else {                     
                    push(caracter);
                    i++;
                    if ( i == 70){
                    i = 0;
                    System.out.println(toString());
                    topo = null;
                    }
                }
            j++;
            }
            System.out.println(toString());
            leitura.close();
    }

    public void push(char top) { // Metodo responsavel por colocar um elemento no topo da pilha
        Celula novo = new Celula();
        novo.caracter = top;
        novo.prox = topo;
        topo = novo;
    }

    public void pop() { // Metodo responsavel por retirar o elemento do topo da pilha
        if (!empty()) {
            topo = topo.prox;
        } else {
            throw new NullPointerException("Lista vazia.");
        }
    }

    public boolean empty() { // Metodo verifica se a pilha esta vazia
        return (topo == null);
    }

    @Override
    public String toString() { // Override do metodo toString para impressao da linha da pilha
        if (!empty()) {
            StringBuilder sb = new StringBuilder();
            Celula aux = topo;
            PilhaDinamica auxPilha = new PilhaDinamica();
            while (aux != null) {
                auxPilha.push(aux.caracter);
                aux = aux.prox;
            }
            aux = auxPilha.topo;
            while (aux != null) {
                sb.append(aux.caracter);
                aux = aux.prox;
            }
            return sb.toString();
        } else {
            throw new NullPointerException("Lista vazia.");
        }
    }
}
