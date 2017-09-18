/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.device.mgt.mobile.windows.internal;

import org.wso2.carbon.device.mgt.mobile.windows.impl.WindowsTokenService;
import org.wso2.carbon.registry.core.service.RegistryService;

/**
 * DataHolder class of Mobile plugins component.
 */
public class WindowsDeviceManagementDataHolder {

	private RegistryService registryService;
	private WindowsTokenService tokenService;

	private static WindowsDeviceManagementDataHolder thisInstance = new WindowsDeviceManagementDataHolder();

	private WindowsDeviceManagementDataHolder() {
	}

	public static WindowsDeviceManagementDataHolder getInstance() {
		return thisInstance;
	}

	public RegistryService getRegistryService() {
		return registryService;
	}

	public void setRegistryService(RegistryService registryService) {
		this.registryService = registryService;
	}

	public WindowsTokenService getTokenService() {
		return tokenService;
	}

	public void setTokenService(WindowsTokenService tokenService) {
		this.tokenService = tokenService;
	}

	public static WindowsDeviceManagementDataHolder getThisInstance() {
		return thisInstance;
	}

	public static void setThisInstance(WindowsDeviceManagementDataHolder thisInstance) {
		WindowsDeviceManagementDataHolder.thisInstance = thisInstance;
	}
}
