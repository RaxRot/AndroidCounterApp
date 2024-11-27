package com.raxrot.counterapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raxrot.counterapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoGallery(modifier: Modifier = Modifier) {
 val photos= listOf(R.drawable.pic1,
     R.drawable.pic2,
     R.drawable.pic3,
     R.drawable.pic3,
     R.drawable.pic4,
     R.drawable.pic5)

    var index by remember { mutableStateOf(0) }

    fun NextPhoto(){
        index++
    }

    fun PrevPhoto(){
        index--
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Photo Gallery")
                },
                actions = {
                    Text(text = "Showing ${(index+1)} / ${photos.size}",
                        modifier = Modifier.padding(15.dp))
                }
            )
        }
    ) {
        Column(modifier = modifier.padding(it).fillMaxSize().padding(10.dp)) {
            Card(modifier = Modifier.weight(5f),
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)) {
                Image(painter = painterResource(id = photos.get(index)),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop)
            }
            Surface(modifier=Modifier.padding(8.dp)
                .weight(1f)
                .wrapContentSize(Alignment.Center)) {
                Row {
                    OutlinedButton(enabled = index>0, onClick = {PrevPhoto()},
                        modifier = Modifier.weight(1f)) {
                        Text(text = "Previous")
                    }
                    Spacer(modifier = Modifier.width(15.dp))

                    OutlinedButton(enabled = index<photos.size-1,onClick = {NextPhoto()},
                        modifier = Modifier.weight(1f)) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PhotoGalleryPreview() {
    PhotoGallery()
}