package com.devshady.githubapidemo.ui.users.details

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation

@Composable
fun UserDetails(
    uiState: UserDetailsViewModel.DetailsUiState
) {
    Text("Users Details Composable")
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        when (uiState) {
            is UserDetailsViewModel.DetailsUiState.Error ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(uiState.msg ?: "Unknown Error")
                }
            UserDetailsViewModel.DetailsUiState.Loading ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Loading")
                }
            is UserDetailsViewModel.DetailsUiState.Success ->
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(context)
                            .data(uiState.data.avatar_url)
                            .transformations(CircleCropTransformation())
                            .build()
                        ,
                        contentDescription = "profile photo",
                        modifier = Modifier.size(100.dp)
                    )
                    Text(text = "Name: ${uiState.data.company}")
                    Text(text = "blogUrl: ${uiState.data.blog}")
                    Text(text = "company: ${uiState.data.company}")
                    Text(text = "location: ${uiState.data.location}")
                    Text(text = "following: ${uiState.data.following}")
                    Text(text = "followers: ${uiState.data.followers}")
                    Text(text = "public_repos: ${uiState.data.public_repos}")

                }
        }
    }
}