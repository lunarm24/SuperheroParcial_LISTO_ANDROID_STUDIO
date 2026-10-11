package com.example.superheroparcial.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.preview.PreviewSuperhero
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun HeroPublisher(publisher: String) {
    Text(publisher.ifBlank { "Editorial desconocida" }.uppercase(),
        color = HeroPalette.Lavender, fontWeight = FontWeight.ExtraBold, fontSize = 10.sp,
        modifier = Modifier.background(HeroPalette.LavenderLight, RoundedCornerShape(50))
            .padding(horizontal = 11.dp, vertical = 6.dp))
}
@Preview(showBackground = true)
@Composable
fun HeroPublisherPreview() { HeroPublisher(PreviewSuperhero.batman.publisher) }
