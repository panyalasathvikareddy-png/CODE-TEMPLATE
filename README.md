# CODE-TEMPLATE
## ➗ Modular Arithmetic Utilities (Mod)

`MOD = 1_000_000_007`

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `add(long a, long b)` | Performs modular addition `(a + b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `sub(long a, long b)` | Performs modular subtraction `(a - b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `mul(long a, long b)` | Performs modular multiplication `(a × b) % MOD`. | `long a`, `long b` | `long` | `O(1)` |
| `inv(long a)` | Computes the modular multiplicative inverse using Fermat's Little Theorem (`a^(MOD-2) % MOD`). | `long a` | `long` | `O(log MOD)` |
| `div(long a, long b)` | Performs modular division `(a / b) % MOD` by multiplying `a` with the modular inverse of `b`. | `long a`, `long b` | `long` | `O(log MOD)` |

### Example

```java
long sum = Mod.add(a, b);

long diff = Mod.sub(a, b);

long product = Mod.mul(a, b);

long inverse = Mod.inv(a);

long answer = Mod.div(a, b);
```
## 🐞 Debug Utilities (DBG)

Provides lightweight debugging methods that print information only when the `DEBUG` flag is enabled.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `log(String label, Object val)` | Logs a variable with its label. Supports primitive arrays and object arrays for readable output. | `String label`, `Object val` | `void` | `O(1)`* |
| `grid(String label, char[][] g)` | Prints a 2D character grid with a descriptive label. | `String label`, `char[][] grid` | `void` | `O(rows × cols)` |
| `msg(String info)` | Prints a custom debug message. | `String info` | `void` | `O(1)` |

> **Note:** All debug methods execute only when the `DEBUG` flag is set to `true`.

### Example

```java
DBG.log("Answer", ans);

DBG.log("Array", arr);

DBG.msg("DFS Started");

DBG.grid("Maze", grid);
```
## 🎲 Random Test Case Generator (Gen)

Provides utility methods for generating random numbers, arrays, strings, and graphs. Useful for stress testing and creating custom test cases.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `i(int min, int max)` | Generates a random integer within the given range (inclusive). | `int min`, `int max` | `int` | `O(1)` |
| `l(long min, long max)` | Generates a random long within the given range (inclusive). | `long min`, `long max` | `long` | `O(1)` |
| `iArr(int n, int min, int max)` | Generates a random integer array of size `n`. | `int n`, `int min`, `int max` | `int[]` | `O(n)` |
| `lArr(int n, long min, long max)` | Generates a random long array of size `n`. | `int n`, `long min`, `long max` | `long[]` | `O(n)` |
| `str(int len)` | Generates a random lowercase string of the specified length. | `int len` | `String` | `O(len)` |
| `edgeArr(int n)` | Generates a random edge list for graph testing. | `int n` | `int[][]` | `O(n)` |

> **Note:** These utilities are primarily intended for stress testing, debugging, and validating algorithm correctness.

### Example

```java
int x = Gen.i(1, 100);

long y = Gen.l(1L, 1_000_000L);

int[] arr = Gen.iArr(10, 1, 100);

long[] nums = Gen.lArr(10, 1, 1000);

String s = Gen.str(8);

int[][] edges = Gen.edgeArr(20);
```
## 📥 Fast Input Utilities (IO)

Provides fast input methods for reading primitive data types, arrays, matrices, and strings. Optimized for Competitive Programming and Online Assessments.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `next()` | Reads the next whitespace-separated token. | - | `String` | `O(length)` |
| `nextLine()` | Reads an entire line of input. | - | `String` | `O(length)` |
| `i()` | Reads an integer. | - | `int` | `O(1)` |
| `l()` | Reads a long integer. | - | `long` | `O(1)` |
| `d()` | Reads a double value. | - | `double` | `O(1)` |
| `c()` | Reads a character. | - | `char` | `O(1)` |
| `iArr(int n)` | Reads an integer array of size `n`. | `int n` | `int[]` | `O(n)` |
| `lArr(int n)` | Reads a long array of size `n`. | `int n` | `long[]` | `O(n)` |
| `dArr(int n)` | Reads a double array of size `n`. | `int n` | `double[]` | `O(n)` |
| `sArr(int n)` | Reads a string array of size `n`. | `int n` | `String[]` | `O(n)` |
| `cArr()` | Reads a character array from the next token. | - | `char[]` | `O(length)` |
| `iMat(int n, int m)` | Reads an `n × m` integer matrix. | `int n`, `int m` | `int[][]` | `O(n × m)` |
| `lMat(int n, int m)` | Reads an `n × m` long matrix. | `int n`, `int m` | `long[][]` | `O(n × m)` |
| `dMat(int n, int m)` | Reads an `n × m` double matrix. | `int n`, `int m` | `double[][]` | `O(n × m)` |
| `cMat(int n)` | Reads a character matrix with `n` rows. | `int n` | `char[][]` | `O(n × m)` |

### Example

```java
int n = IO.i();

long m = IO.l();

double x = IO.d();

String s = IO.next();

String line = IO.nextLine();

char ch = IO.c();

int[] arr = IO.iArr(n);

long[] nums = IO.lArr(n);

char[] letters = IO.cArr();

int[][] grid = IO.iMat(n, m);

char[][] board = IO.cMat(n);
```
## 📚 Stack Utilities (Stk)

Provides helper methods based on **Monotonic Stack** for efficiently solving Next/Previous Greater/Smaller Element problems.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `nge(int[] arr)` | Finds the Next Greater Element for every element. | `int[] arr` | `int[]` | `O(n)` |
| `ngei(int[] arr)` | Finds the index of the Next Greater Element. | `int[] arr` | `int[]` | `O(n)` |
| `pge(int[] arr)` | Finds the Previous Greater Element for every element. | `int[] arr` | `int[]` | `O(n)` |
| `pgei(int[] arr)` | Finds the index of the Previous Greater Element. | `int[] arr` | `int[]` | `O(n)` |
| `nse(int[] arr)` | Finds the Next Smaller Element for every element. | `int[] arr` | `int[]` | `O(n)` |
| `nsei(int[] arr)` | Finds the index of the Next Smaller Element. | `int[] arr` | `int[]` | `O(n)` |
| `pse(int[] arr)` | Finds the Previous Smaller Element for every element. | `int[] arr` | `int[]` | `O(n)` |
| `psei(int[] arr)` | Finds the index of the Previous Smaller Element. | `int[] arr` | `int[]` | `O(n)` |

### Example

```java
int[] nextGreater = Stk.nge(arr);

int[] nextGreaterIndex = Stk.ngei(arr);

int[] previousGreater = Stk.pge(arr);

int[] previousGreaterIndex = Stk.pgei(arr);

int[] nextSmaller = Stk.nse(arr);

int[] nextSmallerIndex = Stk.nsei(arr);

int[] previousSmaller = Stk.pse(arr);

int[] previousSmallerIndex = Stk.psei(arr);
```
****
## 📚 Stack Utilities (Stk)

Provides helper methods based on **Monotonic Stack** for efficiently solving Next Greater Element problems.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `nge(int[] arr)` | Finds the Next Greater Element for every element in the array. | `int[] arr` | `int[]` | `O(n)` |
| `ngei(int[] arr)` | Finds the index of the Next Greater Element for every element in the array. | `int[] arr` | `int[]` | `O(n)` |

### Example

```java
int[] nextGreater = Stk.nge(arr);

int[] nextGreaterIndex = Stk.ngei(arr);
```
## 🌐 Grid Utilities (Grd)

Provides helper methods for working with 2D grids and validating cell positions during graph and matrix traversals.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `ok(int r, int c)` | Checks whether the given cell `(r, c)` lies within the grid boundaries. | `int row`, `int column` | `boolean` | `O(1)` |

### Example

```java
if (Grd.ok(r, c)) {
    // Process the valid cell
}
```
## 🔗 Disjoint Set Union (DSU)

Implements the **Disjoint Set Union (Union-Find)** data structure for efficiently managing disjoint sets. Supports path compression and union operations for near constant-time performance.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `find(int x)` | Finds the representative (parent) of the set containing `x` using path compression. | `int x` | `int` | `O(α(n))` |
| `union(int a, int b)` | Merges the sets containing `a` and `b`. | `int a`, `int b` | `void` | `O(α(n))` |
| `same(int a, int b)` | Checks whether `a` and `b` belong to the same set. | `int a`, `int b` | `boolean` | `O(α(n))` |

> **Note:** `α(n)` denotes the inverse Ackermann function, which grows extremely slowly and is effectively constant for practical input sizes.

### Example

```java
DSU dsu = new DSU(n);

dsu.union(1, 2);

dsu.union(2, 3);

boolean connected = dsu.same(1, 3);

int parent = dsu.find(4);
```
## 🌳 Segment Tree (ST)

Implements a **Segment Tree** for efficient range queries and point updates on arrays.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `build(int node, int start, int end)` | Builds the Segment Tree from the given array. | `int node`, `int start`, `int end` | `void` | `O(n)` |
| `upd(int node, int start, int end, int idx, long val)` | Updates the value at a specific index in the Segment Tree. | `int node`, `int start`, `int end`, `int idx`, `long val` | `void` | `O(log n)` |
| `q(int node, int start, int end, int left, int right)` | Returns the result of a range query over the interval `[left, right]`. | `int node`, `int start`, `int end`, `int left`, `int right` | `long` | `O(log n)` |

### Example

```java
ST st = new ST(arr);

st.build(1, 0, n - 1);

st.upd(1, 0, n - 1, idx, value);

long answer = st.q(1, 0, n - 1, left, right);
```
## 📐 Mathematical Utilities (Mth)

Provides commonly used mathematical helper functions for Competitive Programming, including GCD, LCM, modular exponentiation, primality testing, and prime generation.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `gcd(long a, long b)` | Computes the Greatest Common Divisor (GCD) using Euclid's algorithm. | `long a`, `long b` | `long` | `O(log(min(a,b)))` |
| `lcm(long a, long b)` | Computes the Least Common Multiple (LCM). | `long a`, `long b` | `long` | `O(log(min(a,b)))` |
| `pow(long base, long exp, long mod)` | Computes `(base^exp) % mod` using Binary Exponentiation. | `long base`, `long exp`, `long mod` | `long` | `O(log exp)` |
| `prime(long n)` | Checks whether a number is prime. | `long n` | `boolean` | `O(√n)` |
| `sieve(int n)` | Generates all prime numbers up to `n` using the Sieve of Eratosthenes. | `int n` | `boolean[]` | `O(n log log n)` |

### Example

```java
long g = Mth.gcd(a, b);

long l = Mth.lcm(a, b);

long p = Mth.pow(base, exp, mod);

boolean isPrime = Mth.prime(n);

boolean[] primes = Mth.sieve(limit);
```
## 📊 Array Utilities (Arr)

Provides commonly used helper methods for array operations, including binary search, prefix/suffix computations, and utility functions frequently used in Competitive Programming.

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

### Example

```java
int lower = Arr.lb(arr, target);

int upper = Arr.ub(arr, target);

long[] prefixSum = Arr.pSum(arr);

long[] suffixSum = Arr.sSum(arr);

int[] prefixMin = Arr.pMin(arr);

int[] suffixMin = Arr.sMin(arr);

int[] prefixMax = Arr.pMax(arr);

int[] suffixMax = Arr.sMax(arr);

int[] prefixGcd = Arr.pGcd(arr);

int[] suffixGcd = Arr.sGcd(arr);
```
## 🔢 Bit Manipulation Utilities (Bit)

Provides helper methods for performing common bit manipulation operations. These utilities simplify checking, setting, clearing, and toggling individual bits in an integer.

| Function | Purpose | Input | Output | Time Complexity |
|:---------|:--------|:------|:-------|:---------------|
| `get(int n, int k)` | Returns whether the kth bit of `n` is set (`1`) or not (`0`). | `int n`, `int k` | `boolean` | `O(1)` |
| `set(int n, int k)` | Sets the kth bit of `n` to `1`. | `int n`, `int k` | `int` | `O(1)` |
| `clear(int n, int k)` | Clears the kth bit of `n` by setting it to `0`. | `int n`, `int k` | `int` | `O(1)` |
| `toggle(int n, int k)` | Toggles the kth bit of `n` (0 → 1 or 1 → 0). | `int n`, `int k` | `int` | `O(1)` |

### Example

```java
int num = 10;

boolean bit = Bit.get(num, 1);

num = Bit.set(num, 2);

num = Bit.clear(num, 3);

num = Bit.toggle(num, 0);
```
