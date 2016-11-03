package edu.utsa.cs.sefm.xposed.parameterdetector;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;

/**
 * Created by Rocky Slavin
 */


public class Main implements IXposedHookLoadPackage {

    private static final String TEST_PACKAGE = "com.example.sean.myapplication";

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if(!lpparam.packageName.equals(TEST_PACKAGE)) {
            return;
        }

        try {

            String className = "java.net.URL";
            String methodName = "nothing";
            // insert parameter types between classLoader and callback
            findAndHookConstructor(className, lpparam.classLoader, String.class, new XC_MethodHook() {
                String methodName;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName);
                }


                private XC_MethodHook init(String name){
                    this.methodName = name;
                    return this;
                }
            }.init(className));

//            className = "java.net.URL";
//            methodName = "URL";
//            // insert parameter types between classLoader and callback
//            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, new XC_MethodHook() {
//                String methodName;
//
//                @Override
//                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
//                }
//
//                @Override
//                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                    reportCall(param, methodName);
//                }
//
//                private XC_MethodHook init(String name){
//                    this.methodName = name;
//                    return this;
//                }
//            }.init(className + "." +methodName));

        } catch (NoSuchMethodError e) {
            XposedBridge.log("Couldn't find matching method in " + lpparam.packageName + ". Check parameters.");
        }

    }

    private static void reportCall(XC_MethodHook.MethodHookParam param, String methodName) {
        XposedBridge.log("== FOUND API CALL "+methodName+"() IN " + TEST_PACKAGE + " ==");
        if (param.args != null && param.args.length > 0)
            for (int i = 0; i < param.args.length; i++)
                XposedBridge.log("\tParameter[0]: " + param.args[i].toString());
    }
}
