package com.bvutest.mlkit.example.object;
/*
 * Copyright 2020. Huawei Technologies Co., Ltd. All rights reserved.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import android.util.SparseArray;

import com.huawei.hms.mlsdk.common.MLAnalyzer;
import com.huawei.hms.mlsdk.objects.MLObject;
import com.bvutest.mlkit.example.camera.GraphicOverlay;

public class ObjectAnalyzerTransactor implements MLAnalyzer.MLTransactor<MLObject> {
    private GraphicOverlay mGraphicOverlay;

    ObjectAnalyzerTransactor(GraphicOverlay ocrGraphicOverlay) {
        mGraphicOverlay = ocrGraphicOverlay;
    }

    @Override
    public void transactResult(MLAnalyzer.Result<MLObject> result) {
        mGraphicOverlay.clear();
        SparseArray<MLObject> objectSparseArray = result.getAnalyseList();
        for (int i = 0; i < objectSparseArray.size(); i++) {
            MLObjectGraphic graphic = new MLObjectGraphic(mGraphicOverlay, objectSparseArray.valueAt(i));
            mGraphicOverlay.add(graphic);
        }
    }

    @Override
    public void destroy() {
        mGraphicOverlay.clear();
    }

}
