package com.graction.lumi.dao;

import java.util.ArrayList;

import com.graction.lumi.model.db.RegionReservationTable;
import com.graction.lumi.model.db.RegionReservationTable2;
import com.graction.lumi.model.db.RegionTable;
import com.graction.lumi.model.vo.RegionReservationVO;
import com.graction.lumi.model.vo.RegionVO;

public interface RegionDAO {
	
	/*
	 *	INSERT
	 */
	public boolean insert_region_reversation(RegionReservationTable param);
	
	/*
	 *	SELECT 
	 */
	public ArrayList<RegionTable> select_all_region(RegionVO vo);
	public ArrayList<RegionReservationTable> select_all_region_reservation();
	public ArrayList<RegionReservationVO> select_region_reservation_activtation();
	public RegionReservationVO select_region_reservation_detail(int idx);
	
	/*
	 *	UPDATE
	 */
	public boolean update_region_reservation(RegionReservationTable table);
	public boolean update_region_reservation2(RegionReservationTable2 table);
	
	/*
	 *	DELETE
	 */
	public boolean delete_region_reservation(int idx);
}
