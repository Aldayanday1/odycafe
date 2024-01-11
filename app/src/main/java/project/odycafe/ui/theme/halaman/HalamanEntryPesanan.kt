package project.odycafe.ui.theme.halaman

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import project.odycafe.R
import project.odycafe.data.Menu
import project.odycafe.model.DetailPesanan
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputPesanan(
    detailPesanan: DetailPesanan,
    modifier: Modifier = Modifier,
    onValueChange: (DetailPesanan) -> Unit = {},
    enabled: Boolean = true,
    menuItems: List<Menu>, // Tambahkan parameter untuk menampung daftar menu
){
    Card(
        modifier = modifier
            .padding(top = 15.dp)
            .size(width = 0.dp, height = 610.dp)
            .alpha(0.8f),
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_extra_Large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
        ) {
            OutlinedTextField(
                value = detailPesanan.idpesanan?.toString() ?: "",
                onValueChange = {
                    onValueChange(
                        /** it = nilai yg dimasukkan */
                        if (it.isEmpty()) detailPesanan.copy(idpesanan = null)
                        else detailPesanan.copy(idpesanan = it.toIntOrNull())
                    )
                },
                label = { Text(stringResource(R.string.idpesanan)) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            /** OutlinedTextField memerlukan String sbg nilai value*/
            OutlinedTextField(
                value = detailPesanan.nama,
                onValueChange = { onValueChange(detailPesanan.copy(nama = it)) },
                label = { Text(stringResource(R.string.nama)) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            Divider()

            var expanded by remember { mutableStateOf(false) }
            var selectedMenu: String? by remember { mutableStateOf(null) } // Menggunakan tipe data String nullable untuk menunjukkan pilihan yang kosong

            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { expanded = !expanded }
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = selectedMenu ?: "Select Menu",
                        modifier = Modifier.padding(16.dp)
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.width(315.dp),
                ) {
                    for (menuItem in menuItems) {
                        DropdownMenuItem(
                            onClick = {
                                // Perbarui selectedMenu dan tutup dropdown
                                selectedMenu = menuItem.menu
                                expanded = false
                                onValueChange(
                                    detailPesanan.copy(
                                        idmenuforeignkey = selectedMenu ?: ""
                                    )
                                )
                            },
                            text = { Text(text = menuItem.menu) },
                        )
                    }
                }
            }
            OutlinedTextField(
                value = detailPesanan.detail,
                onValueChange = { onValueChange(detailPesanan.copy(detail = it)) },
                label = { Text(stringResource(R.string.detail)) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPesanan.metode,
                onValueChange = { onValueChange(detailPesanan.copy(metode = it)) },
                label = { Text(text = stringResource(R.string.metode)) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )
            OutlinedTextField(
                value = detailPesanan.tanggal,
                onValueChange = { onValueChange(detailPesanan.copy(tanggal = it)) },
                label = { Text(text = stringResource(R.string.tanggal)) },
                modifier = Modifier.fillMaxWidth(),
                enabled = enabled,
                singleLine = true
            )

            Spacer(modifier = Modifier
                .padding(top = 0.dp, bottom = 0.dp)
            )

            Divider()

            if (enabled) {
                Text(
                    text = stringResource(R.string.required_field),
                    modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                )
            }
        }
    }
}