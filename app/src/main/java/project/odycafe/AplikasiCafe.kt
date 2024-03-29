package project.odycafe

import android.app.Application
import project.odycafe.repositori.ContainerApp
import project.odycafe.repositori.ContainerDataApp

class AplikasiCafe : Application() {
    /*
    * ContainerApp instance digunakan oleh kelas-kelas lainnya untuk medapatkan dependensi
    */
    lateinit var container: ContainerApp

    override fun onCreate() {
        super.onCreate()
        container = ContainerDataApp(this)
    }
}