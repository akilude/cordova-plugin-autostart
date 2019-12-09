
var argscheck = require('cordova/argscheck');
var channel = require('cordova/channel');
var exec = require('cordova/exec');
var cordova = require('cordova');

channel.createSticky('onCordovaInfoReady');
// Tell cordova channel to wait on the CordovaInfoReady event
channel.waitForInitialization('onCordovaInfoReady');


module.exports = {
    doesDeviceNeedAutoStart: function (successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'isAutoStartRequired', 'isAutoStartRequired', []);
    };

    isAutoStartRequired: function(successCallback, errorCallback){
        exec(successCallback, errorCallback, 'showAutoStartSettings', 'showAutoStartSettings', []);
    }
};
