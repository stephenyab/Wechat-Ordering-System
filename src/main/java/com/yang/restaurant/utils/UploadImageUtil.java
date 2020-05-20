package com.yang.restaurant.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName UploadImageUtil
 * @Description
 * @Author yang
 * @Date 2020/5/19 18:11
 * @Version 1.0
 */
public class UploadImageUtil {

    public static Map<String, String> uploadImage(MultipartFile file, String filePath) {
        Map<String, String> ret = new HashMap<String, String>();

        // 文件名
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            ret.put("type", "error");
            ret.put("msg", "保存文件异常！");
            e.printStackTrace();
            return ret;
        }

        String photoUrl = "/images/product/" + fileName;

        ret.put("type", "success");
        ret.put("msg", "上传图片成功！");
        ret.put("photoUrl", photoUrl);

        return ret;
    }
}
