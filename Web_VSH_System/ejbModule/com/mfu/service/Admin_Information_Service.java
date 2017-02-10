package com.mfu.service;

import java.util.List;

import com.mfu.entity.Admin_Information;

public interface Admin_Information_Service {

	public void saveAdmin(Admin_Information admin);

	public void updateAdmin(Admin_Information admin);

	public void deleteAdmin(long adminNumber);
	
	public abstract Admin_Information findAdmin(long adminNumber);

	public List<Admin_Information> getAllAdmin();
	
	public List<Admin_Information> getAdminByID(long id);
	
}
