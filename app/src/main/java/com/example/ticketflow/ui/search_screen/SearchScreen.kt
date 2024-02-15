package com.example.ticketflow.ui.search_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ticketflow.R
import com.example.ticketflow.ui.menu.HorizontalCardContentList
import com.example.ticketflow.ui.menu.MyBottomNavigationBar
import com.example.ticketflow.ui.reusable_content.HeadingText
import com.example.ticketflow.ui.theme.TicketFlowTheme

data class SearchBandCategories(
    val bandName:String,
    val bandImage: Int,
    val selectedBandList: List<HorizontalCardContentList>
)
val rockList = listOf(
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_11,
        "Red Hot Chilli Peppers",
        "27/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_12,
        "Imagine Dragons",
        "07/02/2024",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_13,
        "Cage the elephant",
        "10/02/2024",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_14,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_15,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    )
)
val countrySide = listOf(
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    )
)
val pop = listOf(
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    ),
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    ),
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    )
)
val funk = listOf(
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    )
)
val rap = listOf(
    HorizontalCardContentList(
        R.drawable.pic_5,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_5,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_5,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    )
)
val electronics = listOf(
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    ),
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    ),
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    )
)
val bandList = listOf(
    SearchBandCategories(
        bandName = "Countryside",
        bandImage = R.drawable.search_1,
        selectedBandList = countrySide
        ),
    SearchBandCategories(
        bandName = "Rock",
        bandImage = R.drawable.search_2,
        selectedBandList = rockList
    ),
    SearchBandCategories(
        bandName = "Pop",
        bandImage = R.drawable.search_3,
        selectedBandList = pop
    ),
    SearchBandCategories(
        bandName = "Funk",
        bandImage = R.drawable.search_4,
        selectedBandList = funk
    ),
    SearchBandCategories(
        bandName = "Rap",
        bandImage = R.drawable.search_5,
        selectedBandList = rap
    ),
    SearchBandCategories(
        bandName = "Electronics",
        bandImage = R.drawable.search_6,
        selectedBandList = electronics
    ),
)
@Composable
fun SearchScreen() {
    Scaffold(
        bottomBar = { MyBottomNavigationBar() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.Black)
        ){
            Column (
                modifier = Modifier.padding( start = 24.dp, end = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ){
                Spacer(modifier = Modifier.height(60.dp))
                HeadingText(name = "Search")
                Spacer(modifier = Modifier.height(24.dp))
                MySearchBar()
                Spacer(modifier = Modifier.height(40.dp))
                LazySearchCategories()
            }
        }
    }
}

@Composable
fun LazySearchCategories() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 24.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        items(bandList){item ->
            CategoryCard(bandList = item)
        }
    }
}

@Composable
fun CategoryCard(bandList:SearchBandCategories) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {
        Box(modifier = Modifier.fillMaxSize(),) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = bandList.bandImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(Color.Black, Color.Transparent),
                            startX = 10.0f,
                            endX = 300.0f
                        )
                    )
            )
            Column (
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .align(Alignment.CenterStart),
            ){
                Text(
                    text = bandList.bandName,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }



    }
}

@Composable
fun MySearchBar(modifier: Modifier = Modifier,
                searchIcon: Int = R.drawable.vector__5_,
                onSearch: (String) -> Unit = {}) {

        var searchText by remember { mutableStateOf("") }

        Row(
            modifier = modifier
                .height(40.dp)
                .fillMaxWidth()
                .border(
                    BorderStroke(
                        width = 1.dp, color = Color(0xffA21313)
                    ), shape = RoundedCornerShape(8.dp)
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(6.dp))
            Image(
                painter = painterResource(id = searchIcon),
                contentDescription = null,
            )
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                singleLine = true,
                textStyle = TextStyle(color = Color.Black),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(end = 8.dp),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        Text(
                            text = "Artists, Bands or Venues",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xff5E606A)
                        )
                    }
                }
            )
        }
    }


@Preview(showBackground = true)
@Composable
fun PreviewSearchScreen() {
    TicketFlowTheme {
        SearchScreen()
    }
}