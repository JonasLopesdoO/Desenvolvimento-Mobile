package br.ufc.quixada.dadm.trabalho1.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import br.ufc.quixada.dadm.trabalho1.R;

public class ImageAdapter extends BaseAdapter {

    private Context mContext;

    private Integer[] mThumbIds = {
        R.drawable.android18, R.drawable.baby,
        R.drawable.android, R.drawable.bardock,
        R.drawable.frieza, R.drawable.gogeta,
        R.drawable.gokublack, R.drawable.gokuvegeta,
        R.drawable.goku, R.drawable.vegeta,
    };

    public ImageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {

            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
