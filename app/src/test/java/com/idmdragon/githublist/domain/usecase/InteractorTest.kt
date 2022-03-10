package com.idmdragon.githublist.domain.usecase

import com.idmdragon.githublist.domain.repository.Repository
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class  InteractorTest(){

    private var params: String = "Idm"

    @Mock
    private lateinit var repository: Repository
    private lateinit var interactor: Interactor

    @Before
    fun setUp(){
        interactor = Interactor(repository)
    }

    @Test
    fun `verify getDetailUser `(){
        interactor.getDetailUser(params)
        verify(repository).getDetailUser(params)
    }

    @Test
    fun `verify getListUser `(){
        interactor.getListUser()
        verify(repository).getListUser()
    }

}