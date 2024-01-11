package project.odycafe.ui.halaman

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import project.odycafe.R
import project.odycafe.data.Pesanan
import project.odycafe.navigasi.DestinasiNavigasi

object DetailsPesananDestination : DestinasiNavigasi {
    override val route = "item_details_pesanan"
    override val titleRes = R.string.title_detail_pesanan
    const val detailIdArg = "itemId"
    val routeWithArgs = "$route/{$detailIdArg}"
}

@Composable
fun ItemPesananDetails(
    pesanan : Pesanan, modifier: Modifier = Modifier
){
    Card(
        modifier = modifier
            .padding(top = 145.dp)
            .size(width = 350.dp, height = 315.dp)
            .alpha(0.8f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_Large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ) {
            ItemPesananDetailsRow(
                labelResID = R.string.idpesanan1,
                itemDetail = pesanan.idpesanan.toString(),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            ItemPesananDetailsRow(
                labelResID = R.string.nama1,
                itemDetail = pesanan.nama,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            ItemPesananDetailsRow(
                labelResID = R.string.idmenu1,
                itemDetail = pesanan.idMenuForeignKey.toString(),
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            ItemPesananDetailsRow(
                labelResID = R.string.detail1,
                itemDetail = pesanan.detail,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            ItemPesananDetailsRow(
                labelResID = R.string.metode1,
                itemDetail = pesanan.metode,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
            ItemPesananDetailsRow(
                labelResID = R.string.tanggal1,
                itemDetail = pesanan.tanggal,
                modifier = Modifier.padding(
                    horizontal = dimensionResource(id = R.dimen.padding_medium)
                )
            )
        }

    }
}

@Composable
fun ItemPesananDetailsRow(
    @StringRes labelResID: Int, itemDetail: String, modifier: Modifier = Modifier
){
    Row (
        modifier = modifier
            .padding(top = 15.dp),
    ){
        Text(text = stringResource(labelResID))
        Spacer(modifier = Modifier.weight(1f))
        Text(text = itemDetail, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun DeletePesananConfirmationDialog(
    onDeleteConfirm: () -> Unit,
    onDeleteCancel: () -> Unit,
    deleteConfirmationRequired: Boolean, // Gunakan parameter baru sebagai trigger
    modifier: Modifier = Modifier
){
    if (deleteConfirmationRequired) { // Ubah penanganan tampilan dialog berdasarkan status
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            title = { Text(stringResource(id = R.string.attention)) },
            text = { Text(text = stringResource(id = R.string.delete)) },
            modifier = modifier,
            dismissButton = {
                TextButton(onClick = {
                    onDeleteCancel() // Panggil onDeleteCancel untuk mereset status
                }) {
                    Text(text = stringResource(id = R.string.no))
                }
            },
            confirmButton = {
                TextButton(onClick = onDeleteConfirm) {
                    Text(text = stringResource(id = R.string.yes))
                }
            }
        )
    }
}