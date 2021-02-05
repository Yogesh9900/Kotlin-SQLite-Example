package com.test.pfbtest.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.test.pfbtest.DataAdapter
import com.test.pfbtest.R
import com.test.pfbtest.DocsDBHelper
import com.test.pfbtest.model.ResponseData
import com.test.pfbtest.model.DBModel
import com.test.pfbtest.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    private lateinit var mViewModel: MainViewModel
    lateinit var docsDBHelper: DocsDBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        docsDBHelper = DocsDBHelper(this)

        if (!showData()) {
            mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

            mViewModel.getData("https://api.plos.org/search?q=title:DNA")

            mViewModel.mutableData?.observe(this, Observer { responseData ->
                addData(responseData)


            })
        }

    }

    fun addData(data: ResponseData) {

        for (i in data.response.docs) {
            docsDBHelper.insertDoc(
                DBModel(
                    id = i.id,
                    pdate = i.publication_date,
                    article_type = i.article_type
                )
            )
        }

        showData()
    }

    fun showData() : Boolean{
        var users = docsDBHelper.readAllDocs()

        if (users.isEmpty()) {
           return false
        } else {

            recyclerView.setHasFixedSize(true)
            val adapter = DataAdapter(users)
            recyclerView.adapter = adapter

        }
        return true
    }


}