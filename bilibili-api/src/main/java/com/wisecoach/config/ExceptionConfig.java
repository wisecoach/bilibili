package com.wisecoach.config;

public class ExceptionConfig {
    public final static int MEMBER_NOT_LOGIN_CODE = 4000;
    public final static String MEMBER_NOT_LOGIN_MSG = "请登录";

    public final static int MEMBER_MISSING_CODE = 4001;
    public final static String MEMBER_MISSING_MSG = "该成员不存在";

    public final static int PASSPORT_ERROR_CODE = 4002;
    public final static String PASSPORT_ERROR_MSG = "账号或者密码错误";

    public final static int REGISTER_MESSAGE_CODE = 4003;
    public final static String REGISTER_MESSAGE_MSG = "注册信息有误";

    public final static int ARCHIVE_MISSING_CODE = 4100;
    public final static String ARCHIVE_MISSING_MSG = "该投稿不存在";

    public final static int CHAT_MISSING_CODE = 4200;
    public final static String CHAT_MISSING_MSG = "该视频不存在";

    public final static int CHAT_CONFLICT_CODE = 4201;
    public final static String CHAT_CONFLICT_MSG = "该视频不属于该投稿";

    public final static int FAV_FOLDER_MISSING_CODE = 4300;
    public final static String FAV_FOLDER_MISSING_MSG = "该收藏夹不存在";

    public final static int COIN_LACK_CODE = 4500;
    public final static String COIN_LACK_MSG = "您的硬币不够";

    public final static int TOKEN_VERIFIED_CODE = 4800;
    public final static String TOKEN_VERIFIED_MSG = "token验证错误,请重新登录";

    public final static int NOT_MANAGER_CODE = 4700;
    public final static String NOT_MANAGER_MSG = "您并非管理员账户";

    public final static int VERIFY_BLOCK_CODE = 4701;
    public final static String VERIFY_BLOCK_MSG = "该审核条目已经被其他管理员接受审核";

    public final static int REMOTE_SHELL_CODE = 5000;
    public final static String REMOTE_SHELL_MSG = "远程控制出错了";
}
