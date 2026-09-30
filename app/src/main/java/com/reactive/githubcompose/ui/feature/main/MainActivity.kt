package com.reactive.githubcompose.ui.feature.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.reactive.githubcompose.ui.feature.common.ConnectionSnackBar
import com.reactive.githubcompose.ui.feature.common.NetworkMonitor
import com.reactive.githubcompose.ui.navigation.AppNavigation
import com.reactive.githubcompose.ui.theme.GithubComposeTheme

class MainActivity : ComponentActivity() {
    private lateinit var networkMonitor: NetworkMonitor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        networkMonitor = NetworkMonitor(this) { isConnected ->
            setContent {
                GithubComposeTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        AppNavigation()
                        ConnectionSnackBar(isConnected = isConnected)
                    }
                }
            }
        }
        networkMonitor.start()

        setContent {
            GithubComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppNavigation()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        networkMonitor.stop()
    }
}
