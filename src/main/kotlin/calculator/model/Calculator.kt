package calculator.model

class Calculator {
    fun add(input: String): Int {
        // 빈 문자열 처리
        if (input.isEmpty()) return 0

        val (delimiters, numbers) = if (input.startsWith("//")) {
            findCustomDelimiter(input) ?: throw IllegalArgumentException("Invalid custom delimiter format.")
        } else {
            Pair("[,:]".toRegex(), input)
        }

        // 연속된 구분자 체크
        val consecutiveDelimiterPattern = "${delimiters.pattern}{2,}".toRegex()
        if (consecutiveDelimiterPattern.containsMatchIn(numbers)) {
            throw IllegalArgumentException("Delimiters cannot appear consecutively.")
        }

        val parsedNumbers = numbers.split(delimiters).map {
            val trimmed = it.trim()
            val num = trimmed.toIntOrNull() ?: throw IllegalArgumentException("Non-numeric value found: $trimmed")
            if (num < 0) throw IllegalArgumentException("Negative numbers are not allowed: $num")
            num
        }

        return parsedNumbers.sum()
    }

    private fun findCustomDelimiter(input: String): Pair<Regex, String>? {
        if (!input.contains("\\n")) {
            throw IllegalArgumentException("Input must start with // and end with \\n.")
        }

        val regex = Regex("//([^0-9])\\\\n(.*)")
        val matchResult = regex.find(input)
        return matchResult?.let {
            val customDelimiter = it.groupValues[1]
            if (customDelimiter.isEmpty()) {
                throw IllegalArgumentException("No valid custom delimiter found.")
            }
            val numbers = it.groupValues[2]
            Pair(Regex(Regex.escape(customDelimiter)), numbers)
        }
    }
}
