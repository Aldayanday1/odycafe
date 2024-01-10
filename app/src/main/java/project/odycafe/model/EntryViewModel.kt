package project.odycafe.model


import androidx.lifecycle.ViewModel
import project.odycafe.data.Pesanan
import project.odycafe.repositori.RepositoriMenu
import project.odycafe.repositori.RepositoriPesanan

class EntryViewModel(
    private val repositoriMenu: RepositoriMenu,
    private val repositoriPesanan: RepositoriPesanan
): ViewModel() {
}



    /* ------------- PESANAN ------------ */

    // Mewakili Status Ui untuk Pesanan
    data class UIStatePesanan(
        val detailPesanan: DetailPesanan = DetailPesanan(),
        val isEntryValid: Boolean = false
    )

    data class DetailPesanan(
        val idpesanan: Int? = null,
        val nama: String = "",
        val detail: String = "",
        val metode: String = "",
        val tanggal: String = "",
        val idmenuforeignkey: String = "",
    )

    // Fungsi untuk mengkonversi data input ke data dalam tabel Pesanan
    fun DetailPesanan.toPesanan(): Pesanan = Pesanan(
        idpesanan = idpesanan ?: 0,
        nama = nama,
        detail = detail,
        metode = metode,
        tanggal = tanggal,
        idMenuForeignKey = idmenuforeignkey, // Sesuaikan dengan nilai yang diinginkan
    )

    // Fungsi untuk mengubah Pesanan menjadi UIStatePesanan
    fun Pesanan.toUiStatePesanan(isEntryValid: Boolean = false): UIStatePesanan = UIStatePesanan(
        detailPesanan = this.toDetailPesanan(),
        isEntryValid = isEntryValid
    )

    // Fungsi untuk mengubah Pesanan menjadi DetailPesanan
    fun Pesanan.toDetailPesanan(): DetailPesanan = DetailPesanan(
        idpesanan = idpesanan,
        nama = nama,
        detail = detail,
        metode = metode,
        tanggal = tanggal,
        idmenuforeignkey = idMenuForeignKey
    )