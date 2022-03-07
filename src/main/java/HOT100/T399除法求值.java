package HOT100;

import java.util.*;

public class T399除法求值 {
    public static void main(String[] args) {
        List<String> euqations_1 = new ArrayList<>();
        euqations_1.add("a");
        euqations_1.add("b");

        List<String> euqations_2 = new ArrayList<>();
        euqations_2.add("b");
        euqations_2.add("c");

        List<List<String>> equations = new ArrayList<>();
        equations.add(euqations_1);
        equations.add(euqations_2);

        double[] values = new double[]{2.0, 3.0};

        List<String> querier_1 = new ArrayList<>();
        querier_1.add("a");
        querier_1.add("c");
        List<String> querier_2 = new ArrayList<>();
        querier_2.add("b");
        querier_2.add("a");
        List<String> querier_3 = new ArrayList<>();
        querier_3.add("a");
        querier_3.add("e");
        List<String> querier_4 = new ArrayList<>();
        querier_4.add("a");
        querier_4.add("a");
        List<String> querier_5 = new ArrayList<>();
        querier_5.add("x");
        querier_5.add("x");

        List<List<String>> queries = new ArrayList<>();
        queries.add(querier_1);
        queries.add(querier_2);
        queries.add(querier_3);
        queries.add(querier_4);
        queries.add(querier_5);

        double[] res = calcEquation(equations, values, queries);

        System.out.println(res.toString());

    }
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars = 0;
        Map<String, Integer> variables = new HashMap<String, Integer>();

        int n = equations.size();
        for (int i = 0; i < n; i++) {
            if (!variables.containsKey(equations.get(i).get(0))) {
                variables.put(equations.get(i).get(0), nvars++);
            }
            if (!variables.containsKey(equations.get(i).get(1))) {
                variables.put(equations.get(i).get(1), nvars++);
            }
        }

        // 对于每个点，存储其直接连接到的所有点及对应的权值
        List<Pair>[] edges = new List[nvars];
        for (int i = 0; i < nvars; i++) {
            edges[i] = new ArrayList<Pair>();
        }
        for (int i = 0; i < n; i++) {
            int va = variables.get(equations.get(i).get(0));
            int vb = variables.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb, values[i]));
            edges[vb].add(new Pair(va, 1.0 / values[i]));
        }

        int queriesCount = queries.size();
        double[] ret = new double[queriesCount];
        for (int i = 0; i < queriesCount; i++) {
            List<String> query = queries.get(i);
            double result = -1.0;
            if (variables.containsKey(query.get(0)) && variables.containsKey(query.get(1))) {
                int ia = variables.get(query.get(0)), ib = variables.get(query.get(1));
                if (ia == ib) {
                    result = 1.0;
                } else {
                    Queue<Integer> points = new LinkedList<Integer>();
                    points.offer(ia);
                    double[] ratios = new double[nvars];
                    Arrays.fill(ratios, -1.0);
                    ratios[ia] = 1.0;

                    while (!points.isEmpty() && ratios[ib] < 0) {
                        int x = points.poll();
                        for (Pair pair : edges[x]) {
                            int y = pair.index;
                            double val = pair.value;
                            if (ratios[y] < 0) {
                                ratios[y] = ratios[x] * val;
                                points.offer(y);
                            }
                        }
                    }
                    result = ratios[ib];
                }
            }
            ret[i] = result;
        }
        return ret;
    }

    static class Pair {
        int index;
        double value;

        Pair(int index, double value) {
            this.index = index;
            this.value = value;
        }
    }
}
