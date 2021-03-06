package com.isep.group4.android_weather_forecast.echarts;

import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Line;
import com.github.abel533.echarts.series.Series;
import com.github.abel533.echarts.style.ItemStyle;

import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;
import com.github.abel533.echarts.code.AxisType;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.Label;

public class echartOption {

    public static GsonOption getLineChartOptions(Object[] minimumTem, Object[] maximumTem) {
        GsonOption option = new GsonOption();
        //        option.title("Linear Chart");
//        option.legend("销量");
//        option.tooltip().trigger(Trigger.axis);
        ValueAxis valueXAxis = new ValueAxis();
        valueXAxis.show(false);
        valueXAxis.type(AxisType.category);
        option.xAxis(valueXAxis);

        ValueAxis valueYAxis = new ValueAxis();
        valueYAxis.show(false);
        option.yAxis(valueYAxis);

        Line minimumLine = new Line();
        Label minimumLabel = new Label();
        minimumLabel.show(true).position("bottom");
        ItemStyle minimumStyle = new ItemStyle();
        minimumStyle.normal().label(minimumLabel);
        minimumLine.name("minimum").data(minimumTem).stack("Total");
        minimumLine.itemStyle(minimumStyle);



        Line maximumLine = new Line();
        Label maximumLable = new Label();
        maximumLable.show(true).position("top");
        ItemStyle maximumStyle = new ItemStyle();
        maximumStyle.normal().label(maximumLable);
        maximumLine.name("maximum").data(maximumTem).stack("Total").areaStyle();
        maximumLine.itemStyle(maximumStyle);

        option.series(minimumLine,maximumLine);

        return option;
    }
}