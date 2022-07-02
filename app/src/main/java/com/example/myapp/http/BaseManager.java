package com.example.myapp.http;


/**
 * 子工程必须优先初始化{@link #setIApplication(IApplication)}
 * 调用后才能调用拿相关参数
 * Created by xunuo on 2016/2/29.
 */
public class BaseManager {

    private BaseManager() {
    }

    private static class BaseManagerHolder {
        private static BaseManager instance = new BaseManager();
    }

    public static BaseManager getInstance() {
        return BaseManagerHolder.instance;
    }

    private boolean isDebug;

    public boolean isDebug() {
        return isDebug;
    }

    public BaseManager setDebug(boolean b) {
        isDebug = b;
        return BaseManagerHolder.instance;
    }

    public boolean hasRandomSalt() {
        return hasRandomSalt;
    }

    public void setRandomSalt(boolean hasRandomSalt) {
        this.hasRandomSalt = hasRandomSalt;
    }

    /**
     * 签名带随机盐值
     */
    private boolean hasRandomSalt;

    public boolean hasParamService() {
        return hasParamService;
    }

    public void setParamService(boolean hasParamService) {
        this.hasParamService = hasParamService;
    }

    /**
     * 带service参数
     */
    private boolean hasParamService;

   /* private IAccountManager accountManager;

    public IAccountManager getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(IAccountManager accountManager) {
        this.accountManager = accountManager;
    }*/

    public void setIApplication(IApplication iApplication) {
        //setAccountManager(iApplication.getAccountManager());
        setDebug(iApplication.isDebug());
        setRandomSalt(iApplication.hasRandomSalt());
        setParamService(iApplication.hasParamService());
    }

    public interface IApplication {

        boolean hasRandomSalt();

        boolean hasParamService();


        //IAccountManager getAccountManager();

        boolean isDebug();
    }

}
