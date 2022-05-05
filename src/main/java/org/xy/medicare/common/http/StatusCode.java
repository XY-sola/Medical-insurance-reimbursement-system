package org.xy.medicare.common.http;

/**
 * @description:
 * @author: XY-GYL
 * @time: 2022/5/5 8:09
 */

public enum StatusCode {
    C200, // 正常
    C401, // 认证不通过
    C404, // 未找到资源
    C405, // 权限不足
    C500; // 服务异常
}
