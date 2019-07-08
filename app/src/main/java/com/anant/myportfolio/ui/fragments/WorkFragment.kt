package com.anant.myportfolio.ui.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.anant.myportfolio.R
import com.anant.myportfolio.constants.WORK_FRAGMENT_KEY
import com.anant.myportfolio.data.resume.Education
import com.anant.myportfolio.data.resume.Work
import com.anant.myportfolio.ui.adapter.WorkExperienceRVAdapter
import kotlinx.android.synthetic.main.fragment_work.*
import kotlinx.android.synthetic.main.profile_fragment.*
import kotlinx.android.synthetic.main.profile_fragment.workTextView

class WorkFragment : Fragment() {

    private var work: ArrayList<Work>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let{
           work =  it.getParcelableArrayList(WORK_FRAGMENT_KEY)
        }
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_work, container, false)
        }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
        work?.let { setUpRecyclerView(it) }
    }

    override fun onDetach() {
        super.onDetach()
    }

    private fun setUpRecyclerView(workExItems: ArrayList<Work>) {
        workExRecyclerView.layoutManager = LinearLayoutManager(this.context)
        workExRecyclerView.adapter = WorkExperienceRVAdapter( this.context, workExItems)
    }

    companion object {
        @JvmStatic
        fun newInstance() = WorkFragment()
            }
    }
