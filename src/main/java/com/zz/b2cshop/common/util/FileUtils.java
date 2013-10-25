package com.zz.b2cshop.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileUtils {

	public static byte[] randomReadFile(String fileName, long pos, int len) {

		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}
		RandomAccessFile raFile = null;
		byte[] data = null;
		byte[] buffer = new byte[len];
		try {
			raFile = new RandomAccessFile(file, "r");
			raFile.seek(pos);
			int length = raFile.read(buffer, 0, len);
			if (length < len) {
				data = new byte[length];
				System.arraycopy(buffer, 0, data, 0, length);
				return data;
			}
			return buffer;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raFile != null) {
				try {
					raFile.close();
				} catch (IOException e1) {
				}
			}
		}
		return null;
	}

	public static byte[] readFile(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return null;
		}
		InputStream in = null;
		byte[] buffer = new byte[1024 * 1024];
		byte[] data = null;
		try {
			in = new FileInputStream(file);
			int len = in.read(buffer);
			data = new byte[len];
			System.arraycopy(buffer, 0, data, 0, len);
			in.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}

	public static void writeFile(String fileName, byte[] bytes) {

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		OutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(bytes);
			out.flush();
			out.close();
		} catch (Exception e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void writeFile(String fileName, byte[] bytes, boolean append) {

		File file = new File(fileName);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		OutputStream out = null;
		try {
			out = new FileOutputStream(file, append);
			out.write(bytes);
			out.flush();
			out.close();
		} catch (Exception e) {
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void saveFile(File file, String savePath) throws Exception {
		int bufferSize = 1024 * 4;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(new File(savePath));
			fis = new FileInputStream(file);
			byte[] buffer = new byte[bufferSize];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			fos.flush();
		} finally {
			if (fos != null)
				fos.close();
			if (fis != null)
				fis.close();
		}
	}

	public static String getFileSuffix(String name) {
		int lastDot = 0;
		if ((lastDot = name.lastIndexOf(".")) != -1) {
			return name.substring(lastDot + 1, name.length());
		} else {
			return name;
		}

	}

}
