package primex.ca.commons

import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import primex.ca.ui.theme.AppOnPrimaryColor
import primex.ca.ui.theme.ButtonColor

@Composable
fun BackButton(modifier: Modifier = Modifier, onClick: () -> Unit) {
    FloatingActionButton(
        modifier = modifier.size(42.dp),
        backgroundColor = ButtonColor,
        contentColor = Color(0xFF000000).copy(alpha = 0.60F),
        onClick = { onClick() }) {
        Icon(
            imageVector = Icons.Rounded.ArrowBack,
            contentDescription = "back icon",
        )
    }
}
