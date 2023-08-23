package com.example.testqrcode.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testqrcode.domain.GetUserUseCase
import com.example.testqrcode.domain.ReduceBalanceUseCase
import com.example.testqrcode.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase,
    private val reduceBalanceUseCase: ReduceBalanceUseCase
    ) : ViewModel() {
    val userState: StateFlow<User?> = getUserUseCase.userState

    fun reduceBalance(amount: Double){
        viewModelScope.launch{
            reduceBalanceUseCase.execute(amount)
        }
    }
}