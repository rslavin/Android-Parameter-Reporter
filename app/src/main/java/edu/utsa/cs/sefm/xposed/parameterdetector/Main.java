package edu.utsa.cs.sefm.xposed.parameterdetector;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

/**
 * Created by Rocky Slavin
 */


public class Main implements IXposedHookLoadPackage {

    private static final List<String> TEST_PACKAGES = Arrays.asList(
            "com.example.sean.myapplication",
            "cc.pacer.androidapp",
            "com.dayspringtech.envelopes",
            "com.dietcoacher.sos",
            "com.droid4you.application.wallet",
            "com.fitnow.loseit",
            "com.fooducate.nutritionapp",
            "com.mint"
    );

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        String thisPackageName;
        String className;
        String methodName;
        List<Integer> paramIndices;
        int index;

        if ((index = TEST_PACKAGES.indexOf(lpparam.packageName)) < 0)
            return;

        thisPackageName = TEST_PACKAGES.get(index);

        try {

            /**
             * For each method/constructor hook, create a findAndHookMethod of findAndHookConstructor
             * method below. Make sure to update the className, methodName (not necessary for 
             * constructors), paramIndices, and each parameter type the findAndHook* method.
             *
             * Example: If looking for the second parameter of 
             * package.name.Foo.bar(String param1, Object param2, boolean param3), your
             * method signature will look like: 
             *
             * classname = "package.name.Foo";
             * methodName = "bar"; // set to "" for constructors
             * paramIndices = Arrays.asList(1); // zero-indexed
             * findAndHookMethod(className, lpparam.classLoader, methodName, String.class, Object.class, "boolean", new ...)
             */
             
             //TODO pass Object[] array where findAndHook... takes parameters. This will allow you to
             //TODO loop through a predefined List of methods instead of using a code generator

            /*********************************************/
            /**             PASTE CODE BELOW            **/
            /*********************************************/

            className = "java.net.URL";
            methodName = null;
            paramIndices = Arrays.asList(0);
            findAndHookConstructor(className, lpparam.classLoader, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName != null)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpGet";
            methodName = null;
            paramIndices = Arrays.asList(0);
            findAndHookConstructor(className, lpparam.classLoader, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName != null)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpPost";
            methodName = null;
            paramIndices = Arrays.asList(0);
            findAndHookConstructor(className, lpparam.classLoader, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName != null)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            // TODO figure out how to find the implementation of this interface. Xposed cannot hook interfaces directly.
            className = "org.apache.http.HttpEntityEnclosingRequest";
            methodName = "setEntity";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, HttpEntity.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName != null)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.impl.client.DefaultHttpClient";
            methodName = "execute";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, HttpUriRequest.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpPost";
            methodName = "setEntity";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, HttpEntity.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpGet";
            methodName = null;
            paramIndices = Arrays.asList(0);
            findAndHookConstructor(className, lpparam.classLoader, URI.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpRequestBase";
            methodName = "setHeader";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpGet";
            methodName = "setURI";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, URI.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));
            // END HOOK

            className = "org.apache.http.params.HttpParams";
            methodName = "setParameter";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, Object.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpPost";
            methodName = "setHeader";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.message.BasicNameValuePair";
            methodName = null;
            paramIndices = Arrays.asList(0, 1);
            findAndHookConstructor(className, lpparam.classLoader, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.methods.HttpPost";
            methodName = "addHeader";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            /*className = "java.net.URL";
            methodName = "openConnection";
            paramIndices = Arrays.asList(0); // STATIC!
            // insert parameter types between classLoader and callback
            findAndHookMethod(className, lpparam.classLoader, methodName, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(XC_MethodHook.MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));
*/
            // END HOOK

            className = "org.apache.http.HttpResponse";
            methodName = "setEntity";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, HttpEntity.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "com.loopj.android.http.RequestParams";
            methodName = "put";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.client.HttpClient";
            methodName = "execute";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, HttpUriRequest.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "com.loopj.android.http.RequestParams";
            methodName = "add";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "org.apache.http.message.BasicHeader";
            methodName = null;
            paramIndices = Arrays.asList(0, 1);
            findAndHookConstructor(className, lpparam.classLoader, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "com.squareup.okhttp.Request$Builder";
            methodName = "url";
            paramIndices = Arrays.asList(0);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            className = "com.squareup.okhttp.Request$Builder";
            methodName = "addHeader";
            paramIndices = Arrays.asList(0, 1);
            findAndHookMethod(className, lpparam.classLoader, methodName, String.class, String.class, new XC_MethodHook() {
                String methodName;
                String packageName;
                List<Integer> paramIndices;

                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                }

                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    reportCall(param, methodName, packageName, paramIndices);
                }

                private XC_MethodHook init(String name, String methodName, String packageName, List<Integer> paramIndices) {
                    if (methodName.length() > 0)
                        this.methodName = name + "." + methodName;
                    else
                        this.methodName = name;
                    this.packageName = packageName;
                    this.paramIndices = paramIndices;
                    return this;
                }
            }.init(className, methodName, thisPackageName, paramIndices));

            // END HOOK

            /*********************************************/
            /**             END PASTED CODE             **/
            /*********************************************/

        } catch (NoSuchMethodError e) {
            XposedBridge.log("Couldn't find matching method in " + lpparam.packageName + ". Check parameters.");
        }

    }

    private static void reportCall(XC_MethodHook.MethodHookParam param, String methodName, String packageName, List<Integer> paramIndices) {
        XposedBridge.log(">>> FOUND API CALL <<<\n\tApp:\t\t" + packageName + "\n\tMethod called:\t" + methodName);
        if (param.args != null && param.args.length > 0)
            for (int i = 0; i < param.args.length; i++)
                if (paramIndices.indexOf(i) >= 0)
                    XposedBridge.log("\tParameter[" + i + "]:\t" + param.args[i].toString());
        XposedBridge.log("\n");
    }
}
