import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.model.EntryViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiMenuEntry: DestinasiNavigasi {
    override val route = "item_entry_menu"
    override val titleRes = R.string.title_entry_menu
}

@Composable
fun EntryMenuScreen(
    onNavigateUp: () -> Unit,
    navigateBack: () -> Unit,
    modifier: Modifier,
    viewModel: EntryViewModel = viewModel(factory = PenyediaViewModel.Factory)
){

}