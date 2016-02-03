package vn.nmh.hstudy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SnackbarFragment extends Fragment {
	public SnackbarFragment() {
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.snack_bar_fragment, container,
				false);

		// Inflate the layout for this fragment
		return rootView;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}
}
