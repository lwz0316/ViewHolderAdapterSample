package com.lwz.android.viewholderadapter.sample;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.lwz.android.viewholderadapter.ViewHolderAdapter;

public class MainActivity extends ListActivity {

	private ViewHolderAdapter<Lamp> mAdapter;
	private List<Lamp> mData;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		initData();
		createAdapter();
		setListAdapter(mAdapter);
		
		mAdapter.update(mData);
	}

	private void initData() {
		mData = new ArrayList<Lamp>();
		for( int i=0; i<20; i++ ) {
			Lamp lamp = new Lamp();
			lamp.setTurnon(false);
			lamp.setType("room " + i);
			mData.add(lamp);
		}
	}

	private void createAdapter() {
		mAdapter = new LampAdapter(this, R.layout.item_list);
	}


	class LampAdapter extends ViewHolderAdapter<Lamp> {

		public LampAdapter(Context context, int layoutRes) {
			super(context, layoutRes);
		}

		@Override
		protected void bindData(int pos, final Lamp itemData) {
			
			// get view from ViewHolder	
			TextView type = getViewFromHolder(R.id.title);
			final CheckBox checkBox= getViewFromHolder(R.id.checkBox);
			
			type.setText(itemData.getType());
			checkBox.setChecked(itemData.isTurnon());
			updateCheckBoxStatus(checkBox, itemData.isTurnon());
			
			checkBox.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					itemData.setTurnon(!itemData.isTurnon());
					updateCheckBoxStatus(checkBox, itemData.isTurnon());
				}
			});
		}
		
		private void updateCheckBoxStatus(CheckBox checkBox, boolean isTurnOn) {
			checkBox.setText( isTurnOn ? "ON" : "OFF" );
		}

	}
}
