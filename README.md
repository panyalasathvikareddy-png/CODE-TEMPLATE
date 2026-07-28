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
