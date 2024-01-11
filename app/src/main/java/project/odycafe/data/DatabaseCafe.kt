package project.odycafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Menu::class, Pesanan::class], version = 2, exportSchema = false)
abstract class DatabaseCafe : RoomDatabase(){

    abstract fun menuDao() : MenuDao
    abstract fun pesananDao() : PesananDao

    companion object{
        @Volatile
        private var Instance:DatabaseCafe? = null

        private val MIGRATION: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Tambahkan kolom onUpdate pada definisi kunci asing
                database.execSQL("CREATE TABLE IF NOT EXISTS `tblPesanan_temp` (" +
                        "`idpesanan` INTEGER NOT NULL, " +
                        "`nama` TEXT NOT NULL, " +
                        "`detail` TEXT NOT NULL, " +
                        "`metode` TEXT NOT NULL, " +
                        "`tanggal` TEXT NOT NULL, " +
                        "`idMenuForeignKey` TEXT NOT NULL, " +
                        "PRIMARY KEY(`idpesanan`), " +
                        "FOREIGN KEY(`idMenuForeignKey`) REFERENCES `tblMenu`(`menu`) ON UPDATE CASCADE ON DELETE CASCADE)")

                database.execSQL("INSERT INTO tblPesanan_temp (idpesanan, nama, detail, metode, tanggal, idMenuForeignKey) SELECT idpesanan, nama, detail, metode, tanggal, idMenuForeignKey FROM tblPesanan")

                // Hapus tabel lama
                database.execSQL("DROP TABLE IF EXISTS `tblPesanan`")

                // Ubah nama tabel sementara menjadi nama tabel yang benar
                database.execSQL("ALTER TABLE `tblPesanan_temp` RENAME TO `tblPesanan`")
            }
        }


        @OptIn(InternalCoroutinesApi::class)
        fun getDatabase(context: Context): DatabaseCafe {
            return (Instance?: synchronized(this){
                Room.databaseBuilder(context, DatabaseCafe::class.java, "Cafe_database")
                    .addMigrations(MIGRATION)
                    .build().also { Instance=it }
            })
        }
    }
}


