package com.ufo.learnfrance.fragment;

import com.ufo.learnfrance.MainActivity;
import com.ufo.learnfrance.R;
import com.ufo.learnfrance.adapter.PhraseDetailAdapter;
import com.ufo.learnfrance.adapter.PhraseListAdapter;
import com.ufo.learnfrance.database.Database;
import com.ufo.learnfrance.utils.Utils;

import android.app.Fragment;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SearchPhragment extends ExpandableFragment{
	
	TextView txtNoResult;
	
	String mTitle = "";
	
	String mKeyword;
	
	
	boolean isFound = false;
	
	public SearchPhragment(String query) {
		mKeyword = query;
		
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		liPhraseItems = mDatabase.searchPhrase2(mKeyword);
		this.mCursor =  mDatabase.searchPhrase(mKeyword);
		if(mCursor != null && mCursor.getCount() > 0)
			isFound = true;
		
		if(isFound)
			mPhraseListAdapter  = new PhraseListAdapter(mActivity, liPhraseItems, R.layout.phrase_detail_item_2, mDatabase);
	}
	
	public void updateResult(String query){
		this.liPhraseItems = mDatabase.searchPhrase2(query);
		this.mPhraseListAdapter.updateListPhraseItems(liPhraseItems);
		mPhraseListAdapter.setPositionSelected(-1);
		mListView.setItemChecked(currentPosition,false);
		currentPosition = -1;
		previousView = null;
		mActivity.setTitle("Search for: "+query);
	}
	
	
	@Override
	public void onResume() {
//		mActivity.hideBannerAd();
		super.onResume();
		mActivity.setTitle("Search for: "+mKeyword);
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		mActivity.clearSearchView();
//		mActivity.increaseCounter();
		
	}

}
