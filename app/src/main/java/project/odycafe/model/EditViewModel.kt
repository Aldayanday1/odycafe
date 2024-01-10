package project.odycafe.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import project.odycafe.data.Menu
import project.odycafe.repositori.RepositoriMenu
import project.odycafe.repositori.RepositoriPesanan

class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoriMenu: RepositoriMenu,
    private val repositoriPesanan: RepositoriPesanan

) : ViewModel(){
    var menuUiState by mutableStateOf(UIStateMenu())
        private set
    var pesananUiState by mutableStateOf(UIStatePesanan())
        private set

    /*--------DROPDOWN--------*/

    // Properti untuk daftar menu
    private val _menuItems = MutableStateFlow<List<Menu>>(emptyList())
    val menuItems: StateFlow<List<Menu>> = _menuItems

    init {
        // Panggil fungsi untuk mendapatkan daftar menu dari repositori
        getAllMenu()
    }

    // Fungsi untuk mendapatkan daftar menu dari repositori
    private fun getAllMenu() {
        viewModelScope.launch {
            repositoriMenu.getAllMenuStream().collect { menuList ->
                // Update daftar menu saat data berubah
                _menuItems.value = menuList
            }
        }
    }
}
