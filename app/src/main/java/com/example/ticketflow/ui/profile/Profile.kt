package com.example.ticketflow.ui.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ticketflow.R
import com.example.ticketflow.ui.menu.MyBottomNavigationBar
import com.example.ticketflow.ui.reusable_content.FilledContentButton
import com.example.ticketflow.ui.reusable_content.FilledContentButtonWithIcon
import com.example.ticketflow.ui.reusable_content.HeadingText
import com.example.ticketflow.ui.theme.TicketFlowTheme

@Composable
fun Profile() {
    Scaffold(
        bottomBar = { MyBottomNavigationBar() }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = Color.Black)
        ){
            Column(
                modifier = Modifier.padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.height(60.dp))
                HeadingText(name = "Profile")
                Spacer(modifier = Modifier.height(24.dp))
                ImageBox()
                Spacer(modifier = Modifier.height(30.dp))
                Divider(modifier = Modifier.height(2.dp), color = Color(0xffA3A3A3))
                Spacer(modifier = Modifier.height(30.dp))
                FilledContentButtonWithIcon(name = "Edit profile", icon = R.drawable.icon_3)
                Spacer(modifier = Modifier.height(16.dp))
                FilledContentButtonWithIcon(name = "Payment options", icon = R.drawable.icon_4)
                Spacer(modifier = Modifier.height(16.dp))
                FilledContentButtonWithIcon(name = "Purchases history", icon = R.drawable.icon_5)
                Spacer(modifier = Modifier.height(16.dp))
                FilledContentButtonWithIcon(name = "User Terms of Service", icon = R.drawable.icon_6)
            }
        }
    }
}

@Composable
fun ImageBox() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(226.dp)
                .border(
                    BorderStroke(width = 10.dp, color = Color(0xffA21313)),
                    shape = RoundedCornerShape(100)
                )
            ){
            Image(
                painter = painterResource(id = R.drawable.pic_19),
                contentDescription = null,
                modifier = Modifier.padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Wellington Castro",
            style = MaterialTheme.typography.headlineSmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
    TicketFlowTheme {
        Profile()
    }
}