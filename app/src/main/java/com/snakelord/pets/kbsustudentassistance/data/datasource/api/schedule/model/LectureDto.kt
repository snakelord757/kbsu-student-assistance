package com.snakelord.pets.kbsustudentassistance.data.datasource.api.schedule.model

/**
 * Модель лекции
 *
 * @property lectureName название лекции
 * @property teacher ФИО преподавателя, который проводит лекцию
 * @property startTime время начала лекции
 * @property endTime время окончания лекции
 * @property classroom аудитория, в которой будет проходить лекция
 *
 * @author Murad Luguev on 01-09-2021
 */
data class LectureDto(
    val lectureName: String,

    val teacher: String,

    val startTime: String,

    val endTime: String,

    val classroom: String
)
