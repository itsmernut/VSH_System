package com.mfu.service;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.mfu.entity.Parent_Information;
import com.mfu.entity.Student_Information;

@Stateless
@Remote(Parent_Information_Service.class)
public class Parent_Information_ServiceBean implements Parent_Information_Service {

	@PersistenceContext(unitName = "parentDatabase")
	EntityManager parent_information;
	
	@Override
	public void saveParent(Parent_Information parent) {
		this.parent_information.persist(parent);
	}

	@Override
	public void updateParent(Parent_Information parent) {
		parent_information.merge(parent);
	}

	@Override
	public void deleteParent(long parentNumber) {
		Parent_Information parent = findParent(parentNumber);
		if(parent != null){
			parent_information.remove(parent);
		}
	}

	@Override
	public Parent_Information findParent(long parentNumber) {
		return this.parent_information.find(Parent_Information.class, parentNumber);
	}

	@Override
	public List<Parent_Information> getAllParent() {
		List<Parent_Information> parentlist = null;
		try{
			Query parent = parent_information.createQuery("select parent from Parent_Information parent");
			parentlist = parent.getResultList();
		}	
		catch(Exception e){
			e.printStackTrace();
		}
		return parentlist;
	}

	@Override
	public List<Parent_Information> getParentByID(long id) {
		List<Parent_Information> result = parent_information.createQuery("select parent from Parent_Information parent where parent.parentNumber=:param1")
				.setParameter("param1", id)
				.getResultList();
		return result;
	}

}
