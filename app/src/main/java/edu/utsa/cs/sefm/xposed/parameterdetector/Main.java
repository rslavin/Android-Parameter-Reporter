package edu.utsa.cs.sefm.xposed.parameterdetector;

import org.apache.commons.lang3.ArrayUtils;

import java.util.List;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookConstructor;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static edu.utsa.cs.sefm.xposed.parameterdetector.SearchCriteria.PACKAGES;
import static edu.utsa.cs.sefm.xposed.parameterdetector.SearchCriteria.SEARCH_CRITERIA;

/**
 * Created by Rocky Slavin
 */

public class Main implements IXposedHookLoadPackage {

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if (PACKAGES.indexOf(lpparam.packageName) < 0)
            return;

        for (List criteria : SEARCH_CRITERIA) {
            try {
                String className = (String) criteria.get(0);
                String methodName = (String) criteria.get(1);
                List<Integer> paramIndices = (List<Integer>) criteria.get(2);
                Object paramTypes[] = (Object[]) criteria.get(3);

                // combine arguments with callback so varargs works correctly
                Object args[] = ArrayUtils.addAll(paramTypes, new XC_MethodHook() {
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
                        if (methodName != null && methodName.length() > 0)
                            this.methodName = name + "." + methodName;
                        else
                            this.methodName = name;
                        this.packageName = packageName;
                        this.paramIndices = paramIndices;
                        return this;
                    }
                }.init(className, methodName, lpparam.packageName, paramIndices));

                if (methodName == null) { // constructor
                    findAndHookConstructor(className, lpparam.classLoader, args);
                } else { // method
                    findAndHookMethod(className, lpparam.classLoader, methodName, args);
                }
            } catch (NoSuchMethodError e) {
                XposedBridge.log("Couldn't find matching method in " + lpparam.packageName + ". Check parameters.");
            }
        }
    }

    /**
     * Print API call to log. Grep "Xposed" to find output.
     */
    private static void reportCall(XC_MethodHook.MethodHookParam param, String methodName, String packageName, List<Integer> paramIndices) {
        XposedBridge.log(">>> FOUND API CALL <<<\n\tApp:\t\t" + packageName + "\n\tMethod called:\t" + methodName);
        if (param.args != null && param.args.length > 0)
            for (int i = 0; i < param.args.length; i++)
                if (paramIndices.indexOf(i) >= 0)
                    XposedBridge.log("\tParameter[" + i + "]:\t" + (param.args[i] == null ? "null" : param.args[i].toString()));
        XposedBridge.log("\n");
    }
}