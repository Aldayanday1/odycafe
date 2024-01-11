package project.odycafe.ui.theme.halaman

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import project.odycafe.R
import project.odycafe.navigasi.DestinasiNavigasi

object DetailsMenuDestination : DestinasiNavigasi {
    override val route = "item_details_menu"
    override val titleRes = R.string.title_detail_menu
    const val detailIdArg = "itemId"
    val routeWithArgs = "$route/{$detailIdArg}"
}

@Composable
private fun DeleteMenuConfirmationDialog(
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