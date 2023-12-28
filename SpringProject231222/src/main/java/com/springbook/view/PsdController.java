package com.springbook.view;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.psd.PsdService;
import com.springbook.biz.psd.PsdVO;


@Controller
@SessionAttributes("m")
public class PsdController {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private PsdService service;

	String path = "";
	long time = System.currentTimeMillis();
	SimpleDateFormat daytime = new SimpleDateFormat("HHmmss");
	String timeStr = daytime.format(time);
	
	// @PostConstruct init() 메소드는 WAS(톰캣)가(이) 띄워질 때 실행
	@PostConstruct
	public void init() {
		// D:\eclipse-sts3\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringProject231222\psd\img\
		path = servletContext.getRealPath("/psd/img/");
	}

	@RequestMapping(value="psdWrite.do", method=RequestMethod.GET)
	public String write() {
		
		return "/psd/psdWrite.jsp";
	}
	
	@RequestMapping(value="psdWrite.do", method=RequestMethod.POST)
	public String write(PsdVO vo) throws IOException {
		
		MultipartFile uploadFile = vo.getUploadFile();
		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if(!uploadFile.isEmpty()) {
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + timeStr + extension; 
			}
			uploadFile.transferTo(new File(path + fileName));
		} else {
			fileName = "space.png";
		}
		vo.setUploadFileStr(fileName);
		service.insert(vo);
		
		return "psdList.do";
	}
	
	@RequestMapping(value="psdDelete.do")
	public String delete(PsdVO vo) {
		File delF = new File(path + vo.getUploadFileStr());
		
		if (!vo.getUploadFileStr().equals("space.png")) {
			delF.delete(); // 실제 파일 삭제
		} 
		service.delete(vo);
		
		return "/psdList.do";
	}
	
	@RequestMapping(value="psdList.do")
	public String getPsdList(Model model) {
		System.out.println("==> getBoardList");
		
		model.addAttribute("li", service.getPsdList());
		
		return "/psd/psdList.jsp";
	}
	
	@RequestMapping(value="psdOne.do")
	public String getPsd(Model model, PsdVO vo) {
		System.out.println("==> getBoardList");
		
		service.cnt(vo);
		model.addAttribute("m", service.getPsd(vo));
		
		return "/psd/psdOne.jsp";
	}
	
	@RequestMapping(value="psdUpdate.do")
	public String update(@ModelAttribute("m") PsdVO vo) throws IOException  {
		
		System.out.println("################################vo: " + vo);
		
		MultipartFile uploadFile = vo.getUploadFile();		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if(!uploadFile.isEmpty()) {
			// 첨부파일이 space면 안 삭제
			vo.getUploadFileStr(); // 기존 파일명
			if (!vo.getUploadFileStr().equals("space.png")) {
				File delF = new File(path + vo.getUploadFileStr());
				delF.delete(); // 실제 파일 삭제
			}
			
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + timeStr + extension; 
			}
			uploadFile.transferTo(new File(path + fileName));
		} else {
			fileName = vo.getUploadFileStr();
		}
		vo.setUploadFileStr(fileName);
//		vo.setRegdate(vo.getRegdate()+"(수정)");
//		System.out.println("################################vo: " + vo);
		service.update(vo);
		
		return "/psdList.do";
	}
	
}
