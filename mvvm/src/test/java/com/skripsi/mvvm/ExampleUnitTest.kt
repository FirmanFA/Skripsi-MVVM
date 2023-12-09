package com.skripsi.mvvm

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.test.assertTrue

class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        //akan membuat test berhasil
        // karena 4 sama dengan 2 tambah 2
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testNotSame() {
        //akan membuat test berhasil
        // karena kedua objek tersebut tidak sama
    }

    @Test
    fun is_data_true() {
        //akan membuat test menjadi gagal
        // karena data yang dihasilkan false
        assertTrue(1!=1)
    }

}