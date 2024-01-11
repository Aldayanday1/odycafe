package project.odycafe.ui.theme.halaman

import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object ItemEditPesananDestination : DestinasiNavigasi {
    override val route = "item_edit_pesanan"
    override val titleRes = R.string.title_edit_pesanan
    const val editIdArg = "itemId"
    val routeWithArgs = "$route/{$editIdArg}"
}

