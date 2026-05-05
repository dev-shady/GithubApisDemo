package com.devshady.githubapidemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.devshady.githubapidemo.navigation.Route
import com.devshady.githubapidemo.ui.theme.GithubApiDemoTheme
import com.devshady.githubapidemo.ui.users.details.UserDetails
import com.devshady.githubapidemo.ui.users.feed.UsersList
import com.devshady.githubapidemo.ui.users.feed.UsersListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }

    @Composable
    fun MainScreen() {
        GithubApiDemoTheme {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Surface(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxSize()
                ) {
                    val application = application as GithubDemoApplication
                    val navController = rememberNavController()
                    NavHost(navController= navController, startDestination = Route.UsersList) {

                        composable<Route.UsersList> {
                            val usersListViewModel = viewModel<UsersListViewModel>(
                                factory = object : ViewModelProvider.Factory {
                                    override fun <T : ViewModel> create(modelClass: Class<T>): T {
                                        return UsersListViewModel(application.repository) as T
                                    }
                                }
                            )
                            val uiState = usersListViewModel.uiState.collectAsStateWithLifecycle()
                            UsersList(uiState.value) { userId ->
                                navController.navigate(Route.UserDetails(id = userId))
                            }
                        }
                        composable<Route.UserDetails> { backStackEntry ->
                            val details: Route.UserDetails = backStackEntry.toRoute()
                            UserDetails(details.id)
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun MainScreenPreview() {
        GithubApiDemoTheme {
            MainScreen()
        }
    }
}

