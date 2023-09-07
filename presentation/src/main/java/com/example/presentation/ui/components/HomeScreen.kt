package com.example.presentation.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.domain.model.CompanyModel
import com.example.domain.model.UserInfo
import com.example.domain.model.state.RankState
import com.example.domain.model.state.UserState
import com.example.domain.model.state.WishState
import com.example.presentation.model.MainMenu
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors
import com.example.presentation.theme.nameMedium
import com.example.presentation.ui.common.RecruitCardItem
import com.example.presentation.ui.common.WishItem
import com.example.presentation.ui.components.recruit.DetailScreen
import com.example.presentation.util.showToast
import com.example.presentation.viewmodel.HomeViewModel
import com.example.presentation.viewmodel.WishListViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay
import timber.log.Timber

val images = listOf(
  "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9995B5425EA8EA761D",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6ksF7TTo_05EZphWWYu8ZRCwpAxp1IEjeqA&usqp=CAU",
  "https://cdn.goodnews1.com/news/photo/202104/111942_36930_342.jpg",
  "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQakuxPhhhT8b0wilYwrS8W8GAqCv97t225ZA&usqp=CAU"
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
  val viewModel = hiltViewModel<HomeViewModel>()
  val wishViewModel = hiltViewModel<WishListViewModel>()

  val homeNavController = rememberNavController()

  var name by remember { mutableStateOf("") }
  val userState by viewModel.userState.collectAsStateWithLifecycle()
  val rankState by viewModel.rankState.collectAsStateWithLifecycle()
  val wishState by viewModel.wishState.collectAsStateWithLifecycle()

  val wishList = if (wishState is WishState.Main) {
    (wishState as WishState.Main).wishList
  } else emptyList()

  val context = LocalContext.current
  when (userState) {
    is UserState.Loading -> {

    }

    is UserState.Main -> {
      name = UserInfo.userData?.username ?: ""
    }

    is UserState.Fail -> {
      showToast(context, "유저 정보를 불러올 수 없습니다. 새로 고침 해주세요.")
      viewModel.resetUserState()
    }
  }
  val scrollState = rememberScrollState()

  NavHost(navController = homeNavController, startDestination = "home") {
    composable("home") {
      Column(
        modifier = Modifier
          .background(MaterialTheme.colors.surface)
          .fillMaxSize()
      ) {
        Column(
          modifier = Modifier
            .padding(horizontal = Padding.extra)
            .verticalScroll(scrollState)
        ) {
          Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier.padding(bottom = Padding.extra, top = Padding.xextra)
          ) {
            Text(
              text = name,
              style = MaterialTheme.typography.nameMedium
            )
            Text(
              text = "님 안녕하세요?",
              style = MaterialTheme.typography.bodyMedium
            )
          }
          AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->
              AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                  .data(images[index])
                  .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                  .height(200.dp)
                  .clickable {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(images[index]))
                    context.startActivity(intent)
                  }
              )
            }
          )
          Spacer(modifier = Modifier.size(12.dp))
          Text(
            text = "인기 채용 정보",
            style = MaterialTheme.typography.nameMedium
          )
          Spacer(modifier = Modifier.size(12.dp))
          when (rankState) {
            is RankState.Loading -> {
              Timber.d("MoviesScreen: Loading")
              Box(
                modifier = Modifier
                  .height(180.dp)
                  .fillMaxWidth()
              ) {
                CircularProgressIndicator(
                  modifier = Modifier.align(Alignment.Center)
                )
              }
            }

            is RankState.Main -> {
              Timber.d("MoviesScreen: Success")
              LazyRow(
                horizontalArrangement = Arrangement.spacedBy(Padding.large),
                contentPadding = PaddingValues(
                  start = Padding.small,
                  end = Padding.small
                )
              ) {
                itemsIndexed((viewModel.rankState.value as RankState.Main).rankList) { index, item ->
                  RecruitCardItem(
                    rank = index + 1,
                    company = item.companyName,
                    occupation = item.recruitmentType,
                    onClick = {
                      homeNavController.currentBackStackEntry?.savedStateHandle?.set(
                        key = "companyModel",
                        value = item
                      )
                      homeNavController.navigate("detail")
                    })
                }
              }

            }

            is RankState.Failed -> {
              Timber.d("MoviesScreen: Error")
            }
          }

          Spacer(modifier = Modifier.size(12.dp))
          Text(
            text = "관심을 표한 회사에요",
            style = MaterialTheme.typography.nameMedium
          )
          Spacer(modifier = Modifier.size(12.dp))
          Card(
            elevation = CardDefaults.cardElevation(5.dp),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.surface),
            modifier = Modifier
              .fillMaxWidth()
              .border(
                0.5.dp,
                MaterialTheme.colors.textFiledBackgroundVariant,
                MaterialTheme.shapes.medium
              )
          ) {
            Column(
              horizontalAlignment = Alignment.CenterHorizontally,
              modifier = Modifier
                .padding(Padding.large)
                .clickable {
                  navController.navigate(MainMenu.WishList.name) {
                    popUpTo(MainMenu.Home.name) { inclusive = true }
                  }
                }
            ) {
              WishItem(
                MaterialTheme.colors.background,
                if (wishList.isNotEmpty()) wishList[0].companyName else null,
                if (wishList.isNotEmpty()) wishList[0].recruitmentType else null,
                if (wishList.isNotEmpty()) wishList[0].dDay else null,
                if (wishList.isNotEmpty()) wishList[0] else null,
                if (wishList.isNotEmpty()) wishViewModel else null,
                isHome = true
              )
              Spacer(modifier = Modifier.size(Padding.large))
              WishItem(
                MaterialTheme.colors.secondary,
                if (wishList.size > 1) wishList[1].companyName else null,
                if (wishList.size > 1) wishList[1].recruitmentType else null,
                if (wishList.size > 1) wishList[1].dDay else null,
                if (wishList.size > 1) wishList[1] else null,
                if (wishList.size > 1) wishViewModel else null,
                isHome = true
              )


              Spacer(modifier = Modifier.size(Padding.large))
              WishItem(
                MaterialTheme.colors.background,
                if (wishList.size > 2) wishList[2].companyName else null,
                if (wishList.size > 2) wishList[2].recruitmentType else null,
                if (wishList.size > 2) wishList[2].dDay else null,
                if (wishList.size > 2) wishList[2] else null,
                if (wishList.size > 2) wishViewModel else null,
                isHome = true
              )
            }


          }
        }
      }
    }
    composable("detail") {
      val companyModel =
        homeNavController.previousBackStackEntry?.savedStateHandle?.get<CompanyModel>("companyModel")
          ?: CompanyModel(
            id = 0,
            applicationDate = "",
            recruitmentPeriod = "",
            companyName = "",
            recruitmentType = "",
            typeOfEmployment = "",
            formOfWages = "",
            wage = "",
            entryForm = "",
            requiredExperience = "",
            requiredEducation = "",
            majorField = "",
            requiredCredentials = "",
            businessAddress = "",
            companyType = "",
            responsibleAgency = "",
            contactNumber = "",
            countOfMemberWish = 0,
            registrationDate = "",
            addedWishlist = false
          )
      DetailScreen(companyModel, homeNavController)
    }
  }
}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoSlidingCarousel(
  modifier: Modifier = Modifier,
  autoSlideDuration: Long = 2000,
  pagerState: PagerState = remember { PagerState() },
  itemsCount: Int,
  itemContent: @Composable (index: Int) -> Unit,
) {
  val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

  LaunchedEffect(pagerState.currentPage) {
    delay(autoSlideDuration)
    pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
  }

  Box(
    modifier = modifier.fillMaxWidth(),
  ) {
    HorizontalPager(count = itemsCount, state = pagerState, modifier = Modifier.clickable {

    }) { page ->
      itemContent(page)
    }

    // you can remove the surface in case you don't want
    // the transparant bacground
    Surface(
      modifier = Modifier
        .padding(bottom = 8.dp)
        .align(Alignment.BottomCenter),
      shape = CircleShape,
      color = Color.Black.copy(alpha = 0.5f)
    ) {
      DotsIndicator(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp),
        totalDots = itemsCount,
        selectedIndex = if (isDragged) pagerState.currentPage else pagerState.targetPage,
        dotSize = 8.dp
      )
    }
  }
}

@Composable
fun DotsIndicator(
  modifier: Modifier = Modifier,
  totalDots: Int,
  selectedIndex: Int,
  selectedColor: Color = MaterialTheme.colors.primary,
  unSelectedColor: Color = MaterialTheme.colors.surface,
  dotSize: Dp
) {
  LazyRow(
    modifier = modifier
      .wrapContentWidth()
      .wrapContentHeight()
  ) {
    items(totalDots) { index ->
      IndicatorDot(
        color = if (index == selectedIndex) selectedColor else unSelectedColor,
        size = dotSize
      )

      if (index != totalDots - 1) {
        Spacer(modifier = Modifier.padding(horizontal = 2.dp))
      }
    }
  }
}

@Composable
fun IndicatorDot(
  modifier: Modifier = Modifier,
  size: Dp,
  color: Color
) {
  Box(
    modifier = modifier
      .size(size)
      .clip(CircleShape)
      .background(color)
  )
}



