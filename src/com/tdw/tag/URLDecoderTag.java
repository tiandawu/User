package com.tdw.tag;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class URLDecoderTag extends SimpleTagSupport {

	private String content;
	private String encode;

	@Override
	public void doTag() throws JspException, IOException {

		String decodeStr = URLDecoder.decode(content, encode == null ? "utf-8"
				: encode);
		getJspContext().getOut().write(decodeStr);
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

}
