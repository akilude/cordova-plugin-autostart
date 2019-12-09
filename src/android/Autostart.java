package com.everycrave.autostart;

import java.util.TimeZone;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.provider.Settings;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.ComponentName;
import android.content.pm.ResolveInfo;
import java.util.List;
import android.content.Context;

import android.widget.Toast;

public class Autostart extends CordovaPlugin {

    /**
     * Constructor.
     */
    

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    
        Context context = this.cordova.getActivity().getApplicationContext();
        
        if(action.equalsIgnoreCase("isAutoStartRequired")){
            
            Toast.makeText(context, "Hello World!", Toast.LENGTH_LONG).show();

            String manufacturer = android.os.Build.MANUFACTURER;

            String autoStartRequired = "false";

            switch (manufacturer) {
                case "xiaomi":
                    autoStartRequired = "true";
                    break;
                case "oppo":
                    autoStartRequired = "true";
                    break;
                case "vivo":
                    autoStartRequired = "true";
                    break;
            }
            callbackContext.success(autoStartRequired);   
            return true; 
        }


        if(action.equalsIgnoreCase("showAutoStartSettings")){

            Intent intent = new Intent();

            String manufacturer = android.os.Build.MANUFACTURER;

            switch (manufacturer) {
                case "xiaomi":
                  intent.setComponent(new ComponentName("com.miui.securitycenter","com.miui.permcenter.autostart.AutoStartManagementActivity"));
                  break;
                case "oppo":
                  intent.setComponent(new ComponentName("com.coloros.safecenter","com.coloros.safecenter.permission.startup.StartupAppListActivity"));
                  break;
                case "vivo":
                  intent.setComponent(new ComponentName("com.vivo.permissionmanager","com.vivo.permissionmanager.activity.BgStartUpManagerActivity"));
                  break;
            }

            List<ResolveInfo> arrayList =  context.getPackageManager().queryIntentActivities(intent,PackageManager.MATCH_DEFAULT_ONLY);

            if (arrayList.size() > 0) {
                context.startActivity(intent);
            }

            callbackContext.success("true");   
            return true; 
        }
        
        return false;
    }

}
