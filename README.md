# CODE-TEMPLATE
##  Modular Arithmetic Utilities (Mod)

`MOD = 1_000_000_007`

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `add(long a, long b)` | Performs modular addition `(a + b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `sub(long a, long b)` | Performs modular subtraction `(a - b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `mul(long a, long b)` | Performs modular multiplication `(a × b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `inv(long a)` | Computes the modular multiplicative inverse using Fermat's Little Theorem (`a^(MOD-2) % MOD`). | `long a` | `long` | `O(log MOD)` |
| `div(long a, long b)` | Performs modular division `(a / b) % MOD` by multiplying `a` with the modular inverse of `b`. | `long a`, `long b` | `long` | `O(log MOD)` |

##  Debug Utilities (DBG)



| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `log(String label, Object val)` | Logs a variable with its label. Supports primitive arrays and object arrays for readable output. | `String label`, `Object val` | `void` | `O(1)`* |
| `grid(String label, char[][] g)` | Prints a 2D character grid with a descriptive label. | `String label`, `char[][] grid` | `void` | `O(rows × cols)` |
| `msg(String info)` | Prints a custom debug message. | `String info` | `void` | `O(1)` |



## Random Test Case Generator (Gen)



| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `i(int min, int max)` | Generates a random integer within the given range (inclusive). | `int min`, `int max` | `int` | `O(1)` |
| `l(long min, long max)` | Generates a random long within the given range (inclusive). | `long min`, `long max` | `long` | `O(1)` |
| `iArr(int n, int min, int max)` | Generates a random integer array of size `n`. | `int n`, `int min`, `int max` | `int[]` | `O(n)` |
| `lArr(int n, long min, long max)` | Generates a random long array of size `n`. | `int n`, `long min`, `long max` | `long[]` | `O(n)` |
| `str(int len)` | Generates a random lowercase string of the specified length. | `int len` | `String` | `O(len)` |
| `edgeArr(int n)` | Generates a random edge list for graph testing. | `int n` | `int[][]` | `O(n)` |

## Fast Input Utilities (IO)

A custom fast input class using `BufferedReader` and `StringTokenizer` for competitive programming.

| Function | Purpose | Input | Output | Time Complexity |
|----------|---------|-------|--------|----------------|
| `next()` | Reads the next whitespace-separated token | - | `String` | `O(length)` |
| `i()` | Reads an integer value | - | `int` | `O(1)` |
| `l()` | Reads a long integer value | - | `long` | `O(1)` |
| `line()` | Reads a complete line of input | - | `String` | `O(length)` |
| `iArr(int n)` | Reads an integer array of size `n` | `int n` | `int[]` | `O(n)` |
| `lArr(int n)` | Reads a long array of size `n` | `int n` | `long[]` | `O(n)` |
| `sArr(int n)` | Reads a string array of size `n` | `int n` | `String[]` | `O(n)` |

# Stk — Monotonic Stack
| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `nge(int[] arr)` | Finds the Next Greater Element for every element in the array. | `int[] arr` | `int[]` | `O(n)` |
| `ngei(int[] arr)` | Finds the index of the Next Greater Element for every element in the array. | `int[] arr` | `int[]` | `O(n)` |


##  Grid Utilities (Grd)

| Function | Purpose | Input | Output | Time Complexity |
|----------|---------|-------|--------|-----------------|
| `ok(int row, int col, int rows, int cols)` | Checks whether a grid cell lies within valid boundaries | `row, col, rows, cols` | `boolean` | `O(1)` |
| `dfs(int row, int col, char[][] grid, boolean[][] vis)` | Performs Depth First Search traversal on a grid using 4-direction movement | `row, col, grid, visited array` | `void` | `O(R × C)` |
| `bfs(int startRow, int startCol, char[][] grid, boolean[][] vis)` | Performs Breadth First Search traversal on a grid using queue and 4-direction movement | `startRow, startCol, grid, visited array` | `void` | `O(R × C)` |

##  Disjoint Set Union (DSU)

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `find(int x)` | Finds the representative (parent) of the set containing `x` using path compression. | `int x` | `int` | `O(α(n))` |
| `union(int a, int b)` | Merges the sets containing `a` and `b`. | `int a`, `int b` | `void` | `O(α(n))` |
| `same(int a, int b)` | Checks whether `a` and `b` belong to the same set. | `int a`, `int b` | `boolean` | `O(α(n))` |

##  Segment Tree (ST)

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `build(int node, int start, int end)` | Builds the Segment Tree from the given array. | `int node`, `int start`, `int end` | `void` | `O(n)` |
| `upd(int node, int start, int end, int idx, long val)` | Updates the value at a specific index in the Segment Tree. | `int node`, `int start`, `int end`, `int idx`, `long val` | `void` | `O(log n)` |
| `q(int node, int start, int end, int left, int right)` | Returns the result of a range query over the interval `[left, right]`. | `int node`, `int start`, `int end`, `int left`, `int right` | `long` | `O(log n)` |

##  Mathematical Utilities (Mth)

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `gcd(long a, long b)` | Computes the Greatest Common Divisor (GCD) using Euclid's algorithm. | `long a`, `long b` | `long` | `O(log(min(a,b)))` |
| `lcm(long a, long b)` | Computes the Least Common Multiple (LCM). | `long a`, `long b` | `long` | `O(log(min(a,b)))` |
| `pow(long base, long exp, long mod)` | Computes `(base^exp) % mod` using Binary Exponentiation. | `long base`, `long exp`, `long mod` | `long` | `O(log exp)` |
| `prime(long n)` | Checks whether a number is prime. | `long n` | `boolean` | `O(√n)` |
| `sieve(int n)` | Generates all prime numbers up to `n` using the Sieve of Eratosthenes. | `int n` | `boolean[]` | `O(n log log n)` |

##  Array Utilities (Arr)


| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `lb(int[] arr, int target)` | Finds the index of the first element greater than or equal to the target (Lower Bound). | `int[] arr`, `int target` | `int` | `O(log n)` |
| `ub(int[] arr, int target)` | Finds the index of the first element strictly greater than the target (Upper Bound). | `int[] arr`, `int target` | `int` | `O(log n)` |
| `pSum(int[] arr)` | Computes the Prefix Sum array. | `int[] arr` | `long[]` | `O(n)` |
| `sSum(int[] arr)` | Computes the Suffix Sum array. | `int[] arr` | `long[]` | `O(n)` |
| `pMin(int[] arr)` | Computes the Prefix Minimum array. | `int[] arr` | `int[]` | `O(n)` |
| `sMin(int[] arr)` | Computes the Suffix Minimum array. | `int[] arr` | `int[]` | `O(n)` |
| `pMax(int[] arr)` | Computes the Prefix Maximum array. | `int[] arr` | `int[]` | `O(n)` |
| `sMax(int[] arr)` | Computes the Suffix Maximum array. | `int[] arr` | `int[]` | `O(n)` |
| `pGcd(int[] arr)` | Computes the Prefix GCD array. | `int[] arr` | `int[]` | `O(n log V)` |
| `sGcd(int[] arr)` | Computes the Suffix GCD array. | `int[] arr` | `int[]` | `O(n log V)` |

##  Bit Manipulation Utilities (Bit)

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `get(int n, int k)` | Returns whether the kth bit of `n` is set (`1`) or not (`0`). | `int n`, `int k` | `boolean` | `O(1)` |
| `set(int n, int k)` | Sets the kth bit of `n` to `1`. | `int n`, `int k` | `int` | `O(1)` |
| `clear(int n, int k)` | Clears the kth bit of `n` by setting it to `0`. | `int n`, `int k` | `int` | `O(1)` |
| `toggle(int n, int k)` | Toggles the kth bit of `n` (0 → 1 or 1 → 0). | `int n`, `int k` | `int` | `O(1)` |
