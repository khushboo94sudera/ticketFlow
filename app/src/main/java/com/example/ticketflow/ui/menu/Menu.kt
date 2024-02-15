package com.example.ticketflow.ui.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ticketflow.R
import com.example.ticketflow.ui.reusable_content.HeadingText
import com.example.ticketflow.ui.reusable_content.SmallHeadingText
import com.example.ticketflow.ui.search_screen.SearchBandCategories
import com.example.ticketflow.ui.search_screen.bandList
import com.example.ticketflow.ui.theme.TicketFlowTheme

data class CarouselContentList(
    val movieImage: Int,
    val movieName: String,
    val date: String,
    val address: String
)
val carouselList = listOf(
    CarouselContentList(
        movieImage = R.drawable.pic_3,
        movieName = "Bruno Mars",
        date = "24/08/2022",
        address = "São Paulo, SP"
    ),
    CarouselContentList(
        R.drawable.pic_7,
        "Foo Fighters",
        "09/09/2022",
        "Curitiba, PR"
    ),
    CarouselContentList(
        R.drawable.pic_8,
        "Dua Lipa",
        "10/09/2022",
        "São Paulo, SP"
    ),
    CarouselContentList(
        R.drawable.pic_9,
        "Metallica",
        "15/09/2022",
        "Rio de Janeiro, RJ"
    )

)
data class HorizontalCardContentList(
    val movieImage: Int,
    val movieName: String,
    val date: String,
    val address: String
)
val cardList = listOf(
    HorizontalCardContentList(
        R.drawable.pic_4,
        "Green Day",
        "12/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_5,
        "Audio Slave",
        "26/12/2023",
        "São Paulo, SP"
    ),
    HorizontalCardContentList(
        R.drawable.pic_6,
        "Kendrick Lamar",
        "03/01/2024",
        "Rio de Janeiro, RJ"
    ),
)

@Composable
fun MenuMain() {
    Scaffold (
        bottomBar = {MyBottomNavigationBar()}
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.Black)
        ){
            Column {
                Column(
                    modifier = Modifier.padding(start = 24.dp, end = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ) {
                    Spacer(modifier = Modifier.height(60.dp))
                    HeadingText(name = "Menu")
                    Spacer(modifier = Modifier.height(16.dp))
                    SmallHeadingText(name = "Highlighted")
                    Spacer(modifier = Modifier.height(16.dp))
                    HorizontalCarousel()
                    Spacer(modifier = Modifier.height(8.dp))
                    SmallHeadingText(name = "Other Shows")

                }
                Column (
                    modifier = Modifier.padding( start = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start,
                ){
                    Spacer(modifier = Modifier.height(8.dp))
                    OtherShowCard()
                }
            }

        }
    }
}
@Composable
fun OtherShowCard() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(space = 18.dp),
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 0.dp)
    ) {
        items(bandList){ item ->
            CardContent(cardList = item)
        }
    }
}
@Composable
fun CardContent(cardList: SearchBandCategories) {
    Card(
        modifier = Modifier
            //.background(color = Color.White)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ){
            Column {
                cardList.selectedBandList.firstOrNull()
                    ?.let { painterResource(id = it.movieImage) }?.let {
                        Image(
                            painter = it,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .clip(RoundedCornerShape(12.dp))
                                .size(width = 148.dp, height = 164.dp)
                        )
                    }
                Spacer(modifier = Modifier.height(4.dp))
                cardList.selectedBandList.firstOrNull()?.let {
                    Text(
                        text = it.movieName,
                        style = MaterialTheme.typography.titleMedium.copy(fontStyle = FontStyle.Italic),
                        modifier = Modifier
                    )
                }
                cardList.selectedBandList.firstOrNull()?.let {
                    Text(
                        text = it.date,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                    )
                }
                cardList.selectedBandList.firstOrNull()?.let {
                    Text(
                        text = it.address,
                        style = MaterialTheme.typography.labelSmall,
                        modifier = Modifier
                    )
                }
            }
    }
}
data class NavItem(val title: String, val icon: Int)

@Composable
fun MyBottomNavigationBar( ) {
    val items = listOf(
        NavItem("Menu", R.drawable.home),
        NavItem("Search", R.drawable.search),
        NavItem("Tickets", R.drawable.ticket),
        NavItem("Profile", R.drawable.profile),
    )
    NavigationBar(
        containerColor = Color.Black,
        modifier = Modifier
            .border(BorderStroke(width = 1.dp, color = Color(0xff262B33)))
    ) {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Image(painterResource(id = item.icon),contentDescription = null) },
                label = { Text(text = item.title, style = MaterialTheme.typography.displaySmall) },
                selected = false,
                onClick = {

                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color(0xffA21313),
                    selectedTextColor = Color(0xffA21313),
                    unselectedIconColor = Color(0xff9598A6),
                    unselectedTextColor = Color(0xff9598A6),
                ),
                modifier = Modifier.padding(top = 0.dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalCarousel() {
    val pagerState = rememberPagerState(pageCount = { carouselList.size})
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(275.dp)
    ){
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            pageSpacing = 0.dp,
            userScrollEnabled = true,
            reverseLayout = false,
            contentPadding = PaddingValues(0.dp),
            beyondBoundsPageCount = 0,
            pageSize = PageSize.Fill,

        ){index ->
            Box(
                modifier = Modifier.background(
                    color = Color.Black,
                    shape = RoundedCornerShape(12.dp)
                )
            ){
                Image(
                    painter = painterResource(id = carouselList[index].movieImage),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                        brush = Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black),
                            startY = 250f,
                            endY = 650f
                        )
                        )
                )
                Column(
                    modifier = Modifier.align(Alignment.BottomStart)
                ) {
                    Text(
                        text = carouselList[index].movieName,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontStyle = FontStyle.Italic
                        ),
                    )
                    Text(
                        text = "${carouselList[index].date} - ${carouselList[index].address}",
                        style = MaterialTheme.typography.labelMedium.copy(
                            fontWeight = FontWeight.Medium, color = Color.White
                        ),
                    )
                }
            }
        }

    }
    Spacer(modifier = Modifier.height(8.dp))
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color(0xffA21313) else Color.DarkGray
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuMain() {
    TicketFlowTheme {
        MenuMain()
    }
}