package com.example.randomusermeclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomusermeclient.models.SingleUser
import com.example.randomusermeclient.ui.ScreenUiState

@Composable
fun SingleUserScreen(
    userProvider: () -> Unit,
    stateProvider: () -> ScreenUiState,
    modifier: Modifier = Modifier
) {
    userProvider()
    val state = remember {
        stateProvider()
    }

    when (state) {
        is ScreenUiState.Success -> SingleUserScreenStateless(
            fullUserData = state.data as SingleUser,
            modifier = modifier
        )
        is ScreenUiState.Error -> ErrorScreen()
        is ScreenUiState.Loading -> LoadingScreen()
    }
}
@Composable
fun SingleUserScreenStateless(
    fullUserData: SingleUser,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(2.dp)
    ) {
        UserCard(
            userSummary = fullUserData.basis,
            onClick = {},
            modifier = modifier
        )

        Text(text = "Full data")
    }
}