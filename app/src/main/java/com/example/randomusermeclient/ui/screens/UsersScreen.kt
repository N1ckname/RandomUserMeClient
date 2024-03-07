package com.example.randomusermeclient.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.randomusermeclient.models.UserSummary

@Composable
fun UsersScreen(
    usersSummaries: List<UserSummary>,
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    state: LazyListState = rememberLazyListState(),
) {
    LazyColumn(
        state = LazyListState(),
        modifier = modifier
    ) {
        items(
            items = usersSummaries,
            key = { item -> item.id }
        ) { userSummary ->
            UserCard(
                userSummary = userSummary,
                onClick = { onItemClick(userSummary.id) },
                modifier = modifier.padding(4.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserCard(
    userSummary: UserSummary,
    onClick: () -> Unit,
    modifier: Modifier
) {
    Card(
        onClick = onClick,
        modifier = modifier
    ) {
        Row {
            Text(
                modifier = modifier.weight(1f),
                text = "Place for picture {${userSummary.picture}}"
            )
            Column(
                modifier = modifier
                    .weight(3f)
                    .padding(1.dp)
            ) {
                Text(userSummary.fullName)
                Text(userSummary.address )
                Text(userSummary.phone)
                Text(userSummary.id.toString())
            }
        }
    }
}