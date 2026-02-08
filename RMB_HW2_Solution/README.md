# Домашнее задание №2: Простой счётчик

**Студент:** Смольников Герман  
**Группа:** РПО  
**Дисциплина:** Мобильная разработка  

---

## Описание проекта
Приложение представляет собой простой счетчик (Counter App) для платформы Android. Основная цель — отработка навыков работы с компонентами Activity, TextView и Button, а также управления состоянием (State Management).

## Функционал
1. Увеличение значения счетчика при нажатии на кнопку "+".
2. Уменьшение значения (опционально) при нажатии на "-".
3. Сброс счетчика до нуля.
4. Сохранение состояния при повороте экрана (использование onSaveInstanceState).

## Техническая реализация (Kotlin)
```kotlin
class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var countText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countText = findViewById(R.id.textViewCount)
        val btnPlus = findViewById<Button>(R.id.buttonPlus)
        
        btnPlus.setOnClickListener {
            count++
            countText.text = count.toString()
        }
    }
    
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("COUNT_KEY", count)
    }
}
```

## Заключение
В данной работе была реализована базовая логика мобильного приложения. Отработаны механизмы взаимодействия с UI-элементами через XML-разметку и программный код на Kotlin.

---
**Ссылка на репозиторий:** https://github.com/germanitoto/Mobile-application-development-Android-
