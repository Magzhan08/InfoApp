package com.example.infoapp.ui_components

import android.graphics.BitmapFactory
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.infoapp.R
import com.example.infoapp.ui.theme.HeaderDrawerColor
import com.example.infoapp.utils.ListItem
import java.io.FileDescriptor

@Composable
fun MainListItem(item: ListItem, onClick: (ListItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(5.dp)
            .clickable {
                onClick(item)
            },
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, HeaderDrawerColor)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AssetImage(
                imageName = item.imageName,
                contentDescription = item.title,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = item.title,
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
fun AssetImage(imageName: String, contentDescription: String, modifier: Modifier){
    val context = LocalContext.current
    val assetManager = context.assets
    val inputStream = assetManager.open(imageName)
    val bitmap = BitmapFactory.decodeStream(inputStream)
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}