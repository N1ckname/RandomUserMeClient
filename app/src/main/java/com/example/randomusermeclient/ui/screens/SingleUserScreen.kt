package com.example.randomusermeclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomusermeclient.models.SingleUser

@Composable
fun SingleUserScreen(
    userProvider: () -> State<SingleUser>,
    modifier: Modifier = Modifier
) {
    SingleUserScreenStateless(
        fullUserData = userProvider().value,
        modifier = modifier
    )
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