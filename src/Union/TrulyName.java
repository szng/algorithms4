/**
 * leetcode 面试题17.07
 * 计算size
 */
package Union;

import java.util.*;

public class TrulyName {
    private Map<String, String> id;
    private Map<String, Integer> size;

    public String root(String e) {
        if (e.equals(id.get(e))) {
            return e;
        }
        String temp = root(id.get(e));
        id.put(e, temp);
        return temp;
    }

    public boolean isConnected(String p, String q) {
        p = root(p);
        q = root(q);
        return p == q;
    }

    public void union(String p, String q) {
        p = root(p);
        q = root(q);
        if (p.equals(q)) {
            return;
        }
        int psize = size.get(p);
        int qsize = size.get(q);
        if (p.compareTo(q) < 0) {
            id.put(q, p);
            size.put(p, psize + qsize);
        } else {
            id.put(p, q);
            size.put(q, psize + qsize);
        }
    }


    public String[] solve(String[] names, String[] synonyms) {
        id = new HashMap<>();
        size = new HashMap<>();
        int n = names.length;
        for (int i = 0; i < n; i++) {
            int index = names[i].indexOf('(');
            String name = names[i].substring(0, index);
            String number = names[i].substring(index + 1, names[i].length() - 1);
            id.put(name, name);
            size.put(name, Integer.valueOf(number));
        }
        int m = synonyms.length;
        for (int i = 0; i < m; i++) {
            String[] parts = synonyms[i].split(",");
            String name1 = parts[0].substring(1);
            String name2 = parts[1].substring(0, parts[1].length() - 1);
            if (!id.containsKey(name1)) {
                id.put(name1, name1);
                size.put(name1, 0);
            }
            if (!id.containsKey(name2)) {
                id.put(name2, name2);
                size.put(name2, 0);
            }
            union(name1, name2);
        }
        Set<String> results = new HashSet<>();
        for (String s : id.keySet()) {
            String result = root(s);
            int count = size.get(result);
            if (count != 0) {
                results.add(result + "(" + count + ")");
            }

        }
        String[] ans = new String[results.size()];
        results.toArray(ans);
        return ans;
    }

    public static void main(String[] args) {
        String[] names = {"a(10)", "c(13)"};
        String[] synonyms = {"(a,b)", "(c,d)", "(b,c)"};
        TrulyName a = new TrulyName();
        String[] results = a.solve(names, synonyms);
        Arrays.sort(results);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
