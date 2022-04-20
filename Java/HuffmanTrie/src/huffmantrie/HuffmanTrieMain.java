/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmantrie;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Marco
 */
public class HuffmanTrieMain {

    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String text = ler.nextLine();

        sb.append(text);

        HuffmanTree huff = new HuffmanTree();
        huff.huffman(sb.toString());
    }

}
