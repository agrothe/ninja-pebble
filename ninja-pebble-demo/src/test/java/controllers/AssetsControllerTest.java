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
import org.apache.http.HttpResponse;
import org.doctester.testbrowser.Request;
import org.doctester.testbrowser.Response;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AssetsControllerTest extends NinjaTest {

	final String URL_ASSEST_DXF_MIMETYPE = "assets/files/test_for_mimetypes.dxf";

	@Test
	public void testWhenRequestingAssetThenReturnsTheProperMimeType() {
		// Given
		Map<String, String> headers = Maps.newHashMap();

		// When
		HttpResponse httpResponse = ninjaTestBrowser.makeRequestAndGetResponse(getServerAddress() + URL_ASSEST_DXF_MIMETYPE, headers);

		// Then
		assertThat(httpResponse.getHeaders("Content-Type")[0].getValue(), is(equalTo("application/dxf; charset=UTF-8")));
	}
	
}
