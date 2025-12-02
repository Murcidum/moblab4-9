package com.example.gal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gal.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentArtwork by remember { mutableStateOf(1) }

    // Данные о произведениях искусства
    val artworkData = when (currentArtwork) {
        1 -> ArtworkInfo(
            imageRes = R.drawable.artwork_1,
            title = "Звёздная ночь",
            artist = "Винсент Ван Гог",
            year = "1889"
        )
        2 -> ArtworkInfo(
            imageRes = R.drawable.artwork_2,
            title = "Девушка с жемчужной серёжкой",
            artist = "Ян Вермеер",
            year = "1665"
        )
        3 -> ArtworkInfo(
            imageRes = R.drawable.artwork_3,
            title = "Постоянство памяти",
            artist = "Сальвадор Дали",
            year = "1931"
        )
        4 -> ArtworkInfo(
            imageRes = R.drawable.artwork_4,
            title = "Крик",
            artist = "Эдвард Мунк",
            year = "1893"
        )
        else -> ArtworkInfo(
            imageRes = R.drawable.artwork_5,
            title = "Великая волна в Канагаве",
            artist = "Кацусика Хокусай",
            year = "1831"
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(24.dp))

        ArtworkWall(
            imageRes = artworkData.imageRes,
            contentDescription = artworkData.title
        )

        Spacer(modifier = Modifier.height(32.dp))

        ArtworkDescriptor(
            title = artworkData.title,
            artist = artworkData.artist,
            year = artworkData.year
        )

        Spacer(modifier = Modifier.height(24.dp))

        DisplayController(
            onPreviousClick = {
                currentArtwork = when (currentArtwork) {
                    1 -> 5
                    else -> currentArtwork - 1
                }
            },
            onNextClick = {
                currentArtwork = when (currentArtwork) {
                    5 -> 1
                    else -> currentArtwork + 1
                }
            }
        )

        Spacer(modifier = Modifier.height(24.dp))
    }
}

@Composable
fun ArtworkWall(
    imageRes: Int,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .wrapContentSize()
            .shadow(
                elevation = 8.dp,
                spotColor = Color.Black.copy(alpha = 0.3f)
            ),
        color = Color.White
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
                .heightIn(max = 400.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun ArtworkDescriptor(
    title: String,
    artist: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 4.dp,
                spotColor = Color.Black.copy(alpha = 0.2f)
            ),
        color = MaterialTheme.colorScheme.surfaceVariant
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Row(
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text(
                    text = artist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = " ($year)",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun DisplayController(
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            onClick = onPreviousClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Previous",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = onNextClick,
            modifier = Modifier.weight(1f),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(
                text = "Next",
                fontSize = 16.sp,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }
    }
}

data class ArtworkInfo(
    val imageRes: Int,
    val title: String,
    val artist: String,
    val year: String
)

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}
