package ru.itis.theory;

import java.util.*;

/**
 * Created by alisa on 17.04.2017.
 */
public class Quine4Params {

    private String function;
    private String PerfectDNF;
    public static int sizePerfect;
    private String ShortedDNF;
    public static int sizeShorted;
    private String[] DeadEndDNF;
    private String[] MinimazesDNF;
    private static final int n = 16;
    private static final int m = 4;

    private static final char params[] = new char[]{'x', 'y', 'z', 't'};

    private Node[][] nodes = new Node[200][4];

    public Quine4Params(String function) {
        this.function = function;
    }

    private String getBinary(int i) {
        String binCode = "";
        while (i > 0) {
            binCode = binCode.concat(String.valueOf(i % 2));
            i = i / 2;
        }

        while (binCode.length() != 4) {
            binCode = binCode.concat("0");
        }

        return new StringBuilder(binCode).reverse().toString();
    }

    public Node[][] getPerfectDNF() {
        int step = -1;
        for (int i = 0; i < n; i++) {
            if (this.function.charAt(i) != '0') {
                step++;
                String stepJ = getBinary(i);
                for (int j = 0; j < m; j++) {
                    boolean negative = true;
                    if (stepJ.charAt(j) != '0') {
                        negative = false;
                    }
                    nodes[step][j] = new Node(params[j], negative);
                }
            }
        }
        sizePerfect = step + 1;
        return nodes;
    }

    public String convertFromNodeToString(Node[][] nodesP, int size) {
        String str = "";
        for (int i = 0; i < size; i++) {
            boolean firstIsSet = false;
            for (int j = 0; j < 4; j++) {
                if (nodesP[i][j].isBound()) {
                    String r = "-";
                    if (!nodesP[i][j].isNegative()) {
                        r = "";
                    }
                    if (j != 0 && str.length() > 0 && firstIsSet) {
                        str = str.concat("");
                    }
                    str = str.concat(r.concat(nodesP[i][j].getKey().toString()));
                    firstIsSet = true;
                }
            }
            if (i != size - 1) {
                str = str.concat(" v ");
            }
        }
        return str;
    }

    public Node[][] getShortedDNF(Node[][] nodesG) {
        int sizeDef = 0;
        int sizeUp = sizePerfect;
        int sizeNodes = sizePerfect;
        LinkedList<Node[]> linkedNodes = new LinkedList<Node[]>();
        for (int i = 0; i < sizePerfect; i++) {
            linkedNodes.addLast(nodesG[i]);
        }
        Set<Node[]> NewSet = new HashSet<Node[]>();
        LinkedList<Node[]> newNodes = new LinkedList<Node[]>();
        Set<Node[]> finalNodes = new HashSet<Node[]>();
        boolean f = true;
        while (f) {
            f = false;
            for (int i = 0; i < linkedNodes.size() - 1; i++) {
                for (int j = i + 1; j < linkedNodes.size(); j++) {
                    int difference = 0;
                    int position = -1;
                    for (int k = 0; k < 4; k++) {
                        if (linkedNodes.get(i)[k].isBound() == linkedNodes.get(j)[k].isBound()) {
                            if (!linkedNodes.get(i)[k].isBound()) {
                            } else {
                                if (linkedNodes.get(i)[k].isNegative() != linkedNodes.get(j)[k].isNegative()) {
                                    difference++;
                                    position = k;
                                }
                            }
                        } else {
                            difference = 0;
                            break;
                        }
                    }
                    if (difference == 1) {
                        f = true;
                        Node[] ne = new Node[4];
                        for (int z = 0; z < 4; z++) {
                            ne[z] = new Node();
                            ne[z].setKey(linkedNodes.get(i)[z].getKey());
                            ne[z].setNegative(linkedNodes.get(i)[z].isNegative());
                            ne[z].setBound(linkedNodes.get(i)[z].isBound());
                        }
                        newNodes.addLast(ne);
                        newNodes.getLast()[position].setBound(false);
                    }
                }
            }

            Set<Node[]> OldSet = new HashSet<Node[]>();
            OldSet.addAll(linkedNodes);
            NewSet = new HashSet<Node[]>();
            NewSet.addAll(newNodes);

            for (Node[] newNode : newNodes) {
                for (Node[] oldNode : linkedNodes) {
                    int k = 0;
                    int l = 0;
                    for (int i = 0; i < 4; i++) {
                        if (newNode[i].isBound() == oldNode[i].isBound() && newNode[i].isBound()) {
                            if (newNode[i].isNegative() != oldNode[i].isNegative()) {
                                break;
                            } else {
                                k++;
                            }
                        }
                    }
                    int sizeNewNode = 0;

                    for (int a = 0; a < 4; a++) {
                        if (newNode[a].isBound()) {
                            sizeNewNode++;
                        }
                    }

                    if (sizeNewNode == k) {
                        OldSet.remove(oldNode);
                    }
                }
            }
            finalNodes.addAll(OldSet);


            if (NewSet.size() == 0) {
                f = false;
                break;
            }

            linkedNodes = new LinkedList<Node[]>();
            for (Node[] aNewSet : NewSet) {
                linkedNodes.addFirst(aNewSet);
            }
            newNodes = new LinkedList<Node[]>();


        }

        finalNodes.addAll(NewSet);
        sizeShorted = finalNodes.size();
        LinkedList<Node[]> list = new LinkedList<Node[]>();
        list.addAll(finalNodes);
        return (Node[][]) getNormally((LinkedList<Node[]>) list);
    }


    public Node[][] getNormally(LinkedList<Node[]> linkedList) {
        Set<Node[]> set = new HashSet<Node[]>();
        for (int i = 0; i < linkedList.size() - 1; i++) {
            for (int j = i + 1; j < linkedList.size(); j++) {
                int sum1 = 0, sum2 = 0;
                for (int s = 0; s < 4; s++) {
                    int lo = 0, lo1 = 0;
                    if (linkedList.get(i)[s].isBound()) {
                        lo = 1;
                    }
                    if (linkedList.get(j)[s].isBound()) {
                        lo1 = 1;
                    }
                    sum1 += lo;
                    sum2 += lo1;
                }
                if (sum1 > sum2) {
                    Node[] m = linkedList.get(j);
                    linkedList.set(j, linkedList.get(i));
                    linkedList.set(i, m);
                }
            }
        }
        Set<Node[]> set1 = new HashSet<Node[]>();
        set1.addAll(linkedList);
        Set<Node[]> newSet = new HashSet<Node[]>();
        LinkedList<Node[]> list = new LinkedList<Node[]>();
        list.addAll(set1);
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                boolean f1 = false;
                for (int k = 0; k < 4; k++) {
                    if (list.get(i)[k].isBound() && list.get(j)[k].isBound()) {
                        if (list.get(i)[k].isNegative() == list.get(j)[k].isNegative()) {
                            f1 = true;
                        } else {
                            if (!isContain(newSet, list.get(i)))
                                newSet.add(list.get(i));
                            if (!isContain(newSet, list.get(j)))
                                newSet.add(list.get(j));
                            break;
                        }
                    } else {
                        if (!isContain(newSet, list.get(i)))
                            newSet.add(list.get(i));
                        if (!isContain(newSet, list.get(j)))
                            newSet.add(list.get(j));
                        break;
                    }
                }
                if (f1) {
                    if (!isContain(newSet, list.get(i)))
                        newSet.add(list.get(i));
                    if (!isContain(newSet, list.get(j)))
                        newSet.add(list.get(j));
                }
            }
        }

        sizeShorted = newSet.size();
        return newSet.toArray(new Node[newSet.size()][4]);
    }


    private boolean isContain(Set<Node[]> set, Node[] el) {
        boolean f1 = false;
        int sum1 = 0;
        for (int s = 0; s < 4; s++) {
            int lo = 0;
            if (el[s].isBound()) {
                lo = 1;
            }
            sum1 += lo;
        }

        for (Node[] element : set) {
            boolean inner = false;


            int sum2 = 0;
            for (int s = 0; s < 4; s++) {
                int lo = 0;
                if (element[s].isBound()) {
                    lo = 1;
                }
                sum2 += lo;
            }

            if (sum1 == sum2) {
                for (int k = 0; k < 4; k++) {
                    if (element[k].isBound() == el[k].isBound() && element[k].isBound()) {
                        if (element[k].isNegative() == el[k].isNegative()) {
                            inner = true;
                        } else {
                            inner = false;
                            break;
                        }
                    } else {
                        if (element[k].isBound() != el[k].isBound()) {
                            inner = false;
                            break;
                        } else {
                            if (element[k].isBound() == el[k].isBound()) {

                            }
                        }
                    }
                }
            }

            if (inner)
                return true;
        }
        return false;
    }

    private Node[][] removeduplicates(Node[][] arr) {
        int end = arr.length;
        Set<Node[]> set = new HashSet<Node[]>();

        for (int i = 0; i < end; i++) {
            set.add(arr[i]);
        }
        sizeShorted = set.size();
        Node[][] nodes = (Node[][]) set.toArray(new Node[set.size()][4]);
        return nodes;
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public void setNodes(Node[][] nodes) {
        this.nodes = nodes;
    }
}
