package com.example.taipeizoodemo

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*
import android.content.Intent
import android.net.Uri


class DetailFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    private var actionBar: ActionBar? = null

    companion object {

        const val BUNDLE_KEY = "BUNDLE_KEY"

        fun newInstance(index: Int): DetailFragment {
            val bundle = Bundle()
            bundle.putInt(BUNDLE_KEY, index)
            val frag = DetailFragment()
            frag.arguments = bundle
            return frag

        }
    }

    private var index: Int = 0

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if(context is AppCompatActivity) {
            actionBar = context.supportActionBar
            actionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        index = arguments?.getInt(BUNDLE_KEY) ?: 0

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        println("debug1")
        viewModel = activity?.run {
            ViewModelProviders.of(this).get(MainViewModel::class.java)
        } ?: return
        println("debug2")
        val list = viewModel.data.value ?: return
        println("debug3")
        val imageUrl = list[index].imageUrl
        val detail = list[index].subTitle
        val info = list[index].info.takeIf { it.isNotEmpty() } ?: context?.resources?.getString(R.string.no_close_info)
        val webUrl = list[index].webUrl
        val category = list[index].category
        actionBar?.title = list[index].title

        Glide.with(view).load(imageUrl).into(image)
        txtDetail.text = detail
        txtInfo.text = info
        txtCategory.text = category
        openBrowser.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
            startActivity(browserIntent)
        }
    }

    override fun onDetach() {
        super.onDetach()
        actionBar?.title = context?.resources?.getString(R.string.app_name)
        actionBar?.setDisplayHomeAsUpEnabled(false)
    }
}
