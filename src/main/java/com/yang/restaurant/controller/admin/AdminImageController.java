package com.yang.restaurant.controller.admin;

import com.yang.restaurant.config.ProjectUrl;
import com.yang.restaurant.utils.UploadImageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName AdminImageController
 * @Description
 * @Author yang
 * @Date 2020/5/18 11:19
 * @Version 1.0
 */
@Slf4j
@Controller
@RequestMapping("/admin/image")
public class AdminImageController {

    @Autowired
    private ProjectUrl projectUrl;

    @ResponseBody
    @PostMapping(value = "/uploadPhoto")
    public Map<String, String> uploadPhoto(@RequestParam("photo") MultipartFile file, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();

        ret = UploadImageUtil.uploadImage(file, projectUrl.getImagesRealLocationsUrl());

        return ret;
    }
}
