package com.example.a2021dm2rev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.a2021dm2rev1.connection.AlunoDatabase
import com.example.a2021dm2rev1.model.Aluno
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        read()
    }

    private fun read() {
        val alunos: List<Aluno> =
            AlunoDatabase
                .getInstance(this)
                .alunoDAO()
                .read()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)

        lstPresenca.adapter = adapter
    }
}