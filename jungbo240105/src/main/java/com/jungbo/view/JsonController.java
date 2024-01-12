package com.jungbo.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jungbo.biz.company.CompanyJSONVO;
import com.jungbo.biz.company.CompanyJSONVO2;

@Controller
public class JsonController {

	@RequestMapping("/companyJSON.do")
	String companyJSON(Model model) throws Exception {

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/6300000/openapi2022/festv/getfestv"); /* URL */
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=Rlv%2FLwLil1lc5xKQg7CBwm%2BcvuksrkTpcQuQozGJvXsRYmOryjgMjlL4ou%2BfxTjfI%2F%2BJAO7uBo1vVrIWnAhSmQ%3D%3D"); /*
																																 * Service
																																 * Key
																																 */
		urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
				+ URLEncoder.encode("13", "UTF-8")); /* 한 페이지 결과 수(조회 날짜로 검색 시 사용 안함) */
		urlBuilder.append("&" + URLEncoder.encode("pageNo", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8")); /* 페이지번호(조회 날짜로 검색 시 사용 안함) */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

		System.out.println(sb);

		try {
			JSONParser jsonParser = new JSONParser();

			// JSON데이터를 넣어 JSON Object 로 만들어 준다.
			JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
			JSONObject response = (JSONObject) jsonObject.get("response");
			JSONObject body = (JSONObject) response.get("body");

			// items의 배열을 추출
			JSONArray InfoArray = (JSONArray) body.get("items");
			List<CompanyJSONVO> li = new ArrayList<>();

			System.out.println("* items *");

			for (int i = 0; i < InfoArray.size(); i++) {

				System.out.println("=items_" + i + " ===========================================");

				// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
				JSONObject object = (JSONObject) InfoArray.get(i);

				// JSON name으로 추출
				System.out.println("Info: festvNm==>" + object.get("festvNm"));
				System.out.println("Info: festvSumm==>" + object.get("festvSumm"));
				System.out.println("Info: festvTpic==>" + object.get("festvTpic"));
				System.out.println("Info: festvPrid==>" + object.get("festvPrid"));
				System.out.println("Info: festvPlcNm==>" + object.get("festvPlcNm"));
				System.out.println("Info: festvHostNm==>" + object.get("festvHostNm"));

				String festvNm = (String) object.get("festvNm");
				String festvSumm = (String) object.get("festvSumm");
				String festvTpic = (String) object.get("festvTpic");
				String festvPrid = (String) object.get("festvPrid");
				String festvPlcNm = (String) object.get("festvPlcNm");
				String festvHostNm = (String) object.get("festvHostNm");

				CompanyJSONVO m = new CompanyJSONVO();
				m.setFestvNm(festvNm);
				m.setFestvSumm(festvSumm);
				m.setFestvTpic(festvTpic);
				m.setFestvPrid(festvPrid);
				m.setFestvPlcNm(festvPlcNm);
				m.setFestvHostNm(festvHostNm);

				li.add(m);
			}

			model.addAttribute("li", li);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/company/companyListJSON.jsp";
	}

	@RequestMapping("/companyJSON2.do")
	String companyJSON2(Model model) throws Exception {

		StringBuilder urlBuilder = new StringBuilder(
				"http://api.odcloud.kr/api/15068978/v1/uddi:41f65320-6d5b-4e6e-8276-d3d5bf9b9bb8");
		urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8")
				+ "=Rlv%2FLwLil1lc5xKQg7CBwm%2BcvuksrkTpcQuQozGJvXsRYmOryjgMjlL4ou%2BfxTjfI%2F%2BJAO7uBo1vVrIWnAhSmQ%3D%3D");
		urlBuilder.append("&" + URLEncoder.encode("page", "UTF-8") + "="
				+ URLEncoder.encode("1", "UTF-8"));
		urlBuilder.append("&" + URLEncoder.encode("perPage", "UTF-8") + "="
				+ URLEncoder.encode("10", "UTF-8")); 
		urlBuilder.append("&" + URLEncoder.encode("returnType", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); 
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");

		System.out.println("Response code: " + conn.getResponseCode());

		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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

		System.out.println(sb);

		try {
			JSONParser jsonParser = new JSONParser();

			// JSON데이터를 넣어 JSON Object 로 만들어 준다.
			JSONObject jsonObject = (JSONObject) jsonParser.parse(sb.toString());
			JSONArray InfoArray = (JSONArray) jsonObject.get("data");

			List<CompanyJSONVO2> li2 = new ArrayList<>();

			System.out.println("* data *");

			for (int i = 0; i < InfoArray.size(); i++) {

				System.out.println("=data_" + i + " ===========================================");

				// 배열 안에 있는것도 JSON형식 이기 때문에 JSON Object 로 추출
				JSONObject object = (JSONObject) InfoArray.get(i);

				// JSON name으로 추출
				System.out.println("Info: 대학명==>" + object.get("대학명"));
				System.out.println("Info: 영문명==>" + object.get("영문명"));
				System.out.println("Info: 지역==>" + object.get("지역"));
				System.out.println("Info: 주소==>" + object.get("주소"));
				System.out.println("Info: 홈페이지==>" + object.get("홈페이지"));
				System.out.println("Info: 전화==>" + object.get("전화"));
				System.out.println("Info: 팩스==>" + object.get("팩스"));
				System.out.println("Info: 대표메일==>" + object.get("대표메일"));
				

				String name = (String) object.get("대학명");
				String english = (String) object.get("영문명");
				String region = (String) object.get("지역");
				String address = (String) object.get("주소");
				String homepage = (String) object.get("홈페이지");
				String tel = (String) object.get("전화");
				String fax = (String) object.get("팩스");
				String email = (String) object.get("대표메일");

				CompanyJSONVO2 university = new CompanyJSONVO2();
				university.setName(name);
				university.setEnglish(english);
				university.setRegion(region);
				university.setAddress(address);
				university.setHomepage(homepage);
				university.setTel(tel);
				university.setFax(fax);
				university.setEmail(email);

				li2.add(university);
			}

			model.addAttribute("li2", li2);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/company/companyListJSON2.jsp";
	}

}
