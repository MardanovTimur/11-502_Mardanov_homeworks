package ru.itis.theory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by alisa on 17.04.2017.
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C:\\DNF\\in.txt"));
        while (sc.hasNextLine()) {
            int fileOutName = sc.nextInt();
            StringBuilder function = new StringBuilder();
            for (int i = 0; i < 16; i++) {
                function.append(String.valueOf(sc.nextInt()));
            }
            //"1011101100110111"
            PrintWriter pw = new PrintWriter(new File("C:\\DNF\\out\\"+String.valueOf(fileOutName)+".txt"));
            Quine4Params quine4Params = new Quine4Params(function.toString());
            Node nodes[][] = quine4Params.getPerfectDNF();
            pw.println("Совершенная ДНФ:");
            pw.println(quine4Params.convertFromNodeToString(nodes, quine4Params.sizePerfect));
            Node nodesS[][] = quine4Params.getShortedDNF(nodes);
            pw.println("Сокращенная ДНФ:");
            pw.println(quine4Params.convertFromNodeToString(nodesS, quine4Params.sizeShorted));
            Typic.samp(function.toString(), nodesS, quine4Params.sizeShorted, pw);
            pw.close();
        }
        sc.close();
    }
}