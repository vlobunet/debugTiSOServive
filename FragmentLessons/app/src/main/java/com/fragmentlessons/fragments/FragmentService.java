package com.fragmentlessons.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fragmentlessons.MainActivity;
import com.fragmentlessons.R;
import com.fragmentlessons.adapters.ParameterAdapter;
import com.fragmentlessons.data.Parameter;
import com.fragmentlessons.mLog;

import java.util.ArrayList;

public class FragmentService extends Fragment {
    ArrayList<Parameter> parameters = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setInitialData();
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        ListView lv = view.findViewById(R.id.listService);
        ParameterAdapter adapter = new ParameterAdapter(view.getContext(), R.layout.card_view, parameters);
        lv.setAdapter(adapter);
        MainActivity.PrintMessage(mLog.INFO, "FragmentService", "setAdapter(adapter)");
        return view;
    }

    private void setInitialData() {
        parameters.add(new Parameter("PWM_START_SPEED", "скорость турникета при поиске ноля", "25", R.drawable.pwm, 25, 10, 150));
        parameters.add(new Parameter("PWM_MAX_SAFETY", "Ограничение максимального PWM", "200", R.drawable.pwm, 200, 1, 255));
        parameters.add(new Parameter("PWM_MIN_SPEED", "Минимальная рабочая скорость турникета", "10", R.drawable.pwm, 10, 2, 255));
        parameters.add(new Parameter("SPEED_MIN_FR", "нижняя граница минимальной скорости", "11", R.drawable.speed_min, 11, 2, 255));
        parameters.add(new Parameter("SPEED_MIN_TO", "верхняя граница минимальной скорости", "25", R.drawable.speed_min, 25, 2, 255));
        parameters.add(new Parameter("SPEED_NORM_FR", "Нижняя граница нормальной скорости", "26", R.drawable.speed_norm, 26, 2, 255));
        parameters.add(new Parameter("SPEED_NORM_TO", "Верхняя граница нормальной скорости", "50", R.drawable.speed_norm, 50, 2, 255));
        parameters.add(new Parameter("PWM_SOFT_LOCK", "PWM магнита или муфты для блокировки турникета", "255", R.drawable.pwm, 255, 1, 255));
        parameters.add(new Parameter("DEGREE_MAX_OPEN", "Значение угла при максимально открытом турникете", "95", R.drawable.degrees, 95, 1, 96));
        parameters.add(new Parameter("HYSTERESIS_OF_BREAKING_OPEN", "Размер поля торможения турникета при открытии", "15", R.drawable.degrees, 15, 1, 96));
        parameters.add(new Parameter("HYSTERESIS_OF_BREAKING_CLOSE", "Размер поля торможения турникета при закрытии", "20", R.drawable.degrees, 20, 1, 96));
        parameters.add(new Parameter("TIMER_OPEN_PASSAGE", "Время на совершение прохода", "200", R.drawable.timer, 200, 1, 255));
        MainActivity.PrintMessage(mLog.INFO, "FragmentService", "setInitialData()");
    }
}
