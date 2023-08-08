package com.example.infoapp.ui_components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.infoapp.R
import com.example.infoapp.ui.theme.HeaderDrawerColor
import com.example.infoapp.ui.theme.ItemsBackground
import com.example.infoapp.utils.DrawerEvents

@Composable
fun DrawerMenu(onEvent: (DrawerEvents) -> Unit) {
    Box(
        modifier = Modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.drawer_list_bg),
            contentDescription = "Main Bg Image",
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header()
            Body() {event ->
                onEvent(event)
            }
        }
    }
}

@Composable
fun Header() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(5.dp),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, HeaderDrawerColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.header_bg),
                contentDescription = "Header image",
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "-Справочник ботаника-",
                modifier = Modifier
                    .fillMaxWidth()
                    .background(HeaderDrawerColor)
                    .padding(10.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Black,
                color = Color.White
            )
        }
    }
}

@Composable
fun Body(onEvent: (DrawerEvents) -> Unit) {
    val list = stringArrayResource(id = R.array.drawer_list)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(list) { index, title ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp),
                backgroundColor = ItemsBackground
            ) {
                Text(
                    text = title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onEvent(DrawerEvents.OnItemClick(title = title, index = index))
                        }
                        .padding(10.dp)
                        .wrapContentWidth(),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}