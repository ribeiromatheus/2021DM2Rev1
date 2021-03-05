package com.example.a2021dm2rev1.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Aluno(
    val nome: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
) : Serializable {
    override fun toString(): String {
        return "$nome"
    }
}