package rc.legostore.model;

public class StaticFormDto {
	
private String staticForm;
	
	private String documentName;
	
	private String documentUrl;
	
	private String pdfBytes;
	
	private String displayOrderPreAo;
	
	private String displayOrderafterPostAo;
	
	private String fimp;
	
	

	public StaticFormDto(StaticForm form) {
		
		this.staticForm = form.getStaticForm();
		this.documentName = form.getDocumentName();
		this.documentUrl = form.getDocumentUrl();
		this.pdfBytes = form.getPdfBytes();
		this.displayOrderPreAo = form.getDisplayOrderPreAo();
		this.displayOrderafterPostAo = form.getDisplayOrderafterPostAo();
		this.fimp = form.getFimp();
	}

	public StaticFormDto() {
		
	}

	public String getStaticForm() {
		return staticForm;
	}

	public void setStaticForm(String staticForm) {
		this.staticForm = staticForm;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getDocumentUrl() {
		return documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getPdfBytes() {
		return pdfBytes;
	}

	public void setPdfBytes(String pdfBytes) {
		this.pdfBytes = pdfBytes;
	}

	public String getDisplayOrderPreAo() {
		return displayOrderPreAo;
	}

	public void setDisplayOrderPreAo(String displayOrderPreAo) {
		this.displayOrderPreAo = displayOrderPreAo;
	}

	public String getDisplayOrderafterPostAo() {
		return displayOrderafterPostAo;
	}

	public void setDisplayOrderafterPostAo(String displayOrderafterPostAo) {
		this.displayOrderafterPostAo = displayOrderafterPostAo;
	}

	public String getFimp() {
		return fimp;
	}

	public void setFimp(String fimp) {
		this.fimp = fimp;
	}
	
	
	

}
