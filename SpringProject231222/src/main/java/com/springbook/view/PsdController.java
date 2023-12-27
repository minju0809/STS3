package com.springbook.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.psd.PsdVO;


@Controller
public class PsdController {
	
	@RequestMapping(value="psdList.do")
	public String getBoardList(Model model) {
		System.out.println("==> getBoardList");
		
//		model.addAttribute("li", service.getBoardList(vo));
		
		return "/psd/psdList.jsp";
	}

	@Autowired
//	private PsdService service;
	
	@RequestMapping(value="psdWrite.do", method=RequestMethod.GET)
	public String write() {
		System.out.println("==> write");
		
		return "/psd/psdWrite.jsp";
	}
	
	@RequestMapping(value="psdWrite.do", method=RequestMethod.POST)
	public String write(PsdVO vo) throws IOException {
		System.out.println("==> write");
		
		long time = System.currentTimeMillis();
		SimpleDateFormat daytime = new SimpleDateFormat("HHmmss");
		String timeStr = daytime.format(time);
		System.out.println("timeStr: " + timeStr);
		
		MultipartFile uploadFile = vo.getUploadFile();
		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File("D:/" + fileName);

		if(!uploadFile.isEmpty()) {
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + timeStr + extension; 
			}
			uploadFile.transferTo(new File("D:/" + fileName));
		} else {
			fileName = "space.png";
		}
//		service.insert(vo);
		
		return "psdList.do";
	}
}
