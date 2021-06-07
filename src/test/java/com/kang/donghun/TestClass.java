package com.kang.donghun;


import com.kang.donghun.repository.UploadFileRepository;
import com.kang.donghun.service.ImageService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootTest
public class TestClass {


    @Autowired
    UploadFileRepository uploadFileRepository;

    private final String rootLocation = "d:/image/"; // d:/image/



    @Test
    public void stest(){

    }

}
