var exec = require('cordova/exec');

var autoStart = {
  isAutoStartRequired: function (successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'isAutoStartRequired', 'isAutoStartRequired', []);
  },
  showAutoStartSettings: function(successCallback, errorCallback) {
    exec(successCallback, errorCallback, 'showAutoStartSettings', 'showAutoStartSettings', []);
  }
};

module.exports = autoStart;