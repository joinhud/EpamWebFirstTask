package com.epam.web.first.upload;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

public class FileUploader {
    private static final Logger LOG = LogManager.getLogger();

    private static final String UPLOAD_DIRECTORY = "uploadFiles";

    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

    private List<FileItem> formItems;
    private String uploadPath;

    public FileUploader(HttpServletRequest request) {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
        upload.setSizeMax(MAX_REQUEST_SIZE);

        uploadPath = request.getServletContext().getRealPath("") + UPLOAD_DIRECTORY;

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        try {
            formItems = upload.parseRequest(request);
        } catch (FileUploadException e) {
            LOG.log(Level.ERROR, e);
        }
    }

    public String upload(String attributeName) {
        String fileNameResult = null;

        try {
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if(item.getFieldName().equals(attributeName)) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        item.write(storeFile);
                        fileNameResult = fileName;
                    }
                }
            }
        } catch (Exception e) {
            LOG.log(Level.ERROR, e);
        }

        return fileNameResult;
    }

    public String getParameterValue(String param) {
        String result = null;

        if (formItems != null && formItems.size() > 0) {
            for (FileItem item : formItems) {
                if(item.getFieldName().equals(param)) {
                    result = item.getString();
                }
            }
        }

        return result;
    }
}
