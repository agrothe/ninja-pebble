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

import ninja.NinjaTest;
import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class FilterControllerTest extends NinjaTest {

    final String URL_FILTER = "/filter";


    @Test
    public void testWhenAcceptLanguageHeaderIsSentAndExistsFileForThatLanguageThenTheExistingFileIsUsed() {
        // When
        String result = ninjaTestBrowser.makeRequest(getServerAddress() + URL_FILTER, Collections.<String, String>emptyMap());

        // Then
        assertThat(result, containsString("this is a to test the use of a filter.".toUpperCase()));
    }
}
