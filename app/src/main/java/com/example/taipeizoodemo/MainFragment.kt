package com.example.taipeizoodemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frag_main.*

class MainFragment :Fragment() {

    private val demoData = List(10) {
        MainItem()
    }

    private val adapter: MainAdapter by lazy { val adapter = MainAdapter(); adapter.setData(demoData); adapter }

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.frag_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val context = view.context

        recyclerView = recyclerview
        with(recyclerView){
            val llm = LinearLayoutManager(context)
            llm.orientation = RecyclerView.VERTICAL
            this.layoutManager = llm
        }
        recyclerView.adapter = adapter
    }
}