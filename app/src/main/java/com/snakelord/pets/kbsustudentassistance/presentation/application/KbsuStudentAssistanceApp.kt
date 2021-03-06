package com.snakelord.pets.kbsustudentassistance.presentation.application

import android.app.Application
import com.snakelord.pets.kbsustudentassistance.BuildConfig
import com.snakelord.pets.kbsustudentassistance.di.common.component.ApplicationComponent
import com.snakelord.pets.kbsustudentassistance.di.common.component.DaggerApplicationComponent
import com.yandex.mapkit.MapKitFactory

/**
 * [Application]-класс для инициализации компонентов, чей жизненный цикл
 * не зависит от жизненного цикла компонентов Android и установки выбранной темы приложения
 *
 * @author Murad Luguev on 27-08-2021
 */
class KbsuStudentAssistanceApp : Application() {

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()

        applicationComponent
            .themeChanger()
            .setTheme()

        MapKitFactory.setApiKey(BuildConfig.YANDEX_MAP_API_KEY)
    }

    companion object {
        lateinit var applicationComponent: ApplicationComponent
            private set
    }
}