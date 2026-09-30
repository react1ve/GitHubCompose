package com.reactive.githubcompose.ui.feature.common

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest

class NetworkMonitor(
    context: Context,
    private val onConnectivityChange: (Boolean) -> Unit
) {
    private val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            onConnectivityChange(true)
        }

        override fun onLost(network: Network) {
            onConnectivityChange(false)
        }
    }

    fun start() {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    fun stop() {
        try {
            connectivityManager.unregisterNetworkCallback(networkCallback)
        } catch (_: Exception) {
        }
    }
}
