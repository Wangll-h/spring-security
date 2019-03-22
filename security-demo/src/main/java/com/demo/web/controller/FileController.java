package com.demo.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.demo.dto.FileInfo;

@RestController
@RequestMapping("/file")
public class FileController {

	private static final String folder = "/Users/wanglili1/Documents/stsworkspace/";

	@PostMapping
	public FileInfo uploa(MultipartFile file) throws Exception {

		System.out.println("name：" + file.getName());
		System.out.println("original filename：" + file.getOriginalFilename());
		System.out.println("size：" + file.getSize());

		File localFile = new File(folder, new Date().getTime() + ".txt");

		file.transferTo(localFile);

		return new FileInfo(localFile.getAbsolutePath());
	}

	@GetMapping("/{id}")
	public void download(@PathVariable String id, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		InputStream input = null;
		OutputStream outputStream = null;
		try {
			input = new FileInputStream(new File(folder, id + ".txt"));
			outputStream = response.getOutputStream();

			response.setContentType("application/x-download");
			response.addHeader("Content-Disposition", "attachment;filename=test.txt");

			IOUtils.copy(input, outputStream);
			outputStream.flush();
		} catch (Exception e) {

		} finally {
			input.close();
			outputStream.close();
		}
	}

}
