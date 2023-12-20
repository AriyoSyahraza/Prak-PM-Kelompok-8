package com.example.prakpmkel8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.prakpmkel8.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.auth.User

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = FirebaseDatabase.getInstance().getReference("Users")

        recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(this)
        recyclerView.adapter = userAdapter

        // Load user data initially
//        loadData()



//        binding.mainUpload.setOnClickListener(View.OnClickListener{
//            val intent = Intent(this@MainActivity, UploadActivity::class.java)
//            startActivity(intent)
//            finish()
//        })
//
//        binding.mainUpdate.setOnClickListener(View.OnClickListener{
//            val intent = Intent(this@MainActivity, UpdateActivity::class.java)
//            startActivity(intent)
//        })
//
//        binding.mainDelete.setOnClickListener(View.OnClickListener{
//            val intent = Intent(this@MainActivity, DeleteActivity::class.java)
//            startActivity(intent)
//        })

    }

//    private fun loadData() {
//        database.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                val userList = mutableListOf<User>()
//
//                for (userSnapshot in snapshot.children) {
//                    val user = userSnapshot.getValue(User::class.java)
//                    user?.let {
//                        userList.add(it)
//                    }
//                }
//
//                userAdapter.submitList(userList)
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                // Handle error
//            }
//        })
//    }
}