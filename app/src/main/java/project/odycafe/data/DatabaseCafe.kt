package project.odycafe.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Menu::class, Pesanan::class], version = 1, exportSchema = false)
abstract class DatabaseCafe : RoomDatabase(){

    abstract fun menuDao() : MenuDao
    abstract fun pesananDao() : PesananDao

    companion object{
        @Volatile
        private var Instance:DatabaseCafe? = null

        private val MIGRATION: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {}
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


