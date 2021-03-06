package com.snakelord.pets.kbsustudentassistance.domain.interactor.schedule

import com.snakelord.pets.kbsustudentassistance.data.datasource.api.schedule.model.DayDto
import com.snakelord.pets.kbsustudentassistance.domain.model.schedule.Day
import com.snakelord.pets.kbsustudentassistance.domain.model.schedule.Lecture
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

/**
 * Интерактор для взаимодействия с расписанием студента
 *
 * @author Murad Luguev on 01-09-2021
 */
interface ScheduleInteractor {
    /**
     * Функция для получения расписания с API
     *
     * @return расписание типа [Single]<[List]<[DayDto]>>
     */
    fun getScheduleFromApi(): Single<List<DayDto>>

    /**
     * Функция для получения расписания из базы данных
     *
     * @return расписание типа [Single]<[List]<[Day]>>
     */
    fun getScheduleFromDatabase(): Single<List<Day>>

    /**
     * Функция для сохранения расписания в базу данных
     *
     * @param schedule расписание типа [List]<[DayDto]>
     *
     * @return результат операции типа [Completable]
     */
    fun saveSchedule(schedule: List<DayDto>): Completable

    /**
     * Функция для установки расписания на уровне интерактора
     *
     * @param schedule расписание типа [List]<[Day]>
     */
    fun setSchedule(schedule: List<Day>)

    /**
     * Функция для получения расписания по выбранному дню
     *
     * @param index индекс текущего дня
     *
     * @return список лекций типа [List]<[Lecture]>
     */
    fun getScheduleByIndex(index: Int): List<Lecture>
}