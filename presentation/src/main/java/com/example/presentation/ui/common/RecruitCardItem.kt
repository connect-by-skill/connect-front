package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.theme.nameMedium

@Composable
fun RecruitCardItem(
    rank: Int,
    image: String?=null,
    company: String,
    occupation: String
) {
    Card(
        modifier = Modifier
            .width(145.dp)
            .height(190.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.surface)
                .padding(Padding.large),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = rank.toString(),
                modifier = Modifier.fillMaxWidth(),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.headlineSmall
            )
            AsyncImage(
                model = if(image.isNullOrEmpty()) "https://www.macmillandictionary.com/us/external/slideshow/thumb/Grey_thumb.png" else image,
                contentDescription = "회사 이미지",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(70.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(Padding.small))
            Text(
                text = company,
                style = MaterialTheme.typography.nameMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = occupation,
                style = MaterialTheme.typography.labelMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun RecruitCardItemPreview() {
    WhaleTheme {
        RecruitCardItem(
            rank = 1,
            company = "금오컴퍼니",
            occupation = "영업직"
        )
    }
}