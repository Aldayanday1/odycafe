package project.odycafe.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
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

}