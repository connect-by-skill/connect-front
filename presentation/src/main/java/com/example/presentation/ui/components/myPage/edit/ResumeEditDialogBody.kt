package com.example.presentation.ui.components.myPage.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Money
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.presentation.model.EducationType
import com.example.presentation.model.MajorType
import com.example.presentation.model.WorkType
import com.example.presentation.model.CareerMajorType
import com.example.presentation.theme.Padding
import com.example.presentation.ui.common.dropdown.CustomDropdownMenuController
import com.example.presentation.ui.common.dropdown.CustomTitledTextDropdownMenu
import com.example.presentation.ui.common.textField.CustomTextField
import com.example.presentation.ui.common.textField.CustomTextFieldController
import com.example.presentation.theme.Typography
import com.example.presentation.theme.colors

@Composable
fun ResumeEditDialogBody(
  majorDropdownMenuController: CustomDropdownMenuController<MajorType>,
  educationDropdownMenuController: CustomDropdownMenuController<EducationType>,
  preferIncomeTextFieldController: CustomTextFieldController,
  workTypeDropdownMenuController: CustomDropdownMenuController<WorkType>,
  preferJobMajorDropdownMenuController: CustomDropdownMenuController<CareerMajorType>,
  onEditButtonClicked: (String) -> Unit
) {
  val preferJobMiddleDropdownMenuController = CustomDropdownMenuController(
    preferJobMajorDropdownMenuController.currentValue.getMiddleType()[0],
    preferJobMajorDropdownMenuController.currentValue.getMiddleType(),
  )
  Column {
    Spacer(modifier = Modifier.padding(Padding.large))
    Row(
      verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(modifier = Modifier.weight(1f)) {
        CustomTitledTextDropdownMenu(
          controller = educationDropdownMenuController,
          title = "학력",
          modifier = Modifier.fillMaxWidth()
        )
      }
      Spacer(modifier = Modifier.padding(Padding.large))
      Box(modifier = Modifier.weight(2f)) {
        CustomTitledTextDropdownMenu(
          controller = majorDropdownMenuController,
          title = "전공",
          modifier = Modifier.fillMaxWidth()
        )
      }
    }
    Spacer(modifier = Modifier.padding(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = workTypeDropdownMenuController,
      title = "선호 계약 방식",
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.padding(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = preferJobMajorDropdownMenuController,
      title = "선호 직종 - 대분류",
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.padding(Padding.large))
    CustomTitledTextDropdownMenu(
      controller = preferJobMiddleDropdownMenuController,
      title = "선호 직종 - 중분류",
      modifier = Modifier.fillMaxWidth()
    )
    Spacer(modifier = Modifier.padding(Padding.large))
    Text(
      text = "선호 연봉",
      style = Typography.bodySmall.copy(
        color = MaterialTheme.colors.textSubColor,
        fontWeight = FontWeight.Bold
      )
    )
    Row(
      verticalAlignment = Alignment.Bottom,
      horizontalArrangement = Arrangement.SpaceBetween,
      modifier = Modifier.fillMaxWidth()
    ) {
      Box(modifier = Modifier.weight(1f)) {
        CustomTextField(
          customTextFieldController = preferIncomeTextFieldController,
          leadingIcon = Icons.Rounded.Money
        )
      }
      Spacer(modifier = Modifier.padding(Padding.large))
      Button(
        onClick = {
          onEditButtonClicked(
            if (preferJobMiddleDropdownMenuController.currentValue.toString() == "해당 없음") "${preferJobMajorDropdownMenuController.currentValue}/" else "${preferJobMajorDropdownMenuController.currentValue}/${preferJobMiddleDropdownMenuController.currentValue}"
          )
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colors.tertiary),
        modifier = Modifier.padding(0.dp)
      ) {
        Text(text = "저장")
      }
    }
  }
}

@Preview
@Composable
fun ResumeEditDialogBodyPreview() {
  val resumeMajorDropdownMenuController = CustomDropdownMenuController(
    MajorType.ETC,
    MajorType.values().toList(),
  )
  val resumeEducationDropdownMenuController = CustomDropdownMenuController(
    EducationType.MIDDLE,
    EducationType.values().toList(),
  )
  val resumeWorkTypeDropdownMenuController = CustomDropdownMenuController(
    WorkType.ETC,
    WorkType.values().toList(),
  )
  val preferJobDropdownMenuController = CustomDropdownMenuController(
    CareerMajorType.BUSINESS_ADMINISTRATION_CLERICAL,
    CareerMajorType.values().toList(),
  )
  val resumePreferIncomeTextFieldController = CustomTextFieldController()

  Scaffold {
    it
    ResumeEditDialogBody(
      majorDropdownMenuController = resumeMajorDropdownMenuController,
      educationDropdownMenuController = resumeEducationDropdownMenuController,
      workTypeDropdownMenuController = resumeWorkTypeDropdownMenuController,
      preferIncomeTextFieldController = resumePreferIncomeTextFieldController,
      preferJobMajorDropdownMenuController = preferJobDropdownMenuController,
      onEditButtonClicked = {}
    )
  }
}