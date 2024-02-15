package com.example.ticketflow.ui.tickets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ticketflow.R
import com.example.ticketflow.ui.menu.MyBottomNavigationBar
import com.example.ticketflow.ui.reusable_content.HeadingText
import com.example.ticketflow.ui.theme.TicketFlowTheme

data class Ticket(
    val ticketImage : Int,
    val ticketMaskImage : Int,
    val ticketName:String,
    val venue: String,
    val showDate: String,
    val time: String,
    val ticketPurchasedOn: String,
)
val ticketList = listOf(
    Ticket(
        R.drawable.pic_16,
        R.drawable.mask_1,
        "Bad Bunny",
        "São Paulo, SP - Allianz Park",
        "28/09/2023",
        "21:00 (BRT)",
        "22/05/2023"
    ),
    Ticket(
        R.drawable.pic_17,
        R.drawable.mask_2,
        "Gorillaz",
        "Curitiba, PR - Pedreira Paulo Leminski",
        "17/10/2023",
        "19:00 (BRT)",
        "14/07/2023"
    ),
    Ticket(
        R.drawable.pic_18,
        R.drawable.mask_3,
        "Foo Fighters",
        "São Paulo, SP - Alianz Park",
        "28/10/2023",
        "21:00 (BRT)",
        "13/08/2023"
    ),
)

@Composable
fun Tickets() {
    Scaffold(
        bottomBar = { MyBottomNavigationBar() }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.Black),
        ){
            Column(
                modifier = Modifier.padding( horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
            ){
                Spacer(modifier = Modifier.height(60.dp))
                HeadingText(name = "My Tickets")
                Spacer(modifier = Modifier.height(24.dp))
                MyTicketsList()
            }
        }
    }
}

@Composable
fun MyTicketsList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(ticketList){ item->
            TicketCard(myList = item)
        }
    }
}

@Composable
fun TicketCard(myList: Ticket) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Black)
    ) {
        Row {
            Box(){
                Image(
                    painter = painterResource(id = myList.ticketImage),
                    contentDescription = null,
                    modifier = Modifier
                        .size(height = 196.dp, width = 140.dp)
                )
                Image(
                    painter = painterResource(id = myList.ticketMaskImage),
                    contentDescription = null,
                    modifier = Modifier.size(height = 196.dp, width = 140.dp)
                )
            }
            Column(
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
            ) {
                Text(
                    text = myList.ticketName,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Local:",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Text(
                    text = myList.venue,
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Date:",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Text(
                    text = myList.showDate,
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Opening:",
                    style = MaterialTheme.typography.displaySmall,
                    color = Color.White
                )
                Text(
                    text = myList.time,
                    style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row {
                    Text(
                        text = "Purchased on: ",
                        style = MaterialTheme.typography.displaySmall.copy(fontStyle = FontStyle.Italic),
                        color = Color.White
                    )
                    Text(
                        text = myList.ticketPurchasedOn,
                        style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.SemiBold),
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTickets() {
    TicketFlowTheme {
        Tickets()
    }
}