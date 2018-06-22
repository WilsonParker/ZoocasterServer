package com.graction.lumi.dao;

import com.graction.lumi.model.db.FileInformationTable;

public interface FileInformationDAO {
	
	/*
	 *	INSERT
	 */
	public boolean insert_file_information(FileInformationTable param);
}
