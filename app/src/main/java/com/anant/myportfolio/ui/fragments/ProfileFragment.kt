package com.anant.myportfolio.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anant.myportfolio.R
import com.anant.myportfolio.constants.EDUCATION_FRAGMENT_KEY
import com.anant.myportfolio.constants.Skill_FRAGMENT_KEY
import com.anant.myportfolio.constants.WORK_FRAGMENT_KEY
import com.anant.myportfolio.data.resume.Education
import com.anant.myportfolio.data.resume.Resume
import com.anant.myportfolio.data.resume.Skill
import com.anant.myportfolio.data.resume.Work
import com.anant.myportfolio.util.isNetworkAvailable
import kotlinx.android.synthetic.main.profile_fragment.*

class ProfileFragment : Fragment() {

    companion object {
        fun newInstance() = ProfileFragment()
    }

    val bundle = Bundle()
    var educationDetail: List<Education?>? = null
    var workDetail: ArrayList<Work?>? = null
    var skillDetail: ArrayList<Skill?>? = null
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ProfileViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        if(isNetworkAvailable(this.context)){
            viewModel.doGetResume()
            val resumeDataObserver: MutableLiveData<Resume>? = viewModel.resumeFeed
            resumeDataObserver?.observe(this,
                Observer<Resume> {
                    educationDetail = it.education
                    workDetail = it.work
                    skillDetail = it.skills
                    resumeResponseTextView.text = it.basics?.name
                    educationTextView.text = it.headings?.education
                    workTextView.text = it.headings?.work
                    skillTextView.text = it.headings?.skills
                })
        } else {
            Toast.makeText(this.context, "Please check your Network", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        setUpEducationClickListener()
        setUpSkillClickListener()
        setUpWorkClickListener()
    }

    private fun  setUpEducationClickListener(){
        educationImageButton.setOnClickListener {
            bundle.putParcelable(EDUCATION_FRAGMENT_KEY, educationDetail?.get(0))
            val educationFragmentFragment = EducationFragment.newInstance()
            educationFragmentFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, educationFragmentFragment)?.commit()
        }

        educationTextView.setOnClickListener {
            bundle.putParcelable(EDUCATION_FRAGMENT_KEY, educationDetail?.get(0))
            val educationFragmentFragment = EducationFragment.newInstance()
            educationFragmentFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, educationFragmentFragment)?.commit()
        }
    }

    private fun setUpSkillClickListener(){
        skillImageButton.setOnClickListener {
            bundle.putParcelableArrayList(Skill_FRAGMENT_KEY, skillDetail)
            val skillFragment = SkillsFragment.newInstance()
            skillFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, skillFragment)?.commit()
        }

        skillTextView.setOnClickListener {
            bundle.putParcelableArrayList(Skill_FRAGMENT_KEY, skillDetail)
            val skillFragment = SkillsFragment.newInstance()
            skillFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, skillFragment)?.commit()
        }
    }

    private fun setUpWorkClickListener(){
        workImageButton.setOnClickListener {
            bundle.putParcelableArrayList(WORK_FRAGMENT_KEY, workDetail)
            val workFragment = WorkFragment.newInstance()
            workFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, workFragment)?.commit()
        }

        workTextView.setOnClickListener {
            bundle.putParcelableArrayList(WORK_FRAGMENT_KEY, workDetail)
            val workFragment = WorkFragment.newInstance()
            workFragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.container, workFragment)?.commit()
        }
    }
}
