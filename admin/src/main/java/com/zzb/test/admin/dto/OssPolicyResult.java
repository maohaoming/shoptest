package com.zzb.test.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 文件上传时，前端所需的参数
 * Created by zzb on 2019/12/24 15:08
 */
@Getter
@Setter
public class OssPolicyResult {

    @ApiModelProperty("访问阿里云身份认证")
    private String accessKeyId;
    @ApiModelProperty("用户表单上传的策略，经过base64编码的字符串")
    private String policy;
    @ApiModelProperty("对policy签名后的字符串")
    private String signature;
    @ApiModelProperty("上传文件夹路径前缀")
    private String dir;
    @ApiModelProperty("oss对外服务的访问域名")
    private String host;
    @ApiModelProperty("上传成功后的回调设置")
    private String callBack;
}
