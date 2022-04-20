package impostoreal;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class impostoReal {

    public static class Estrada {

        int tamanho;
        Cidade cidadeA;
        Cidade cidadeB;
        boolean visitada = false;
    }

    public static class Cidade {
        int id;
        ArrayList<Estrada> caminhos = new ArrayList();
        int imposto = -1;
        int cont = 0;
    }
    

    public static int recolheImpostos(Cidade[] cidades, int capCarruagem, int montanteTotal) {
        Stack<Cidade> navegCidades = new Stack();
        Stack<Estrada> navegEstradas = new Stack();
        Cidade proxCidade, cidade = cidades[1];
        Estrada ant;
        int carruagem;
        int menorDistancia = 0;

        while (cidades[1].imposto != montanteTotal) {
            carruagem = 0;
            for (int i = 0; i < cidade.caminhos.size(); i++) {
                if (cidade.caminhos.get(i).cidadeB == cidade) {
                    proxCidade = cidade.caminhos.get(i).cidadeA;
                } else {
                    proxCidade = cidade.caminhos.get(i).cidadeB;
                }

                if (cidade.caminhos.get(i).visitada == false) {

                    cidade.cont = i;
                    navegCidades.push(cidade);
                    navegEstradas.push(cidade.caminhos.get(i));
                    ant = cidade.caminhos.get(i);
                    ant.visitada = true;
                    menorDistancia += ant.tamanho;                    
                    cidade = proxCidade;
                    i = -1;
                }

            }
            System.out.println(menorDistancia);
          System.out.println(cidade.id);
            while (cidade.imposto != 0) {
                ant = navegEstradas.peek();

                if (cidade.imposto > capCarruagem) {
                    carruagem += capCarruagem;
                    cidade.imposto -= capCarruagem;
                   // System.out.println(2*ant.tamanho);
                    menorDistancia += ant.tamanho * 2;
                } else {
                   // System.out.println(ant.tamanho);
                    menorDistancia += ant.tamanho;
                    carruagem += cidade.imposto;
                    cidade.imposto = 0;
                }
            }
            cidade = navegCidades.pop();
            navegEstradas.pop();
            cidade.imposto += carruagem;

        }
        return menorDistancia;
    }

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        int numCidades = ler.nextInt();
        while (numCidades < 2 || numCidades > 10000) {
            numCidades = ler.nextInt();
        }
        int capCarruagem = ler.nextInt();
        while (capCarruagem < 1 || capCarruagem > 100) {
            capCarruagem = ler.nextInt();
        }
        Cidade[] cidades = new Cidade[numCidades + 1];
        Cidade cidade;
        int impostoTotal = 0;
        
        for (int i = 1; i <= numCidades; i++) {
            
            cidade = new Cidade();
            cidade.id = i;
            cidade.imposto = ler.nextInt();
            cidades[i] = cidade;
            impostoTotal += cidade.imposto;

        }

        for (int i = 0; i < numCidades - 1; i++) {

            int part = ler.nextInt();
            int cheg = ler.nextInt();
            int compri = ler.nextInt();

            Cidade cidadeA = cidades[part];
            Cidade cidadeB = cidades[cheg];

            Estrada estrada = new Estrada();
            estrada.tamanho = compri;
            estrada.cidadeA = cidadeA;
            estrada.cidadeB = cidadeB;
            
            cidadeA.caminhos.add(estrada);
            cidadeB.caminhos.add(estrada);

        }
        System.out.println(recolheImpostos(cidades, capCarruagem, impostoTotal));
    }

}
