package org.zerocouplage.web.manager;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import org.zerocouplage.api.config.IViewConfig;
import org.zerocouplage.api.config.IZeroCouplageConfig;
import org.zerocouplage.api.controller.IZCManager;
import org.zerocouplage.api.controller.IZCVirtualView;
import org.zerocouplage.api.logger.IZCLogger;
import org.zerocouplage.common.logger.ZCLoggerFactory;
import org.zerocouplage.impl.config.ZeroCouplageConfigImpl;
import org.zerocouplage.impl.controller.ZCManagerFactory;
/**
 * @author Mestari salma version 1.2.0
 * @author Taj Sara version 1.2.0
 *  @author hmiza 2.0.0
 */
public class ZCManagerWeb implements IZCVirtualView, Filter {

	private static IZCLogger logger = ZCLoggerFactory
			.getLogger(ZCManagerWeb.class);
	private static final String _ZC_SOURCE_VIEW_NAME = "_ZC_SOURCE_VIEW_NAME";
	private String businessName;
	private String viewName;
	private Map<String, Object> listWebParams;
	private IZCManager manager;
	protected  ServletRequest request;
	protected ServletResponse response;

	public ZCManagerWeb() {
		businessName = "";
		viewName = "";
		manager = ZCManagerFactory.getNewManager(this);
		listWebParams = new HashMap<String, Object>();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		this.request = req;
		this.response = resp;
		updateViewName();
		updateBusinessName();
		try {
			loadListParamFromRequest();
		} catch (Exception e1) {
			logger.error("error while loading the list of parameters from request");
			e1.printStackTrace();
		}
		try {
			String  zcSourceEventComponentId = (String) req.getParameter("zcComponentId");
			manager.executeBusiness(businessName, false, zcSourceEventComponentId);
		} catch (ClassNotFoundException e) {
			logger.error("the businessName resultView that you've indacate in zerocouplage.xml is not found");
			e.printStackTrace();
		} catch (InstantiationException e) {
			logger.error("cannot instanciate the zerocouplage.xml file");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			logger.error("problem while using java reflexion");
			e.printStackTrace();
		}
	}

	/**
	 * <p>method that load the parameters from request </p>
	 * @throws Exception
	 */
	private void loadListParamFromRequest() throws Exception {

		listWebParams = new HashMap<String, Object>();
		boolean isMultipart = ServletFileUpload
				.isMultipartContent((HttpServletRequest) request);

		if (isMultipart) {
			String UPLOAD_DIRECTORY = System.getProperty("java.io.tmpdir")
					+ File.separator + "ZeroCouplage";
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory())
					.parseRequest((HttpServletRequest) request);
			for (FileItem item : items) {

				if (item.isFormField()) {

					if (item.getFieldName().equals(_ZC_SOURCE_VIEW_NAME)) {
						this.viewName = item.getString();
					}

					String fieldname = item.getFieldName();

					Object fieldvalue = (Object) item.getString();

					this.listWebParams.put("" + fieldname, fieldvalue);

				} else {

					String uploadPath = UPLOAD_DIRECTORY + File.separator
							+ (new Date().getTime());
					File uploadDir = new File(uploadPath);
					if (!uploadDir.exists()) {
						uploadDir.mkdirs();
					}
					String fieldname = item.getFieldName();
					String filename = FilenameUtils.getName(item.getName());

					String filePath = uploadPath + File.separator + filename;
					
					 InputStream inputStream = item.getInputStream();
					File storeFile = new File(filePath);
					
					copyTofile(inputStream, filePath);

					listWebParams.put("" + fieldname, filePath);
					item.write(storeFile);

				}

			}
		} else {
			for (Object paramName : request.getParameterMap().keySet()) {
				listWebParams.put("" + paramName,
						request.getParameter("" + paramName));
			}
		}

	}

	private void copyTofile(InputStream inputStream, String  filePath) {
		
		BufferedReader br = null;
		try {
			// read this file into InputStream
			inputStream = new FileInputStream(filePath);
	 
			br = new BufferedReader(new InputStreamReader(inputStream));
	 
			StringBuilder sb = new StringBuilder();
	 
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
	 
			System.out.println(sb.toString());
			System.out.println("\nDone!");
	 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	/**
	 * <p> methode that compose the businessName based on the url </p>
	 */
	private void updateBusinessName() {
		if (request instanceof HttpServletRequest) {
			StringBuffer url = ((HttpServletRequest) request).getRequestURL();
			int indexLastSlash = url.lastIndexOf("/");
			this.businessName = url.substring(indexLastSlash + 1);
			if (this.businessName.endsWith(".zc"))
				;
			{
				int indexOfLastDote = this.businessName.lastIndexOf('.');
				this.businessName = this.businessName.substring(0,
						indexOfLastDote);
			}
		} else {
			logger.error("No business name is founded : \n"
					+ "Because, the request is not an instance of HttpServletRequest !!");
		}
	}

	/**
	 * <p> method that update the view name using the hidden input _ZC_SOURCE_VIEW_NAME</p>
	 */
	private void updateViewName() {

		viewName = request.getParameter(_ZC_SOURCE_VIEW_NAME);
		if (viewName == null) {
			viewName = "";
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void goToPageError(String pageName,
			Map<String, String> listParamsError) {

		for (String errorField : listParamsError.keySet()) {
			this.request.setAttribute(errorField,
					listParamsError.get(errorField));
		}

		for (String field : listWebParams.keySet()) {

			this.request.setAttribute(field, listWebParams.get(field));
		}

		try {
			this.request.getRequestDispatcher(pageName).forward(this.request,
					this.response);
		} catch (ServletException e) {
			logger.error("Can not excute forward to the  page '" + pageName
					+ "' ", e);
		} catch (IOException e) {
			logger.error("Can not excute forward to the  page '" + pageName
					+ "' ", e);
		}
	}

	@Override
	public void goToPage(String pageName, String beanName, Object beanValue,
			boolean useSameViewInstance) {

		if (File.class.isInstance(beanValue)) {
			try {
				download((File) beanValue);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			IZeroCouplageConfig zcConfig = ZeroCouplageConfigImpl.getInstance();

			IViewConfig resultView = zcConfig.getLoaderConfig()
					.getViewConfigMap().getViewConfigByName(pageName);
			String target = resultView.getTargetName();

			if (beanName != null) {
				this.request.setAttribute(beanName, beanValue);
			}
			try {

				this.request.getRequestDispatcher(target).forward(this.request,
						this.response);
			} catch (ServletException e) {
				logger.error("Can not excute forward to the  page '" + target
						+ "' ", e);
			} catch (IOException e) {
				logger.error("Can not excute forward to the  page '" + target
						+ "' ", e);
			}
		}

	}

	@Override
	public void destroy() {
		

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	@Override
	public Map<String, Object> getListParm() {

		return this.listWebParams;
	}

	@Override
	public String getViewName() {

		return this.viewName;
	}

	@Override
	public void setViewInstance(Object view) {
	

	}

	/**
	 * <p>method that download a file </p>
	 * @param fileToDownload
	 * @throws IOException
	 */
	protected void download(File fileToDownload) throws IOException {
		response.setContentType("application/download");
		((HttpServletResponse) response).setHeader("Content-Disposition",
				"attachment;filename=\"" + fileToDownload.getName() + "\"");

		ServletOutputStream out = response.getOutputStream();

		BufferedInputStream from = null;

		try {
			response.setContentLength((int) fileToDownload.length());
			int bufferSize = 64 * 1024;
			from = new BufferedInputStream(new FileInputStream(fileToDownload),
					bufferSize * 2);

			byte[] bufferFile = new byte[bufferSize];

			for (int i = 0;; i++) {

				int len = from.read(bufferFile);

				if (len < 0) {
					break;
				}

				out.write(bufferFile, 0, len);
			}
			out.flush();

		} catch (FileNotFoundException e) {
			logger.error("cannot find the file that you want to download");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			if (from != null) {
				try {
					from.close();
				} catch (Exception e) {
					logger.error("cannot close the BufferedInputStream ");
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (Exception e) {
					logger.error("cannot close the  ServletOutputStream ");
					e.printStackTrace();
				}
			}
			
		}
	}

}
