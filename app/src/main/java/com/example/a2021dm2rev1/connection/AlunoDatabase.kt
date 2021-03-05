package com.example.a2021dm2rev1.connection

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.a2021dm2rev1.dao.AlunoDAO
import com.example.a2021dm2rev1.model.Aluno

@Database(entities = [Aluno::class], version = 1)
abstract class AlunoDatabase : RoomDatabase() {
    abstract fun alunoDAO(): AlunoDAO

    companion object {
        private var database: AlunoDatabase? = null

        private val DATABASE = "Aluno"

        fun getInstance(context: Context): AlunoDatabase {
            return database ?: createDatabase(context).also { database = it }
        }

        private fun createDatabase(context: Context): AlunoDatabase {
            return Room
                .databaseBuilder(context, AlunoDatabase::class.java, DATABASE)
                .allowMainThreadQueries()
                .build()
        }
    }
}