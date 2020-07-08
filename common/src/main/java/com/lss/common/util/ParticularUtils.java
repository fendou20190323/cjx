package com.lss.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author wangyg
 */
public class ParticularUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(ParticularUtils.class);
	
	public static String trim(Object obj, String defaultValue){
		return obj == null ? defaultValue : obj.toString().trim();
	}
	
	public static int toNumber(Object obj){
		try {
			if(obj == null){
				return 0;
			}
			return Integer.valueOf(obj.toString());
		} catch (Exception e) {}
		return 0;
	}
	
	public static void writeObj(Object obj, String filePathName) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(filePathName));
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(oos != null){
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	public static Object readObj(String filePathName) throws Exception {
		return readObj(new FileInputStream(filePathName));
	}
	
	public static Object readObj(InputStream is) throws Exception {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(is);
			return ois.readObject();
		} catch (Exception e) {
			throw e;
		} finally{
			if(ois != null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	/**
	 * 序列化和反序列化
	 * @author wangyg
	 * @param t 使用序列化方式拷贝对象
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	@SuppressWarnings("unchecked")
	public static <T> T objectCopy(T t) throws IOException, ClassNotFoundException {
        if (t == null) {
            throw new RuntimeException("[The incoming parameter is empty!]");
        }
        ByteArrayOutputStream byteArrayOutputStream  = new ByteArrayOutputStream();
        new ObjectOutputStream(byteArrayOutputStream).writeObject(t);
        return (T) (new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray())).readObject());
    }

	/**
	 * to_date string类型的日期，方便拼接sql
	 * @param str 类型的日期
	 * @return
	 * @throws IOException
	 */

	public static String FormatDataStr(String str) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return "to_date('" + format.format(format.parse(str.toString())) + "','yyyy-MM-dd')";
		} catch (ParseException e) {
			return str;
		}
	}

	/**
	 * 判断是不是日期型数据
	 * @param str 类型的日期
	 * @return
	 * @throws IOException
	 */
	public static boolean isValidDate(String str) {
		boolean convertSuccess = true;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			format.parse(str);
		} catch (ParseException e) {
			convertSuccess = false;
		}
		return convertSuccess;
	}
	
	/**
	 * ZIP 压缩
	 * @param sourceDir : 目标zip文件路径, 文件/文件夹
	 * @param outputDir : 生成 ZIP 文件路径;
	 * @throws RuntimeException
	 */
	public static void toZip(String sourceDir, String outputDir, String toZipName) throws RuntimeException {
		long start = System.currentTimeMillis();
		ZipOutputStream zos = null;
		try {
			zos = new ZipOutputStream(new FileOutputStream(outputDir + toZipName + ".zip"));
			File sourceFile = new File(sourceDir);

			toZipCompress(sourceFile, zos, sourceFile.getName());
			
			long end = System.currentTimeMillis();
			logger.debug("压缩完成, 耗时: " + (end - start) + " ms");
		} catch (Exception e) {
			throw new RuntimeException("zip error from ZipUtils", e);
		} finally {
			if(zos != null){
				try {
					zos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	private static void toZipCompress(File sourceFile, ZipOutputStream zos, String dirName) throws Exception {
		byte[] buffer = new byte[1024*2];
		
		// 判断文件是否是文件.
		// 文件
		if (sourceFile.isFile()) {
			// 向zip输出流中添加一个zip实体, 构造器中dirName为zip实体的文件的名字
			zos.putNextEntry(new ZipEntry(dirName));
			
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buffer)) != -1) {
				zos.write(buffer, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
			
		} 
		// 文件夹
		else {
			File[] listFiles = sourceFile.listFiles();
			if (listFiles == null || listFiles.length == 0) {
				// 需要保留原来的文件结构时, 需要对空文件夹进行处理;
				// 空文件夹的处理;
				zos.putNextEntry(new ZipEntry(dirName + "/"));
				// 没有文件, 不需要文件的copy
				zos.closeEntry();

			} else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构

					// 注意: file.getName()前面需要带上父文件夹的名字加一斜杠,
					// 不然最后压缩包中就不能保留原来的文件结构,即: 所有文件都跑到压缩包根目录下了
					toZipCompress(file, zos, dirName + "/" + file.getName());
				}
			}
		}
	}
	
	/**
	 * ZIP 解压
	 * @param zipPath
	 * @param outputDir
	 * @return : 返回解压目录
	 * @throws IOException
	 */
	public static String unZipFiles(String zipPath, String outputDir) throws IOException {
		ZipFile zip = null;
		try {
			String menus = null;
			File zFile = new File(zipPath);
			File outputFile = new File(outputDir);
			// 判断文件夹是否存在, 不存在则创建; 若是多个文件夹不存在则创建多级文件夹
			if (!outputFile.exists()) {
				outputFile.mkdirs();
			}
			
			zip = new ZipFile(zFile);
			
			ZipEntry entry = null;
			String zipEntryName = null;
			InputStream in = null;
			String outPath = null;
			File file = null;
			OutputStream out = null;
			byte[] buffer = null;
			int len = 0;
			for (
					@SuppressWarnings("unchecked")
					Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries(); entries.hasMoreElements();) {
				try {
					entry = entries.nextElement();
					zipEntryName = entry.getName();
					if(menus == null){
						int index = 0;
						if((index=zipEntryName.indexOf("/")) > 0){
							menus = zipEntryName.substring(0, index);
						}else if((index=zipEntryName.indexOf("\\")) > 0){
							menus = zipEntryName.substring(0, index);
						}else{
							menus = zipEntryName;
						}
					}
					
					in = zip.getInputStream(entry);
					outPath = (outputDir + zipEntryName).replaceAll("\\*", "/");
					
					// 判断路径是否存在,不存在则创建文件路径
					file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
					if (!file.exists()) {
						file.mkdirs();
					}
					// 判断文件全路径是否为文件夹,如果是上面已经上传,不需要解压
					if (new File(outPath).isDirectory()) {
						continue;
					}
					// 输出文件路径信息
					logger.debug(outPath);

					out = new FileOutputStream(outPath);
					buffer = new byte[1024];
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
				} catch (Exception e) {
					throw e;
				} finally{
					if(in != null){
						in.close();
						in = null;
					}
					if(out != null){
						out.close();
						out = null;
					}
					if(entry != null){
						entry.clone();
						entry = null;
					}
				}
			}
			logger.debug("[解压完毕]");
			return menus;
		} catch (Exception e) {
			throw e;
		} finally{
			if(zip != null){
				zip.close();
			}
		}
	}
	
	
	/**
	 * 文件拷贝
	 * @param is
	 * @param isCloseIS : 是否关闭 InputStream
	 * @param os
	 * @param isCloseOS : 是否关闭 OutputStream
	 * @param multipleByte
	 */
	public static void copyFile(InputStream is, boolean isCloseIS, OutputStream os, boolean isCloseOS, int multipleByte){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);
			if(multipleByte <= 0){
				multipleByte = 1;
			}
			byte[] b = new byte[1024*multipleByte];
			int len;
			while((len = bis.read(b)) != -1){
				bos.write(b, 0, len);
			}
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(isCloseIS){
				if(bis != null){
					try {
						bis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if(isCloseOS){
				if(bos != null){
					try {
						bos.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateFormat(Date date, String pattern){
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(new Date());
	}
	
	
	/**
	 * 删除文件、文件夹
	 * @param dir
	 */
	public static void deleteFile(String dir){
		if(dir == null){
			return;
		}
		deleteFile(new File[]{new File(dir)}, 1);
	}
	
	/**
	 * 删除文件、文件夹
	 * @param file
	 */
	public static void deleteFile(File file){
		if(file == null){
			return;
		}
		deleteFile(new File[]{file}, 1);
	}
	
	/**
	 * 递归删除文件、文件夹
	 * @param files
	 */
	private static void deleteFile(File[] files, int breakIdentify){
		breakIdentify++;
		if(breakIdentify > 10 || files == null){
			return;
		}
		for(File file : files){
			if(!file.exists()){
				continue;
			}
			
			// 文件
			if(file.isFile()){
				file.delete();
				logger.debug("[delete file: " + file.getName() + "]");
				continue;
			}
			
			// 文件夹
			if(file.isDirectory()){
				File[] listFiles = file.listFiles();
				if(listFiles != null){
					if(listFiles.length == 0){
						file.delete();
					}else{
						deleteFile(listFiles, breakIdentify);
					}
				}
				
				listFiles = file.listFiles();
				if(listFiles != null){
					if(listFiles.length == 0){
						file.delete();
						logger.debug("[delete folder: " + file.getName() + "]");
					}
				}
			}
		}
	}
	
	
	/**
	 * 根据路径判断文件或文件夹是否存在, 不存在则创建(有多级创建)
	 * @param filePath
	 */
	public static void createFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	public final static String PATTERN = "yyyy-MM-dd";
	public static Date getDate(String source, String pattern){
		try {
			return new SimpleDateFormat(pattern).parse(source);
		} catch (Exception e) {}
		return new Date();
	}
	
	public static void main(String[] args) {

	}
}
