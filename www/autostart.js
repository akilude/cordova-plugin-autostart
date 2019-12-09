
var argscheck = require('cordova/argscheck');
var channel = require('cordova/channel');
var exec = require('cordova/exec');
var cordova = require('cordova');


window.doesDeviceNeedAutoStart = function( callback) {
    exec(successCallback, errorCallback, 'isAutoStartRequired', 'isAutoStartRequired', []);
};


window.isAutoStartRequired = function(successCallback, errorCallback){
    exec(successCallback, errorCallback, 'showAutoStartSettings', 'showAutoStartSettings', []);
}