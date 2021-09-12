package com.snakelord.pets.kbsustudentassistance.di.common.component

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.Database
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.dao.schedule.ScheduleDao
import com.snakelord.pets.kbsustudentassistance.data.datasource.database.dao.student.StudentDao
import com.snakelord.pets.kbsustudentassistance.di.common.module.ApplicationModule
import com.snakelord.pets.kbsustudentassistance.di.common.module.BaseErrorMapperModule
import com.snakelord.pets.kbsustudentassistance.di.common.module.SchedulersProviderModule
import com.snakelord.pets.kbsustudentassistance.di.common.module.ViewModelFactoryModule
import com.snakelord.pets.kbsustudentassistance.domain.mapper.Mapper
import com.snakelord.pets.kbsustudentassistance.domain.model.OperationError
import com.snakelord.pets.kbsustudentassistance.presentation.common.schedulers.SchedulersProvider
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import javax.inject.Singleton

/**
 * Dagger-компонент для предоставления зависимостей для всех экранов приложения
 *
 * @author Murad Luguev on 27-08-2021
 */
@Component(
    modules = [
        ApplicationModule::class,
        ViewModelFactoryModule::class,
        SchedulersProviderModule::class,
        BaseErrorMapperModule::class
    ]
)
@Singleton
interface ApplicationComponent {

    /**
     * Функция, предоставляющая провайдер планировщиков
     *
     * @return реализацию [SchedulersProvider]
     */
    fun schedulersProvider(): SchedulersProvider

    /**
     * Функция, предоставляющая фабрику для всех ViewModel в приложении
     *
     * @return реализацию [ViewModelProvider.Factory]
     */
    fun viewModelFactory(): ViewModelProvider.Factory

    /**
     * Функция, предоставляющая клиент для работы с API
     *
     * @return экземпляр [OkHttpClient]
     */
    fun okHttpClient(): OkHttpClient

    /**
     * Функция, предоставляющая базу данных
     *
     * @return экземпляр [Database]
     */
    fun database(): Database

    /**
     * Функиця, предоставляющая DAO для работы с данными студента
     *
     * @return реализацию [StudentDao]
     */
    fun studentDao(): StudentDao

    /**
     * Функция, для предоставления [Application] в граф зависимостей
     *
     * @return экземпляр [Application]
     */
    fun application(): Application

    /**
     * Функиця, предоставляющая DAO для работы с расписанием
     *
     * @return реализацию [StudentDao]
     */
    fun scheduleDao(): ScheduleDao

    /**
     * Функция, предоставляющая маппер для преобразования исключения в [OperationError]
     *
     * @return маппер исключений типа [Mapper]<[Throwable], [OperationError]>
     */
    fun baseErrorMapper(): Mapper<Throwable, OperationError>

    /**
     * Builder для создания экземпляра [ApplicationComponent] с дополнительными параметрами
     * в графе зависимостей
     *
     * @author Murad Luguev on 27-08-2021
     */
    @Component.Builder
    interface Builder {
        /**
         * Функция, для предоставления [Context] в граф зависимостей
         *
         * @param context экземпляр [Context]
         * @return билдер для сборки компонента
         */
        @BindsInstance
        fun context(context: Context): Builder

        /**
         * Функция, для предоставления [Application] в граф зависимостей
         *
         * @param application экземпляр [Application]
         * @return билдер для сборки компонента
         */
        @BindsInstance
        fun application(application: Application): Builder

        /**
         * Функция для сборки экземпляра [ApplicationComponent]
         *
         * @return экземпляр [ApplicationComponent]
         */
        fun build(): ApplicationComponent
    }
}