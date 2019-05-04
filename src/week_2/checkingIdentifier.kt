package week_2

fun isValidIdentifier(string: String): Boolean {
    fun IndexedValue<Char>.isValid() = value.isLetterOrDigit() || value == '_'
    fun IndexedValue<Char>.isValidAndNotDigit() = value.isLetter() || value == '_'
    fun IndexedValue<Char>.isFirst() = index == 0

    var isStringValid = false
    if (string.isNotEmpty()) {
        for (character in string.withIndex()) {
            isStringValid = if (character.isFirst()) character.isValidAndNotDigit() else character.isValid()
            if (!isStringValid) return isStringValid
        }
    }
    return isStringValid
}

//fun isValidIdentifier(s: String): Boolean {
//    var isValid = false
//    if (s.isNotEmpty()) {
//        for (ch in s.withIndex()) {
//            isValid = if (ch.index != 0) when (ch.value) {
//                in 'a'..'z', in 'A'..'Z', in '0'..'9', '_' -> true
//                else -> false
//            } else when (ch.value) {
//                in 'a'..'z', in 'A'..'Z', '_' -> true
//                else -> false
//            }
//            if (!isValid) return isValid
//        }
//    }
//    return isValid
//}

fun main(args: Array<String>) {
    println(isValidIdentifier("name"))   // true
    println(isValidIdentifier("_name"))  // true
    println(isValidIdentifier("_12"))    // true
    println(isValidIdentifier(""))       // false
    println(isValidIdentifier("012"))    // false
    println(isValidIdentifier("no$"))    // false
}

