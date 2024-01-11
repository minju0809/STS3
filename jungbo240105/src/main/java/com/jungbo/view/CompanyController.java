package com.jungbo.view;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.jungbo.biz.company.CompanyService;
import com.jungbo.biz.company.CompanyVO;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	@RequestMapping("/company.do")
	public  String   insert(Model model) throws Exception {
		
		List<CompanyVO> companyList = new ArrayList<>();
		
		
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamgoodemploycompany/gyeongnamgoodemploycompanylist"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=Rlv%2FLwLil1lc5xKQg7CBwm%2BcvuksrkTpcQuQozGJvXsRYmOryjgMjlL4ou%2BfxTjfI%2F%2BJAO7uBo1vVrIWnAhSmQ%3D%3D"); /*Service Key (일반인증키)*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
        urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*시도 코드 (행정구역코드 앞 2자리)*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
        
        Node data1 = null;   
        Node data2 = null;   
        Node data3 = null;
        Node data4 = null;
        Node data5 = null;
        Node data6 = null;
        
        try {
        	DocumentBuilderFactory	dbFactory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
        	
        	FileOutputStream output = new FileOutputStream("./ApiExplorer");
        	output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
        	output.close();
        	
        	Document doc = dBuilder.parse("./ApiExplorer");
        	doc.getDocumentElement().normalize();
        	
        	Element body =(Element) doc.getElementsByTagName("body").item(0);
        	Element items =(Element) body.getElementsByTagName("items").item(0);
        	
        	for(int i=0 ; i<10; i++ ) {
        		CompanyVO company = new CompanyVO();
        		
	        	Element item =(Element) items.getElementsByTagName("item").item(i);
	        	
	        	data1 = item.getElementsByTagName("rdnmadr").item(0);  // 필요한 데이터 값 추출하기 
	        	data2 = item.getElementsByTagName("logitude").item(0);
	        	data3 = item.getElementsByTagName("entrprsNm").item(0);
	        	data4 = item.getElementsByTagName("rprsntvNm").item(0);
	        	data5 = item.getElementsByTagName("latitude").item(0);
	        	data6 = item.getElementsByTagName("mainGoods").item(0);
	         	
	        	String strData1 = data1.getChildNodes().item(0).getNodeValue();
	        	String strData2 = data2.getChildNodes().item(0).getNodeValue();
	        	String strData3 = data3.getChildNodes().item(0).getNodeValue();
	        	String strData4 = data4.getChildNodes().item(0).getNodeValue();
	        	String strData5 = data5.getChildNodes().item(0).getNodeValue();
	        	String strData6 = data6.getChildNodes().item(0).getNodeValue();
	        	
	        	company.setEntrprsNm(strData3);
	            company.setRdnmadr(strData1);
	            company.setRprsntvNm(strData4);
	            company.setMainGoods(strData6);
	            company.setLatitude(strData5);
	            company.setLogitude(strData2);

	            companyList.add(company);
	            
	            model.addAttribute("li", companyList);
	        	
	        	System.out.println("@@@@@" + strData1+" "+strData2+" "+strData3+" "+strData4+" "+strData5+" "+strData6);

        	}        	
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return "/company/companyList.jsp";        
    }
	
	@RequestMapping(value = "/companyList.do", method=RequestMethod.GET)
	public String companyList(Model model, CompanyVO vo) {
		
		model.addAttribute("li", service.getCompanyList(vo));

		return "/company/companyList.jsp";
	}
}
