package project.odycafe.ui.theme.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.model.EntryViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiPesananEntry: DestinasiNavigasi {
    override val route = "item_entry_pesanan"
    override val titleRes = R.string.title_entry_pesanan
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryPesananScreen(
    onNavigateUp: () -> Unit,
    navigateBack: () -> Unit,
    /** Modifier untuk Behavior -> agar Appbar Menyusut saat digulir kebawah*/
    modifier: Modifier,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}