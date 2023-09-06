package com.example.presentation.ui.common.buttons

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.theme.underlineDisplay

@Composable
fun UnderlinedButton(
    modifier : Modifier = Modifier,
    text: String = "",
    @StringRes id: Int? = null,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colors.surface,
            contentColor = MaterialTheme.colors.textFiledBackgroundVariant,
            disabledContainerColor = MaterialTheme.colors.background,
            disabledContentColor = MaterialTheme.colors.disabledSecondary
        )
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = id?.let { stringResource(id = id) } ?: text,
                style = MaterialTheme.typography.underlineDisplay,
                modifier = Modifier.padding(Padding.small)
            )
        }
    }
}

@Preview
@Composable
fun UnderlinedButtonPreview() {
    WhaleTheme {
        UnderlinedButton(text = "로그인 하기") {}
    }
}