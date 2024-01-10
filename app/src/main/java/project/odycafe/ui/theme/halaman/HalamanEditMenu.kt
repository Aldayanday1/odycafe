package project.odycafe.ui.theme.halaman

import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object ItemEditMenuDestination : DestinasiNavigasi {
    override val route = "item_edit_menu"
    override val titleRes = R.string.title_edit_menu
    const val editIdArg = "itemId"
    val routeWithArgs = "$route/{$editIdArg}"
}
