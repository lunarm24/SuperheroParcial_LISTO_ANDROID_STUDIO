package com.example.superheroparcial.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroparcial.ui.theme.HeroPalette

@Composable
fun ErrorMessage(message: String, onRetry: () -> Unit) {
    Column(Modifier.fillMaxWidth().padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)) {
        Text("✧", fontSize = 48.sp, color = HeroPalette.Coral)
        Text("¡Houston, tenemos un problema!", color = HeroPalette.Ink,
            fontSize = 19.sp, fontWeight = FontWeight.Bold)
        Text(message, color = HeroPalette.Muted)
        Button(onClick = onRetry, shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = HeroPalette.Lavender)) {
            Text("INTENTAR DE NUEVO")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ErrorMessagePreview() { ErrorMessage("Sin conexión", {}) }
