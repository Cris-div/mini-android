package com.example.bienvenidoalcurso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenidoalcurso.ui.theme.BienvenidoAlCursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BienvenidoAlCursoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD6E8D2) // fondo verde claro como en la imagen
                ) {
                    BusinessCardScreen()
                }
            }
        }
    }
}

@Composable
fun BusinessCardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Parte superior con logo y nombre
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.android_logo), // asegúrate de tener un logo en drawable
                contentDescription = "Logo Android",
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFF073042))
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Jennifer Doe",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                color = Color(0xFF006400) // verde oscuro
            )
        }

        // Parte inferior con datos de contacto
        Column(
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp)
        ) {
            ContactRow(
                icon = R.drawable.ic_phone,
                contactText = "+11 (123) 444 555 666"
            )
            ContactRow(
                icon = R.drawable.ic_share,
                contactText = "@AndroidDev"
            )
            ContactRow(
                icon = R.drawable.ic_email,
                contactText = "jen.doe@android.com"
            )
        }
    }
}

@Composable
fun ContactRow(icon: Int, contactText: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(start = 40.dp)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(0xFF006400),
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = contactText, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BienvenidoAlCursoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFD6E8D2)
        ) {
            BusinessCardScreen()
        }
    }
}
