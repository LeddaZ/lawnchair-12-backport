/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.launcher3.allapps.search;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.launcher3.BaseDraggingActivity;
import com.android.launcher3.allapps.AllAppsGridAdapter;

/**
 * A UI expansion wrapper providing for search results
 */
public abstract class SearchAdapterProvider {

    protected final BaseDraggingActivity mLauncher;

    public SearchAdapterProvider(BaseDraggingActivity launcher) {
        mLauncher = launcher;
    }

    /**
     * Called from RecyclerView.Adapter#onBindViewHolder
     */
    public abstract void onBindView(AllAppsGridAdapter.ViewHolder holder, int position);

    /**
     * Called from LiveSearchManager to notify slice status updates.
     */
    public abstract void onSliceStatusUpdate(Uri sliceUri);

    /**
     * Returns whether or not viewType can be handled by searchProvider
     */
    public abstract boolean isSearchView(int viewType);

    /**
     * Called from RecyclerView.Adapter#onCreateViewHolder
     */
    public abstract AllAppsGridAdapter.ViewHolder onCreateViewHolder(LayoutInflater layoutInflater,
            ViewGroup parent, int viewType);

    /**
     * Returns supported item per row combinations supported
     */
    public int[] getSupportedItemsPerRowArray() {
        return new int[]{};
    }

    /**
     * Returns how many cells a view should span
     */
    public int getItemsPerRow(int viewType, int appsPerRow) {
        return appsPerRow;
    }

    /**
     * handles selection event on search adapter item. Returns false if provider can not handle
     * event
     */
    public abstract boolean onAdapterItemSelected(AllAppsGridAdapter.AdapterItem adapterItem,
            View view);
}
