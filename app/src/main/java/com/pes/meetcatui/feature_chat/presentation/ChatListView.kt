package com.pes.meetcatui.feature_chat.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pes.meetcatui.commons.presentation.Navigation
import com.pes.meetcatui.ui.theme.Background
import com.pes.meetcatui.ui.theme.Gray
import com.pes.meetcatui.ui.theme.Highlight
import com.pes.meetcatui.ui.theme.typo

@Preview
@Composable
fun ChatListScreen(
    //viewModel: ChatListViewModel,
) {
    val viewModel = ChatListViewModel()
    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {

            viewModel.init()
            item {
                for (friend in viewModel.friends.value) {
                    Row {
                        Chat(sender = friend, lastMessage = "")
                    }
                }
            }
        }
        Row (
            modifier = Modifier.fillMaxHeight(0.2F),
            verticalAlignment = Bottom,
        ) {
            Navigation(section = "chat")
        }
    }
}

@Composable
fun Chat(
    sender: String,
    lastMessage: String,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .background(color = Background, shape = RectangleShape)
            .padding(horizontal = 16.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp, top = 24.dp),
        ) {
            Text(
                modifier = Modifier
                    .width(256.dp)
                ,
                text = sender,
                style = typo.h4,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Box(
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
                    .size(12.dp)
                    .background(color = Highlight, shape = CircleShape)
            )
        }
        Divider(
            startIndent = 0.dp,
            thickness = 1.dp,
            color = Gray,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}


