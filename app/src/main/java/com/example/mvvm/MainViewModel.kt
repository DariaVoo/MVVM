package com.example.mvvm

import androidx.databinding.ObservableField

/**
 * Класс ViewModel
 *
 * @repoModel экземпляр RepoModel
 * @text текст, который будет показан
 * @isLoading хранит текущее состояние
 *
 * */
class MainViewModel {
    var repoModel: RepoModel = RepoModel()

    // ObservableField это класс из библиотеки Data Binding,
    // который мы можем использовать вместо создания объекта Наблюдателя (Observable).
    // Он оборачивает объект, который мы хотим наблюдать.
    val text = ObservableField<String>()
    val isLoading = ObservableField<Boolean>()

    /**
     * object позволяет создать анонимный обект интерфейса без создания подкласса
     * */
    private val onDataReadyCallback = object : OnDataReadyCallback {
        override fun onDataReady(data: String) {
            isLoading.set(false) //загрузка завершена
            text.set(data) //получение данных
        }
    }

    /**
     * Метод refresh вызывает refreshData у RepoModel,
     * который в аргументах берёт реализацию OnDataReadyCallback
     * */
    fun refresh(){
        isLoading.set(true) //состояние загрузки
        repoModel.refreshData(onDataReadyCallback)
    }
}