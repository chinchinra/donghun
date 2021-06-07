package com.kang.donghun.repository;

import com.kang.donghun.dto.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile,Long> {
}
