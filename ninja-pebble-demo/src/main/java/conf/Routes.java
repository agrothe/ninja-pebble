/**
 * Copyright (C) 2016 the original author or authors.
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

package conf;


import controllers.DirectAccessController;
import controllers.FilterController;
import controllers.I18nController;
import ninja.AssetsController;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;

public class Routes implements ApplicationRoutes {

    private static final String INDEX_METHOD = "index";

    @Override
    public void init(Router router) {

        router.GET().route("/").with(ApplicationController.class, INDEX_METHOD);
        router.GET().route("/i18n").with(I18nController.class, INDEX_METHOD);
        router.GET().route("/direct").with(DirectAccessController.class, INDEX_METHOD);
        router.GET().route("/filter").with(FilterController.class, INDEX_METHOD);

        ///////////////////////////////////////////////////////////////////////
        // Assets (pictures / javascript)
        ///////////////////////////////////////////////////////////////////////    
        router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
        router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");

        ///////////////////////////////////////////////////////////////////////
        // Index / Catchall shows index page
        ///////////////////////////////////////////////////////////////////////
        router.GET().route("/.*").with(ApplicationController.class, "index");
    }

}
