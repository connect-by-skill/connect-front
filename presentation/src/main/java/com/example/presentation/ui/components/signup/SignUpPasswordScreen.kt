package com.example.presentation.ui.components.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.presentation.theme.Padding
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.ui.common.buttons.PrimaryButton
import com.example.presentation.viewmodel.SignUpViewModel
import com.example.presentation.model.SignUpScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpPasswordScreen(navController: NavHostController, viewModel: SignUpViewModel){
    var checkPassword by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.padding(Padding.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "로그인에 사용할\n비밀번호를 입력해주세요.",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = viewModel.pw.observeAsState(initial = "").value,
            onValueChange = { pw ->
                viewModel.setPw(pw)
            },
            label = { Text("비밀번호") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Text(
            text = viewModel.checkPasswordFormat(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colors.onError,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = viewModel.pwCheck.observeAsState(initial = "").value,
            onValueChange = { pwCheck ->
                viewModel.setPwCheck(pwCheck)
            },
            label = { Text("비밀번호 확인") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Text(
            text = viewModel.checkPasswordSame(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colors.onError,
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        PrimaryButton (
            text = "다음",
            onClick = {
                navController.navigate(SignUpScreen.DisabilityInfo.name)
            },
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(0.9f)
            , state = viewModel.passwordValid()
        )
    }
}

@Preview
@Composable
fun SignUpPasswordScreen(){
    WhaleTheme {
        SignUpPasswordScreen(navController = rememberNavController(), viewModel = viewModel())
    }
}