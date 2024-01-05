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

import com.springbook.biz.shop.ProductService;
import com.springbook.biz.shop.ProductVO;


@Controller
@SessionAttributes("m")
public class ProductController {
	
	@Autowired
	private ServletContext servletContext;

	@Autowired
	private ProductService service;

	String path = "";
	long time = System.currentTimeMillis();
	SimpleDateFormat daytime = new SimpleDateFormat("HHmmss");
	String timeStr = daytime.format(time);
	
	// @PostConstruct init() 메소드는 WAS(톰캣)가(이) 띄워질 때 실행
	@PostConstruct
	public void init() {
		// D:\eclipse-sts3\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\SpringProject231222\psd\img\
		path = servletContext.getRealPath("/shop/img/");
	}

	@RequestMapping(value="productWrite.do", method=RequestMethod.GET)
	public String write(Model model) {
		
		model.addAttribute("productId", service.getProductId());
		
		return "/shop/productWrite.jsp";
	}
	
	@RequestMapping(value="productWrite.do", method=RequestMethod.POST)
	public String write(ProductVO vo) throws IOException {
		
		MultipartFile uploadFile = vo.getProduct_img_file();
		
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
		vo.setProduct_img(fileName);
		
		service.productInsert(vo);
		
		return "productList.do";
	}
	
	@RequestMapping(value="productDelete.do")
	public String delete(ProductVO vo) {
		File delF = new File(path + vo.getProduct_img());
		
		if (!vo.getProduct_img().equals("space.png")) {
			delF.delete(); // 실제 파일 삭제
		} 
		service.productDelete(vo);
		
		return "/productList.do";
	}
	
	@RequestMapping(value="productList.do")
	public String getProductList(Model model, ProductVO vo) {
		
		model.addAttribute("li", service.getProductList(vo));
		
		return "/shop/productList.jsp";
	}
	
	@RequestMapping(value="productOne.do")
	public String getProduct(Model model, ProductVO vo) {
		
		model.addAttribute("m", service.getProduct(vo));
		
		return "/shop/productOne.jsp";
	}
	
	@RequestMapping(value="productList2.do")
	public String getProductList2(Model model, ProductVO vo) {
		
		model.addAttribute("li", service.getProductList(vo));
		
		return "/shop/productList2.jsp";
	}
	
	@RequestMapping(value="productUpdate.do")
	public String update(@ModelAttribute("m") ProductVO vo) throws IOException  {
		
		System.out.println("################################vo: " + vo);
		
		MultipartFile uploadFile = vo.getProduct_img_file();		
		String fileName = uploadFile.getOriginalFilename();
		File f = new File(path + fileName);

		if(!uploadFile.isEmpty()) {
			// 첨부파일이 space면 안 삭제
			vo.getProduct_img(); // 기존 파일명
			if (!vo.getProduct_img().equals("space.png")) {
				File delF = new File(path + vo.getProduct_img());
				delF.delete(); // 실제 파일 삭제
			}
			
			if(f.exists()) {
				String onlyFileName = fileName.substring(0, fileName.lastIndexOf("."));
				String extension = fileName.substring(fileName.lastIndexOf("."));
				fileName = onlyFileName + "_" + timeStr + extension; 
			}
			uploadFile.transferTo(new File(path + fileName));
		} else {
			fileName = vo.getProduct_img();
		}
		vo.setProduct_img(fileName);
		service.productUpdate(vo);
		
		return "/productList.do";
	}
		
}
