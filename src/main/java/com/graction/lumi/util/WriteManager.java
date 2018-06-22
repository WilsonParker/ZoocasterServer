package com.graction.lumi.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class WriteManager {
	private static final WriteManager instance = new WriteManager();

	public static WriteManager getInstance() {
		return instance;
	}

	public void write(HttpServletResponse httpServletResponse, String data) throws IOException {
		httpServletResponse.setCharacterEncoding("UTF-8");
		httpServletResponse.setContentType("text/html;charset=UTF-8");
		httpServletResponse.getWriter().print(data);
	}
}
