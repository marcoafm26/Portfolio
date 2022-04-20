/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmantrie;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author Marco
 */
public class HuffmanTree {

    Node raiz;
    String treeCarac = "";

    public HuffmanTree() {
        raiz = null;
    }

    private class Node implements Comparable<Node> {

        Node esq, dir;
        char carac;
        int frequencia;

        private Node(char carac) {
            this.carac = carac;
            this.frequencia = 0;
        }

        private Node(Node esq, Node dir) {
            this.frequencia = esq.frequencia + dir.frequencia;
            this.esq = esq;
            this.dir = dir;
            this.carac = '\0';
        }

        private void add() {
            frequencia++;
        }

        @Override
        public int compareTo(Node node) {
            return frequencia - node.frequencia;
        }

    }

    public void huffman(String texto) {

        StringBuilder sb = new StringBuilder();
        raiz = Arvore(frequencia(texto));
        Map<Character, String> map = new HashMap();
        map = Tabela(raiz, "", map);
        PreOrdem(raiz, "");
        sb.append(treeCarac).append(toBinary(texto.length()));
        String aux = "";

        for (int i = 0; i < texto.length(); i++) {
            aux += map.get(texto.charAt(i));
            sb.append(map.get(texto.charAt(i)));
        }

        int mod = sb.toString().length() % 8;

        for (int i = 0; i < 8 - mod; i++) {
            sb.append("0");
        }
        System.out.println(sb.length() + " bits");

    }

    private Node Arvore(PriorityQueue<Node> node) {
        Node pai = null, esq, dir;
        while (!node.isEmpty()) {
            esq = node.poll();
            dir = node.poll();
            pai = new Node(esq, dir);

            if (!node.isEmpty()) {
                node.add(pai);
            }
        }
        return pai;
    }

    private Map Tabela(Node raiz, String code, Map<Character, String> map) {
        if (raiz.esq == null && raiz.dir == null) {
            if (raiz.carac != '\0') {
                map.put(raiz.carac, code);
            }
            return map;
        }
        Tabela(raiz.esq, code + "0", map);
        Tabela(raiz.dir, code + "1", map);
        return map;
    }

    private PriorityQueue<Node> frequencia(String texto) {
        Map<Character, Node> map = new HashMap();
        for (int j = 0; j < texto.length(); j++) {
            if (!map.containsKey(texto.charAt(j))) {
                map.put(texto.charAt(j), new Node(texto.charAt(j)));
            }
            map.get(texto.charAt(j)).add();
        }
        return new PriorityQueue<>(map.values());
    }

    private void PreOrdem(Node raiz, String pre) {
        if (raiz != null) {
            if (raiz.esq != null && raiz.dir != null) {
                setTree(pre + "0");
            } else {
                setTree(pre + "1" + toBinary(raiz.carac));
            }
            PreOrdem(raiz.esq, pre);
            PreOrdem(raiz.dir, pre);
        }
    }

    private String toBinary(char b) {
        String bin = Integer.toBinaryString(b);
        while (bin.length() < 8) {
            bin = "0" + bin;
        }
        return bin;
    }

    private String toBinary(int b) {
        String bin = Integer.toBinaryString(b);
        while (bin.length() < 32) {
            bin = "0" + bin;
        }
        return bin;
    }

    private void setTree(String in) {
        this.treeCarac = this.treeCarac + in;
    }

    private void resetTree() {
        this.treeCarac = "";
    }
}
