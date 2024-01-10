package project.odycafe.ui.theme.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.model.HomeViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiMenu : DestinasiNavigasi {
    override val route = "menu"
    override val titleRes = R.string.welcome_menu
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    navigateToItemEntry: () -> Unit,
    onDetailClick: (Int) -> Unit = {},
    navigateBack: () -> Unit,
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {}