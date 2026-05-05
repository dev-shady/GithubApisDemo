package com.devshady.githubapidemo.ui.users.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UsersList(onClick: (String) -> Unit) {

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text("Users List Composable")
        }
        items(
            items=listOf("Akshay", "SRK", "Salman", "Ranbir")
        ) {
            Button(
                onClick = { onClick(it) }
            ) {
                Text(text = it)
            }
        }
    }
}