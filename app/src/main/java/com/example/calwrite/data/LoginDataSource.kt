package com.example.calwrite.data

import android.app.Activity
import androidx.activity.ComponentActivity
import com.example.calwrite.data.model.LoggedInUser
import io.appwrite.Client
import io.appwrite.services.Account
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        return try {
            val fakeUser = LoggedInUser(
                UUID.randomUUID().toString(),
                "Jane Doe"
            )
            Result.Success(fakeUser)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    suspend fun loginOAuth(activity: Activity, provider: String): Result<Boolean> {
        return try {
            val client = Client(activity)
                .setEndpoint("https://appwrite.jakebarnby.com")
                .setProject("60f00afd0648c")
                .setSelfSigned(true)

            val account = Account(client)

            account.createOAuth2Session(
                activity as ComponentActivity,
                provider,
                "appwrite-callback-60f00afd0648c://success",
                "appwrite-callback-60f00afd0648c://failure",
                listOf("*")
            )

            Result.Success(true)
        } catch (e: Throwable) {
            Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {

    }
}