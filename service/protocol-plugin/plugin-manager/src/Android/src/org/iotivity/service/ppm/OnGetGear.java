//******************************************************************
//
// Copyright 2015 Samsung Electronics All Rights Reserved.
//
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
//-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=

/// @file OnGetGear.java

/// @brief This class is OnGetListener for Gear.

package org.iotivity.service.ppm;

import java.util.List;

import org.iotivity.base.OcHeaderOption;
import org.iotivity.base.OcRepresentation;
import org.iotivity.base.OcResource;

import android.util.Log;

public class OnGetGear implements OcResource.OnGetListener {
    final private static String TAG = "OnGetGear";

    public void onGetCompleted(List<OcHeaderOption> headerOptions,
            OcRepresentation rep) {
        Log.i(TAG, "GET request Gear was successful");

        MainActivity.gearplug.m_name = rep.getValueString("name");
        MainActivity.gearplug.m_power = rep.getValueString("power");
        MainActivity.gearplug.m_bright = rep.getValueInt("brightness");
        MainActivity.gearplug.m_color = rep.getValueInt("color");
        MainActivity.gearplug.m_uri = rep.getValueString("uri");

        Log.i(TAG, "name : " + MainActivity.gearplug.m_name);
        Log.i(TAG, "power : " + MainActivity.gearplug.m_power);
        Log.i(TAG, "brightness : " + MainActivity.gearplug.m_bright);
        Log.i(TAG, "color : " + MainActivity.gearplug.m_color);
        Log.i(TAG, "uri : " + MainActivity.gearplug.m_uri);

        Log.e(TAG, "updating display from thread");

        MainActivity.mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                MainActivity.updateGearStatus();
            }
        });
    }
}
