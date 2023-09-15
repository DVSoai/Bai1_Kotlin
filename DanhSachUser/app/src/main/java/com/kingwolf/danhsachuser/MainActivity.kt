package com.kingwolf.danhsachuser

import android.app.Dialog
import android.os.Bundle

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val userList = mutableListOf<User>()
    private lateinit var userAdapter: ArrayAdapter<User>
    private lateinit var userListView: ListView
    private lateinit var addUserButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList)
        userListView = findViewById(R.id.userListView)
        userListView.adapter = userAdapter

        addUserButton = findViewById(R.id.addUserButton)
        addUserButton.setOnClickListener {
            showAddUserDialog()
        }
    }

    private fun showAddUserDialog() {
        val addUserDialog = Dialog(this)
        addUserDialog.setContentView(R.layout.add_user_dialog)

        val etName = addUserDialog.findViewById<EditText>(R.id.etName)
        val etAge = addUserDialog.findViewById<EditText>(R.id.etAge)
        val etSex = addUserDialog.findViewById<EditText>(R.id.etSex)
        val addButton = addUserDialog.findViewById<Button>(R.id.addButton)

        addButton.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val etSex = etSex.text.toString()

            val newUser = User(name, age, etSex)
            userList.add(newUser)
            userAdapter.notifyDataSetChanged()

            addUserDialog.dismiss()
        }

        addUserDialog.show()
    }
}
