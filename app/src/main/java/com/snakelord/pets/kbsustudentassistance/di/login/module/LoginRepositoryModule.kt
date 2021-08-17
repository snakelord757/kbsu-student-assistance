package com.snakelord.pets.kbsustudentassistance.di.login.module

import com.snakelord.pets.kbsustudentassistance.data.repository.StudentRepositoryImpl
import com.snakelord.pets.kbsustudentassistance.domain.repository.StudentRepository
import dagger.Binds
import dagger.Module

@Module
interface LoginRepositoryModule {
    @Binds
    fun bindsStudentRepository(studentRepositoryImpl: StudentRepositoryImpl): StudentRepository
}