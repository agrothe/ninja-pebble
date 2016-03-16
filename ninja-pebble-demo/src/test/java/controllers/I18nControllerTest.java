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

import ninja.NinjaDocTester;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class I18nControllerTest extends NinjaDocTester {

    String URL_INDEX = "/i18n";

    String TEXT_EN = "Hello World";
    String TEXT_ES = "Hola Mundo";

    @Test
    public void testWhenAcceptLanguageHeaderIsSentAndExistsFileForThatLanguageThenTheExistingFileIsUsed() {

        Response response = makeRequest(
            Request.GET().addHeader("Accept-Language", "es-ES").url(
                testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString(TEXT_ES));
    }

    @Test
    public void testWhenAcceptLanguageHeaderIsNotSentThenDefaultLanguageFileIsUsed() {

        Response response = makeRequest(
            Request.GET().url(
                testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString(TEXT_EN));
    }

    @Test
    public void testWhenAcceptLanguageHeaderIsSentAndDoesNotExistFileForThatLanguageThenDefaultLanguageFileIsUsed() {

        Response response = makeRequest(
            Request.GET().addHeader("Accept-Language", "de-DE").url(
                testServerUrl().path(URL_INDEX)));

        assertThat(response.payload, containsString(TEXT_EN));
    }
}
