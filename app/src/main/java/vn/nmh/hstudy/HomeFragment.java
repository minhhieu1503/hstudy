package vn.nmh.hstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.nmh.hstudy.fragments.ContentFragment;
import vn.nmh.hstudy.fragments.GrammerFragment;
import vn.nmh.hstudy.fragments.PracticeFragment;
import vn.nmh.hstudy.fragments.VocabularyFragment;

public class HomeFragment extends Fragment implements View.OnClickListener{
	private Button mBtnVocabulary, mBtnPractice, mBtnContent, mBtnGrammer;
	Fragment mVocabularyFragment, mPracticeFragment, mContentFragment, mGrammerFragment;
	public HomeFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.home_fragment, container,
				false);
		mBtnVocabulary = (Button)rootView.findViewById(R.id.home_btn_vocabulary);
		mBtnGrammer = (Button)rootView.findViewById(R.id.home_btn_grammer);
		mBtnContent = (Button)rootView.findViewById(R.id.home_btn_content);
		mBtnPractice = (Button)rootView.findViewById(R.id.home_btn_practice);

		mBtnVocabulary.setOnClickListener(this);
		mBtnGrammer.setOnClickListener(this);
		mBtnContent.setOnClickListener(this);
		mBtnPractice.setOnClickListener(this);

		if (getActivity().getSupportFragmentManager() != null) {
			getActivity().getSupportFragmentManager()
					.beginTransaction()
					.add(R.id.home_fl_container, mVocabularyFragment = new VocabularyFragment(), VocabularyFragment.TAG)
					.add(R.id.home_fl_container, mContentFragment = new ContentFragment(), ContentFragment.TAG)
					.add(R.id.home_fl_container, mPracticeFragment = new PracticeFragment(), PracticeFragment.TAG)
					.add(R.id.home_fl_container, mGrammerFragment = new GrammerFragment(), GrammerFragment.TAG)
					.commit();
			showFragment(mVocabularyFragment);
		}

		// Inflate the layout for this fragment
		return rootView;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.home_btn_vocabulary:
				showFragment(mVocabularyFragment);
				break;
			case R.id.home_btn_grammer:
				showFragment(mGrammerFragment);
				break;
			case R.id.home_btn_content:
				showFragment(mContentFragment);
				break;
			case R.id.home_btn_practice:
				showFragment(mPracticeFragment);
				break;
			default:
				break;
		}
	}

	private void showFragment(Fragment frag) {

		FragmentManager manager;
		if ((manager = getActivity().getSupportFragmentManager()) != null) {
			FragmentTransaction transaction = manager.beginTransaction().show(frag);
			if (frag instanceof VocabularyFragment) {
				transaction.hide(mGrammerFragment).hide(mContentFragment).hide(mPracticeFragment);
			} else if (frag instanceof GrammerFragment) {
				transaction.hide(mVocabularyFragment).hide(mContentFragment).hide(mPracticeFragment);
			} else if (frag instanceof ContentFragment) {
				transaction.hide(mGrammerFragment).hide(mVocabularyFragment).hide(mPracticeFragment);
			} else if (frag instanceof PracticeFragment) {
				transaction.hide(mGrammerFragment).hide(mContentFragment).hide(mVocabularyFragment);
			}
			transaction.commit();
		}
	}
}
