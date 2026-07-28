import java.io.*;
import java.util.*;

public class Main {

    static final boolean DEBUG = true;

// ======================== Modular Arithmetic Utilities ========================

    static final class Mod {

        private Mod() {}

        static final long MOD = 1_000_000_007L;

        // Returns (a + b) % MOD
        static long add(long a, long b) {
            long result = ((a % MOD) + (b % MOD)) % MOD;
            if (result < 0) result += MOD;
            DBG.log("Mod.add", result);
            return result;
        }

        // Returns (a - b) % MOD
        static long sub(long a, long b) {
            long result = ((a % MOD) - (b % MOD)) % MOD;
            if (result < 0) result += MOD;
            DBG.log("Mod.sub", result);
            return result;
        }

        // Returns (a × b) % MOD
        static long mul(long a, long b) {
            long result = ((a % MOD) * (b % MOD)) % MOD;
            DBG.log("Mod.mul", result);
            return result;
        }

        // Computes modular inverse of a
        static long inv(long value) {
            long result = pow(value, MOD - 2);
            DBG.log("Mod.inv", result);
            return result;
        }

        // Computes (a / b) % MOD
        static long div(long a, long b) {
            long result = mul(a, inv(b));
            DBG.log("Mod.div", result);
            return result;
        }
    }

// ============================ Debug Utilities ================================

    static final class DBG {

        private DBG() {}

        // Prints any variable or array
        static void log(String key, Object value) {

            if (!DEBUG) return;

            if (value instanceof int[])
                System.err.println("[DEBUG] " + key + " -> " + Arrays.toString((int[]) value));

            else if (value instanceof long[])
                System.err.println("[DEBUG] " + key + " -> " + Arrays.toString((long[]) value));

            else if (value instanceof Object[])
                System.err.println("[DEBUG] " + key + " -> " + Arrays.deepToString((Object[]) value));

            else
                System.err.println("[DEBUG] " + key + " -> " + value);
        }

        // Prints a character grid
        static void grid(String title, char[][] grid) {

            if (!DEBUG) return;

            System.err.println("\n" + title);

            for (char[] row : grid)
                System.err.println(Arrays.toString(row));
        }

        // Prints custom debug message
        static void msg(String message) {

            if (DEBUG)
                System.err.println("[INFO] " + message);
        }
    }

// ======================= Random Test Case Generator ==========================

    static final class Gen {

        private Gen() {}

        private static final Random RAND = new Random();

        // Random integer in [low, high]
        static int i(int low, int high) {
            return low + RAND.nextInt(high - low + 1);
        }

        // Random long in [low, high]
        static long l(long low, long high) {
            return low + (long) (RAND.nextDouble() * (high - low + 1));
        }

        // Random integer array
        static int[] iArr(int size, int low, int high) {

            int[] arr = new int[size];

            for (int idx = 0; idx < size; idx++)
                arr[idx] = i(low, high);

            return arr;
        }

        // Generates common edge-case values
        static int[] edgeArr(int size) {

            int[] pool = {
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    -1,
                    0,
                    1
            };

            int[] arr = new int[size];

            for (int idx = 0; idx < size; idx++)
                arr[idx] = pool[RAND.nextInt(pool.length)];

            return arr;
        }

        // Random lowercase string
        static String str(int len) {

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < len; i++)
                sb.append((char) ('a' + RAND.nextInt(26)));

            return sb.toString();
        }
    }

// =========================== Fast Input Reader ===============================

    static final class IO {

        private IO() {}

        private static final BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        private static StringTokenizer st;

        // Reads next token
        static String next() {

            while (st == null || !st.hasMoreTokens()) {

                try {

                    String line = br.readLine();

                    if (line == null)
                        return null;

                    st = new StringTokenizer(line);

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return st.nextToken();
        }

        // Reads integer
        static int i() {
            return Integer.parseInt(next());
        }

        // Reads long
        static long l() {
            return Long.parseLong(next());
        }

        // Reads complete line
        static String line() {

            try {
                return br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // Reads integer array
        static int[] iArr(int n) {

            int[] arr = new int[n];

            for (int idx = 0; idx < n; idx++)
                arr[idx] = i();

            return arr;
        }

        // Reads long array
        static long[] lArr(int n) {

            long[] arr = new long[n];

            for (int idx = 0; idx < n; idx++)
                arr[idx] = l();

            return arr;
        }

        // Reads string array
        static String[] sArr(int n) {

            String[] arr = new String[n];

            for (int idx = 0; idx < n; idx++)
                arr[idx] = next();

            return arr;
        }
    }
    // ========================= Stack Utilities ==========================


    static final class StackUtils {

    private StackUtils() {}

    // Finds Next Greater Element values
    static int[] nge(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans, -1);

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return ans;
    }


    // Finds Next Greater Element indices
    static int[] ngei(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        Arrays.fill(ans, -1);

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ans[i] = st.peek();
            }

            st.push(i);
        }

        return ans;
    }
}

    // ========================= Grid Traversal Utilities ==========================

static final class Grd {

    private Grd() {}

    private static final int[] ROW = {-1, 1, 0, 0};
    private static final int[] COL = {0, 0, -1, 1};

    // Checks whether a cell lies inside the grid
    static boolean ok(int row, int col, int rows, int cols) {

        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Performs DFS on a grid
    static void dfs(int row, int col, char[][] grid, boolean[][] vis) {

        vis[row][col] = true;

        for (int dir = 0; dir < 4; dir++) {

            int nextRow = row + ROW[dir];
            int nextCol = col + COL[dir];

            if (ok(nextRow, nextCol, grid.length, grid[0].length)
                    && !vis[nextRow][nextCol]
                    && grid[nextRow][nextCol] != '#') {

                dfs(nextRow, nextCol, grid, vis);
            }
        }
    }

    // Performs BFS on a grid
    static void bfs(int startRow, int startCol, char[][] grid, boolean[][] vis) {

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{startRow, startCol});
        vis[startRow][startCol] = true;

        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for (int dir = 0; dir < 4; dir++) {

                int nextRow = row + ROW[dir];
                int nextCol = col + COL[dir];

                if (ok(nextRow, nextCol, grid.length, grid[0].length)
                        && !vis[nextRow][nextCol]
                        && grid[nextRow][nextCol] != '#') {

                    vis[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
    }
}


// =========================== Disjoint Set Union ==============================

static final class DSU {

    private final int[] parent;
    private final int[] size;

    // Finds representative of a set
    int find(int node) {

        if (parent[node] != node)
            parent[node] = find(parent[node]);

        return parent[node];
    }

    // Merges two components
    boolean union(int u, int v) {

        int rootU = find(u);
        int rootV = find(v);

        if (rootU == rootV)
            return false;

        if (size[rootU] < size[rootV]) {

            int temp = rootU;
            rootU = rootV;
            rootV = temp;
        }

        parent[rootV] = rootU;
        size[rootU] += size[rootV];

        return true;
    }

    // Checks if two nodes belong to the same component
    boolean same(int u, int v) {

        return find(u) == find(v);
    }
}
    // ============================== Segment Tree ================================

static final class ST {

    private final int n;
    private final long[] tree;

    // Builds Segment Tree from an initial array
    ST(long[] arr) {

        n = arr.length;
        tree = new long[4 * n];

        build(0, 0, n - 1, arr);
    }

    private void build(int node, int left, int right, long[] arr) {

        if (left == right) {
            tree[node] = arr[left];
            return;
        }

        int mid = left + (right - left) / 2;

        build(2 * node + 1, left, mid, arr);
        build(2 * node + 2, mid + 1, right, arr);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Point Update
    void upd(int idx, long value) {
        update(0, 0, n - 1, idx, value);
    }

    private void update(int node, int left, int right, int idx, long value) {

        if (left == right) {
            tree[node] = value;
            return;
        }

        int mid = left + (right - left) / 2;

        if (idx <= mid)
            update(2 * node + 1, left, mid, idx, value);
        else
            update(2 * node + 2, mid + 1, right, idx, value);

        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    // Range Sum Query
    long q(int l, int r) {
        return query(0, 0, n - 1, l, r);
    }

    private long query(int node, int left, int right, int l, int r) {

        if (right < l || left > r)
            return 0;

        if (l <= left && right <= r)
            return tree[node];

        int mid = left + (right - left) / 2;

        return query(2 * node + 1, left, mid, l, r)
                + query(2 * node + 2, mid + 1, right, l, r);
    }
}


// ======================= Mathematical Utilities =============================

static final class Mth {

    private Mth() {}

    // Greatest Common Divisor
    static long gcd(long a, long b) {

        while (b != 0) {

            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // Least Common Multiple
    static long lcm(long a, long b) {

        return (a / gcd(a, b)) * b;
    }

    // Binary Exponentiation
    static long pow(long base, long exp, long mod) {

        long ans = 1;
        base %= mod;

        while (exp > 0) {

            if ((exp & 1) == 1)
                ans = (ans * base) % mod;

            base = (base * base) % mod;
            exp >>= 1;
        }

        return ans;
    }

    // Prime Check
    static boolean prime(long n) {

        if (n < 2)
            return false;

        if (n == 2 || n == 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (long i = 5; i * i <= n; i += 6) {

            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

    // Sieve of Eratosthenes
    static boolean[] sieve(int limit) {

        boolean[] prime = new boolean[limit + 1];

        Arrays.fill(prime, true);

        if (limit >= 0)
            prime[0] = false;

        if (limit >= 1)
            prime[1] = false;

        for (int i = 2; i * i <= limit; i++) {

            if (!prime[i])
                continue;

            for (int j = i * i; j <= limit; j += i)
                prime[j] = false;
        }

        return prime;
    }
}

    // ============================ Array Utilities ===============================

static final class Arr {

    private Arr() {}

    // Returns first index where value >= target
    static int lb(int[] arr, int target) {

        int left = 0, right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] >= target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    // Returns first index where value > target
    static int ub(int[] arr, int target) {

        int left = 0, right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > target)
                right = mid;
            else
                left = mid + 1;
        }

        return left;
    }

    // Prefix Sum
    static long[] pSum(int[] arr) {

        long[] prefix = new long[arr.length + 1];

        for (int i = 0; i < arr.length; i++)
            prefix[i + 1] = prefix[i] + arr[i];

        return prefix;
    }

    // Suffix Sum
    static long[] sSum(int[] arr) {

        long[] suffix = new long[arr.length + 1];

        for (int i = arr.length - 1; i >= 0; i--)
            suffix[i] = suffix[i + 1] + arr[i];

        return suffix;
    }

    // Prefix Minimum
    static int[] pMin(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        if (n == 0) return ans;

        ans[0] = arr[0];

        for (int i = 1; i < n; i++)
            ans[i] = Math.min(ans[i - 1], arr[i]);

        return ans;
    }

    // Suffix Minimum
    static int[] sMin(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        if (n == 0) return ans;

        ans[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--)
            ans[i] = Math.min(ans[i + 1], arr[i]);

        return ans;
    }

    // Prefix Maximum
    static int[] pMax(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        if (n == 0) return ans;

        ans[0] = arr[0];

        for (int i = 1; i < n; i++)
            ans[i] = Math.max(ans[i - 1], arr[i]);

        return ans;
    }

    // Suffix Maximum
    static int[] sMax(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        if (n == 0) return ans;

        ans[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--)
            ans[i] = Math.max(ans[i + 1], arr[i]);

        return ans;
    }

    // Prefix GCD
    static long[] pGcd(int[] arr) {

        int n = arr.length;
        long[] ans = new long[n];

        if (n == 0) return ans;

        ans[0] = arr[0];

        for (int i = 1; i < n; i++)
            ans[i] = Mth.gcd(ans[i - 1], arr[i]);

        return ans;
    }

    // Suffix GCD
    static long[] sGcd(int[] arr) {

        int n = arr.length;
        long[] ans = new long[n];

        if (n == 0) return ans;

        ans[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--)
            ans[i] = Mth.gcd(ans[i + 1], arr[i]);

        return ans;
    }
}


// ====================== Bit Manipulation Utilities ==========================

static final class Bit {

    private Bit() {}

    // Returns true if kth bit is set
    static boolean get(int num, int bit) {

        return ((num >> bit) & 1) != 0;
    }

    // Sets kth bit
    static int set(int num, int bit) {

        return num | (1 << bit);
    }

    // Clears kth bit
    static int clear(int num, int bit) {

        return num & ~(1 << bit);
    }

    // Toggles kth bit
    static int toggle(int num, int bit) {

        return num ^ (1 << bit);
    }
}


// ================================ Solution ==================================

static void solve() {

    // Write your solution here

}


// ================================== Main ====================================

public static void main(String[] args) {

    solve();

}
}
