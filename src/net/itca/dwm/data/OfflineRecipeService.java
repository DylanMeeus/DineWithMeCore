package net.itca.dwm.data;

import java.util.ArrayList;

import net.itca.dwm.interfaces.IRecipe;

public class OfflineRecipeService implements IRecipe
{

	public boolean createRecipe(String name, String ingredients, String instructions, int currentUserID, int people)
	{
		// TODO Auto-generated method stub
		return false;
	}

	public void deleteRecipe(int currentUserID, String recipeName)
	{
		// TODO Auto-generated method stub
		
	}

	public String getRecipeDetails(int currentUserID, String recipeName)
	{
		// TODO Auto-generated method stub
		return null;
	}

	public int getRecipeID(String recipename, int currentUserID)
	{
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<String> getRecipesByID(int userID)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
