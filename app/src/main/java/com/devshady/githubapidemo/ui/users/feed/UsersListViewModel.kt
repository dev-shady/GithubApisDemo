package com.devshady.githubapidemo.ui.users.feed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.devshady.githubapidemo.domain.GithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UsersListViewModel @Inject constructor(dataRepository: GithubRepository): ViewModel() {
    var uiState = dataRepository.getPagedUsers().cachedIn(viewModelScope)
}