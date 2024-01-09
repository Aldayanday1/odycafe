package project.odycafe.repositori

import kotlinx.coroutines.flow.Flow
import project.odycafe.data.Menu
import project.odycafe.data.Pesanan

interface RepositoriMenu {
    suspend fun insertMenu(menu: Menu)

    suspend fun updateMenu(menu: Menu)

    suspend fun deleteMenu(menu: Menu)

    fun getMenuStream(id: Int): Flow<Menu?>

    fun getAllMenuStream(): Flow<List<Menu>>

    // Search Fiture
    fun searchMenu(query: String): Flow<List<Menu>>
    suspend fun insertSearchMenu(menu: Menu)

    // Save URL Image to Database
    suspend fun updateMenuPhoto(idmenu: Int, imageUrl: String)
}

interface RepositoriPesanan {

    suspend fun insertPesanan(pesanan: Pesanan)

    suspend fun updatePesanan(pesanan: Pesanan)

    suspend fun deletePesanan(pesanan: Pesanan)

    fun getPesananStream(id: Int): Flow<Pesanan?>
    fun getAllPesananStream(): Flow<List<Pesanan>>
}

