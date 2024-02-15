package com.example.ticketflow.ui.search_category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ticketflow.ui.menu.HorizontalCardContentList
import com.example.ticketflow.ui.reusable_content.HeadingText
import com.example.ticketflow.ui.reusable_content.IconBack
import com.example.ticketflow.ui.search_screen.SearchBandCategories
import com.example.ticketflow.ui.search_screen.bandList
import com.example.ticketflow.ui.search_screen.rockList
import com.example.ticketflow.ui.theme.TicketFlowTheme

@Composable
fun SearchCategory() {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.Black)
        ){
            Column(
                modifier = Modifier.padding( start = 24.dp, end = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                Row {
                    IconBack()
                    Spacer(modifier = Modifier.width(24.dp))
                    HeadingText(name = "Rock")
                }
                Spacer(modifier = Modifier.height(24.dp))
                SubCategoryGrid()
            }
        }
    }
}

@Composable
fun SubCategoryGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(rockList) { item ->
            GridCardContent( gridCardList = item)
        }
    }
}
@Composable
fun GridCardContent(gridCardList: HorizontalCardContentList) {
    Card(
        modifier = Modifier
            //.background(color = Color.White)
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ){
        Column {

                    Image(
                        painter = painterResource(id = gridCardList.movieImage),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .size(width = 148.dp, height = 164.dp)
                    )

            Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = gridCardList.movieName,
                    style = MaterialTheme.typography.titleMedium.copy(fontStyle = FontStyle.Italic),
                    modifier = Modifier,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )


                Text(
                    text = gridCardList.date,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                )


                Text(
                    text = gridCardList.address,
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                )

        }
    }
}

@Preview
@Composable
fun PreviewSearchCategory() {
    TicketFlowTheme {
        SearchCategory()
    }
}