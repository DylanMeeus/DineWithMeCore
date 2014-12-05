package net.itca.dwm.data;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.itca.dwm.interfaces.DataService;

/**
 * Database extension for dealing with recipes (CRUD operations)
 * @author Dylan
 *
 */
public class RecipeService extends Database implements DataService
{

	public RecipeService()
	{
		super();
	}

	/**
	 * Adds a recipe to the database based on the given parameters.
	 * @param name
	 * @param ingredients
	 * @param instructions
	 * @param currentUserID
	 * @param people
	 * @return
	 */
	public boolean createRecipe(String name, String ingredients,
			String instructions, int currentUserID, int people)
	{
		boolean succes = false;
		try
		{
			openConnection();
			String createRecipeString = "Insert into recipes(name,ingredients,instructions,userid, people) values ('"
					+ name
					+ "', '"
					+ ingredients
					+ "', '"
					+ instructions
					+ "', " + currentUserID + ", " + people + ");";
			System.out.println("SQL: " + createRecipeString);
			Statement createStatement = connection.createStatement();
			int affected = createStatement.executeUpdate(createRecipeString); // if
																				// 0
																				// rows
																				// affected,
																				// something
																				// went
																				// wrong,
																				// return
																				// boolean?
			if (affected == 1)
				succes = true;
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return succes;
	}
	
	
	/**
	 * Gets all recipes based on a user ID.
	 * @param userID
	 * @return
	 */
	public ArrayList<String> getRecipesByID(int userID)
	{
		ArrayList<String> recipes = new ArrayList<String>();
		try
		{
			openConnection();
			String getRecipesString = "select name from recipes where userid="
					+ userID + ";";
			Statement recipeStatement = connection.createStatement();
			ResultSet results = recipeStatement.executeQuery(getRecipesString);
			while (results.next())
			{
				recipes.add(results.getString("name"));
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return recipes;
	}

	/**
	 * Gets the recipe name, amount of people, ingredients and instructions from the database based on a given recipe name and user ID. Uses the magic value -1 when the people field was not entered.
	 * @param currentUserID
	 * @param recipeName
	 * @return
	 */
	public String getRecipeDetails(int currentUserID, String recipeName)
	{
		
		String details = "";
		String name = "";
		int people = -1;
		String ingredients = "";
		String instructions = "";
		try
		{
			openConnection();
			String getDetailString = "select name, people, ingredients, instructions from recipes where name='"+recipeName+"' and userid="+currentUserID+";";
			Statement getDetailStatement = connection.createStatement();
			ResultSet results = getDetailStatement
					.executeQuery(getDetailString);
			while (results.next())
			{
				name = results.getString("name");
				people = results.getInt("people");
				ingredients = results.getString("ingredients");
				instructions = results.getString("instructions");
			}
			
			details += "name: " + name + "\n people: " + people + "\n ingredients: " + ingredients + "\n instructions: " + instructions;
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally
		{
			closeConnection();
		}

		return details;
	}
	
	/**
	 * Deletes a recipe from the database based on a given recipe name and user ID.
	 * @param currentUserID
	 * @param recipeName
	 */
	public void deleteRecipe(int currentUserID, String recipeName)
	{
		try
		{
			openConnection();
			String deleteRecipeString = "delete from recipes where userid="+currentUserID+" and name='"+recipeName+"';";
			Statement deleteStatement = connection.createStatement();
			int affected = deleteStatement.executeUpdate(deleteRecipeString);	
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
	}
	
	
	/**
	 * Gets the recipe ID based on a given recipe name and user ID.
	 * @param recipename
	 * @param currentUserID
	 * @return
	 */
	public int getRecipeID(String recipename, int currentUserID)
	{
		int recipeID = -1;
		try
		{
			openConnection();
			String getDetailString = "select recipeid from recipes where name='"+recipename+"' and userid="+currentUserID+";";
			Statement getDetailStatement = connection.createStatement();
			ResultSet results = getDetailStatement
					.executeQuery(getDetailString);
			while (results.next())
			{
				recipeID = results.getInt("recipeid");
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
		return recipeID;
	}
}
