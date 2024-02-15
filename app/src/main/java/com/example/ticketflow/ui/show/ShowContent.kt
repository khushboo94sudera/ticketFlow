package com.example.ticketflow.ui.show

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollbarStyle
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ticketflow.R
import com.example.ticketflow.ui.reusable_content.FilledContentButton
import com.example.ticketflow.ui.reusable_content.IconBack
import com.example.ticketflow.ui.theme.TicketFlowTheme

@Composable
fun ShowContent() {
    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(color = Color.Black)
        ){
            Image(
                painter = painterResource(id = R.drawable.pic_3),
                contentDescription = null,
                modifier = Modifier.size(width = 390.dp, height = 522.dp),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(Color.Transparent, Color.Black),
                            startY = 400f,
                            endY = 1400f
                        )
                    )
            )
            Column(
                modifier = Modifier.padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(modifier = Modifier.height(76.dp))
                IconBack()
                //Spacer(modifier = Modifier.height(136.dp))
                Image(
                    painter = painterResource(id = R.drawable.pic_10),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(width = 270.dp, height = 216.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ){
                    Image(
                        painter = painterResource(id = R.drawable.icon_1),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "São Paulo, SP - Allianz Parque",
                        style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_2),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "24/07/2023 - Opening: 20:00 (BRT) ",
                        style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
                        modifier = Modifier
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "About",
                    style = MaterialTheme.typography.titleSmall.copy(color = Color.White,fontWeight = FontWeight.SemiBold),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                var text by remember { mutableStateOf("This is a long text.".repeat(500)) }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(187.dp)
                        .border(
                            BorderStroke(width = 1.dp, color = Color(0xffA21313)),
                            shape = RoundedCornerShape(12.dp)
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                    ) {
                        BasicTextField(
                            value = text,
                            onValueChange = { text = it },
                            modifier = Modifier
                                .weight(1f),
                            textStyle = MaterialTheme.typography.labelSmall.copy(lineHeight = 17.sp, textAlign = TextAlign.Start),
                            singleLine = false
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                            VerticalScrollbar(
                                modifier = Modifier,
                                style = ScrollbarStyle(
                                    thickness = 4.dp,
                                    shape = RoundedCornerShape(10.dp),
                                    unhoverColor =Color(0xffA21313),
                                    hoverColor = Color(0xffA21313),
                                    hoverDurationMillis = 300,
                                    minimalHeight = 37.dp,
                                ),
                                adapter = rememberScrollbarAdapter(scrollState = rememberScrollState())
                            )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                FilledContentButton(name = "Buy Tickets")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShowContent() {
    TicketFlowTheme {
        ShowContent()
    }
}