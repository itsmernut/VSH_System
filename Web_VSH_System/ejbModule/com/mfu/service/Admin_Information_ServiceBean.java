package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mfu.entity.Admin_Information;
import com.mfu.entity.Teacher_Information;

@Stateless
@Remote(Admin_Information_Service.class)
public class Admin_Information_ServiceBean implements Admin_Information_Service {

	@PersistenceContext(unitName = "adminDatabase")
	EntityManager admin_information;
	
	@Override
	public void saveAdmin(Admin_Information admin) {
		this.admin_information.persist(admin);
	}

	@Override
	public void updateAdmin(Admin_Information admin) {
		admin_information.merge(admin);
	}

	@Override
	public void deleteAdmin(long adminNumber) {
		Admin_Information admin = findAdmin(adminNumber);
		if(admin != null){
			admin_information.remove(admin);
		}
	}

	@Override
	public Admin_Information findAdmin(long adminNumber) {
		return this.admin_information.find(Admin_Information.class, adminNumber);
	}

	@Override
	public List<Admin_Information> getAllAdmin() {
		List<Admin_Information> adminlist = null;
		try{
			Query admin = admin_information.createQuery("select admin from Admin_Information admin");
			adminlist = admin.getResultList();
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		return adminlist;
	}

	@Override
	public List<Admin_Information> getAdminByID(long id) {
		List<Admin_Information> result = admin_information.createQuery("select admin from Admin_Information admin where admin.adminNumber=:param1")
				.setParameter("param1", id)
				.getResultList();
		return result;
	}

}
