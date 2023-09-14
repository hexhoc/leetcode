fun isLetter(x: Char) = x in 'A'..'Z'
fun isDigit(x: Char) = x in '0'..'9'

fun isFirst(str: String, cur: Int): Boolean {
    return isLetter(str[cur]) &&
            isDigit(str[cur + 1]) &&
            isDigit(str[cur + 2]) &&
            isLetter(str[cur + 3]) &&
            isLetter(str[cur + 4])
}

fun isSecond(str: String, cur: Int): Boolean {
    return isLetter(str[cur]) &&
            isDigit(str[cur + 1]) &&
            isLetter(str[cur + 2]) &&
            isLetter(str[cur + 3])
}

fun main() {
    val t = readln().toInt()
    kek@ for (kkkkk in 0 until t) {
        val s = readln()
        val ans = StringBuilder()
        var cur = 0
        while (cur + 3 < s.length) {
            cur += if (isSecond(s, cur)) {
                ans.append(s, cur, cur + 4)
                4
            } else if (cur + 4 < s.length && isFirst(s, cur)) {
                ans.append(s, cur, cur + 5)
                5
            } else {
                println('-')
                continue@kek
            }
            ans.append(' ')
        }
        if (cur == s.length) {
            println(ans.toString())
        } else {
            println('-')
        }
    }
}