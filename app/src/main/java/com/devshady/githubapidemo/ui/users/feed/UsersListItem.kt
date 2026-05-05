package com.devshady.githubapidemo.ui.users.feed

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.devshady.githubapidemo.R

@Composable
fun UsersListItem(user: UsersListViewModel.UserView) {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data(user.profileUrl)
                        //TODO differentiate shimmer for loading and error placeholder image
                        .placeholder(R.drawable.ic_launcher_background)
                        .transformations(CircleCropTransformation())
                        .build(),
                    modifier = Modifier.size(100.dp),
                    contentDescription = "profile photo"
                )
                Text(text = user.name, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = user.company, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = user.blogUrl,  fontSize = 12.sp, fontWeight = FontWeight.Medium)
                Text(text = user.location,  fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UsersListItemPreview() {
    val context = LocalContext.current

    Card(
        modifier = Modifier.fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .padding(4.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context)
                        .data("https://avatars.githubusercontent.com/u/1?v=4")
                        .placeholder(R.drawable.ic_launcher_background)
                        .transformations(CircleCropTransformation())
                        .build(),
                    modifier = Modifier.size(100.dp),
                    contentDescription = "profile photo"
                )
                Text(text = "First and Last Name", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
            Spacer(Modifier.width(16.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Company", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = "blog link",  fontSize = 12.sp, fontWeight = FontWeight.Medium)
                Text(text = "location",  fontSize = 12.sp, fontWeight = FontWeight.Normal)
            }
        }


    }
}