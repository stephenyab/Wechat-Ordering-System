package com.yang.restaurant.controller.adminmobile;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.utils.UploadImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName AdminMobileImageController
 * @Description
 * @Author yang
 * @Date 2020/5/19 18:06
 * @Version 1.0
 */
@Controller
@RequestMapping("/adminMobile/image")
public class AdminMobileImageController {

    @Autowired
    private ProjectUrl projectUrl;

    @ResponseBody
    @PostMapping(value = "/uploadPhoto")
    public Map<String, String> uploadPhoto(@RequestParam("photo") MultipartFile file) {
        Map<String, String> ret = new HashMap<String, String>();

        ret = UploadImageUtil.uploadImage(file, projectUrl.getImagesRealLocationsUrl());

        return ret;
    }

}
