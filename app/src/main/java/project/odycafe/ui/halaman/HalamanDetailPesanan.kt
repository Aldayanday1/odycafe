package project.odycafe.ui.halaman

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object DetailsPesananDestination : DestinasiNavigasi {
    override val route = "item_details_pesanan"
    override val titleRes = R.string.title_detail_pesanan
    const val detailIdArg = "itemId"
    val routeWithArgs = "$route/{$detailIdArg}"
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