package project.odycafe.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import project.odycafe.AplikasiCafe


object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                AplikasiCafe().container.repositoriMenu,
                AplikasiCafe().container.repositoriPesanan
            )
        }
        initializer {
            EntryViewModel(
                AplikasiCafe().container.repositoriMenu,
                AplikasiCafe().container.repositoriPesanan
            )
        }
        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                AplikasiCafe().container.repositoriMenu,
                AplikasiCafe().container.repositoriPesanan
            )
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                AplikasiCafe().container.repositoriMenu,
                AplikasiCafe().container.repositoriPesanan
            )
        }
    }
}


/*
* Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah
* instance dari [AplikasiCafe].
*/

fun CreationExtras.AplikasiCafe(): AplikasiCafe =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiCafe)