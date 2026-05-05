package com.devshady.githubapidemo.ui.users.feed

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun UsersList(
    uiState: UsersListViewModel.UiState,
    onClick: (String) -> Unit) {

    val context = LocalContext.current

    when (uiState) {
        is UsersListViewModel.UiState.Error -> {
            Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
        }
        UsersListViewModel.UiState.Loading -> {
            Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
        }
        is UsersListViewModel.UiState.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                item {
                    Text("Users List:")
                }
                items(
                    items= uiState.data
                ) {
                    UsersListItem(it)
                }
            }

        }
    }


}