package com.bjdv.znfk.utils;

/**
 * @param
 * @return
 * @author hanxulei
 * @create 2018/9/17
 */

import java.io.File;

/**
 * 〈文件后缀名〉
 *
 * @author hanxulei
 * @create 2018/9/17
 * @since 1.0.0
 */
public class FileUtils {

    //图片格式
    private static String[] image = new String[]{".bmp", ".gif", ".ico", ".ilbm", ".lbm", ".iff", ".jpg", ".jpeg", ".png", ".ppm", ".psd", ".tif", ".tiff", ".webp", ".gifv"};
    //音频格式
    private static String[] audio = new String[]{".aiff", ".au", ".cdda", ".raw", ".wav", ".ape", ".tak", ".tta", ".wma", ".mp3", ".ra", ".wma", ".aac", ".mpc", ".mid", ".nsf", ".mod", ".s3m", ".xm", ".it"};
    //视频格式
    private static String[] video = new String[]{".aaf", ".ani", ".asf", ".avi", ".dat", ".swf", ".mkv", ".mng", ".mov", ".qt", ".qtx", ".mpeg", ".mxf", ".ogg", ".rm", ".rmvb"};
    //文件格式
    private static String[] document = new String[]{".txt", ".html", ".xhtml", ".shtml", ".htm", ".chm", ".hlp", ".inf", ".rtf", ".tex", ".ltx", ".doc", ".docx", ".ppt", ".pptx", ".wps", ".odf", ".mht", ".mhtml", ".pdf", ".xlsx"};
    //其他文件
    String[] other = new String[]{};


    /**
     * 判断是否有此文件
     *
     * @param suffixName
     * @return
     */
    public static String isMeetConditions(String suffixName, String basePath) {
        //遍历图片,判断是否是此文件,然后生成图片文件夹
        for (String suffix : image) {
            if (suffix.equals( suffixName )) {
                return file( "\\image\\", basePath );
            }
        }
        for (String suffix : audio) {
            if (suffix.equals( suffixName )) {
                return file( "\\audio\\", basePath );
            }
        }
        for (String suffix : video) {
            if (suffix.equals( suffixName )) {
                return file( "\\video\\", basePath );
            }
        }
        for (String suffix : document) {
            if (suffix.equals( suffixName )) {
                return file( "\\document\\", basePath );
            }
        }
        return file( "\\other\\", basePath );
    }

    /**
     * 如果没有文件夹则创建
     *
     * @param path
     * @param basePath
     * @return
     */
    public static String file(String path, String basePath) {
        String basePathimage = basePath + path;
        File targetFiles = new File( basePathimage );
        if (!targetFiles.exists()) {
            targetFiles.mkdirs();
        }
        return basePathimage;
    }

    /**
     * 获取随机文件名
     *
     * @return
     */
    public static String getFileName() {
        return UUIDUtil.getUid( "FL_", 17 );
    }

    /**
     * 返回文件名后缀
     *
     * @param fileName
     * @return
     */
    public static String getFileNameSub(String fileName) {
        return fileName.substring( fileName.lastIndexOf( "." ), fileName.length() );
    }


}
