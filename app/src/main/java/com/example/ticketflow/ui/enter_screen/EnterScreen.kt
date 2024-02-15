package com.example.ticketflow.ui.enter_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
import com.example.ticketflow.ui.reusable_content.FilledContentButton
import com.example.ticketflow.ui.reusable_content.OutlinedContentButton
import com.example.ticketflow.ui.theme.TicketFlowTheme

@Composable
fun EnterScreen() {
    Scaffold {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ){
            Image(
                painter = painterResource(id = R.drawable.title),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(135.dp))
                Image(
                    painter = painterResource(id = R.drawable.group_278),
                    contentDescription = null,
                    modifier = Modifier.size(248.dp,118.dp)
                )
                Spacer(modifier = Modifier.height(385.dp))
                FilledContentButton(name = "Login")
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedContentButton(name = "Register")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewEnterScreen() {
    TicketFlowTheme {
        EnterScreen()
    }
}