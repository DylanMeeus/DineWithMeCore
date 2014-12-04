package net.itca.dwm.data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class RecipeService extends Database
{

	public RecipeService()
	{
		super();
	}

	public boolean createRecipe(String name, String ingredients,
			String instructions, int currentUserID)
	{
		boolean succes = false;
		try
		{
			openConnection();
			String createRecipeString = "Insert into recipes(name,ingredients,instructions,userid) values ('" + name +"', '" + ingredients + "', '" + instructions + "', " +  currentUserID +");";
			System.out.println("SQL: " + createRecipeString);
			Statement createStatement = connection.createStatement();
			int affected = createStatement.executeUpdate(createRecipeString); // if 0 rows affected, something went wrong, return boolean?
			if(affected==1) succes = true;
		} 
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		
		return succes;
	}
	
	public ArrayList<String> getRecipesByID(int userID)
	{
		ArrayList<String> recipes = new ArrayList<String>();
		try
		{
			openConnection();
			String getRecipesString = "select name from recipes where userid=" + userID+";";
			Statement recipeStatement = connection.createStatement();
			ResultSet results = recipeStatement.executeQuery(getRecipesString);
			while(results.next())
			{
				recipes.add(results.getString("name"));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		
		
		return recipes;
	}
}
