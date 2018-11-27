class isogram {
    companion object {
        fun isIsogram(sentence: String) = sentence.filter(Char::isLetter).toLowerCase().let { it.length == it.toSet().size }
    }
}