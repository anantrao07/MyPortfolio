package com.anant.myportfolio.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anant.myportfolio.R

class SkillsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            //param1 = it.getString(Skill_FRAGMENT_KEY)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_skills, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        @JvmStatic
        fun newInstance() = SkillsFragment()
    }
}
