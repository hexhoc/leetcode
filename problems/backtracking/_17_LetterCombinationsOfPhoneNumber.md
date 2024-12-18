
Easy

tags: best, retry

Given a string containing digits from `2-9` inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

```
Map.of(
    2, "abc",  
    3, "def",  
    4, "ghi",  
    5, "jkl",  
    6, "mno",  
    7, "pqrs",  
    8, "tuv",  
    9, "wxyz"
```

### Constraints:

- 0 ≤ digits.length ≤ 4
- `digits[i]` is a digit in the range `['2', '9']`.

### Examples

Example 1:

```text
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
```

Example 2:

```text
Input: digits = ""
Output: []
```

Example 3:

```text
Input: digits = "2"
Output: ["a","b","c"]
```
