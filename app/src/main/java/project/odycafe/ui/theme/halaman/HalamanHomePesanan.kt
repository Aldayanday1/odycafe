package project.odycafe.ui.theme.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.model.HomeViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiPesanan : DestinasiNavigasi {
    override val route = "pesanan"
    override val titleRes = R.string.welcome_pesanan
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PesananScreen(
    navigateToItemEntry: () -> Unit,
    onDetailClick: (Int) -> Unit = {},
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}