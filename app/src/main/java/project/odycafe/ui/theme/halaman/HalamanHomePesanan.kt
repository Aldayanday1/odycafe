package project.odycafe.ui.theme.halaman

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.data.Pesanan
import project.odycafe.model.HomeViewModel
import project.odycafe.model.PenyediaViewModel
import project.odycafe.navigasi.CafeTopAppBar
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
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            CafeTopAppBar(
                title = stringResource(DestinasiPesanan.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack,
                scrollBehavior = scrollBehavior,
                modifier = Modifier.alpha(0.5f),
            )
        },
        floatingActionButton = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = dimensionResource(id = R.dimen.padding_Large)),
                horizontalAlignment = Alignment.End
            ){
                Row(
                    modifier = Modifier
                        .padding(dimensionResource(id = R.dimen.padding_Large))
                        .alpha(0.8f),
                ) {
                    FloatingActionButton(
                        onClick = navigateToHome,
                        shape = MaterialTheme.shapes.medium
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = stringResource(R.string.entry_pesanan)
                        )

                    }

                    Spacer(modifier = Modifier.padding(end = 10.dp))

                    FloatingActionButton(
                        onClick = navigateToItemEntry,
                        shape = MaterialTheme.shapes.medium,
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = stringResource(R.string.entry_pesanan)
                        )
                    }


                }
            }

        },
    ){
            innerPadding ->

        val uiStatePesanan by viewModel.pesananUiState.collectAsState()

        //------- SEARCH PESANAN -------/
        val searchQueryState = remember { mutableStateOf("") }

        // filter = pemfilteran terhadap elemen yg ditampilkan (pesanan)
        //ignorecase true = mengabaikan kondisi dari huruf kapital / huruf kecilnya

        val filteredPesanan = uiStatePesanan.listPesanan.filter {
            it.idMenuForeignKey.contains(searchQueryState.value, ignoreCase = true)
        }

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.esteh),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds,
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = 15.dp,
                        bottom = 15.dp
                    ),
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                item {
                    OutlinedTextField(
                        value = searchQueryState.value,
                        onValueChange = { searchQueryState.value = it },
                        label = { Text("Search Pesanan") },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search Icon",
                                modifier = Modifier.size(24.dp)
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                end = 35.dp,
                                start = 35.dp,
                                bottom = 10.dp
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun DataPesanan(
    pesanan: Pesanan,
    modifier: Modifier = Modifier
){

}