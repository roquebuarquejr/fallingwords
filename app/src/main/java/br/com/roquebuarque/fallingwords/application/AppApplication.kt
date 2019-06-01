package br.com.roquebuarque.fallingwords.application

import android.app.Application
import br.com.roquebuarque.fallingwords.application.di.ApplicationComponent
import br.com.roquebuarque.fallingwords.application.di.DaggerApplicationComponent
import timber.log.Timber

class AppApplication:Application() {

    private var component: ApplicationComponent? = null

    override fun onCreate() {
        super.onCreate()
        getComponent().inject(this)

        //TODO RULE FOR BUILD VARIANT
        Timber.plant(Timber.DebugTree())

    }

    fun getComponent(): ApplicationComponent {
        if (component == null) {
            component = DaggerApplicationComponent.factory()
                .create(applicationContext)
        }
        return component as ApplicationComponent
    }
}