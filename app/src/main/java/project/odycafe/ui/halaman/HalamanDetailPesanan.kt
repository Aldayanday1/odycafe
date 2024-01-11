package project.odycafe.ui.halaman

import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object DetailsPesananDestination : DestinasiNavigasi {
    override val route = "item_details_pesanan"
    override val titleRes = R.string.title_detail_pesanan
    const val detailIdArg = "itemId"
    val routeWithArgs = "$route/{$detailIdArg}"
}

