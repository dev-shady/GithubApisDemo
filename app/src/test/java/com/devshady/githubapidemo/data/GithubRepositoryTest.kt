package com.devshady.githubapidemo.data

import com.devshady.githubapidemo.domain.RemoteDataSource
import com.devshady.githubapidemo.domain.Resource
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import retrofit2.Response

//("hello", (result as Resource.Success).data[0].name)

class GithubRepositoryTest {

    private val remoteDataSource = mock<RemoteDataSource>()
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()
    private val githubRepoImpl = GithubRepositoryImpl(remoteDataSource, testDispatcher)

    @Test
    fun `getUsers should emit Success with mapped domain model`() = runTest {

        whenever(remoteDataSource.getUsers()).then { Response.success(listOf<UserDto>(UserDto("hello","1","1","1","1",))) }

        val result = githubRepoImpl.getUsers().first()

        assert(result is Resource.Success) {"Expected Success but got $result" }
        assertEquals("hello", (result as Resource.Success).data[0].profileUrl)

    }
}