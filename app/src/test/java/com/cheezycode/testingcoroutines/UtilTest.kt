package com.cheezycode.testingcoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.*

class UtilTest {

    @get:Rule
    val mainCoroutineRule = MainCoroutineRule()

    @Test
    fun testGetUserName() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUserName()
        }
    }

    @Test
    fun testGetUser() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getUser()
        }
    }

    @Test
    fun testGetAddress() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddress()
        }
    }

    @Test
    fun testGetAddressDetail() {
        val sut = Util(mainCoroutineRule.testDispatcher)
        runTest {
            sut.getAddressDetail()
            mainCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()
            Assert.assertEquals(true, sut.globalArg)
        }
    }

}