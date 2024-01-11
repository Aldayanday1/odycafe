package project.odycafe.ui.theme.halaman

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import project.odycafe.R
import project.odycafe.model.DetailMenu
import project.odycafe.model.UIStateMenu
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiMenuEntry: DestinasiNavigasi {
    override val route = "item_entry_menu"
    override val titleRes = R.string.title_entry_menu
}

@Composable
fun EntryMenuBody(
    uiStateMenu: UIStateMenu,
    onMenuValueChange: (DetailMenu) -> Unit,
    onSaveClick: () -> Unit,
    modifier: Modifier = Modifier
){

    Column (
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_Large)),
        modifier = modifier.padding(dimensionResource(id = R.dimen.padding_medium))
    ){
        FormInputMenu(
            detailMenu = uiStateMenu.detailMenu,
            onValueChange = onMenuValueChange,
            modifier = Modifier.fillMaxWidth(),
        )
        OutlinedButton(
            onClick = onSaveClick,
            enabled = uiStateMenu.isEntryValid,
            modifier = Modifier
                .width(200.dp)
                .align(Alignment.CenterHorizontally),
            border = BorderStroke(0.dp, Color.Transparent),  // Menghapus border
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.DarkGray.copy(alpha = 0.8f),
                contentColor = Color.DarkGray.copy(alpha = 0.4f)
            ),
            shape = MaterialTheme.shapes.small
        ) {
            Text(
                text = stringResource(id = R.string.btn_submit),
                color = Color.White
            )
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormInputMenu(
    detailMenu: DetailMenu,
    modifier: Modifier = Modifier,
    onValueChange: (DetailMenu) -> Unit = {},
    enabled: Boolean = true
){
    Card(
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_small))
            .size(width = 350.dp, height = 510.dp)
            .alpha(0.8f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ){
        Column(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_Large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ){
            Column (
                modifier = modifier,
                verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_medium))
            ){
                /** OutlinedTextField memerlukan String sbg nilai value*/
                OutlinedTextField(
                    value = detailMenu.idmenu?.toString() ?: "",
                    onValueChange = {
                        onValueChange(
                            /** it = nilai yg dimasukkan */
                            if (it.isEmpty()) detailMenu.copy(idmenu = null)
                            else detailMenu.copy(idmenu = it.toIntOrNull())
                        )
                    },
                    label = { Text(stringResource(R.string.idmenu)) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                OutlinedTextField(
                    value = detailMenu.menu,
                    onValueChange = {onValueChange(detailMenu.copy(menu = it)) },
                    label = { Text(stringResource(R.string.menu)) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true
                )
                OutlinedTextField(
                    value = detailMenu.harga,
                    onValueChange = {onValueChange(detailMenu.copy(harga = it)) },
                    label = { Text(stringResource(R.string.harga)) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true
                )
                OutlinedTextField(
                    value = detailMenu.ketersediaan,
                    onValueChange = {onValueChange(detailMenu.copy(ketersediaan = it)) },
                    label = { Text(text = stringResource(R.string.ketersediaan)) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true
                )
                OutlinedTextField(
                    value = detailMenu.kategori,
                    onValueChange = {onValueChange(detailMenu.copy(kategori = it)) },
                    label = { Text(text = stringResource(R.string.kategori)) },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = enabled,
                    singleLine = true
                )

                Spacer(modifier = Modifier.padding(top = 0.dp))
                Divider()

                if (enabled){
                    Text(
                        text = stringResource(R.string.required_field),
                        modifier = Modifier.padding(start = dimensionResource(id = R.dimen.padding_medium))
                    )
                }
            }
        }
    }
}
