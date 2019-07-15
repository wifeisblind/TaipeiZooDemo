package com.example.taipeizoodemo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.frag_main.*

class MainFragment :Fragment() {

    lateinit var viewModel: MainViewModel

    private var adapter: MainAdapter? = null

    lateinit var recyclerView: RecyclerView

    private var callBack: OnItemClickListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnItemClickListener) {
            callBack = context
            adapter = MainAdapter(callBack)
        }

    }

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

        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: return

        recyclerView.adapter = adapter
        viewModel.data.observe(this,
            Observer<List<MainItem>> {
                adapter?.setData(it)
            })
        viewModel.get()
    }


}