package vn.nmh.hstudy.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import vn.nmh.hstudy.R;
import vn.nmh.hstudy.models.Category;
import vn.nmh.hstudy.models.Items;

public class VocabularyFragment extends Fragment implements View.OnClickListener{
	public static final String TAG = "VocabularyFragment";
	private Button mBtnInserData;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.vocabulary_fragment, container,
				false);
		mBtnInserData = (Button)rootView.findViewById(R.id.vocabulary_btn_insert_data);
		mBtnInserData.setOnClickListener(this);
		// Inflate the layout for this fragment
		return rootView;
	}

	@Override
	public void onDetach() {
		super.onDetach();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.vocabulary_btn_insert_data:
				Category category = new Category();
				category.name = "Hieu";
				category.save();

				Items items = new Items();
				items.category = category;
				items.name = "Minh";
				items.save();
				break;
			default:
				break;
		}
	}
}
