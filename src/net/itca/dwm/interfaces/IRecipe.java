package net.itca.dwm.interfaces;

import java.util.ArrayList;

public interface IRecipe
{
	boolean createRecipe(String name, String ingredients, String instructions, int currentUserID, int people);
	void deleteRecipe(int currentUserID, String recipeName);
	String getRecipeDetails(int currentUserID, String recipeName);
	int getRecipeID(String recipename, int currentUserID);
	ArrayList<String> getRecipesByID(int userID);
}
