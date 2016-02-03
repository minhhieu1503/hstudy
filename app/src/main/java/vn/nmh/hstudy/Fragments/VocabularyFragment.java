package vn.nmh.hstudy.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.nmh.hstudy.R;

public class VocabularyFragment extends Fragment {
	public static final String TAG = "VocabularyFragment";
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.vocabulary_fragment, container,
				false);

		// Inflate the layout for this fragment
		return rootView;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}
