package com.raju.kitabeli.di

import android.content.Context
import com.raju.kitabeli.BuildConfig
import com.raju.kitabeli.application.KitaBeliApp
import com.raju.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext applicationContext: Context): KitaBeliApp {
        return applicationContext as KitaBeliApp
    }

    @Provides
    @Singleton
    @Named("base_url")
    fun providesBaseUrl(): String {
        return AppConstants.BaseUrl.BASE_URL
    }

    @Provides
    @Singleton
    @Named("is_debug")
    fun providesIsDebug(): Boolean {
        return BuildConfig.DEBUG
    }

    @Provides
    @Singleton
    @Named("version_name")
    fun providesVersionName(): String {
        return BuildConfig.VERSION_NAME
    }

    @Provides
    @Singleton
    @Named("version_code")
    fun providesVersionCode(): Int {
        return BuildConfig.VERSION_CODE
    }
}