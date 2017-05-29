package ru.itis.inform;

/**
 * Created by Timur Mardanov on 09.05.2017.
 * ITIS
 */
public class SearchInDeep {
    private int[][] matrix;
    private boolean[] used;
    private int[] parents;


    void visitLow(int u) {
        used[u] = true;
        for (int it = 0; it != matrix[u].length; it++)
            if (!used[it]) {
                parents[it] = u;
                visitLow(it);
            }
    }

    void visitBCC(int u) {
        for(int it = 0; it != matrix[u].length; it++)
            if(parents[it] == u) {
            bcc[*it] = (low[*it] < enter[u]) ? bcc[u] :         // Дочернее ребро эквивалентно текущему
            (low[*it] > enter[u]) ? -1 :             // Дочернее ребро есть мост
            (newIndex++);                            // Дочернее ребро лежит в новой компоненте
            visitBCC(*it);
        }
    }

    public SearchInDeep(int[][] matrix) {
        this.matrix = matrix;
        this.used = new boolean[matrix.length];
        dfs(0);
        init();
    }

    private void init() {
        parents = new int[matrix.length];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = -1;
        }
    }

    //TODO Что должен возвращать тип при поиске
    public Integer search(int value) {
        return null;
    }

    private void dfs(int pos) {
        used[pos] = true;
        System.out.println(pos);
        for (int next : matrix[pos])
            if (!used[next])
                dfs(next);
    }
}
