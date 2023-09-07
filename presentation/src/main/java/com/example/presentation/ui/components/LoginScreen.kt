package com.example.presentation.ui.components

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import android.os.Handler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.domain.model.state.LoginState
import com.example.presentation.R
import com.example.presentation.model.Screen
import com.example.presentation.theme.WhaleTheme
import com.example.presentation.theme.colors
import com.example.presentation.ui.common.buttons.PrimaryButton
import com.example.presentation.ui.common.buttons.UnderlinedButton
import com.example.presentation.viewmodel.LoginViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.presentation.util.SpeechTool
import com.example.presentation.util.SpeechTool.isSupported
import com.example.presentation.util.SpeechTool.offTool
import com.example.presentation.util.SpeechTool.speakOut
import com.example.presentation.util.SpeechTool.speechStart
import com.example.presentation.util.showToast

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
  contextActivity: Context,
  navController: NavHostController,
  loginViewModel: LoginViewModel = hiltViewModel()
) {
  var speechState by remember { mutableStateOf(false) }
  val context = LocalContext.current
  var buttonText by remember { mutableStateOf("이메일로 로그인") }
  val coroutineScope = rememberCoroutineScope()
  var loginState by remember { mutableStateOf(LoginState.LOADING) }
  var doubleClick: Boolean? = false
  var isLock by remember { mutableStateOf(!isSupported) }

  val imageLoader = ImageLoader.Builder(LocalContext.current)
    .components {
      if (SDK_INT >= 28) {
        add(ImageDecoderDecoder.Factory())
      } else {
        add(GifDecoder.Factory())
      }
    }
    .build()


  LaunchedEffect(speechState) {
    coroutineScope.launch {
      if (isSupported) {
        speakOut("안녕하세요? 장애인 맞춤형 취업 추천 애플리케이션 웨일입니다. 지금과 같이 음성 지원 기능을 원하지 않으신다면 화면을 빠르게 두 번 터치해주세요.")
        delay(18000)
        if (isSupported) {
          speakOut("로그인 혹은 회원가입을 선택해주세요.")
          delay(2000)
          speechStart(context)
        } else {
          isLock = true
          offTool(context)
        }
      }
    }
  }


  Surface {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier.fillMaxSize()
    ) {
      Image(
        modifier = Modifier
          .fillMaxWidth(0.35f)
          .clickable(enabled = !isLock) {
            if (doubleClick!!) {
              SpeechTool.isSupported = !SpeechTool.isSupported
            }
            doubleClick = true
            Handler().postDelayed({ doubleClick = false }, 2000)
          },
        painter = painterResource(id = R.drawable.whale_logo),
        contentDescription = "Whale logo"
      )
      OutlinedTextField(
        value = loginViewModel.id.observeAsState(initial = "").value,
        onValueChange = { id ->
          loginViewModel.setId(id)
        },
        label = { Text("Email") },
        singleLine = true,
        enabled = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
          unfocusedBorderColor = MaterialTheme.colors.primary,
          focusedBorderColor = MaterialTheme.colors.background
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        modifier = Modifier
          .padding(horizontal = 20.dp)
          .fillMaxWidth()
      )
      Spacer(modifier = Modifier.size(12.dp))
      OutlinedTextField(
        colors = TextFieldDefaults.outlinedTextFieldColors(
          unfocusedBorderColor = MaterialTheme.colors.primary,
          focusedBorderColor = MaterialTheme.colors.background
        ),
        label = { Text("PW") },
        enabled = true,
        value = loginViewModel.pw.observeAsState(initial = "").value,
        onValueChange = { pw ->
          loginViewModel.setPw(pw)
        },
        visualTransformation = PasswordVisualTransformation(),
        singleLine = true,
        modifier = Modifier
          .padding(horizontal = 20.dp)
          .fillMaxWidth()
      )
      Spacer(modifier = Modifier.size(20.dp))
      PrimaryButton(
        onClick = {
          buttonText = "로그인 진행중..."
          coroutineScope.launch {
            loginState = loginViewModel.login()
            when (loginState) {
              LoginState.LOADING -> {

              }

              LoginState.ID_PW_EMPTY -> {
                showToast(context, "아이디와 비밀번호를 먼저 입력해주세요.")
                buttonText = "이메일로 로그인"
                loginState = LoginState.LOADING
              }

              LoginState.NOT_EMAIL -> {
                showToast(context, "아이디 양식이 잘못 되었습니다.")
                buttonText = "이메일로 로그인"
                loginState = LoginState.LOADING
              }

              LoginState.SUCCESS -> {
                loginViewModel.saveToken(contextActivity)
                buttonText = "이메일로 로그인"
                navController.navigate(Screen.Main.name) {
                  popUpTo(Screen.Login.name) { inclusive = true }
                }

              }

              LoginState.WRONG_PW_ID -> {
                showToast(context, "잘못된 로그인 정보입니다.")
                buttonText = "이메일로 로그인"
                loginState = LoginState.LOADING
              }

              LoginState.UNKNOWN_ERROR -> {
                showToast(context, "Unknown error")
                buttonText = "이메일로 로그인"
                loginState = LoginState.LOADING
              }
            }
          }
        },
        modifier = Modifier
          .padding(horizontal = 20.dp)
          .fillMaxWidth(),
        text = buttonText
      )
      UnderlinedButton(
        text = stringResource(id = R.string.sign_up),
        modifier = Modifier.fillMaxWidth(0.7f),
        onClick = {
          navController.navigate(Screen.SignUp.name) {
            popUpTo(Screen.Login.name) { inclusive = true }
          }
        }
      )
      Image(
        painter = rememberAsyncImagePainter(model = R.drawable.whale_login, imageLoader),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxWidth()
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun OutlinedTextField() {
  WhaleTheme {
    Surface {
      OutlinedTextField(
        value = "",
        onValueChange = { },
        label = { Text("Email") },
        singleLine = true,
        enabled = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(
          unfocusedBorderColor = MaterialTheme.colors.primary,
          focusedBorderColor = MaterialTheme.colors.background
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
      )
    }
  }
}
