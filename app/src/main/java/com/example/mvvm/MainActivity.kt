package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvm.databinding.ActivityMainBinding

/** Класс View - связывает xml с
 * (Activity_main.xml это тоже класс view)
 * */
class MainActivity : AppCompatActivity() {
    /**
     * @binding - своеобразное представление интерфейса
     * latenit - отложенная инициализация - элемен будет создан только при вызове
     * */
    lateinit var binding: ActivityMainBinding

    /** Ссылка на ViewModel*/
    var mainViewModel = MainViewModel()

    /** Эта функция выполняется при открытии приложения*/
    override fun onCreate(savedInstanceState: Bundle?) {
        /** Подключение последнего сохранённого состояния приложения*/
        super.onCreate(savedInstanceState)

        // binding помогает организовать работу с элементами интерфейса меншим колическвом кода
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //связывает элемент viewModel разметки с экземпляром класса MainViewModel
        binding.viewModel = mainViewModel
        // используем executePendingBindings, чтобы биндинг(обработка событий) не откладывался,
        // а выполнился как можно быстрее
        binding.executePendingBindings()

    }

}
