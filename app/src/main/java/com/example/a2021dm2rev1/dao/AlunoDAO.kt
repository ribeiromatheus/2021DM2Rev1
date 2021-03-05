package com.example.a2021dm2rev1.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.a2021dm2rev1.model.Aluno

@Dao
interface AlunoDAO {
    @Insert
    fun create(aluno: Aluno)

    @Query("SELECT * FROM Aluno")
    fun read(): List<Aluno>

    @Query("SELECT COUNT(*) FROM Aluno")
    fun count(): Int
}