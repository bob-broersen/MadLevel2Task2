package com.broersen.madlevel2task2

data class Question (
    var answer : Boolean,
    var text: String
)
{
    companion object {
        val QUESTION_TEXT = arrayOf(
            "A \'val\' and \'var\' are the same.",
            "Mobile Application Development grants 12 ETCS.",
            "A unit in Kotlin corresponds a void in Java.",
            "In Kotlin \'when\' replace the \'switch\' operator in Java."
        )

        val QUESTION_ANSWER = arrayOf(
            false,
            true,
            false,
            true
        )
    }
}