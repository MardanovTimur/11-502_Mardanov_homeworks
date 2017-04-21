/**
 * Created by alisa on 17.04.2017.
 */
public class Test {
    public static void main(String[] args) {
        Quine4Params quine4Params = new Quine4Params("1111111100000000");
        Node nodes[][] = quine4Params.getPerfectDNF();
        System.out.println(quine4Params.convertFromNodeToString(nodes, quine4Params.sizePerfect));
        Node nodesS[][] = quine4Params.getShortedDNF(nodes);
        System.out.println(quine4Params.convertFromNodeToString(nodesS, quine4Params.sizeShorted));
    }
}