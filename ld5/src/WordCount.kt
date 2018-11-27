object WordCount {
    fun phrase(sentence: String): Map<String, Int> {
        return sentence.toLowerCase()
                .split(Regex("""\W'|'\W|[^\w']+"""))
                .filter(String::isNotEmpty)
                .groupBy { it }.mapValues { it.value.size }
    }
}