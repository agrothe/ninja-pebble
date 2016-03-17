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

package controllers;


import com.google.common.collect.Maps;
import ninja.NinjaTest;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class DirectAccessControllerTest extends NinjaTest {
    
    final String URL_INDEX = "/direct";
    
    @Test
    public void testWhenDirectAccessToTemplateThenEverythingIsProperlyRendered() {

        // Given
        Map<String, String> headers = Maps.newHashMap();

        // When
        String result = ninjaTestBrowser.makeRequest(getServerAddress() + URL_INDEX, headers);

        // Then
        assertThat(result, containsString("Direct access to template by " + ApplicationController.NAME));

    }
}
