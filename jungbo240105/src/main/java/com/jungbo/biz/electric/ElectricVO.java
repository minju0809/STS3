package com.jungbo.biz.electric;

import lombok.Data;

@Data
public class ElectricVO {
	private int idx;
	private String region;
	private String station;
	private String longitude; // 경도
	private String latitude; // 위도
}
