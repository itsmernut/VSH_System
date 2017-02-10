package com.mfu.service;

import java.util.List;

import com.mfu.entity.Parent_Information;

public interface Parent_Information_Service {

	public void saveParent(Parent_Information parent);

	public void updateParent(Parent_Information parent);

	public void deleteParent(long parentNumber);
	
	public abstract Parent_Information findParent(long parentNumber);

	public List<Parent_Information> getAllParent();
	
	public List<Parent_Information> getParentByID(long id);
	
}
