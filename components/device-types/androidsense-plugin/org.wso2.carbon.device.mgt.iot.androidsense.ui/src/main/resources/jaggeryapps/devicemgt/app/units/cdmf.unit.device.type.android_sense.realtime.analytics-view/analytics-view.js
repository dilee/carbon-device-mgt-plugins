/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

function onRequest(context) {
    var log = new Log("stats.js");
    var carbonServer = require("carbon").server;
    var device = context.unit.params.device;

    // graph configuration
    var graphData = {
        Sensors:["accelerometer","magnetic", "gravity", "pressure", "proximity", "gyroscope"],
        Realtime_Data:['battery','light','rotation']
    };
    var devicemgtProps = require("/app/modules/conf-reader/main.js")["conf"];
    var constants = require("/app/modules/constants.js");
    var userModule = require("/app/modules/business-controllers/user.js")["userModule"];
    var websocketEndpoint = devicemgtProps["wssURL"].replace("https", "wss");
    var jwtService = carbonServer.osgiService(
        'org.wso2.carbon.identity.jwt.client.extension.service.JWTClientManagerService');
    var jwtClient = jwtService.getJWTClient();
    var encodedClientKeys = session.get(constants["ENCODED_TENANT_BASED_WEB_SOCKET_CLIENT_CREDENTIALS"]);
    var token = "";
    var tokenPair = null;
    var user = userModule.getCarbonUser();
    var tenantDomain = user.domain;
    if (encodedClientKeys) {
        var tokenUtil = require("/app/modules/oauth/token-handler-utils.js")["utils"];
        var resp = tokenUtil.decode(encodedClientKeys).split(":");
        if (tenantDomain == "carbon.super") {
            tokenPair = jwtClient.getAccessToken(resp[0], resp[1], context.user.username,"default", {});
            if (tokenPair) {
                token = tokenPair.accessToken;
            }
            websocketEndpoint = websocketEndpoint + "/secured-websocket/org.wso2.iot.android.sense/1.0.0?" +
                "deviceId=" + device.deviceIdentifier + "&deviceType=" + device.type + "&websocketToken=" + token;
        } else {
            tokenPair = jwtClient.getAccessToken(resp[0], resp[1], context.user.username + "@" + tenantDomain,"default", {});
            if (tokenPair) {
                token = tokenPair.accessToken;
            }
            websocketEndpoint = websocketEndpoint + "/secured-websocket/t/"+tenantDomain+"/org.wso2.iot.android.sense/1.0.0?" +
                "deviceId=" + device.deviceIdentifier + "&deviceType=" + device.type + "&websocketToken=" + token;
        }

    }
    return {"device": device, "websocketEndpoint": websocketEndpoint, "graphData":graphData};
}