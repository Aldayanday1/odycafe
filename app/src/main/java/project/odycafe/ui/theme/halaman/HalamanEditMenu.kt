package project.odycafe.ui.theme.halaman

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.model.EditViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.DestinasiNavigasi

object ItemEditMenuDestination : DestinasiNavigasi {
    override val route = "item_edit_menu"
    override val titleRes = R.string.title_edit_menu
    const val editIdArg = "itemId"
    val routeWithArgs = "$route/{$editIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemEditMenuScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: EditViewModel = viewModel(factory = PenyediaViewModel.Factory)
) {

}