package com.example.presentation.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.domain.model.CompanyModel
import com.example.presentation.R
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors
import com.example.presentation.viewmodel.WishListViewModel

@Composable
fun WishItem(
    color: Color,
    company: String? = null,
    occupation: String? = null,
    dDay: String? = null,
    item: CompanyModel? = null,
    viewModel: WishListViewModel? = null,
    isDetail: MutableState<Boolean>? = null,
    detailInfo: MutableState<CompanyModel>? = null,
    isHome: Boolean = false
) {
    val isWish = remember { mutableStateOf(item?.addedWishlist ?: false) }
    Row(
        modifier = if(isHome){
            Modifier
                .background(color, shape = MaterialTheme.shapes.large)
                .fillMaxWidth()
                .height(75.dp)
                .padding(horizontal = Padding.extra)
        } else{
            Modifier
                .background(color, shape = MaterialTheme.shapes.large)
                .fillMaxWidth()
                .height(75.dp)
                .padding(horizontal = Padding.extra)
                .clickable {
                    isDetail?.value = true
                    detailInfo?.value = item!!
                }
        },
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (company.isNullOrEmpty()) {
            Text(
                text = "위시리스트를 추가해보세요.",
                style = MaterialTheme.typography.bodyMedium
            )
        } else {
            Column(
                modifier = Modifier.fillMaxWidth(0.7f)
            ) {
                Text(
                    text = company,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = occupation ?: "",
                    style = MaterialTheme.typography.labelMedium,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 2
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = dDay ?: "",
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.size(Padding.medium))
            IconButton(onClick = {
                if(!isHome) viewModel!!.changeWishStatus(isWish.value, item!!)
            }) {
                Icon(
                    painter = if (isWish.value) painterResource(id = R.drawable.clober) else painterResource(
                        id = R.drawable.selected_clover
                    ),
                    tint = if (isWish.value || isHome) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
                    contentDescription = "찜하기",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}

