package com.hk.oa.common.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shisan
 * @version V1.0.0
 * @Package com.hk.insurance.common.rest
 * @ClassName: FileController
 * @Description:
 * @date 2018年11月29日 15:20
 */
public class FileController {

   /* @Autowired
    private HttpServletResponse response;

    *//**
     * 并不是每个服务都需要文件上传，所以设置为required = false
     *//*
    @Autowired(required = false)
    private FileUploadFeign fileUploadFeign;

    *//**
     * 获取上传的文件为Map
     * @auth Shisan
     * @param maxSize
     * @return
     * @throws Exception
     *//*
    protected final Map<String, MultipartFile> getUpdateFiles (HttpServletRequest request, Long maxSize) throws Exception{
        CommonsMultipartResolver mResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        Map<String, MultipartFile> files = new LinkedHashMap<>();
        if(mResolver.isMultipart(request)){
            MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest) request;
            Iterator<String> fileNames = mRequest.getFileNames();
            MultipartFile mFile;
            String fileName;
            while(fileNames.hasNext()) {
                fileName = fileNames.next();
                mFile = mRequest.getFile(fileName);
                if(maxSize != null && maxSize > 0){
                    AssertUtil.valid(mFile.getBytes().length <= maxSize,"文件大小超过了限制！");
                }
                files.put(fileName,mFile);
            }
        }
        return files;
    }

    *//**
     * 获取上传的文件为数组
     * @param request
     * @param maxSize
     * @return
     * @throws Exception
     *//*
    protected final MultipartFile[] getUpdateFilesArray(HttpServletRequest request, Long maxSize) throws Exception{
        Map<String, MultipartFile> updateFiles = getUpdateFiles(request, maxSize);
        MultipartFile files[] = null;
        if(updateFiles.size()>0){
            files = new MultipartFile[updateFiles.size()];
            int index = 0;
            for(MultipartFile f:updateFiles.values()){
                files[index++] = f;
            }
        }else{
            files = new MultipartFile[0];
        }
        return files;
    }

    *//**
     * 下载文件
     * @param urls  路径
     * @param fileName  下载后压缩包的名字
     * @param mediaType   默认 application/octet-stream
     * @throws Exception
     *//*
    protected void downloadZip(List<DownloadZipDto> urls, String fileName,String mediaType) throws Exception{
        if(urls!=null&&!urls.isEmpty()){
            LinkedHashMap<String,byte[]> datas = new LinkedHashMap<>(urls.size());
            urls.stream().sequential().forEach(e-> {
                try {
                    datas.put(e.getFileName(),PackageDownloadUtil.downloadFromUrl(e.getUrl()));
                } catch (Exception e1) {
                    throw new RuntimeException(e1);
                }
            });
            byte result[] = PackageDownloadUtil.gzipData(datas);
            fileName = URLEncoder.encode(fileName, "UTF-8");
            response.setContentType(mediaType==null?"application/octet-stream":mediaType);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.getOutputStream().write(result);
        }else{
            response.setStatus(500);
            response.getWriter().write("ERROR,No Files Found.");
        }
    }
*/

}
