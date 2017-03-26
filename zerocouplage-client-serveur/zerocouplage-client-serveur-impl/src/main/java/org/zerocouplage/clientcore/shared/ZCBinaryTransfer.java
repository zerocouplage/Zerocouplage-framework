package org.zerocouplage.clientcore.shared;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * classe qui fait tout ce qui concerne le traitement pout l'envoie et la reception des donnée vers un serveur web HTTP
 * POST requests to a web server. 
 * @author fouadAZioiz
 *
 */
public class ZCBinaryTransfer {
	private static final int BUFFER_SIZE = 4096;
	private final String boundary;
	private static final String LINE_FEED = "\r\n";
	private HttpURLConnection httpConn;
	private String charset;
	private OutputStream outputStream;
	private PrintWriter writer;

	/**
	 * ce constructeur initialise une nouvelle requete HTTP POST avec multipart/form comme content type de requete
	 * is set to multipart/form-data
	 * @param requestURL
	 * @param charset
	 * @param pHttpConn 
	 * @throws IOException
	 */
	public ZCBinaryTransfer( String charset, HttpURLConnection pHttpConn)
			throws IOException {
		this.charset = charset;
		
		// creates a unique boundary based on time stamp
		boundary = "===" + System.currentTimeMillis() + "===";
		
		//URL url = new URL(requestURL);
		httpConn = pHttpConn;
		httpConn.setUseCaches(false);
		httpConn.setDoOutput(true);	// indicates POST method
		httpConn.setDoInput(true);
		httpConn.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=" + boundary);
		httpConn.setRequestProperty("User-Agent", "CodeJava Agent");
		httpConn.setRequestProperty("Test", "Bonjour");
		outputStream = httpConn.getOutputStream();
		writer = new PrintWriter(new OutputStreamWriter(outputStream, charset),
				true);
	}

	/**
	 * ajoute le nom du champ ainsi que sa valeur dans la requète 
	 * @param name field name
	 * @param value field value
	 * @author fouadAzioiz
	 * 
	 */
	public void addFormField(String name, String value) {
		writer.append("--" + boundary).append(LINE_FEED);
		writer.append("Content-Disposition: form-data; name=\"" + name + "\"")
				.append(LINE_FEED);
		writer.append("Content-Type: text/plain; charset=" + charset).append(
				LINE_FEED);
		writer.append(LINE_FEED);
		writer.append(value).append(LINE_FEED);
		writer.flush();
	}

	/**
	 *ajouter la partie de upload dans la requète 
	 * @param fieldName name attribute in <input type="file" name="..." />
	 * @param uploadFile a File to be uploaded 
	 * @throws IOException
	 * @author fouad
	 */
	public void addFilePart(String fieldName, File uploadFile)
			throws IOException {
		String fileName = uploadFile.getName();
		writer.append("--" + boundary).append(LINE_FEED);
		writer.append(
				"Content-Disposition: form-data; name=\"" + fieldName
						+ "\"; filename=\"" + fileName + "\"")
				.append(LINE_FEED);
		writer.append(
				"Content-Type: "
						+ URLConnection.guessContentTypeFromName(fileName))
				.append(LINE_FEED);
		writer.append("Content-Transfer-Encoding: binary").append(LINE_FEED);
		writer.append(LINE_FEED);
		writer.flush();

		FileInputStream inputStream = new FileInputStream(uploadFile);
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}
		outputStream.flush();
		inputStream.close();
		
		writer.append(LINE_FEED);
		writer.flush();		
	}

	/**
	 * ajouter le header pour la requete http
	 * @param name - name of the header field
	 * @param value - value of the header field
	 */
	public void addHeaderField(String name, String value) {
		writer.append(name + ": " + value).append(LINE_FEED);
		writer.flush();
	}
	
	/**
	 * complète la requète et visualise le resultat du code html
	 * @return retourne le code html généré du serveur
	 * 
	 * @throws IOException
	 * @author fouad
	 * 
	 */
	public List<String> finish() throws IOException {
		List<String> response = new ArrayList<String>();

		writer.append(LINE_FEED).flush();
		writer.append("--" + boundary + "--").append(LINE_FEED);
		writer.close();

		// checks server's status code first
		int status = httpConn.getResponseCode();
		if (status == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					httpConn.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				response.add(line);
			}
			reader.close();
			httpConn.disconnect();
		} else {
			throw new IOException("Server returned non-OK status: " + status);
		}

		return response;
	}
	/**<p>méthode qui se connécte à un lien de telechargement
	 * et fait le traitement pour reconstituer le binaire reçue et le placer dans un fichier temporaire </p>
	 * @author FouadAzioiz
	 * @param con 
	 *
	 */
	public static File downloadFile(HttpURLConnection con)
            throws IOException {
		File downloadedfile=null;
      //  URL url = new URL(fileURL);
    //    HttpURLConnection con = (HttpURLConnection) url.openConnection();
        int responseCode = con.getResponseCode();
 
        // always check HTTP response code first
        if (responseCode == HttpURLConnection.HTTP_OK) {
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
//            else {
//                // extracts file name from URL
//                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
//                        fileURL.length());
//            }
 
            System.out.println("Content-Type = " + contentType);
            System.out.println("Content-Disposition = " + disposition);
            System.out.println("Content-Length = " + contentLength);
            System.out.println("fileName = " + fileName);
 
            // opens input stream from the HTTP connection
            InputStream inputStream = con.getInputStream();
            String DOWNLOAD_DIRECTORY = System.getProperty("java.io.tmpdir")+"ZeroCouplage";
			String downlaodPath = DOWNLOAD_DIRECTORY + File.separator
					+ (new Date().getTime());
			File dowlaoandDir = new File(downlaodPath);
			if (!dowlaoandDir.exists()) {
				dowlaoandDir.mkdirs();
			}
            String saveFilePath = downlaodPath + File.separator + fileName;
            
            downloadedfile=new File(saveFilePath);
            // opens an output stream to save into file
            FileOutputStream outputStream = new FileOutputStream(downloadedfile);
            
            int bytesRead = -1;
            byte[] buffer = new byte[BUFFER_SIZE];
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
        return downloadedfile;
    }

}