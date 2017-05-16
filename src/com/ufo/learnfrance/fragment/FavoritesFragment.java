package com.ufo.learnfrance.fragment;

import com.ufo.learnfrance.R;
import com.ufo.learnfrance.adapter.PhraseListAdapter;
import android.os.Bundle;

public class FavoritesFragment extends ExpandableFragment {
		
	int categoryId;
	
	String mTitle = "";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		this.mTitle  = mActivity.getResources().getString(R.string.favorite_title);
		
		liPhraseItems = mDatabase.getListPhraseFavorite2();
		
		mPhraseListAdapter = new PhraseListAdapter(mActivity, liPhraseItems, R.layout.phrase_detail_item_2, mDatabase);
//		mActivity.increaseCounter();
	}
	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		mActivity.showBannerAd();
		mActivity.setTitle(mTitle);
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mActivity.increaseCounter();
		
	}
}
