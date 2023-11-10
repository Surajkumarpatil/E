package com.infy.employee.ServiceImpl;

import com.infy.employee.Entity.Employee;
import com.infy.employee.Repo.EmployeeRepo;
import com.infy.employee.Service.UploadFileService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class UploadFileServiceImpl implements UploadFileService {

    @Autowired
    private EmployeeRepo repo;

}
