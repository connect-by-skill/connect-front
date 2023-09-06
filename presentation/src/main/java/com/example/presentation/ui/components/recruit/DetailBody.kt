package com.example.presentation.ui.components.recruit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.domain.model.CompanyModel
import com.example.presentation.theme.Padding
import com.example.presentation.theme.colors

@Composable
fun DetailBody(companyModel: CompanyModel) {
  Column {
    DetailBodyItem(
      "지원 기간",
      "${companyModel.applicationDate} ~ ${companyModel.recruitmentPeriod}",
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "회사 명",
      companyModel.companyName,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "직종",
      companyModel.recruitmentType,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "고용 형태",
      companyModel.typeOfEmployment,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "임금 형태",
      companyModel.formOfWages,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "급여",
      companyModel.wage,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.medium))
    DetailBodyItem(
      "이력서",
      companyModel.entryForm,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "요구 경력",
      companyModel.requiredExperience,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "요구 학력",
      companyModel.requiredEducation,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "요구 전공",
      companyModel.majorField ?: "",
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "요구 신용",
      companyModel.requiredCredentials ?: "",
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    Spacer(modifier = Modifier.height(Padding.medium))
    DetailBodyItem(
      "회사 주소",
      companyModel.businessAddress,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "회사 규모",
      companyModel.companyType,
      modifier = Modifier
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
    DetailBodyItem(
      "관할 기관",
      companyModel.responsibleAgency,
      modifier = Modifier
        .clip(
          RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
        )
        .background(MaterialTheme.colors.checked)
        .padding(horizontal = Padding.large)
    )
  }
}