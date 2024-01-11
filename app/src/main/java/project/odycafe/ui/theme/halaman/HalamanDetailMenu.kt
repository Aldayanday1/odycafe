package project.odycafe.ui.theme.halaman

import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object DetailsMenuDestination : DestinasiNavigasi {
    override val route = "item_details_menu"
    override val titleRes = R.string.title_detail_menu
    const val detailIdArg = "itemId"
    val routeWithArgs = "$route/{$detailIdArg}"
}

