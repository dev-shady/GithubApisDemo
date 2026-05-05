package com.devshady.githubapidemo.ui.users.details

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.devshady.githubapidemo.domain.GithubRepository
import com.devshady.githubapidemo.domain.User
import com.devshady.githubapidemo.domain.UserDetails
import com.devshady.githubapidemo.navigation.Route
import com.devshady.githubapidemo.ui.users.feed.UsersListViewModel.UiState
import com.devshady.githubapidemo.ui.users.feed.toDetailsView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(savedStateHandle: SavedStateHandle, repository: GithubRepository): ViewModel() {


    data class UserDetailsView (
        val avatar_url: String,
        val company: String,
        val blog: String,
        val location: String,
        val public_repos: Int,
        val followers: Int,
        val following: Int,
    )

    sealed class DetailsUiState {
        object Loading: DetailsUiState()
        data class Success(val data: UserDetailsView): DetailsUiState()
        data class  Error(val msg: String?): DetailsUiState()
    }

    private val userRoute = savedStateHandle.toRoute<Route.UserDetails>()
    private val userId = userRoute.id

    val uiState: StateFlow<DetailsUiState> = repository.getUser(userId)
        .map<UserDetails, DetailsUiState> { user ->
            DetailsUiState.Success(user.toDetailsView())
        }
        .catch { e ->
            emit(DetailsUiState.Error(e.message ?: "Unknown Error"))
            Log.d("aamku stacktrace", e.stackTrace.toString())
            Log.d("aamku message", e.message.toString())
            Log.d("aamku cause", e.cause.toString())
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = DetailsUiState.Loading
        )

}