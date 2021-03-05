package com.example.a2021dm2rev1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.a2021dm2rev1.connection.AlunoDatabase
import com.example.a2021dm2rev1.model.Aluno
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSmile.setOnClickListener {
            txtHello.text = "Olá " + edtNome.text + ", seja bem vindo(a)!"

            if (swtToast.isChecked)
                Toast.makeText(
                    this, "Olá " + edtNome.text + ", seja bem vindo(a)!",
                    Toast.LENGTH_LONG
                ).show()

            if (tglSalvar.isChecked) {
                create()
            }
        }
    }

    private fun create() {
        val nome = Aluno(edtNome.text.toString())

        AlunoDatabase.getInstance(this).alunoDAO().create(nome)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_principal, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val QUANTIDADE_ALUNO = AlunoDatabase.getInstance(this).alunoDAO().count()

        if (item.itemId == R.id.menu_listagem) {
            if (QUANTIDADE_ALUNO == 0) {
                Toast.makeText(
                    this, "Lista Vazia",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                startActivity(Intent(this, ListActivity::class.java))
            }
        }

        return super.onOptionsItemSelected(item)
    }
}