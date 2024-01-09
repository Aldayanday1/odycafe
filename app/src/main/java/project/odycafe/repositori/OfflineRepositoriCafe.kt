package project.odycafe.repositori

import kotlinx.coroutines.flow.Flow
import project.odycafe.data.Menu
import project.odycafe.data.MenuDao
import project.odycafe.data.Pesanan
import project.odycafe.data.PesananDao

class OfflineRepositoriCafe(

    private val menuDao: MenuDao,
    private val pesananDao: PesananDao,

    ):RepositoriPesanan, RepositoriMenu {
    override suspend fun insertMenu(menu: Menu) = menuDao.insert(menu)

    override suspend fun updateMenu(menu: Menu) = menuDao.update(menu)

    override suspend fun deleteMenu(menu: Menu) = menuDao.delete(menu)

    override fun getMenuStream(id: Int): Flow<Menu?> = menuDao.getMenu(id)

    override fun getAllMenuStream(): Flow<List<Menu>> = menuDao.getAllMenu()

    // Search Fiture
    override fun searchMenu(query: String): Flow<List<Menu>> = menuDao.getAllMenu()

    override suspend fun insertSearchMenu(menu: Menu) = menuDao.insert(menu)

    // Image Fiture
    override suspend fun updateMenuPhoto(idmenu: Int, imageUrl: String) {
        menuDao.updateMenuPhoto(idmenu, imageUrl)
    }

    override suspend fun insertPesanan(pesanan: Pesanan) = pesananDao.insert(pesanan)

    override suspend fun updatePesanan(pesanan: Pesanan) = pesananDao.update(pesanan)

    override suspend fun deletePesanan(pesanan: Pesanan) = pesananDao.delete(pesanan)

    override fun getPesananStream(id: Int): Flow<Pesanan?> = pesananDao.getPesanan(id)


    override fun getAllPesananStream(): Flow<List<Pesanan>> = pesananDao.getAllPesanan()
}