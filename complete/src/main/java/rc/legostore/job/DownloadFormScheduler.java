package rc.legostore.job;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import rc.legostore.model.StaticForm;
import rc.legostore.model.StaticFormDto;

@Configuration
public class DownloadFormScheduler {

	@Autowired
	MongoTemplate mongoTemplate;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DownloadFormScheduler.class);
	
	
	public byte[] getBytes(URL url)
	{
		byte[] pdfBytes= null;
		try(InputStream is= url.openStream())
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int reads= is.read();
			while(reads != -1)
			{
				baos.write(reads);
			}
			
			pdfBytes = baos.toByteArray();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return pdfBytes;
		
	}
	
	
	public void downloadStaticForms()
	{
		List<StaticFormDto> formList = mongoTemplate.find(new Query(),StaticForm.class).stream().map(StaticFormDto:: new ).collect(Collectors.toList());
		
		
		try
		{
		for(StaticFormDto form: formList)
		{
			URL url = new URL(form.getDocumentUrl().trim());
			byte[] pdfBytes= getBytes(url);
             form.setPdfBytes(Base64.getEncoder().encodeToString(pdfBytes));
			
			
		}
		
		if(!formList.isEmpty())
		{
			mongoTemplate.remove(new Query(),StaticForm.class);
			formList.stream().map(StaticForm ::new).forEach(e->mongoTemplate.save(e));
		}
		
		}
		catch (Exception e) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
