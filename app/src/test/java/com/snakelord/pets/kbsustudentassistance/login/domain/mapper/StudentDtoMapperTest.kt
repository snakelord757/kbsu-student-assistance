package com.snakelord.pets.kbsustudentassistance.login.domain.mapper

import com.google.common.truth.Truth
import com.snakelord.pets.kbsustudentassistance.data.datasource.api.student.model.StudentDto
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.entity.student.StudentEntity
import com.snakelord.pets.kbsustudentassistance.domain.mapper.student.StudentDtoMapper
import org.junit.Test

class StudentDtoMapperTest {

    private val studentDtoMapper = StudentDtoMapper()

    @Test
    fun mapTest() {
        //Arrange
        val expectedResult = EXPECTED_STUDENT_ENTITY

        //Act
        val actualResult = studentDtoMapper.map(EXPECTED_STUDENT_DTO)

        //Assert
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    companion object {
        private val EXPECTED_STUDENT_ENTITY = StudentEntity(
            fullName = "Иванов Иван Иванович",
            id = 3,
            specialityCode = "09.03.01-3"
        )

        private val EXPECTED_STUDENT_DTO = StudentDto(
            fullName = "Иванов Иван Иванович",
            id = 3,
            specialityCode = "09.03.01-3"
        )
    }
}