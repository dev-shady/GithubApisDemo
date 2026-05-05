package com.devshady.githubapidemo.ui.users.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.devshady.githubapidemo.domain.User

@Composable
fun UsersList(
    pagingItems: LazyPagingItems<User>,
    onClick: (String) -> Unit
) {

    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text("Users List:")
        }

        items(
            pagingItems.itemCount
        ) { index ->
            pagingItems[index]?.let { user ->
                UsersListItem(user = user) {
                    onClick(user.name)
                }
            }
        }

        if (pagingItems.loadState.append is LoadState.Loading) {
            item {
                CircularProgressIndicator()
            }
        }
    }


}