package project.odycafe.model

import androidx.lifecycle.SavedStateHandle
import project.odycafe.repositori.RepositoriMenu
import project.odycafe.repositori.RepositoriPesanan

class DetailsViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriMenu: RepositoriMenu,
    private val repositoriPesanan: RepositoriPesanan

)

data class ItemDetailsMenuUiState(
    val detailMenu: DetailMenu = DetailMenu(),
)

data class ItemDetailsPesananUiState(
    val detailPesanan: DetailPesanan = DetailPesanan()
)