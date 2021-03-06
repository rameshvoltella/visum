/*
 * Copyright (C) 2017 Renat Sarymsakov.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.reist.sandbox.app;

import android.app.Application;

import io.reist.visum.ComponentCache;
import io.reist.visum.ComponentCacheProvider;

/**
 * Created by Reist on 10/16/15.
 */
public class SandboxApplication extends Application implements ComponentCacheProvider {

    private ComponentCache componentCache;

    @Override
    public ComponentCache getComponentCache() {
        if (componentCache == null) {
            componentCache = new SandboxComponentCache(this);
        }
        return componentCache;
    }

    public void setComponentCache(ComponentCache componentCache) {
        this.componentCache = componentCache;
    }

}
