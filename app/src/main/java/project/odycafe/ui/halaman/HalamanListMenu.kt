package project.odycafe.ui.halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import project.odycafe.R
import project.odycafe.data.Menu
import project.odycafe.navigasi.DestinasiNavigasi

object DestinasiListMenu : DestinasiNavigasi {
    override val route = "listmenu"
    override val titleRes = R.string.list_menu
}


@Composable
fun DataListMenu(
    menu: Menu,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier
            .padding(bottom = 16.dp)
            .size(width = 350.dp, height = 255.dp)
            .alpha(0.8f),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
    ){
        Column (
            modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_Large)),
            verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_small))
        ){
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(
                    text = stringResource(id = R.string.idmenu1),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = menu.idmenu.toString(),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(
                    text = stringResource(id = R.string.menu1),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = menu.menu,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(
                    text = stringResource(id = R.string.harga1),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = menu.harga,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight ,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(
                    text = stringResource(id = R.string.ketersediaan1),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = menu.ketersediaan,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.padding_small)))
            Row {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight ,
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_medium)))
                Text(
                    text = stringResource(id = R.string.kategori1),
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.padding_small)))
                Text(
                    text = menu.kategori,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

