package com.fragmentlessons.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.fragmentlessons.R;
import com.fragmentlessons.data.Parameter;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;
import java.util.List;

public class ParameterAdapter extends ArrayAdapter<Parameter> {
    private final LayoutInflater inflater;
    private final List<Parameter> parameters;
    private final int layout;
    SeekBar seekBar = null;
    TextView textViewValue;

    public ParameterAdapter(Context context, int resource, ArrayList<Parameter> parameters) {
        super(context, resource, parameters);
        this.parameters = parameters;
        this.inflater = LayoutInflater.from(context);
        this.layout = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        seekBar = convertView.findViewById(R.id.parameterProgress);
        textViewValue = convertView.findViewById(R.id.parameterValue);

        final Parameter parameter = parameters.get(position);

        viewHolder.icoView.setImageResource(parameter.getParameterIco());
        viewHolder.about.setText(parameter.getParameterAbout());
        viewHolder.name.setText(parameter.getParameterName());
        viewHolder.value.setText(parameter.getParameterValue());

        viewHolder.progress.setProgress(parameter.getParameterProgress());
        int max = parameter.getParameterMaxValue();
        int min = parameter.getParameterMinValue();
        viewHolder.progress.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int currentValue = 0;
            int newValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int delta = (progress - currentValue);
                if (Math.abs(delta) == 1) {
                    int v = Integer.parseInt(viewHolder.value.getText().toString());
                    if (v + delta <= max && v + delta >= min) {
                        newValue = Integer.parseInt(viewHolder.value.getText().toString()) + delta;
                        viewHolder.value.setText(String.valueOf(newValue));
                    }
                }
                currentValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                parameter.setParameterValue(String.valueOf(newValue));
            }
        });

        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in);
        convertView.startAnimation(animation);
        return convertView;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView icoView;
        final TextView name, about, value;
        final SeekBar progress;

        ViewHolder(View view) {
            super(view);
            icoView = view.findViewById(R.id.parameterIco);
            name = view.findViewById(R.id.parameterName);
            value = view.findViewById(R.id.parameterValue);
            about = view.findViewById(R.id.parameterAbout);
            progress = view.findViewById(R.id.parameterProgress);
        }
    }
}
