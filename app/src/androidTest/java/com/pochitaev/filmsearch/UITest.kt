package com.pochitaev.filmsearch


import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import org.junit.Test



class UITest {
    @Test
    fun openPhone() {
        val device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        //Нажимаем кнопку домашнего экрана, на случай если во время теста мы будем находится в другом месте
        device.pressHome()

        //Находим наше приложение по description
        val launcher: UiObject = device.findObject(UiSelector().description("Поиск фильмов"))
        //Кликаем по иконке и ждём, пока запустится
        launcher.clickAndWaitForNewWindow()
        Thread.sleep(1000)
        val menuHome: UiObject = device.findObject(UiSelector().description("Главная"))
        val menuFav: UiObject = device.findObject(UiSelector().description("Избраное"))
        val menuWL: UiObject = device.findObject(UiSelector().description("Посмотреть позже"))
        val menuSelections: UiObject = device.findObject(UiSelector().description("Подборки"))
        menuHome.click()
        Thread.sleep(1000)
        menuFav.click()
        Thread.sleep(1000)
        menuWL.click()
        Thread.sleep(1000)
        menuSelections.click()

    }


}

