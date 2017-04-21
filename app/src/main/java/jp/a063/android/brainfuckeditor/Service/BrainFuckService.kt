package jp.a063.android.brainfuckeditor.Service

import android.app.IntentService
import android.content.Intent
import jp.a063.android.brainfuckeditor.Data.BFStatus

/**
 * Created by umare on 2017/04/20.
 */

class BFService : IntentService("BrainFuckService") {

    override fun onHandleIntent(intent: Intent) {


    }

    fun nextStatus(nowStatus: BFStatus): BFStatus {
        if (nowStatus.QueryIndex >= nowStatus.QueryString.length) {
            return nowStatus
        }
        val nowJobQueue: Char = nowStatus.QueryString.get(nowStatus.QueryIndex)
        if (nowJobQueue == '+') {
            val retMemory = ArrayList<Int>(nowStatus.Memory)
            retMemory[nowStatus.MemoryIndex]++
            if (retMemory[nowStatus.MemoryIndex] == 256) {
                retMemory[nowStatus.MemoryIndex] = 0
            }
            return nowStatus.copy(Memory = retMemory, QueryIndex = nowStatus.QueryIndex + 1)
        } else if (nowJobQueue == '-') {
            val retMemory = ArrayList<Int>(nowStatus.Memory)
            retMemory[nowStatus.MemoryIndex]--
            if (retMemory[nowStatus.MemoryIndex] == -1) {
                retMemory[nowStatus.MemoryIndex] = 255
            }
            return nowStatus.copy(Memory = retMemory, QueryIndex = nowStatus.QueryIndex + 1)
        } else if (nowJobQueue == '>') {
            val retMemory = ArrayList<Int>(nowStatus.Memory)
            var nowMemoryIndex = nowStatus.MemoryIndex
            nowMemoryIndex++
            if (retMemory.size <= nowMemoryIndex) {
                retMemory.add(0);
            }
            return nowStatus.copy(Memory = retMemory, MemoryIndex = nowMemoryIndex, QueryIndex = nowStatus.QueryIndex + 1)
        } else if (nowJobQueue == '<') {
            val retMemory = ArrayList<Int>(nowStatus.Memory)
            var nowMemoryIndex = nowStatus.MemoryIndex
            nowMemoryIndex--
            if (nowMemoryIndex == -1) {
                retMemory.add(0, 0);
                nowMemoryIndex = 0
            }
            return nowStatus.copy(Memory = retMemory, MemoryIndex = nowMemoryIndex, QueryIndex = nowStatus.QueryIndex + 1)
        }
        return nowStatus.copy(QueryIndex = nowStatus.QueryIndex + 1)
    }
}