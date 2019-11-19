package io.github.zoha131.daggerkotlindelegate

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

@Component
interface ActivityComponent {

    @Component.Factory
    interface Factory{
        fun create(
            @BindsInstance pref: SharedPreferences
        ): ActivityComponent
    }

    fun getClient(): PrefClient
}

//todo here kotlin class delegation giving me error
class PrefClient @Inject constructor(pref: SharedPreferences): SharedPreferences by pref{

}
