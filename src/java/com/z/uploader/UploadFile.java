/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.uploader;
 
import java.util.List;
import java.io.File;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import javax.servlet.http.HttpServletRequest;

public class UploadFile
{
    private String server_path;
    private String server_file;
    private String file_key;
    private HttpServletRequest request;
    
    public String getServer_path() {
        return this.server_path;
    }
    
    public String getFile_key() {
        return this.file_key;
    }
    
    public void setFile_key(final String file_key) {
        this.file_key = file_key;
    }
    
    public void setServer_path(final String server_path) {
        this.server_path = server_path;
    }
    
    public String getServer_file() {
        return this.server_file;
    }
    
    public void setServer_file(final String server_file) {
        this.server_file = server_file;
    }
    
    public HttpServletRequest getRequest() {
        return this.request;
    }
    
    public void setRequest(final HttpServletRequest request) {
        this.request = request;
    }
    
    public String uploadFile() {
        String msg = "";
        final String UPLOAD_DIRECTORY = this.server_path;
        if (ServletFileUpload.isMultipartContent(this.request)) {
            try {
                final List<FileItem> multiparts = (List<FileItem>)new ServletFileUpload((FileItemFactory)new DiskFileItemFactory()).parseRequest(this.request);
                for (final FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        this.server_file = this.file_key + new File(item.getName()).getName();
                        item.write(new File(UPLOAD_DIRECTORY + File.separator + this.server_file));
                    }
                }
                msg = "Photo Uploaded Successfully";
            }
            catch (Exception ex) {
                msg = "Photo Upload Failed due to " + ex;
            }
        }
        else {
            msg = "Sorry this Servlet only handles file upload request";
        }
        return msg;
    }
}
