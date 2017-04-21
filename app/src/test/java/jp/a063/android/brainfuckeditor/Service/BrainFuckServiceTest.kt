package jp.a063.android.brainfuckeditor.Service

import jp.a063.android.brainfuckeditor.Data.BFStatus
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by umare on 2017/04/20.
 */

class BFServiceTest {
    @Test
    fun init() {
        var now = BFStatus()
        assertEquals(now.QueryString, "")
        assertEquals(now.QueryIndex, 0)
        assertEquals(now.Memory, arrayListOf<Int>(0))
        assertEquals(now.MemoryIndex, 0)
    }

    @Test
    fun plus() {
        val now = BFStatus(QueryString = "+")

        assertEquals(BFService().nextStatus(now).QueryIndex, 1)
        assertEquals(BFService().nextStatus(now).Memory, arrayListOf<Int>(1))
    }

    @Test
    fun plusplus() {
        val now = BFStatus(QueryString = "++")

        val next = BFService().nextStatus(now)
        assertEquals(next.QueryIndex, 1)
        assertEquals(next.Memory, arrayListOf<Int>(1))

        val nextnext = BFService().nextStatus(next)
        assertEquals(nextnext.QueryIndex, 2)
        assertEquals(nextnext.Memory, arrayListOf<Int>(2))
    }

    @Test
    fun minus() {
        val now = BFStatus(QueryString = "-")

        assertEquals(BFService().nextStatus(now).QueryIndex, 1)
        assertEquals(BFService().nextStatus(now).Memory, arrayListOf<Int>(255))
    }

    @Test
    fun minusminus() {
        val now = BFStatus(QueryString = "--")

        val next = BFService().nextStatus(now)
        assertEquals(next.QueryIndex, 1)
        assertEquals(next.Memory, arrayListOf<Int>(255))

        val nextnext = BFService().nextStatus(next)
        assertEquals(nextnext.QueryIndex, 2)
        assertEquals(nextnext.Memory, arrayListOf<Int>(254))
    }
}