package project.odycafe.ui.halaman

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import project.odycafe.R
import project.odycafe.model.EditViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.CafeTopAppBar
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
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            CafeTopAppBar(
                title = stringResource(ItemEditMenuDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        EntryMenuBody(
            uiStateMenu = viewModel.menuUiState,
            onMenuValueChange = viewModel::updateUiStateMenu,
            onSaveClick = {
                coroutineScope.launch {
                    viewModel.updateMenu()
                    navigateBack()
                }
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}