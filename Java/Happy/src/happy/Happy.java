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
public class Happy {

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

        int count = 0;
        if (b > 1) {
            while (horarios[0].length() > 1) {
                if (horarios[0].charAt(0) != '\n') {
                    int j = 1, p = 0;
                    while (p == 0 && horarios[j] != null && horarios[j].charAt(0) != '\n') {
                        if (horarios[j].length() < 1 || horarios[0].length() < 1) {
                            p = 1;
                            horarios = null;
                        }
                        if (horarios[0].charAt(0) < horarios[j].charAt(0)) {
                            p = 1;
                        } else if (horarios[0].charAt(0) > horarios[j].charAt(0)) {
                            while (horarios[j].charAt(0) < horarios[0].charAt(0)) {
                                System.out.println(horarios[j].charAt(0) + " " + j);
                                if (horarios[j].charAt(0) == ' ' ) {
                                    for (int i = 0; i < b; i++) {
                                        if (horarios[i].length() > 1) {
                                            while (horarios[i].charAt(0) != ' ') {
                                                horarios[i] = horarios[i].substring(1);
                                            }
                                        } else {
                                            p = 1;
                                            horarios[0] = "\n";
                                            break;
                                        }

                                    }
                                    break;
                                } else {
                                    horarios[j] = horarios[j].substring(1);
                                }
                                if (horarios[j].length() < 1) {
                                    p = 1;
                                }
                                break;
                            }

                        } else if (horarios[0].charAt(0) == horarios[j].charAt(0)) {
                            horarios[j] = horarios[j].substring(1);
                            count++;
                            if (horarios[j].length() < 1 || horarios[0].length() < 1) {
                                p = 1;
                                sb.append(horarios[0].charAt(0));
                                horarios[0] = "\n";
                            }
                            j++;
                            if (j == b) {
                                p = 1;
                            }
                        } else if (horarios[j].charAt(0) < horarios[0].charAt(0)) {
                            while (horarios[j].charAt(0) < horarios[0].charAt(0)) {
                                horarios[j] = horarios[j].substring(1);
                            }
                            if (horarios[j].length() < 1 || horarios[0].length() < 1) {
                                p = 1;
                                sb.append(horarios[0].charAt(0));
                                horarios[0] = "\n";
                            }
                            j++;
                        }
                        if (j < b) {
                            if (horarios[j].length() < 1) {
                                p = 1;
                            }
                        }
                    }

                    if (count == (b - 1)) {
                        sb.append(horarios[0].charAt(0));
                    }
                    horarios[0] = horarios[0].substring(1);
                    count = 0;
                    j = 1;
                } else {

                }

            }
            System.out.println(sb.toString());
        } else {
            System.out.println(horarios[0]);
        }
    }

}
