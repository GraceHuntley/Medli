package com.biomarkhealth.medli.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.biomarkhealth.medli.R;
import com.biomarkhealth.medli.models.doses.ConceptProperty;

import java.util.List;

/**
 * Created by cmac147 on 4/6/16.
 */
public class DoseSuggestionAdapter extends ArrayAdapter<ConceptProperty> {

    private List<ConceptProperty> data;

    public DoseSuggestionAdapter(Context context, int resource) {
        super(context, resource);
    }

    public DoseSuggestionAdapter(Context context, int resource, List<ConceptProperty> data) {
        super(context, resource, data);
        this.data = data;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.single_line_text, null);
        }

        TextView tv = (TextView) v.findViewById(R.id.option);

        tv.setText(getItem(position).getName());


        return v;
    }

}
