package com.example.superheroparcial.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroSearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        singleLine = true,
        shape = RoundedCornerShape(18.dp),
        placeholder = { Text("Buscar superhéroes…", color = HeroPalette.Muted) },
        trailingIcon = {
            if (value.isNotEmpty()) {
                Text(
                    text = "×",
                    color = HeroPalette.Muted,
                    modifier = Modifier.clickable { onValueChange("") }
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = HeroPalette.White,
            unfocusedContainerColor = HeroPalette.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            cursorColor = HeroPalette.Lavender
        )
    )
}

@Preview(showBackground = true)
@Composable
fun HeroSearchFieldPreview() {
    HeroSearchField(value = "", onValueChange = {})
}
