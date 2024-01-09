package project.odycafe.repositori

import android.content.Context
import project.odycafe.data.DatabaseCafe
import project.odycafe.data.MenuDao
import project.odycafe.data.PesananDao

interface ContainerApp {
    val repositoriMenu : RepositoriMenu
    val repositoriPesanan : RepositoriPesanan
}

class ContainerDataApp(private val context: Context): ContainerApp {

    private val menuDao: MenuDao = DatabaseCafe.getDatabase(context).menuDao()
    private val pesananDao: PesananDao = DatabaseCafe.getDatabase(context).pesananDao()

    override val repositoriMenu: RepositoriMenu by lazy {
        OfflineRepositoriCafe(menuDao, pesananDao)
    }
    override val repositoriPesanan: RepositoriPesanan by lazy {
        OfflineRepositoriCafe(menuDao, pesananDao)
    }
}