package com.example.domain.repository

import com.example.domain.EntityWrapper
import com.example.domain.model.ResumeModel


interface MyPageRepository {
  suspend fun getResume() : EntityWrapper<ResumeModel>
  suspend fun saveResume(resumeModel: ResumeModel) : EntityWrapper<ResumeModel>
  suspend fun deleteResume() : EntityWrapper<ResumeModel>
}