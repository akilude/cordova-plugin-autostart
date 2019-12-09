var exec = require('cordova/exec');

var autoStart = {
  doesDeviceNeedAutoStart: function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'isAutoStartRequired', 'isAutoStartRequired', []);
  },
  isAutoStartRequired: function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'showAutoStartSettings', 'showAutoStartSettings', []);
  }
};

module.exports = autoStart;