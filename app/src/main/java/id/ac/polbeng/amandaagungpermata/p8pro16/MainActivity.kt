package id.ac.polbeng.amandaagungpermata.p8pro16

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getPreferences(Context.MODE_PRIVATE)

        btnSave.setOnClickListener {
            val editor = pref.edit()
            editor.putString("lastname", inputLastName.text.toString())
            editor.putString("firstname", inputFirstName.text.toString())
            editor.apply()
            Toast.makeText(this, "Saved data", Toast.LENGTH_SHORT).show()
        }

        btnLoad.setOnClickListener {
            val lastName = pref.getString("lastname", "")
            val firstName = pref.getString("firstname", "")
            val output = "$firstName $lastName"
            tvName.text = output
        }
    }

    override fun onResume() {
        super.onResume()
        inputFirstName.setText("")
        inputLastName.setText("")
        tvName.setText("")
    }
}