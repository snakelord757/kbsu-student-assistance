package com.snakelord.pets.kbsustudentassistance.data.datasource.api.schedule

import com.snakelord.pets.kbsustudentassistance.data.datasource.api.BaseApiMapper
import com.snakelord.pets.kbsustudentassistance.data.datasource.api.schedule.model.DayDto
import com.snakelord.pets.kbsustudentassistance.domain.mapper.Mapper
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject

/**
 * Реализация интерфейса [ScheduleApi]
 *
 * @property okHttpClient клиент для HTTP запросов
 * @property scheduleResponseMapper маппер ответа, который преобразует [String] в [List]<[DayDto]>
 *
 * @author Murad Luguev on 01-09-2021
 */
class ScheduleApiImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val scheduleResponseMapper: Mapper<String, List<DayDto>>,
) : BaseApiMapper<List<DayDto>>(
    okHttpClient,
    scheduleResponseMapper
), ScheduleApi {

    override fun getSchedule(specialityCode: String): List<DayDto> {
        return executeRequest(specialityCode)
    }

    override fun generateRequest(vararg params: String): Request {
        return Request.Builder()
            .url(BASE_URL +
                    """
                        "${params[0]}"
                    """
                        .trimIndent())
            .get()
            .build()
    }

    companion object {
        private const val BASE_URL =
            "https://my-json-server.typicode.com/snakelord757/FakeUniversityDB/schedule/?"
    }
}