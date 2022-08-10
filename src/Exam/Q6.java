package Exam;
/*
zoom 第二题
 */

import java.util.HashMap;
import java.util.Scanner;

public class Q6 {
    public static class Union {
        private int[] id;
        private int[] size;

        public int root(int e) {
            while (e != id[e]) {
                id[e] = id[id[e]];
                e = id[e];
            }
            return e;
        }

        public void connect(int p, int q) {
            p = root(p);
            q = root(q);
            if (size[p] < size[q]) {
                int temp = p;
                p = q;
                q = temp;
            }
            if (p != q) {
                id[q] = p;
                size[p] += size[q];
            }
        }

        public int count(int e) {
            return size[root(e)];
        }

        public void initial() {
            int n = 10000 * 5;
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                size[i] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Union union = new Union();
        union.initial();

        StringBuilder result = new StringBuilder();
        HashMap<String, Integer> stokes = new HashMap<>();
        HashMap<String, Integer> names = new HashMap<>();
        HashMap<String, Integer> nameStoke = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            if (scanner.nextInt() == 1) {
                String name = scanner.next();
                int num = scanner.nextInt();
                names.put(name, num);
                scanner.nextLine();
                String[] temp = scanner.nextLine().split(" ");
                for (int j = 0; j < num; j++) {
                    String stoke = temp[j];
                    if (stokes.get(stoke) == null) {
                        stokes.put(stoke, stokes.size());
                    }
                    union.connect(stokes.get(temp[0]), stokes.get(stoke));
                }
                nameStoke.put(name, stokes.get(temp[0]));
            } else {
                String name = scanner.next();
                if (names.get(name) == null) {
                    result.append("error\n");
                } else {
                    int sum = union.count(nameStoke.get(name)) - names.get(name);
                    result.append(sum);
                    result.append("\n");
                }
            }
        }
        System.out.println(result);
    }
}