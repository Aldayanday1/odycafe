package project.odycafe.navigasi

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import project.odycafe.R
import project.odycafe.ui.halaman.AdminScreen
import project.odycafe.ui.halaman.CustomerScreen
import project.odycafe.ui.halaman.DestinasiAdmin
import project.odycafe.ui.halaman.DestinasiCustomer
import project.odycafe.ui.halaman.DestinasiListMenu
import project.odycafe.ui.halaman.DestinasiListPesanan
import project.odycafe.ui.halaman.DestinasiMenu
import project.odycafe.ui.halaman.DestinasiMenuEntry
import project.odycafe.ui.halaman.DestinasiPesanan
import project.odycafe.ui.halaman.DestinasiStart
import project.odycafe.ui.halaman.DetailsMenuDestination
import project.odycafe.ui.halaman.DetailsMenuListDestination
import project.odycafe.ui.halaman.DetailsMenuListScreen
import project.odycafe.ui.halaman.DetailsMenuScreen
import project.odycafe.ui.halaman.EntryMenuScreen
import project.odycafe.ui.halaman.ItemEditMenuDestination
import project.odycafe.ui.halaman.ItemEditMenuScreen
import project.odycafe.ui.halaman.MenuListScreen
import project.odycafe.ui.halaman.MenuScreen
import project.odycafe.ui.halaman.StartScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CafeTopAppBar(
    title: String,
    canNavigateBack: Boolean,
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
    navigateUp: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.ExtraBold
            )
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
        navigationIcon = {
            if (canNavigateBack){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        }
    )
}

@Composable
fun HostNavigasi(
    navController: NavHostController,
){
    NavHost(
        navController = navController,
        startDestination = DestinasiStart.route,
        modifier = Modifier
    ){
        /* ------------- START ------------ */

        composable(DestinasiStart.route){
            StartScreen (
                onNextButtonAdminClicked = {navController.navigate(DestinasiAdmin.route)},
                onNextButtonCustomerClicked = {navController.navigate(DestinasiCustomer.route)},
            )
        }

        /* ------------- ADMIN & CUST ------------ */

        composable(DestinasiAdmin.route){
            AdminScreen (
                onNextButtonMenuClicked = {navController.navigate(DestinasiMenu.route)},
                onNextButtonPesananListClicked = {navController.navigate(DestinasiListPesanan.route)},
                navigateBack = { navController.popBackStack()},
            )
        }
        composable(DestinasiCustomer.route){
            CustomerScreen (
                onNextButtonPesananClicked = {navController.navigate(DestinasiPesanan.route)},
                onNextButtonMenuListClicked = {navController.navigate(DestinasiListMenu.route)},
                navigateBack = { navController.popBackStack()},
            )
        }

        /* ------------- NAV MENU ------------ */

        composable(DestinasiMenu.route){
            MenuScreen(
                navigateToItemEntry = {navController.navigate(DestinasiMenuEntry.route)},
                navigateBack = { navController.navigateUp() },
                navigateToHome = {navController.navigate(DestinasiStart.route)},
                onDetailClick = {
                    navController.navigate("${DetailsMenuDestination.route}/$it")
                },
            )
        }
        composable(DestinasiMenuEntry.route){
            EntryMenuScreen(
                navigateBack = { navController.popBackStack()},
                onNavigateUp = { navController.navigateUp() },
                modifier = Modifier
            )
        }
        composable(DetailsMenuDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailsMenuDestination.detailIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailsMenuScreen(
                navigateBack = { navController.popBackStack() },
                navigateToEditItem = {
                    navController.navigate("${ItemEditMenuDestination.route}/$it")
                }
            )
        }
        composable(ItemEditMenuDestination.routeWithArgs,
            arguments = listOf(navArgument(ItemEditMenuDestination.editIdArg) {
                type = NavType.IntType
            })
        ) {
            ItemEditMenuScreen(
                navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() }
            )
        }

        /* ------------- LIST MENU ------------ */

        composable(
            DestinasiListMenu.route){
            MenuListScreen(
                navigateBack = { navController.navigateUp() },
                onDetailMenuListClick = {
                    navController.navigate("${DetailsMenuListDestination.route}/$it")
                },
            )
        }
        composable(
            DetailsMenuListDestination.routeWithArgs,
            arguments = listOf(navArgument(DetailsMenuListDestination.detailIdArg) {
                type = NavType.IntType
            })
        ) {
            DetailsMenuListScreen(
                navigateBack = { navController.popBackStack() },
            )
        }
    }
}
