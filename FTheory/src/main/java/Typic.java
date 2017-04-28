import java.lang.reflect.Array;
import java.util.ArrayList;

public class Typic {

    private static boolean table[][] = new boolean[1000][1000];

    public static void main(String[] args) {
        Node[][] nodes = new Node[2][4];
        Node node1 = new Node('x',true,false);
        Node node2 = new Node('y',true,false);
        Node node3 = new Node('z',true,false);
        Node node4 = new Node('t',true,false);
        Node node5 = new Node('t',false,false);
        nodes[0] = new Node[]{node1,node2,node3,node4};
        nodes[1] = new Node[]{node1,node2,node3,node5};
        String function = "1100000000000000";
        buildTypic(function,nodes,2);
    }

    public static void buildTypic(String function, Node[][] nodes, int size) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < function.length(); j++) {
                if (function.charAt(j) == '1') {

                    table[i][j] = isOne(j, nodes[i]);

                }
            }
        }
        ArrayList<ArrayList<ArrayList<Node[]>>> list = new ArrayList<ArrayList<ArrayList<Node[]>>>();
        for (int m = 0; m < function.length(); m++) {
            if (function.charAt(m) == '1') {
                ArrayList<ArrayList<Node[]>> nodes1 = new ArrayList<ArrayList<Node[]>>();
                for (int i = 0; i < size; i++) {
                    if (table[i][m]) {
                        ArrayList<Node[]> nodes2 = new ArrayList<Node[]>();
                        nodes2.add(nodes[i]);
                        nodes1.add(nodes2);
                    }

                }
                list.add(nodes1);
            }
        }
        System.out.println(list);
        ArrayList<ArrayList<ArrayList<Node[]>>> list1 = list;

        for (int i = 1; i < list1.size(); i++){
            ArrayList<ArrayList<Node[]>> stolbec = new ArrayList<ArrayList<Node[]>>();
            for (int j=0; j<list1.get(i).size();j++){
                ArrayList<Node[]> ks1 = list1.get(i).get(j);
                if (!existsInPrev(ks1,list1.get(i-1))) {
                    for (int k = 0; k < list1.get(i - 1).size(); k++) {
                        ArrayList<Node[]> ks2 = list1.get(i - 1).get(k);
                        ArrayList<Node[]> newks = makeSet(ks2,ks1);
                        stolbec.add(newks);
                    }
                }
                else{
                    ArrayList<Node[]> newks = new ArrayList<Node[]>();
                    newks.addAll(ks1);
                    stolbec.add(newks);
                }

            }
        list1.set(i,buildStolbec(stolbec));
        }

        System.out.println(list1);
        show(list1.get(list1.size()-1));
    }


    public static boolean isOne(int i, Node[] nodes) {
        String kon = Node.getBinary(i);
        for (int k = 0; k < nodes.length; k++) {
            if ((kon.charAt(k) == '1' && nodes[k].getNegative() || (kon.charAt(k) == '0' && !nodes[k].getNegative())) && !nodes[k].isBound()) {
                return false;
            }
        }
        return true;
    }
    public static boolean existsInPrev(ArrayList<Node[]> ks, ArrayList<ArrayList<Node[]>> stolbec){

        for (int i=0; i<stolbec.size();i++){
            if (ks.size()==stolbec.get(i).size()){
                if (ks.containsAll(stolbec.get(i))&&stolbec.containsAll(ks)){
                    return true;
                }
            }
        }
        return false;
    }
    public static ArrayList<Node[]> makeSet(ArrayList<Node[]> ks1, ArrayList<Node[]> ks2){
        ArrayList<Node[]> ks3 = new ArrayList<Node[]>();
        ks3.addAll(ks2);
        for (Node[] nodes: ks1){
            if (!ks2.contains(nodes)){
                ks3.add(nodes);
            }
        }
        return ks3;
    }
    public static ArrayList<ArrayList<Node[]>> buildStolbec(ArrayList<ArrayList<Node[]>> stolbec){
        ArrayList<ArrayList<Node[]>> excces= new ArrayList<ArrayList<Node[]>>();
        for (int i=0; i<stolbec.size();i++){
            ArrayList<Node[]> ks = stolbec.get(i);
            for (int j=i+1;j<stolbec.size();j++){
                ArrayList<Node[]> ks1 = stolbec.get(j);
                if (ks1.containsAll(ks) && !excces.contains(ks1)){
                    excces.add(ks1);
                }
                if (ks.containsAll(ks1) && !excces.contains(ks)){
                    excces.add(ks);
                }
            }
        }
        stolbec.removeAll(excces);
        return stolbec;
    }
    public static void show(ArrayList<ArrayList<Node[]>> stolbec){
        for (int i=0; i<stolbec.size();i++){
            for (int j=0; j<stolbec.get(i).size();j++){
                showNode(stolbec.get(i).get(j));
                if (j!=stolbec.get(i).size()-1) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }
    public static void showNode(Node[] nodes){
        for (Node node: nodes){
            if (!node.isBound()){
                if (node.getNegative()){
                    System.out.print("-"+node.getKey());
                }
                else{
                    System.out.print(node.getKey());
                }
            }
        }
    }


}
