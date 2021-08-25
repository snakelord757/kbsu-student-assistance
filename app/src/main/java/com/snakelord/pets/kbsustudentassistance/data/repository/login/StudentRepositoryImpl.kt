package com.snakelord.pets.kbsustudentassistance.data.repository.login

import com.snakelord.pets.kbsustudentassistance.data.datasource.api.StudentLoginApi
import com.snakelord.pets.kbsustudentassistance.data.datasource.api.model.StudentDto
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.dao.StudentDao
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.entity.StudentEntity
import com.snakelord.pets.kbsustudentassistance.domain.repository.login.StudentRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class StudentRepositoryImpl @Inject constructor(
    private val studentLoginApi: StudentLoginApi,
    private val studentDao: StudentDao
) : StudentRepository {

    override fun loginStudent(secondName: String, recordBookNumber: String): Single<StudentDto> {
        return Single.fromCallable {
            studentLoginApi.loginStudent(secondName, recordBookNumber)
        }
    }

    override fun saveStudent(studentEntity: StudentEntity): Completable {
        return studentDao.saveStudent(studentEntity)
    }

    override fun isStudentLogined(): Maybe<StudentEntity> {
        return studentDao.isUserLogined()
    }

}