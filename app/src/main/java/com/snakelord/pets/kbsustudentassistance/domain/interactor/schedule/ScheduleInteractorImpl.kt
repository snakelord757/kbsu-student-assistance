package com.snakelord.pets.kbsustudentassistance.domain.interactor.schedule

import androidx.annotation.WorkerThread
import com.snakelord.pets.kbsustudentassistance.data.datasource.api.schedule.model.DayDto
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.entity.schedule.DayEntity
import com.snakelord.pets.kbsustudentassistance.domain.mapper.Mapper
import com.snakelord.pets.kbsustudentassistance.domain.model.schedule.Day
import com.snakelord.pets.kbsustudentassistance.domain.model.schedule.Lecture
import com.snakelord.pets.kbsustudentassistance.domain.repository.schedule.ScheduleRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * Реализация интерфейса [ScheduleInteractor]
 *
 * @property scheduleRepository репозиторий для получения расписания
 * @property daysDtoMapper маппер для преобразования [List]<[DayDto]> в [List]<[DayEntity]>
 * @property daysEntityMapper маппер для преобразования [List]<[DayEntity]> в [List]<[Day]>
 *
 * @author Murad Luguev on 01-09-2021
 */
class ScheduleInteractorImpl @Inject constructor(
    private val scheduleRepository: ScheduleRepository,
    private val daysDtoMapper: Mapper<List<DayDto>, List<DayEntity>>,
    private val daysEntityMapper: Mapper<List<DayEntity>, List<Day>>
) : ScheduleInteractor {

    private var schedule: List<Day> = emptyList()

    @WorkerThread
    override fun getScheduleFromApi(): Single<List<DayDto>> {
        return scheduleRepository.getScheduleFromApi()
    }

    @WorkerThread
    override fun getScheduleFromDatabase(): Single<List<Day>> {
        return scheduleRepository.getScheduleFromDatabase()
            .map { dayEntities -> daysEntityMapper.map(dayEntities) }
    }

    @WorkerThread
    override fun saveSchedule(schedule: List<DayDto>): Completable {
        return scheduleRepository.saveSchedule(
            daysDtoMapper.map(schedule)
        )
    }

    override fun setSchedule(schedule: List<Day>) {
        this.schedule = schedule
    }

    override fun getScheduleByIndex(index: Int): List<Lecture> {
        return schedule[index].lectures
    }
}
