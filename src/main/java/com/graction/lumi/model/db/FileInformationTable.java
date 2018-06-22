package com.graction.lumi.model.db;

public class FileInformationTable {
	private int fileInformation_index;
	private String fileInformation_path, fileInformation_name, fileInformation_impormation;

	public FileInformationTable(String fileInformation_path, String fileInformation_name) {
		super();
		this.fileInformation_path = fileInformation_path;
		this.fileInformation_name = fileInformation_name;
	}

	public int getFileInformation_index() {
		return fileInformation_index;
	}

	public void setFileInformation_index(int fileInformation_index) {
		this.fileInformation_index = fileInformation_index;
	}

	public String getFileInformation_path() {
		return fileInformation_path;
	}

	public void setFileInformation_path(String fileInformation_path) {
		this.fileInformation_path = fileInformation_path;
	}

	public String getFileInformation_name() {
		return fileInformation_name;
	}

	public void setFileInformation_name(String fileInformation_name) {
		this.fileInformation_name = fileInformation_name;
	}

	public String getFileInformation_impormation() {
		return fileInformation_impormation;
	}

	public void setFileInformation_impormation(String fileInformation_impormation) {
		this.fileInformation_impormation = fileInformation_impormation;
	}

}
