package com.zzb.test.admin.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * oss文件上传成功后回调结果
 * Created by zzb on 2019/12/24 15:20
 */
@Getter
@Setter
public class OssCallbackResult {

    @ApiModelProperty("文件名称")
    private String fileName;
    @ApiModelProperty("文件大小")
    private String size;
    @ApiModelProperty("文件的mimeType")
    private String mimeType;
    @ApiModelProperty("图片文件的宽")
    private String width;
    @ApiModelProperty("图片文件的高")
    private String height;
}
