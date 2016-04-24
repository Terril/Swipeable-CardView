package com.andtinder.view;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andtinder.R;
import com.andtinder.model.CardModel;

public final class SimpleCardStackAdapter extends CardStackAdapter {

    Context context;

    public SimpleCardStackAdapter(Context mContext) {
        super(mContext);
        context = mContext;
    }

    @Override
    public View getCardView(int position, CardModel model, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.std_card_inner, parent, false);
            assert convertView != null;
        }
        ((ImageView) convertView.findViewById(R.id.image)).setImageDrawable(model.getCardImageDrawable());
        Typeface myTypefaceTitle = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Bold.ttf");
        Typeface myTypefaceDescription = Typeface.createFromAsset(context.getAssets(), "fonts/RobotoCondensed-Regular.ttf");
        TextView lblTitle = (TextView) convertView.findViewById(R.id.title);
        TextView lblDescription = (TextView) convertView.findViewById(R.id.description);
        lblTitle.setText(model.getTitle());
        lblTitle.setTypeface(myTypefaceTitle);
        lblDescription.setText(model.getDescription());
        lblDescription.setTypeface(myTypefaceDescription);
        return convertView;
    }
}
