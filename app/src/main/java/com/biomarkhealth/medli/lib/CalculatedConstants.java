package com.biomarkhealth.medli.lib;

import com.biomarkhealth.medli.utils.CommonUtil;

/**
 * Created by cmac147 on 3/25/16.
 */
public class CalculatedConstants {

    private int deviceHeight = 0;
    private int deviceWidth = 0;

    public int EXPLORE_ICON_HEIGHT = 0;
    public int EXPLORE_ICON_WIDTH = 0;

    static CalculatedConstants instance;

    private CalculatedConstants() {


        deviceWidth = CommonUtil.deviceDimensions().x;
        deviceHeight = CommonUtil.deviceDimensions().y;

        EXPLORE_ICON_WIDTH = (int) Math.floor(deviceWidth * (45.0 / 500.0));
        EXPLORE_ICON_HEIGHT = EXPLORE_ICON_WIDTH;
    }

    public static CalculatedConstants getInstance() {
        if (instance == null) instance = new CalculatedConstants();
        return instance;
    }
}
