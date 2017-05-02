package ru.itis.theory;

import java.util.Scanner;

/**
 * Created by alisa on 17.04.2017.
 */
public class Test {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите функцию:");
            String function = sc.nextLine();
            //"1011101100110111"
            Quine4Params quine4Params = new Quine4Params(function);
            Node nodes[][] = quine4Params.getPerfectDNF();
            System.out.println("Совершенная ДНФ:");
            System.out.println(quine4Params.convertFromNodeToString(nodes, quine4Params.sizePerfect));
            Node nodesS[][] = quine4Params.getShortedDNF(nodes);
            System.out.println("Сокращенная ДНФ:");
            System.out.println(quine4Params.convertFromNodeToString(nodesS, quine4Params.sizeShorted));
            Typic.samp(function, nodesS, quine4Params.sizeShorted);
            sc.nextLine();
        }
    }
}