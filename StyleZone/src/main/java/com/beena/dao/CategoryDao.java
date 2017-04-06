package com.beena.dao;

import java.util.List;

import com.beena.model.Category;

public interface CategoryDao 
{
	public boolean newCategory(Category category);
	public Category getCategory(int id);
	public List<Category> allCategories();
	public  boolean deleteCategory(int id);
	public boolean updateCategory(Category category);

}
