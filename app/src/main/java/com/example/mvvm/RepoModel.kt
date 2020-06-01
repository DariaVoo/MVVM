package com.example.mvvm

import android.os.Handler

/**
 * Класс Model
 * */
class RepoModel {
    /**
     * Метод refreshData реализует (имплементирует) OnDataReadyCallback.
     *
     * @Handler используется для имитации ожидания.
     * Раз в 2 секунды метод onDataReady будет вызываться у классов,
     * реализующих интерфейс OnDataReadyCallback.
     * */
    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({ onDataReadyCallback.onDataReady("new data") },2000)
    }
}

