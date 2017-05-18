package ru.itis.theory;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Typic {

    public static ArrayList<ArrayList<Node[]>> tupics = new ArrayList<ArrayList<Node[]>>();
    public static ArrayList<ArrayList<Node[]>> min = new ArrayList<ArrayList<Node[]>>();

    private static boolean table[][] = new boolean[1000][1000];

    public static void samp(String function, Node[][] nodes, int size, PrintWriter pw) {

        /*ru.itis.theory.Node[][] nodes = new ru.itis.theory.Node[size+1][4];
        ru.itis.theory.Node node1 = new ru.itis.theory.Node('x',true,false);
        ru.itis.theory.Node node11 = new ru.itis.theory.Node('x',true,true);
        ru.itis.theory.Node node2 = new ru.itis.theory.Node('y',true,false);
        ru.itis.theory.Node node9 = new ru.itis.theory.Node('y',true,true);
        ru.itis.theory.Node node10 = new ru.itis.theory.Node('t',false,true);
        ru.itis.theory.Node node3 = new ru.itis.theory.Node('z',true,true);
        ru.itis.theory.Node node4 = new ru.itis.theory.Node('t',true,true);
        ru.itis.theory.Node node5 = new ru.itis.theory.Node('z',true,false);
        ru.itis.theory.Node node6 = new ru.itis.theory.Node('t',true,false);
        ru.itis.theory.Node node7 = new ru.itis.theory.Node('x',false,false);
        ru.itis.theory.Node node8 = new ru.itis.theory.Node('y',false,false);
        ru.itis.theory.Node node13 = new ru.itis.theory.Node('t',false,false);
        ru.itis.theory.Node node14 = new ru.itis.theory.Node('z',false,false);
        nodes[0] = new ru.itis.theory.Node[]{node1,node2,node3,node4};
        nodes[1] = new ru.itis.theory.Node[]{node11,node2,node3,node6};
        nodes[2] = new ru.itis.theory.Node[]{node1,node9,node5,node13};
        nodes[3] = new ru.itis.theory.Node[]{node7,node9,node3,node6};
        nodes[4] = new ru.itis.theory.Node[]{node7,node8,node14,node4};
        *//*String function = "1111010010101011";
        */
        buildTypic(function,nodes, size, pw);
    }

    public static void buildTypic(String function, Node[][] nodes, int size,PrintWriter pw) {

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
        //System.out.println(list);
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

        //System.out.println(list1);
        pw.println("Тупиковые");
        show(list1.get(list1.size()-1),pw);
        tupics = list1.get(list1.size()-1);
        pw.println("Минимальные");
        int count = showMin(list1.get(list1.size()-1),pw);
        min = list1.get(list1.size()-1);
    }


    public static boolean isOne(int i, Node[] nodes) {
        String kon = Node.getBinary(i);
        for (int k = 0; k < nodes.length; k++) {
            if ((kon.charAt(k) == '1' && nodes[k].getNegative() || (kon.charAt(k) == '0' && !nodes[k].getNegative())) && nodes[k].isBound()) {
                return false;
            }
        }
        return true;
    }
    public static boolean existsInPrev(ArrayList<Node[]> ks, ArrayList<ArrayList<Node[]>> stolbec){

        for (int i=0; i<stolbec.size();i++){
            if (ks.size()==stolbec.get(i).size()){
                if (ks.containsAll(stolbec.get(i))&&stolbec.get(i).containsAll(ks)){
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
                int count = 0;
                if (ks1.containsAll(ks) && !excces.contains(ks1)){
                    excces.add(ks1);
                    count++;
                }
                if (ks.containsAll(ks1) && !excces.contains(ks)){
                    excces.add(ks);
                    count++;
                }
                if (count==2) {
                    excces.remove(ks1);
                }

            }
        }
        stolbec.removeAll(excces);
        return stolbec;
    }
    public static void show(ArrayList<ArrayList<Node[]>> stolbec,PrintWriter pw){
        for (int i=0; i<stolbec.size();i++){
            for (int j=0; j<stolbec.get(i).size();j++){
                showNode(stolbec.get(i).get(j),pw);
                if (j!=stolbec.get(i).size()-1) {
                    pw.print(" v ");
                }
            }
            pw.println();
        }
    }
    public static void showNode(Node[] nodes,PrintWriter pw){
        for (Node node: nodes){
            if (node.isBound()){
                if (node.getNegative()){
                    pw.print("-"+node.getKey());
                }
                else{
                    pw.print(node.getKey());
                }
            }
        }
    }
    public static int showMin(ArrayList<ArrayList<Node[]>> stolbec,PrintWriter pw){
        int min=countVar(stolbec.get(0));
        for (int i=0; i<stolbec.size();i++){
            if (countVar(stolbec.get(i))<min){
                min=countVar(stolbec.get(i));
            }
        }
        for (int i=0; i<stolbec.size();i++){
            if (countVar(stolbec.get(i))==min){
                for (int j=0; j<stolbec.get(i).size();j++){
                    showNode(stolbec.get(i).get(j),pw);
                    if (j!=stolbec.get(i).size()-1) {
                        pw.print(" v ");
                    }
                }
                pw.println();
            }
        }
        return min;
    }
    public static int countVar(ArrayList<Node[]> ks){
        int count = 0;
        for (Node[] nodes: ks){
            for (int i=0; i<nodes.length;i++){
                if (nodes[i].isBound()){
                    count++;
                }
            }
        }
        return count;
    }


}
