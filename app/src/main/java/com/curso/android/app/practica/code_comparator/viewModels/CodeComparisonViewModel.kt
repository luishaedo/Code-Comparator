package com.curso.android.app.practica.code_comparator.viewModels


import android.text.SpannableStringBuilder
import android.text.style.BackgroundColorSpan
import androidx.lifecycle.ViewModel
class CodeComparisonViewModel : ViewModel() {

    fun compareAndHighlight(code1: String, code2: String): Pair<SpannableStringBuilder, SpannableStringBuilder> {
        val lines1 = code1.split('\n')
        val lines2 = code2.split('\n')

        val highlightedText1 = SpannableStringBuilder()
        val highlightedText2 = SpannableStringBuilder()

        val maxLines = maxOf(lines1.size, lines2.size)

        for (i in 0 until maxLines) {
            val line1 = if (i < lines1.size) lines1[i] else ""
            val line2 = if (i < lines2.size) lines2[i] else ""

            val maxWords = maxOf(line1.split(' ').size, line2.split(' ').size)
            val words1 = line1.split(' ')
            val words2 = line2.split(' ')

            for (j in 0 until maxWords) {
                val word1 = if (j < words1.size) words1[j] else ""
                val word2 = if (j < words2.size) words2[j] else ""

                val maxChars = maxOf(word1.length, word2.length)

                for (k in 0 until maxChars) {
                    val char1 = if (k < word1.length) word1[k] else ' '
                    val char2 = if (k < word2.length) word2[k] else ' '

                    if (char1 == char2) {
                        highlightedText1.append(char1.toString())
                        highlightedText2.append(char2.toString())
                    } else {
                        val backgroundColorSpan = BackgroundColorSpan(codeDifferenceBackgroundColor)

                        highlightedText1.append(char1.toString())
                        highlightedText2.append(char2.toString())
                        highlightedText1.setSpan(
                            backgroundColorSpan,
                            highlightedText1.length - 1,
                            highlightedText1.length,
                            0
                        )
                        highlightedText2.setSpan(
                            backgroundColorSpan,
                            highlightedText2.length - 1,
                            highlightedText2.length,
                            0
                        )
                    }
                }

                if (j < maxWords - 1) {
                    highlightedText1.append(" ")
                    highlightedText2.append(" ")
                }
            }

            if (i < maxLines - 1) {
                highlightedText1.append("\n")
                highlightedText2.append("\n")
            }
        }

        return Pair(highlightedText1, highlightedText2)
    }
}

val codeDifferenceBackgroundColor = 0xFFFFE0 // Color amarillo claro