package primex.ca.commons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MovieGenreChip(
    genre: String,
    background: Color = Color(0xFFFFEB3B).copy(alpha = 0.36F),
    textColor: Color = Color(0XFF000000)
) {
    Box(
        modifier = Modifier
            .padding(end = 4.dp)
            .widthIn(min = 80.dp)
            .clip(CircleShape)
            .background(background)
            .height(32.dp)
            .widthIn(min = 80.dp)
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = genre,
            color = textColor,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            fontWeight = FontWeight.Thin,
            modifier = Modifier.padding(horizontal = 2.dp)
        )
    }
}
