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
import ninja.NinjaDocTester;
import ninja.NinjaTest;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class I18nControllerTest extends NinjaTest {

    final String URL_I18N = "/i18n";

    final String TEXT_EN = "Hello World";
    final String TEXT_ES = "Hola Mundo";

    @Test
    public void testWhenAcceptLanguageHeaderIsSentAndExistsFileForThatLanguageThenTheExistingFileIsUsed() {
        // Given
        Map<String, String> headers = Maps.newHashMap();
        headers.put("Accept-Language", "es-ES");

        // When
        String result = ninjaTestBrowser.makeRequest(getServerAddress() + URL_I18N, headers);

        // Then
        assertThat(result, containsString(TEXT_ES));
    }

    @Test
    public void testWhenAcceptLanguageHeaderIsNotSentThenDefaultLanguageFileIsUsed() {
        // Given
        Map<String, String> headers = Maps.newHashMap();

        // When
        String result = ninjaTestBrowser.makeRequest(getServerAddress() + URL_I18N, headers);

        // Then
        assertThat(result, containsString(TEXT_EN));
    }

    @Test
    public void testWhenAcceptLanguageHeaderIsSentAndDoesNotExistFileForThatLanguageThenDefaultLanguageFileIsUsed() {
        // Given
        Map<String, String> headers = Maps.newHashMap();
        headers.put("Accept-Language", "de-DE");

        // When
        String result = ninjaTestBrowser.makeRequest(getServerAddress() + URL_I18N, headers);

        // Then
        assertThat(result, containsString(TEXT_EN));
    }
}
