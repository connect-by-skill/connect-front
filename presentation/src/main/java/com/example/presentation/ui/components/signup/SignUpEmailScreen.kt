package com.example.presentation.ui.components.signup

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
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
import com.example.presentation.ui.common.buttons.SecondaryButton
import com.example.presentation.util.showToast
import com.example.presentation.viewmodel.SignUpViewModel
import com.example.presentation.model.SignUpScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpEmailScreen(navController: NavHostController, viewModel: SignUpViewModel){
    var checkEmail by remember { mutableStateOf(false)}
    val context = LocalContext.current
    Column(
        modifier = Modifier.padding(Padding.large),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "로그인에 사용할\n이메일을 입력해주세요.",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            textAlign = TextAlign.Left
        )
        Spacer(modifier = Modifier.size(24.dp))
        OutlinedTextField(
            value = viewModel.email.observeAsState(initial = "").value,
            onValueChange = { email ->
                viewModel.setEmail(email)
            },
            label = { Text("Email") },
            singleLine = true,
            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth(0.9f)
        )
        Text(
            text = viewModel.checkEmailFormat(),
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colors.onError,
            textAlign = TextAlign.Left
        )
        Crossfade(targetState = checkEmail) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                when(it){
                    false -> {
                        PrimaryButton (
                            text = "이메일 인증하기",
                            onClick = {
                                checkEmail = true
                                viewModel.requestCertificationNumber()
                            },
                            modifier = Modifier
                                .height(56.dp)
                                .fillMaxWidth(0.9f)
                            , state = viewModel.emailValid()
                        )
                    }
                    true -> {
                        OutlinedTextField(
                            value = viewModel.certificationNumber.observeAsState(initial = "").value,
                            onValueChange = { certificationNumber ->
                                viewModel.setCertificationNumber(certificationNumber)
                            },
                            label = { Text("인증 번호") },
                            singleLine = true,
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = MaterialTheme.colors.primary, focusedBorderColor = MaterialTheme.colors.background),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                            modifier = Modifier.fillMaxWidth(0.9f)
                        )
                        Spacer(modifier = Modifier.size(24.dp))
                        Row(
                        ) {
                            SecondaryButton (
                                text = "인증 재요청",
                                onClick = {
                                    viewModel.requestCertificationNumber()
                                },
                                modifier = Modifier
                                    .height(56.dp)
                                    .width(150.dp)
                            )
                            Spacer(modifier = Modifier.fillMaxWidth(0.1f))
                            PrimaryButton (
                                text = "다음",
                                onClick = {
                                    if(viewModel.requestCertification()){
                                        navController.navigate(SignUpScreen.PasswordInfo.name)
                                    } else {
                                        showToast(context, "유효하지 않은 인증번호입니다.")
                                    }
                                },
                                modifier = Modifier
                                    .height(56.dp)
                                    .width(150.dp)
                                , state = viewModel.certificationNumberValid()
                            )
                        }
                    }
                }
            }

        }
    }
}

@Preview
@Composable
fun SignUpEmailScreenPreview(){
    WhaleTheme {
        SignUpEmailScreen(navController = rememberNavController(), viewModel = viewModel())
    }
}