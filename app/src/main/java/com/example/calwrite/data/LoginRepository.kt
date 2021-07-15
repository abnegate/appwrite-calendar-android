package com.example.calwrite.data

import android.app.Activity
import com.example.calwrite.data.model.LoggedInUser

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepository(val dataSource: LoginDataSource) {

    private var user: LoggedInUser? = null

    val isLoggedIn = user != null

    init {
        user = null
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username, password)
        if (result is Result.Success) {
            user = result.data
        }
        return result
    }

    suspend fun loginOAuth(activity: Activity, provider: String): Result<Boolean> {
        return dataSource.loginOAuth(activity, provider)
    }
}