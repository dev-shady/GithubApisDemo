package com.devshady.githubapidemo.ui.users.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devshady.githubapidemo.domain.AppException
import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(dataRepository: GithubRepository): ViewModel() {

    sealed class UiState {
        object Loading: UiState()
        data class Success(
            val data: List<UserView>
            ): UiState()
        data class Error(val errorMsg: String): UiState()
    }

    data class UserView(
        val profileUrl: String,
        val name: String,
        val company: String,
        val blogUrl: String,
        val location: String,
    )

    var uiState: StateFlow<UiState> = dataRepository.getUsers().map { resource ->
        when (resource) {
            is Resource.Failure -> {
                val msg =  when (resource.e) {
                    AppException.NetworkError -> "NetworkError"
                    AppException.ServerError -> "ServerError"
                    is AppException.UnknownError -> "UnknownError"
                }
                UiState.Error(msg)
            }

            is Resource.Success -> {
                UiState.Success(resource.data.map {it.toView()})
            }
        }
    }
        .catch { e ->
            emit(UiState.Error(e.message ?: "Unknown Error"))
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = UiState.Loading
        )
}