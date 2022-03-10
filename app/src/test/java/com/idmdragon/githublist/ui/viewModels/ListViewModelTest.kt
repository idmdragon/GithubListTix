package com.idmdragon.githublist.ui.viewModels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.paging.PagingData
import com.idmdragon.githublist.data.Resource
import com.idmdragon.githublist.domain.model.User
import com.idmdragon.githublist.domain.usecase.UseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ListViewModelTest {

    private lateinit var viewModel: ListViewModel
    private var params: String = "Idm"

    @get:Rule
    val instantExecutor = InstantTaskExecutorRule()

    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Mock
    private lateinit var useCase: UseCase

    @Mock
    private lateinit var fakeUser: User

    @Mock
    private lateinit var fakePagedUser: PagingData<User>

    private val flowUser: Flow<Resource<User>> = flow { Resource.Success(fakeUser) }
    private val flowPagedUser: Flow<PagingData<User>> = flow {fakePagedUser}

    @Mock
    private lateinit var observerUser: Observer<Resource<User>>
    @Mock
    private lateinit var observerPagedUser: Observer<PagingData<User>>

    @Before
    fun setUp() {
        viewModel = ListViewModel(useCase)
    }

    @Test
    fun `verify get user detail success`() = runBlockingTest {

        `when`(useCase.getDetailUser(params)).thenReturn(flowUser)
        viewModel.getDetailUser(params).observeForever(observerUser)

        verify(useCase).getDetailUser(params)
    }

    @Test
    fun `verify get list user success`() = runBlockingTest {

        `when`(useCase.getListUser()).thenReturn(flowPagedUser)
        viewModel.getListUser().observeForever(observerPagedUser)

        verify(useCase).getListUser()
    }


}