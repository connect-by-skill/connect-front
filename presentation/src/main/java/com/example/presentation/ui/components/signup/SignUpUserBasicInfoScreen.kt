package com.example.presentation.ui.components.signup

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.domain.model.AddressInfo
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors
import com.example.presentation.ui.common.buttons.PrimaryButton
import com.example.presentation.model.SignUpScreen
import com.example.presentation.ui.webview.SearchAddressScreen
import com.example.presentation.viewmodel.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpUserBasicInfoScreen(navController: NavHostController, viewModel: SignUpViewModel){
    val inputAddress = remember { mutableStateOf(false)}
    Crossfade(targetState = inputAddress.value) {
        when(it) {
            false -> {
                viewModel.setAddressInfo(AddressInfo.address)
                Column(
                    modifier = Modifier.padding(Padding.large),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "사용자의 기본 정보를\n입력해주세요.",
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp),
                        textAlign = TextAlign.Left
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    OutlinedTextField(
                        value = viewModel.name.observeAsState(initial = "").value,
                        onValueChange = { name ->
                            viewModel.setName(name)
                        },
                        label = { Text("이름") },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = MaterialTheme.colors.primary,
                            focusedBorderColor = MaterialTheme.colors.background
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    OutlinedTextField(
                        value = viewModel.age.observeAsState(initial = "").value,
                        onValueChange = { age ->
                            viewModel.setAge(age)
                        },
                        label = { Text("나이") },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = MaterialTheme.colors.primary,
                            focusedBorderColor = MaterialTheme.colors.background
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    OutlinedTextField(
                        value = viewModel.addressInfo.observeAsState(AddressInfo.address).value,
                        onValueChange = { viewModel.setAddressInfo(it) },
                        label = { Text("주소") },
                        readOnly = true,
                        modifier = Modifier.clickable(
                            onClick = {
                                inputAddress.value = true
                            },
                            enabled = true
                        ).fillMaxWidth(0.9f),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            disabledBorderColor = MaterialTheme.colors.primary,
                            disabledLabelColor = MaterialTheme.colors.onSurface,
                            disabledTextColor = MaterialTheme.colors.onSurface
                        ),
                        enabled = false
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    OutlinedTextField(
                        value = viewModel.addressDetail.observeAsState(initial = "").value,
                        onValueChange = { address ->
                            viewModel.setAddressDetail(address)
                        },
                        label = { Text("상세 주소") },
                        singleLine = true,
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = MaterialTheme.colors.primary,
                            focusedBorderColor = MaterialTheme.colors.background
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        modifier = Modifier.fillMaxWidth(0.9f)
                    )
                    Spacer(modifier = Modifier.size(24.dp))
                    PrimaryButton(
                        text = "다음",
                        onClick = {
                            navController.navigate(SignUpScreen.EmailInfo.name)
                        },
                        modifier = Modifier
                            .height(56.dp)
                            .fillMaxWidth(0.9f),
                        state = viewModel.checkUserInfoValid()
                    )
                }
            }
            true -> {
                SearchAddressScreen(state = inputAddress)
            }
        }
    }

}