package com.example.superheroparcial.ui.detail.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.SuperheroTheme

@Composable
fun HeroPublisher(publisher: String, modifier: Modifier = Modifier) {
    Text(publisher.ifBlank { "Editorial desconocida" }.uppercase(),
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 10.sp,
        modifier = modifier.background(
            MaterialTheme.colorScheme.primaryContainer,
            RoundedCornerShape(50)
        )
            .padding(horizontal = 11.dp, vertical = 6.dp))
}
@Preview(showBackground = true)
@Composable
fun HeroPublisherPreview() {
    SuperheroTheme { HeroPublisher("DC Comics") }
}
