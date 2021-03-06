/**Extension extension
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

package ninja.pebble;

import com.google.inject.AbstractModule;
import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.extension.Extension;
import ninja.pebble.template.TemplateEnginePebble;

public class NinjaPebbleModule extends AbstractModule {

  private Extension[] extensions;

  public NinjaPebbleModule() {}

  public NinjaPebbleModule(Extension... extensions) {
    this.extensions = extensions;
  }

  @Override
  protected void configure() {

    if (extensions == null) {
      bind(PebbleEngine.class).toProvider(PebbleEngineProvider.class);
    } else {
      bind(PebbleEngine.class).toProvider(new PebbleEngineProvider(extensions));
    }
    bind(TemplateEnginePebble.class);
  }
}
