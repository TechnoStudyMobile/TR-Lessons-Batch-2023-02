package com.atilsamancioglu.artbookhilttesting

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

// Bu sınıf, coroutines'in test sırasında ana (main) iş parçacığında çalışmasını sağlar
@ExperimentalCoroutinesApi
class MainCoroutineRule (
    // Test için kullanılacak CoroutineDispatcher'ı varsayılan olarak TestCoroutineDispatcher olarak ayarlar
    private val dispatcher: CoroutineDispatcher = TestCoroutineDispatcher()
) : TestWatcher(), // JUnit TestWatcher sınıfından türetilmiştir, testlerin yaşam döngüsünü izler
    TestCoroutineScope by TestCoroutineScope(dispatcher) { // Bu sınıf aynı zamanda bir TestCoroutineScope'dir

    // Her test başlamadan önce çağrılır
    override fun starting(description: Description?) {
        super.starting(description)
        // Ana (main) dispatcher'ı test dispatcher'ı ile değiştirir
        // Bu, test sırasında ana (main) iş parçacığında çalışacak coroutines'in yürütülmesini sağlar
        Dispatchers.setMain(dispatcher)
    }

    // Her test tamamlandıktan sonra çağrılır
    override fun finished(description: Description?) {
        super.finished(description)
        // Test sırasında oluşturulan tüm coroutines'leri temizler
        cleanupTestCoroutines()
        // Ana (main) dispatcher'ı varsayılan haline geri döndürür
        // Bu, diğer testlerin etkilenmemesini sağlar
        Dispatchers.resetMain()
    }
}
