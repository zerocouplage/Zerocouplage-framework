/**
 * 
 */
package org.zerocouplage.clientcore.manager;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.net.ssl.HttpsURLConnection;

import org.zerocouplage.clientapi.bean.ZCCookies;
import org.zerocouplage.clientapi.bean.ZCRequest;
import org.zerocouplage.clientapi.bean.ZCResponse;
import org.zerocouplage.clientapi.exceptions.ZCClientException;
import org.zerocouplage.clientapi.httpmanager.IZCHttpManager;
import org.zerocouplage.clientapi.httpmanager.ZCCookiesManager;
import org.zerocouplage.clientcore.shared.ZCjsonFormater;
import org.zerocouplage.tutorial.beans.UserBeanOut;

/**<p>controller client-serveur </p>
 * @author FouadAzioiz
 *
 */
public class ZCHttpManager implements IZCHttpManager {

	private String uRLApplication;
	private String agent;

	

	/**
	 * (non-Javadoc)
	 *<p> methode pour envoyer une requete HTTP vers le serveur ,elle retourne ZCResponse
	 *vérifie l'état de la requète s'il y a un file dedant il fait un upload vers le serveur .
	 * vérifie le header de la reponse s'il sagit d'un telechargement il fait un Download </p>
	 * @author fouad Azioiz
	 * @see
	 * org.zerocouplage.clientapi.httpmanager.IZCHttpManager#send(org.zerocouplage
	 * .clientapi.bean.ZCRequest)
	 */
	//@Override
	public ZCResponse send(ZCRequest request) throws ZCClientException {
		ZCResponse response = new ZCResponse();

		String urlBusiness = this.uRLApplication + "/" + request.getUri();
		
		ZCCookies zccookies = ZCCookiesManager.getInstance(this.uRLApplication);

		// add reuqest header
		try {
			URL obj = new URL(urlBusiness);
			HttpURLConnection con = null;
			
			if(this.uRLApplication.startsWith("https"))
			{
				con = (HttpsURLConnection) obj.openConnection();
				con.setDoOutput(true);
			}
			else
			{
				con = (HttpURLConnection) obj.openConnection();
				con.setDoOutput(true);
			}
			//con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", getAgent());
			
			if(request.getFileUpload() != null)
			{
				
			
				
				
				String nameFile=request.getFileUpload().getName();
				String fieldName=request.getFileFieledName();
				//String paramToSend = System.getProperty("user.home")+File.separator+nameFile;
				//File fileToUpload = new File(paramToSend);
				String boundary = Long.toHexString(System.currentTimeMillis()); // Just generate some unique random value.

				
//				con.setDoOutput(true); // This sets request method to POST.
				con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
				PrintWriter writer = null;
				try {
				    writer = new PrintWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
				  //  writer.append("Content-Disposition: form-data; name=\"" + nameFile + "\"");
				  
				    Set<String> setKey = request.getMapParams().keySet();
					for (Iterator<String> iterator = setKey.iterator(); iterator.hasNext();) 
					{
						String paramName = (String) iterator.next();
						String paramValue = request.getMapParams().get(paramName);
						
						writer.println("--" + boundary);
					    writer.println("Content-Disposition: form-data; name=\""+paramName+"\"");
					    writer.println("Content-Type: text/plain; charset=UTF-8");
					    writer.println();
					    writer.println(paramValue);
						
					}
					
				

				    writer.println("--" + boundary);
				    writer.println("Content-Disposition: form-data; name=\""+fieldName+"\"; filename=\""+nameFile+"\"");
				    writer.println("Content-Type: text/plain; charset=UTF-8");
				    writer.println();
				    BufferedReader reader = null;
				    try {
				        reader = new BufferedReader(new InputStreamReader(new FileInputStream(request.getFileUpload()), "UTF-8"));
				        for (String line; (line = reader.readLine()) != null;) {
				            writer.println(line);
				        }
				    } finally {
				        if (reader != null) try { reader.close(); } catch (IOException logOrIgnore) {}
				    }

				    writer.println("--" + boundary + "--");
				} finally {
				    if (writer != null) writer.close();
				}

				// Connection is lazily executed whenever you request any status.
				int responseCode = ((HttpURLConnection) con).getResponseCode();
				System.out.println(responseCode);;
			}
			
			// con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			

			// Send post request
		//	con.setDoOutput(true);
			String urlParameters = request.formatParams();
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			
			wr.flush();
			wr.close();
			
				//TODO ajouter le contenu binaire dans la requette HTTP
				//Voir http://stackoverflow.com/questions/2469451/upload-files-with-java
				//nameFilePhysique = request.getFileUpload().getName();
				//nameFileForm = request.getFileFieledName();
				
			
		

			int responseCode = con.getResponseCode();
		/*	List<String> cookies = con.getHeaderFields().get("Set-Cookie");
			for (String cookie : cookies) {
				System.out.println("cookie = "+cookie.toString());
				//TODO remplir : zccookies
			}*/
			
			System.out.println("\nSending 'POST' request to URL : "
					+ urlBusiness);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					con.getInputStream()));
//			
			

			//TODO : se baser sur le contentType de respo pour savoir le type de la reponse (JSON, HTML  ou File)
			boolean isDowloadFile = false;
			//Map<String, List<String>> map = con.getHeaderFields();
			String contentype=con.getContentType();
			if("application/download".equals(contentype))
				isDowloadFile=true;
			if(isDowloadFile)
			{
				
				String paramName=null;
				String paramValue=null;
				String rep1=null;
				String rep2=null;
				Set<String> setKey = request.getMapParams().keySet();
				for (Iterator<String> iterator = setKey.iterator(); iterator.hasNext();) 
				{
					
					 paramName = (String) iterator.next();
					 if ("login".equals(paramName))
					 rep1 = request.getMapParams().get(paramName);
//					 if("password".equals(paramName))
//						 rep1 = request.getMapParams().get(paramName);
					 else if ("password".equals(paramName)) 
						 rep2 = request.getMapParams().get(paramName);
					//zcupload.addFormField(paramName, paramValue);
				}
				
				
			//  URL url = new URL(fileURL);
			    //    HttpURLConnection con = (HttpURLConnection) url.openConnection();
			        int responseeCode = con.getResponseCode();
			 
			        // always check HTTP response code first
			        if (responseeCode == HttpURLConnection.HTTP_OK) {
			            String fileName = "";
			            String disposition = con.getHeaderField("Content-Disposition");
			            String contentType = con.getContentType();
			            int contentLength = con.getContentLength();
			 
			            if (disposition != null) {
			                // extracts file name from header field
			                int index = disposition.indexOf("filename=");
			                if (index > 0) {
			                    fileName = disposition.substring(index + 10,
			                            disposition.length() - 1);
			                }
			            }
			            else 
			            {
			            	fileName = "download.zc";
			            }
//			            else {
//			                // extracts file name from URL
//			                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
//			                        fileURL.length());
//			            }
			 
			            System.out.println("Content-Type = " + contentType);
			            System.out.println("Content-Disposition = " + disposition);
			            System.out.println("Content-Length = " + contentLength);
			            System.out.println("fileName = " + fileName);
			 
			            // opens input stream from the HTTP connection
			            InputStream inputStream = con.getInputStream();
			           
			            //String DOWNLOAD_DIRECTORY = System.getProperty("java.io.tmpdir")+"ZeroCouplage";
			            
			            String DOWNLOAD_DIRECTORY = System.getProperty("user.home")+File.separator+rep2+ File.separator+rep1;
						String downlaodPath = DOWNLOAD_DIRECTORY + File.separator
								+ (new Date().getTime());
						File dowlaoandDir = new File(downlaodPath);
						if (!dowlaoandDir.exists()) {
							dowlaoandDir.mkdirs();
						}
			            String saveFilePath = downlaodPath + File.separator + fileName;
			            
			          File  downloadedfile=new File(saveFilePath);
			            // opens an output stream to save into file
			            FileOutputStream outputStream = new FileOutputStream(downloadedfile);
			            
			            int bytesRead = -1;
			            byte[] buffer = new byte[4096];
			            while ((bytesRead = inputStream.read(buffer)) != -1) {
			                outputStream.write(buffer, 0, bytesRead);
			            }
			 
			            outputStream.close();
			            inputStream.close();
			 
			            System.out.println("File downloaded");
			             
			        } else {
			            System.out.println("No file to download. Server replied HTTP code: " + responseCode);
			            
			        }
			       
			        con.disconnect();
			        
			    }
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			
			
				String inputLine;
				StringBuffer responseBuffer = new StringBuffer();

				while ((inputLine = in.readLine()) != null) {
					responseBuffer.append(inputLine);
				}
				in.close();
				String jsonResponse = responseBuffer.toString();
				System.out.println("json RESP"+jsonResponse);
				
				String[] listContent = jsonResponse.split(ZCjsonFormater.ZC_SEPARATOR_JSON_RESPONSE);
				String jsonZCResponse = listContent[0];
				String content = listContent[1];
				response = (ZCResponse) ZCjsonFormater.tojava(jsonZCResponse, ZCResponse.class);
				
				if(content!=null && !"null".equals(content))
				{
					Class classContentName;
					try 
					{
						classContentName = Class.forName(response.getClassName());
						Object beanOut = ZCjsonFormater.tojava(content, classContentName);
						response.setContent(beanOut);
					} catch (ClassNotFoundException e) {
						response.setZcStatus("Error:ClassNotFoundException");
						e.printStackTrace();
					}
				}
			
			
			
		} catch (ProtocolException e) {
			throw new ZCClientException("Erreur ProtocolException", e);
			
		} catch (IOException e) {
			throw new ZCClientException("Erreur IOException", e);
		}
		return response;
	}

	//@Override
	public String getURLApplication() {

		return this.uRLApplication;
	}

	//@Override
	public void setAgent(String aAgent) {
		agent = aAgent;
	}

	//@Override
	public String getAgent() {
		return this.agent;
	}

	//@Override
	public void setURLApplication(String urlApplication) {
		this.uRLApplication = urlApplication;
	}
	
	
	  private static final String extractFileNameFromContentDisposition(
              String contentDisposition) {
         String[] attributes = contentDisposition.split(";");

         for (String a : attributes) {
              if (a.toLowerCase().contains("filename")) {
                   // The attribute is the file name. The filename is between
                   // quotes.
                   return a.substring(a.indexOf('\"') + 1, a.lastIndexOf('\"'));
              }
         }

         // not found
         return null;
    }
}