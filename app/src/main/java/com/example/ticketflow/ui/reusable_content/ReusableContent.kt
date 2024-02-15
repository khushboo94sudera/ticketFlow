package com.example.ticketflow.ui.reusable_content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ticketflow.R

@Composable
fun IconBack() {
    Box(
        modifier = Modifier
            .size(44.dp)
            .clip(shape = RoundedCornerShape(24.dp))
            .background(color = Color.Black),
    ){
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = null,
            modifier = Modifier.align(Alignment.Center),
            tint = Color(0xffA21313)
        )
    }
}

@Composable
fun OutlinedContentButton(name:String) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 4.dp, color = Color(0xffA21313)),
        contentPadding = PaddingValues(vertical = 16.dp),
    ){
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
            modifier = Modifier
        )
    }
}
@Composable
fun OutlinedContentButtonWithIcon(name:String, icon:Int) {
    OutlinedButton(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(width = 4.dp, color = Color(0xffA21313)),
        contentPadding = PaddingValues(vertical = 16.dp),
    ){
        Image(
            painter = painterResource(id = icon),
            contentDescription = null
        )
        Spacer(
            modifier = Modifier.size(ButtonDefaults.IconSpacing)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium.copy(color = Color.White),
            modifier = Modifier
        )
    }
}

@Composable
fun FilledContentButton(name:String) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(Color(0xffA21313))
    ){
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier
        )
    }
}
@Composable
fun FilledContentButtonWithIcon(name:String, icon:Int) {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        contentPadding = PaddingValues(vertical = 16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xffA21313), contentColor = Color.White)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
            Spacer(
                modifier = Modifier.width(16.dp)
            )
            Text(
                text = name,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
            )
        }

    }
}

@Composable
fun TextBoxContent(name:String) {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        placeholder = {
            Text(
                text = name,
                style = MaterialTheme.typography.titleSmall
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                BorderStroke(width = 3.dp, color = Color(0xffA21313)),
                shape = RoundedCornerShape(6.dp)
            ),
        shape = RoundedCornerShape(6.dp),
        colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xffA21313))

    )
}

@Composable
fun HeadingText(name:String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
    )
}

@Composable
fun MediumHeadingText(name:String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleMedium,
        modifier = Modifier
    )
}
@Composable
fun SmallHeadingText(name:String) {
    Text(
        text = name,
        style = MaterialTheme.typography.headlineSmall,
        modifier = Modifier
    )
}
@Composable
fun HorizontalOrDivider(name:String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ){
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .weight(1f),
            color = Color(0xffA3A3A3)
        )
        Text(
            text = name,
            style = MaterialTheme.typography.labelMedium,
            color = Color(0xffA3A3A3),
            modifier = Modifier.padding(horizontal = 12.dp)

        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .weight(1f),
            color = Color(0xffA3A3A3)
        )
    }
}