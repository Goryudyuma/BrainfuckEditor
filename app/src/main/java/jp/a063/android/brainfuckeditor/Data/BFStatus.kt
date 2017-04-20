package jp.a063.android.brainfuckeditor.Data

/**
 * Created by umare on 2017/04/20.
 */

data class BFStatus(
        val QueryString: String = "",
        val QueryIndex: Int = 0,
        val Memory: ArrayList<Int>,
        val MemoryIndex: Int = 0
)
